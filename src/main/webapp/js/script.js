$(document).ready(function(){
	$('.botonBorrar').click(function () {
    	var miElementoId = $(this).data('id');
    	$(".modal-footer #botonBorrar").val( miElementoId );
	});

$(document).on("click", ".responderComentario", function () {
    var miComentarioId = $(this).data('id');
    $(".responderComent #responderComentario").val( miComentarioId );
}); 


