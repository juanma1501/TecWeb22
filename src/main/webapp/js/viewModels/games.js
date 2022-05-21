define(['knockout', 'appController', 'ojs/ojmodule-element-utils', 'accUtils',
    'jquery'], function (ko, app, moduleUtils, accUtils, $) {

    class MenuViewModel {
        constructor() {
            let self = this;

            self.games = ko.observableArray([]);
            self.matches = ko.observableArray([]);

            self.cont = 0;

            self.x = ko.observable(null);
            self.y = ko.observable(null);
            self.mensaje = ko.observable(null);
            self.error = ko.observable(null);

            self.secondMove = function(data,event){
                self.moveSecondGame(event.target.innerText)
            }

            // Header Config
            self.headerConfig = ko.observable({
                'view': [],
                'viewModel': null
            });
            moduleUtils.createView({
                'viewPath': 'views/header.html'
            }).then(function (view) {
                self.headerConfig({
                    'view': view,
                    'viewModel': app.getHeaderModel()
                })
            });


            self.conectarAWebSocket();

            self.refresh = function (array) {
                let data = array().slice(0);
                array([]);
                array(data);
            };

        }


        connected() {
            accUtils.announce('Juegos.');
            document.title = "Juegos";

            let self = this;

            let data = {
                type: "get",
                url: "/games/getGames",
                success: function (response) {
                    self.games(response);
                },
                error: function (response) {
                    console.error(response);
                    self.error(response);
                }
            }
            $.ajax(data);
        };

        mover(match) {
            let self = this;

            let info = {
                matchId: match.id(),
                x: this.x(),
                y: this.y()
            };

            let data = {
                type: "post",
                url: "/games/move",
                data: JSON.stringify(info),
                contentType: "application/json",
                success: function (response) {
                    console.log(response);
                },
                error: function (response) {
                    console.error(response);
                    self.error(response);
                }
            }
            $.ajax(data);
        }

        conectarAWebSocket() {
            let self = this;
            self.cont += 1
            let ws = new WebSocket("ws://localhost/wsGenerico");
            ws.onopen = function (event) {
                self.mensaje("Conexión establecida")

            }
            ws.onmessage = function (event) {

                let msg = JSON.parse(event.data);
                console.log(msg)
                if (msg.type == "PREPARADA") {
                    self.matches().map((match, index) => {
                        if (self.matches()[index].id() == msg.id) {
                            self.matches()[index].ready(true)

                            self.actualizarPreparada(self.matches()[index], msg)

                            console.log("JUGADORES DE UNA PARTIDA " + match.players())
                            self.mensaje("Jugando")
                            //self.refresh()
                        }
                    })
                }

                if (msg.type == "BOARD"){
                    self.matches().map((match, index) => {
                        if (self.matches()[index].id() == msg.id) {

                            console.log(self.matches()[index].name)

                            console.log("EL TABLERO QUE LLEGA ES:")
                            console.log(msg)

                            self.actualizarMovimiento(self.matches()[index], msg)

                        }
                    })
                }

            }
        }

        actualizarPreparada(partida, msg){
            //VAMOS IR RECARGANDO ATRIBUTO A ATRIBUTO
            let player = {
                email: ko.observable(msg.player.email),
                id: ko.observable(msg.player.id),
                name: ko.observable(msg.player.name)
            }
            partida.ready(partida.ready())
            //Esto sirve para recargar el observableArray de players y que pinte en los dos clientes
            partida.players.splice(1, 1);
            partida.players.splice(1, 0, player);
            console.log(msg.playerWithTurn)
            partida.playerWithTurn(msg.playerWithTurn)
        }

        actualizarMovimiento(partida, msg){
            partida.board(msg.board)
            partida.setTurn(msg.playerWithTurn)

            if (msg.winner != null){
                partida.winner(msg.winner)
                partida.looser(msg.looser)
            }

            partida.draw(msg.draw)
        }

        joinGame(game) {
            let self = this;
            console.log(game.name)

            let data = {
                type: "get",
                url: "/games/joinGame/" + game.name,
                success: function (response) {
                    //VAMOS A CREAR UN PARTIDO DONDE TODOS SEAN OBSEVARBLES PARA PODER
                    //ACTUALIZAR CUANDO UN JUGADOR SE UNA
                    let match = new Partida(ko, response)

                    console.log("INFORMACION DE LA RAW RESPONSE ABAJO")
                    console.log(match);
                    console.log(response.players)
                    //SE PINTA CUANDO SE HACE PUSH
                    self.matches.push(match)
                    console.log("PARTIDAS " + self.matches().length)
                    //console.log("PARTIDAS " + self.players())

                },
                error: function (response) {
                    console.error(response.responseJSON.message);
                    alert(response.responseJSON.message);
                }
            };
            $.ajax(data);
        }

        joinGameCPU(game) {
            let self = this;

            let data = {
                type: "get",
                url: "/games/joinGame/" + game.name,
                success: function (response) {
                    //VAMOS A CREAR UN PARTIDO DONDE TODOS SEAN OBSEVARBLES PARA PODER
                    //ACTUALIZAR CUANDO UN JUGADOR SE UNA
                    let match = new Partida(ko, response)

                    //SE PINTA CUANDO SE HACE PUSH
                    self.matches.push(match)
                    match.unete($, ko, game)

                },
                error: function (response) {
                    console.error(response.responseJSON.message);
                    alert(response.responseJSON.message);
                }
            };
            $.ajax(data);
        }

        reload(match) {
            let self = this;

            let data = {
                type: "get",
                url: "/games/findMatch/" + match.id,
                success: function (response) {
                    for (let i = 0; i < self.matches().length; i++)
                        if (self.matches()[i].id() == match.id) {
                            self.matches.splice(i, 1, response);
                            break;
                        }
                    console.log(JSON.stringify(response));
                },
                error: function (response) {
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

        moveSecondGame(data){
            let self = this;
            console.log(data)
        }
    }

    return MenuViewModel;
});
