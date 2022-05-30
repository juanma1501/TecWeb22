class Partida{
    constructor(vm, ko, response, game) {
        this.id = ko.observable(response.id)
        this.board = ko.observable(response.board)
        this.ready = ko.observable(response.ready)
        this.players = ko.observableArray(response.players)
        this.playerWithTurn = ko.observable(response.playerWithTurn)
        this.winner = ko.observable(response.winner)
        this.looser = ko.observable(response.looser)
        this.draw = ko.observable(response.draw)
        this.game = ko.observable(game)
        this.game_ = game
        this.vm = vm
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
                self._game=game


                console.log(self.board())
                console.log(self.game_)

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
        let self = this;

        this.playerWithTurn(nombre)
        if(self.game_ == "Tres en raya"){
            if (nombre == "cpu")
                this.mover()
        }else{
            if (nombre == "cpu")
                this.mover2()
        }

    }

    mover() {
        let self = this;
        let posicion = self.cogerCasillaLibre()

        if(self.winner() !== null){
            return
        }

        let info = {
            matchId: self.id(),
            x: posicion[0],
            y: posicion[1]
        };

        let data = {
            type: "post",
            url: "/games/move?cpu=true",
            data: JSON.stringify(info),
            contentType: "application/json",
            success: function (response) {
                console.log(response);
            },
        }
        $.ajax(data);
    }

    mover2() {
        let self = this;
        //Piedra --> 1 ; Papel --> 2; Tijera --> 3

        if (self.ready()){
            let infoMove = {
                matchId: self.id(),
                move: Math.floor(Math.random() * (4 - 1)) + 1,
            };

            console.log("LA MAQUINA TIRA ")
            console.log(infoMove)

            let data = {
                type: "post",
                url: "/games/move2?cpu=true",
                data: JSON.stringify(infoMove),
                contentType: "application/json",
                success: function (response) {
                    console.log(response);
                },
                error: function (response) {
                   console.log(response)
                }
            }
            $.ajax(data);
        }else{
            self.infoMessage("Match isn´t ready yet.")
        }
    }

    cogerCasillaLibre(){
        let self = this;
        var posicion = new Array()

            for (let i=0; i<self.board().squares[0].length; i++){
                for (let j=0; j<self.board().squares[0].length; j++){
                    if (self.board().squares[i][j] == 0){
                        posicion = [i, j]
                        break
                    }
                }
            }
            return posicion;
    }
}