class Partida{
    constructor(ko, response) {
        this.id = ko.observable(response.id)
        this.ready = ko.observable(response.ready)
        this.players = ko.observableArray(response.players)
        this.playerWithTurn = ko.observable(response.playerWithTurn)
        this.winner = ko.observable(response.winner)
        this.looser = ko.observable(response.looser)
        this.draw = ko.observable(response.draw)
    }
}