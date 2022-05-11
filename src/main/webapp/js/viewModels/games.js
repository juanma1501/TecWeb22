define([ 'knockout', 'appController', 'ojs/ojmodule-element-utils', 'accUtils',
		'jquery' ], function(ko, app, moduleUtils, accUtils, $) {

	class MenuViewModel {
		constructor() {
			let self = this;

			self.games = ko.observableArray([]);
			self.matches = ko.observableArray([]);
			self.players = ko.observableArray([]);

			self.cont = 0;

			self.x = ko.observable(null);
			self.y = ko.observable(null);
			self.mensaje = ko.observable(null);
			self.error = ko.observable(null);
						
			// Header Config
			self.headerConfig = ko.observable({
				'view' : [],
				'viewModel' : null
			});
			moduleUtils.createView({
				'viewPath' : 'views/header.html'
			}).then(function(view) {
				self.headerConfig({
					'view' : view,
					'viewModel' : app.getHeaderModel()
				})
			});
		}

		connected() {
			accUtils.announce('Juegos.');
			document.title = "Juegos";

			let self = this;

			let data = {
				type : "get",
				url : "/games/getGames",
				success : function(response) {
					self.games(response);
				},
				error : function(response) {
					console.error(response);
					self.error(response);
				}
			}
			$.ajax(data);
		};

		mover(match) {
			let self = this;

			let info = {
				matchId : match.id,
				x : this.x(),
				y : this.y()
			};

			let data = {
				type : "post",
				url : "/games/move",
				data : JSON.stringify(info),
				contentType : "application/json",
				success : function(response) {
					console.log(JSON.stringify(response));
				},
				error : function(response) {
					console.error(response);
					self.error(response);
				}
			}
			$.ajax(data);
		}

		conectarAWebSocket(match) {
			let self = this;
			self.cont += 1
			let ws = new WebSocket("ws://localhost/wsGenerico");
			ws.onopen = function(event) {
				self.mensaje("Conexión establecida")
				let msg = {
					type: "UNIR",
					id: match.id()
				}
				ws.send(JSON.stringify(msg))

			}
			ws.onmessage = function(event) {
				let msg = JSON.parse(event.data);
				console.log(msg)
				if (msg.type == "PREPARADA"){
					self.matches().map( (match, index) => {
						if (self.matches()[index].id() == msg.id) {
							self.matches()[index].ready(true)
							let player = {
								id : ko.observable(msg.player.id),
								name : ko.observable(msg.player.name),
								email : ko.observable(msg.player.email),
							}

							self.players.push(player)
							self.players().map((pl, index) => {
								if (pl !== player){
									match.players.push(player)
								}
							})
							console.log(player)
							console.log(player.name())
							console.log(match.players())
							console.log(self.matches())
							self.mensaje("Jugando")
						}
					})
				}
			}
		}

		joinGame(game) {
			let self = this;

			let data = {
				type : "get",
				url : "/games/joinGame/" + game.name,
				success : function(response) {
					//VAMOS A CREAR UN PARTIDO DONDE TODOS SEAN OBSEVARBLES PARA PODER
					//ACTUALIZAR CUANDO UN JUGADOR SE UNA
					//let match = new Partida (ko,response)

					let match = {
						id : ko.observable(response.id),
						ready : ko.observable(response.ready),
						players : ko.observableArray(response.players),
						playerWithTurn : ko.observable(response.playerWithTurn),
						winner : ko.observable(response.winner),
						looser : ko.observable(response.looser),
						draw : ko.observable(response.draw),
					}

					console.log(JSON.stringify(response));
					console.log(response.players)
					self.matches.push(match);
					console.log("PARTIDAS " + self.matches().length)
					console.log("PARTIDAS " + self.players())
					self.conectarAWebSocket(match);

				},
				error : function(response) {
					console.error(response.responseJSON.message);
					self.error(response.responseJSON.message);
				}
			};
			$.ajax(data);
		}

		reload(match) {
			let self = this;

			let data = {
				type : "get",
				url : "/games/findMatch/" + match.id,
				success : function(response) {
					for (let i=0; i<self.matches().length; i++)
						if (self.matches()[i].id()==match.id) {
							self.matches.splice(i, 1, response);
							break;
						}
					console.log(JSON.stringify(response));
				},
				error : function(response) {
					console.error(response.responseJSON.message);
					self.error(response.responseJSON.message);
				}
			};
			$.ajax(data);
		}

		disconnected() {
			// Implement if needed
		};

		transitionCompleted() {
			// Implement if needed
		};
	}

	return MenuViewModel;
});
