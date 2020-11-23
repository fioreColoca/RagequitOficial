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

$(document).ready(function(){
	$('.botonCollapseComentarios').click(function () {
    	var categoriaId= $(this).data('id');
    	var comentariosACollapse = "#collapseComentario";
    	
    	var comentariosAMostrar = comentariosACollapse.concat(categoriaId);
    	$(comentariosAMostrar).collapse('toggle');
	});
});

$(document).ready(function(){
	$('.botonEditar').click(function () {
    	var categoriaId= $(this).data('id');
    	$(".modal-footer #botonGuardar").val( categoriaId);
	});
});

var owl = $('.owl-carousel');

owl.owlCarousel({
	center: true,
	items:5,
	nav:true,
	dots:false,
	loop:true,
	lazyLoad:true,
	margin: 11,
	stagePadding:70,
	autoWidth: true,
	responsiveClass:true,
	responsive:{
		0: {
			nav:false,
			items:1,
			dots:false		
		},
		485:{
			nav:false,
			items:2,
			dots:false
		},
		728:{
			nav:false,
			items:3,
			dots:false
		},
		960:{
			nav:false,
			items:4,
			dots:false
		},
		1200:{	
			items:5,
			dots:false
		}
	}
});


owl.on('mousewheel', '.owl-stage', function (e) {
    if (e.deltaY>0) {
        owl.trigger('next.owl');
    } else {
        owl.trigger('prev.owl');
    }
    e.preventDefault();
});