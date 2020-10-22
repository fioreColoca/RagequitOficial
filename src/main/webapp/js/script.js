$(document).on("click", ".botonBorrar", function () {
    var miPublicacionId = $(this).data('id');
    $(".modal-footer #botonBorrar").val( miPublicacionId );
});

$(document).on("click", ".responderComentario", function () {
    var miComentarioId = $(this).data('id');
    $(".responderComent #responderComentario").val( miComentarioId );
});