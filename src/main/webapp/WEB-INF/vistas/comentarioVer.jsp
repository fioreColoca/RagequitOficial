<%@ include file="header.jsp"%>
<main>



<div class="container p-3 mb-2 colorCeleste text-white">
	
	<div class="row">

		<div class="d-flex flex-row user-info mb-3 col-md-2 col-lg-1 justify-content-center">
				<img class="rounded-circle" src="img/santiago.jpeg" width="50" height="50">
		</div>
		
		<div class="container col-md-10 col-lg-11 justify-content-center"> 
		
				<h5>Nombre de usuario</h5>	 	
			 	<small>   ${comentario.getFechaHora().getHours()}:${comentario.getFechaHora().getMinutes()} hs ${comentario.getFechaHora().getDate()} / ${comentario.getFechaHora().getMonth()} / ${comentario.getFechaHora().getYear() + 1900 }  </small>
				<p>En respuesta a: </p>
				
				<div class="container colorComentario">
				<p class="text-dark !important p-3">${comentario.getMensaje()}</p>
				</div>
	 	
	 	
	 	<p> ${comentario.getTipo()}</p>
	 	
	 	<div class=" container row">
	 	
	 	<div>
	 		<form action="meGustaComentario">
				<button type="submit" value=" ${comentario.getId()}" name="botonLike" class="text-warning btn btn-outline-warning">
					<svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-star-fill" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
  						<path d="M3.612 15.443c-.386.198-.824-.149-.746-.592l.83-4.73L.173 6.765c-.329-.314-.158-.888.283-.95l4.898-.696L7.538.792c.197-.39.73-.39.927 0l2.184 4.327 4.898.696c.441.062.612.636.283.95l-3.523 3.356.83 4.73c.078.443-.36.79-.746.592L8 13.187l-4.389 2.256z"/>
					</svg>
				</button>
			</form> <!--  Esto tiene pìnta de hacerse de una manera mas limpia -->
			 
		</div>
		
		<div class="ml-1">
		 	<p>${comentario.getCantidadLikes()}</p>
		</div>
		
		<div class="ml-3">
		<button type="submit" class="text-warning btn btn-outline-warning">
		<svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-chat-dots" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
  			<path fill-rule="evenodd" d="M2.678 11.894a1 1 0 0 1 .287.801 10.97 10.97 0 0 1-.398 2c1.395-.323 2.247-.697 2.634-.893a1 1 0 0 1 .71-.074A8.06 8.06 0 0 0 8 14c3.996 0 7-2.807 7-6 0-3.192-3.004-6-7-6S1 4.808 1 8c0 1.468.617 2.83 1.678 3.894zm-.493 3.905a21.682 21.682 0 0 1-.713.129c-.2.032-.352-.176-.273-.362a9.68 9.68 0 0 0 .244-.637l.003-.01c.248-.72.45-1.548.524-2.319C.743 11.37 0 9.76 0 8c0-3.866 3.582-7 8-7s8 3.134 8 7-3.582 7-8 7a9.06 9.06 0 0 1-2.347-.306c-.52.263-1.639.742-3.468 1.105z"/>
  			<path d="M5 8a1 1 0 1 1-2 0 1 1 0 0 1 2 0zm4 0a1 1 0 1 1-2 0 1 1 0 0 1 2 0zm4 0a1 1 0 1 1-2 0 1 1 0 0 1 2 0z"/>
		</svg>
		</button>
		</div>
	
		<div class="ml-3">
			<form action="borrarComentario">
				<button type="button" class="btn btn-outline-warning botonBorrar" data-toggle="modal" data-target="#borrarComentario" data-id="${comentario.getId()}">
					<svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-trash2-fill" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
  						<path d="M2.037 3.225l1.684 10.104A2 2 0 0 0 5.694 15h4.612a2 2 0 0 0 1.973-1.671l1.684-10.104C13.627 4.224 11.085 5 8 5c-3.086 0-5.627-.776-5.963-1.775z"/>
  						<path fill-rule="evenodd" d="M12.9 3c-.18-.14-.497-.307-.974-.466C10.967 2.214 9.58 2 8 2s-2.968.215-3.926.534c-.477.16-.795.327-.975.466.18.14.498.307.975.466C5.032 3.786 6.42 4 8 4s2.967-.215 3.926-.534c.477-.16.795-.327.975-.466zM8 5c3.314 0 6-.895 6-2s-2.686-2-6-2-6 .895-6 2 2.686 2 6 2z"/>
					</svg>
				</button>
			</form>
		</div>
	
		</div>
	 </div>
	 
	 
	 
	 <div class="modal fade" id="borrarComentario" tabindex="-1" aria-hidden="true">
  		<div class="modal-dialog">
    		<div class="modal-content">
      			<div class="modal-header">
        			<h5 class="modal-title text-dark">Borrar comentario</h5>
        			<button type="button" class="close" data-dismiss="modal" aria-label="Close">
          				<span aria-hidden="true">&times;</span>
        			</button>
      			</div>
      			<div class="modal-body text-dark">
        			<p>¿Seguro que deseas borrar el comentario?.</p>
      			</div>
      			<div class="modal-footer">
        			<button type="button" class="btn btn-secondary" data-dismiss="modal">No</button>
        			<form action="borrarComentario">
        				<button type="submit" class="btn btn-danger" name="botonBorrar" id="botonBorrar">BORRAR</button>
        			</form>
        			
      			</div>
    		</div>
  		</div>
  	</div>	
  	
  	
  	</div>
</main>	

	<!--  ACA NO VA EL ESTILO, ES PROVISORIO -->
	<style> 
	.colorCeleste{background: #287EB0;}
	.colorComentario{background: #eceff0;}
	</style>
	
	
<%@ include file="footer.jsp"%>
