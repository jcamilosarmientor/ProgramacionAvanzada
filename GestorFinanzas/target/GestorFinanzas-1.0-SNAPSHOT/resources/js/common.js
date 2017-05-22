$(document).ready(function () {
   console.log('listo');
   var click = 0; //no lo muestra
   var megaMenu = $('#menu');
   
   megaMenu.hide();
   
   $('#btnSuperior').click(function () {
       var options = { to: { width: 280, height: 185 } };
        if (click === 0) {
            megaMenu.show("drop", options, 500);
            click = 1;
        } else {
            megaMenu.hide("drop", options, 500);
            click = 0;
        }
   });
});

