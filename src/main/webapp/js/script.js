$(document).on("click", ".botonBorrar", function () {
    var miPublicacionId = $(this).data('id');
    $(".modal-footer #botonBorrar").val( miPublicacionId );
});