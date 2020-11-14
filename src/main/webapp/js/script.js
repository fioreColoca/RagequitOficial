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

$('.owl-carousel').owlCarousel({
	center: true,
	items:5,
	nav:true,
	dots:false,
	loop:true,
	lazyLoad:true,
	margin: 5,
	stagePadding:5,
	autoHeight:true,
	responsive:{
		0: {
			items:1,
			dots:false		
		},
		485:{
			items:2,
			dots:false
		},
		728:{
			items:3,
			dots:false
		},
		960:{
			items:4,
			dots:true
		},
		1200:{
			items:5,
			dots:false
		}
	}
});

$('.owl-carousel').on('mousewheel', '.owl-stage', function(e){
	if(e.deltaY>0){
		$('.owl-carousel').trigger('next.owl');
	}else{
		$('.owl-carousel').trigger('prev.owl');
	}
	e.preventDefault();
});

