define(['knockout', 'appController', 'ojs/ojmodule-element-utils', 'accUtils',
    'jquery'], function (ko, app, moduleUtils, accUtils, $) {

    class MenuViewModel {
        constructor() {
            let self = this;

            self.games = ko.observableArray([]);
            self.matches = ko.observableArray([]);
            //self.players = ko.observableArray([]);

            self.cont = 0;

            self.x = ko.observable(null);
            self.y = ko.observable(null);
            self.mensaje = ko.observable(null);
            self.error = ko.observable(null);

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
                matchId: match.id,
                x: this.x(),
                y: this.y()
            };

            let data = {
                type: "post",
                url: "/games/move",
                data: JSON.stringify(info),
                contentType: "application/json",
                success: function (response) {
                    console.log(JSON.stringify(response));
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

                            let player = {
                                email: ko.observable(msg.player.email),
                                id: ko.observable(msg.player.id),
                                name: ko.observable(msg.player.name)
                            }

                            //Esto sirve para recargar el observableArray de players y que pinte en los dos clientes
                            self.matches()[index].players.splice(1, 1);
                            self.matches()[index].players.splice(1, 0, player);

                            console.log("JUGADORES DE UNA PARTIDA " + match.players())
                            console.log(self.matches())
                            self.mensaje("Jugando")
                            //self.refresh()
                        }
                    })
                }

            }
        }

        joinGame(game) {
            let self = this;

            let data = {
                type: "get",
                url: "/games/joinGame/" + game.name,
                success: function (response) {
                    //VAMOS A CREAR UN PARTIDO DONDE TODOS SEAN OBSEVARBLES PARA PODER
                    //ACTUALIZAR CUANDO UN JUGADOR SE UNA
                    let match = new Partida(ko, response)

                    console.log(JSON.stringify(response));
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
    }

    return MenuViewModel;
});
