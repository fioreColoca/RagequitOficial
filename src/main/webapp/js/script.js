$(document).ready(function(){
	$('.botonBorrar').click(function () {
    	var miElementoId = $(this).data('id');
    	$(".modal-footer #botonBorrar").val( miElementoId );
	});

	$('.responderComentario').click(function () {
    	var miComentarioId = $(this).data('id');
    	$(".responderComent #responderComentario").val( miComentarioId );
	});
	
});


