class Alerta{

    constructor() {

    }

    abre(id, classes, titulo, corpo, functionCancelar, functionEnviar, textoCancelar, textoEnviar){
        let self = this
        var cancelar = (textoCancelar !== undefined)? textoCancelar: 'Continuar';
        var enviar = (textoEnviar !== undefined)? textoEnviar: 'Send';
        classes += ' ';
        var classArray = classes.split(' ');
        classes = '';
        var classesFundo = '';
        var classBot = '';
        $.each(classArray, function(index, value){
            switch(value){
                case 'alert' : classBot += ' alert '; break;
                case 'blue' : classesFundo += this + ' ';
                case 'green' : classesFundo += this + ' ';
                case 'red' : classesFundo += this + ' ';
                case 'white': classesFundo += this + ' ';
                case 'orange': classesFundo += this + ' ';
                case 'purple': classesFundo += this + ' ';
                default : classes += this + ' '; break;
            }
        });
        var popFundo = '<div id="popFundo_' + id + '" class="popUpFundo ' + classesFundo + '"></div>'
        var janela = '<div id="' + id + '" class="popUp ' + classes + '"><h1>' + titulo + "</h1><div><span>" + corpo + "</span></div><button class='puCancelar " + classBot + "' id='" + id +"_cancelar' data-parent=" + id + ">" + cancelar + "</button><button class='puEnviar " + classBot + "' data-parent=" + id + " id='" + id +"_enviar'>" + enviar + "</button></div>";
        $("window, body").css('overflow', 'hidden');

        $("body").append(popFundo);
        $("body").append(janela);
        $("body").append(popFundo);
        //alert(janela);
        $("#popFundo_" + id).fadeIn("fast");
        $("#" + id).addClass("popUpEntrada");

        $("#" + id + '_cancelar').on("click", function(){
            if((functionCancelar !== undefined) && (functionCancelar !== '')){
                functionCancelar();

            }else{
                self.fecha(id);
            }
        });
        $("#" + id + '_enviar').on("click", function(){
            if((functionEnviar !== undefined) && (functionEnviar !== '')){
                functionEnviar();
            }else{
                self.fecha(id);
            }
        });

    };

    fecha(id){
        if(id !== undefined){
            $("#" + id).removeClass("popUpEntrada").addClass("popUpSaida");

            $("#popFundo_" + id).fadeOut(1000, function(){
                $("#popFundo_" + id).remove();
                $("#" + $(this).attr("id") + ", #" + id).remove();
                if (!($(".popUp")[0])){
                    $("window, body").css('overflow', 'auto');
                }
            });


        }
        else{
            $(".popUp").removeClass("popUpEntrada").addClass("popUpSaida");

            $(".popUpFundo").fadeOut(1000, function(){
                $(".popUpFundo").remove();
                $(".popUp").remove();
                $("window, body").css('overflow', 'auto');
            });


        }
    }
}

