$(document).ready(function () {
    var click = 0; //no lo muestra
    var menuVertical = $('#menu');
    var contenidoPrincipal = $('#contenido');

    $('#btnSuperior').click(function () {
        var options = {to: {width: 280, height: 185}};
        if (click === 0) { //oculta
            console.log('oculta');
            menuVertical.hide("drop", options, 500);
            contenidoPrincipal.css({'width': '98%', 'margin-left': '0'});
            click = 1;
        } else { //muestra
            console.log('muestra');
            menuVertical.show("drop", options, 500);
            contenidoPrincipal.css({'width': '80%', 'margin-left': '18.5%'});
            click = 0;
        }
    });
});



