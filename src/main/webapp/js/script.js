$(document).ready(function() {
    /************************BAJA PUBLICACION COMENTARIOS**********************************/
    $('.botonBorrar').click(function() {
        var miElementoId = $(this).data('id');
        $(".modal-footer #botonBorrar").val(miElementoId);
    });

    /************************MODAL RESPONDER COMENTARIO**********************************/
    $('.responderComentario').click(function() {
        var miComentarioId = $(this).data('id');
        $(".responderComent #responderComentario").val(miComentarioId);
    });

    /************************COLLAPSE COMENTARIOS**********************************/
    $('.botonCollapseComentarios').click(function() {
        var categoriaId = $(this).data('id');
        var comentariosACollapse = "#collapseComentario";

        var comentariosAMostrar = comentariosACollapse.concat(categoriaId);
        $(comentariosAMostrar).collapse('toggle');
    });

    /************************COLLAPSE RESPUESTAS**********************************/
    $('.botonCollapseRespuesta').click(function() {
        var comentarioId = $(this).data('id');
        var respuestaACollapse = "#collapseRespuesta";

        var respuestaAMostrar = respuestaACollapse.concat(comentarioId);
        $(respuestaAMostrar).collapse('toggle');
    });


    /************************EDITAR CATEGORIA**********************************/
    $('.botonEditar').click(function() {
        var categoriaId = $(this).data('id');
        $(".modal-footer #botonGuardar").val(categoriaId);
    });

    /************************AJAX DE CREAR PUBLICACION**********************************/
    $("#crearPublicacionFormulario").submit(function(event) {
        event.preventDefault();
        var post_url = $(this).attr("action");
        var categoriaId = $("#categoriaPublicacion").val();
        var mensaje = $("#mensajePublicacion").val();
        $.ajax({
            type: 'POST',
            url: post_url,
            data: {
                categoriaId: categoriaId,
                mensaje: mensaje
            }
        }).done(function(datosPublicacion) {
            $("#mensajeVacio").html("");
            $("#categoriaVacia").html("");
            $("#creacionPublicacionExitosa").html("");
            if (datosPublicacion.mensajeVacio == true) {
                $("#mensajeVacio").html("<span>Debe escribir un mensaje</span>");
            }
            if (datosPublicacion.categoriaVacia == true) {
                $("#categoriaVacia").html("<span>Debe elegir una categoria</span>");
            }
            if (datosPublicacion.mensajeVacio == false && datosPublicacion.categoriaVacia == false) {
                $("#creacionPublicacionExitosa").html("<span>Se creo la publicacion con exito!</span>");
            }
        }).fail(function() {
            console.log("error al cargar AJAX publicacion");
        });
    });

    /************************AJAX DE LIKEAR PUBLICACION**********************************/
    $("button[id^='idPublicacionADarLike']").click(function() {
        var post_url = "darLikePublicacion";
        var idPublicacion = $(this).val();
        $.ajax({
            type: 'POST',
            url: post_url,
            data: {
                idPublicacionADarLike: idPublicacion
            }

        }).done(function(datosLikePublicacion) {
            $("#cantidadLikesPublicacion" + datosLikePublicacion.idPublicacion).html("");
            $("#cantidadLikesPublicacion" + datosLikePublicacion.idPublicacion).html(datosLikePublicacion.cantidadLikesPublicacion);
        }).fail(function(data) {
            console.log(data);
            console.log("error al cargar Ajax dar like publicacion");
        });
    });
});


/************************CAROUSEL INICIO**********************************/
var owl = $('.owl-carousel');

owl.owlCarousel({
    center: true,
    items: 2,
    nav: true,
    dots: false,
    loop: true,
    lazyLoad: true,
    margin: 11,
    stagePadding: 70,
    autoWidth: true,
    responsiveClass: true,
    responsive: {
        0: {
            nav: false,
            items: 1,
            dots: false
        },
        485: {
            nav: false,
            items: 2,
            dots: false
        },
        728: {
            nav: false,
            items: 3,
            dots: false
        },
        960: {
            nav: false,
            items: 4,
            dots: false
        },
        1200: {
            items: 5,
            dots: false
        }
    }
});


owl.on('mousewheel', '.owl-stage', function(e) {
    if (e.deltaY > 0) {
        owl.trigger('next.owl');
    } else {
        owl.trigger('prev.owl');
    }
    e.preventDefault();
});