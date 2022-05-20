class Partida{
    constructor(ko, response) {
        this.id = ko.observable(response.id)
        this.board = ko.observable(response.board)
        this.ready = ko.observable(response.ready)
        this.players = ko.observableArray(response.players)
        this.playerWithTurn = ko.observable(response.playerWithTurn)
        this.winner = ko.observable(response.winner)
        this.looser = ko.observable(response.looser)
        this.draw = ko.observable(response.draw)
    }

    unete($, ko, game){
        let self = this;

        let data = {
            type: "get",
            url: "/games/joinGame/" + game.name + "?cpu=true",
            success: function (response) {

                //VAMOS A CREAR UN PARTIDO DONDE TODOS SEAN OBSEVARBLES PARA PODER
                //ACTUALIZAR CUANDO UN JUGADOR SE UNA
                self.id(response.id)
                self.board(response.board)
                self.ready(response.ready)
                self.players(response.players)
                self.winner(response.winner)
                self.looser(response.looser)
                self.draw(response.draw)
                self.setTurn(response.playerWithTurn.name)


                console.log(self.board())

                //SE PINTA CUANDO SE HACE PUSH
                //self.matches.push(match)

            },
            error: function (response) {
                console.error(response.message);
                alert(response.message);
            }
        };
        $.ajax(data);
    }

    setTurn(nombre){

        this.playerWithTurn(nombre)
        if (nombre == "cpu")
            this.mover()
    }

    mover() {
        let self = this;

        let info = {
            matchId: self.id(),
            x: 2,
            y: 2
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

    cogerCasillaLibre(){
        let self = this;

            for (let i=0; i<self.board().length; i++);
    }
}