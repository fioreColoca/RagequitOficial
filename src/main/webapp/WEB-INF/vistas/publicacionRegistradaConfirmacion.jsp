<%@ include file="header.jsp"%>
	<main>
	<section>
		<c:if test="${not empty mensaje}">
			<h2 class="text-center text-warning">${mensaje}</h2>
			<a href="publicar"><button type="submit" class="btn btn-warning">Volver al inicio</button></a>
		</c:if>	
	</section>
	<section>
		<c:if test="${not empty publicaciones}">
    		<c:forEach items="${publicaciones}" var="publicacion">
       			<div class="container mt-5 mb-5">
					<div class="d-flex justify-content-center row">
						<div class="col-md-10">
							<div class="d-flex justify-content-around p-2 bg-primary" >
								<div class="d-flex flex-column justify-content-start">
									<h3>Santiago Fagliano</h3>
  									<button class="btn btn-warning">SEGUIR</button>
								</div>
								<div class="d-flex flex-row user-info">
									<img class="rounded-circle" src="img/santiago.jpeg" width="100">
								</div>		
  								<div class="text-right">
  									<h4>${publicacion.getCategoria()}</h4>
  									<p class="text-white-50">${publicacion.getFechaHora().getHours()}:${publicacion.getFechaHora().getMinutes()}hs 
  									${publicacion.getFechaHora().getDate()}/${publicacion.getFechaHora().getMonth()}/${publicacion.getFechaHora().getYear()}</p>
  									<button type="button" class="btn btn-outline-warning botonBorrar" data-toggle="modal" data-target="#borrarPublicacion" data-id="${publicacion.getId()}">
  										<svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-trash" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
  											<path d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0V6z"/>
  											<path fill-rule="evenodd" d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1v1zM4.118 4L4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4H4.118zM2.5 3V2h11v1h-11z"/>
										</svg>
  									</button>
  								</div>	
							</div>
  							<div class="text-left p-3 bg-light text-dark">
  								<p class="comment-text">${publicacion.getMensaje()}</p>
  							</div>
  							<div class="d-flex justify-content-around bg-primary p-2">
  								<i class="fa fa-thumbs-o-up btn btn-outline-warning"></i>
  								<i class="fa fa-commenting-o btn btn-outline-warning"></i>
  								<i class="fa fa-share-alt btn btn-outline-warning"></i>
  								<i class="fa fa-gg btn btn-outline-warning"></i>
  							</div>
  						</div>
  					</div>
				</div>
		</c:forEach>
	</c:if>
	<div class="modal fade" id="borrarPublicacion" tabindex="-1" aria-hidden="true">
  		<div class="modal-dialog">
    		<div class="modal-content">
      			<div class="modal-header">
        			<h5 class="modal-title text-dark">Borrar publicacion</h5>
        			<button type="button" class="close" data-dismiss="modal" aria-label="Close">
          				<span aria-hidden="true">&times;</span>
        			</button>
      			</div>
      			<div class="modal-body text-dark">
        			<p>¿Seguro que deseas borrar la publicacion?.</p>
      			</div>
      			<div class="modal-footer">
        			<button type="button" class="btn btn-secondary" data-dismiss="modal">No</button>
        			<form action="borrarPublicacion">
        				<button type="submit" class="btn btn-danger" name="botonBorrar" id="botonBorrar">BORRAR</button>
        			</form>
        			
      			</div>
    		</div>
  		</div>
  	</div>	
</section>
	<!--<h1 class="text-center">Publicacion</h1>
	<div>
		<p>	El ID de la publicacion es: ${idpublicacion}. </p>
		<p>	El Mensaje de la publicacion es: ${publicacion.getMensaje()}</p>
		<p>	La categoria de la publicacion es: ${categoria}</p>
		<a href="registrarPublicacion">Hacer otra publicacion</a>
	</div>  
	<div class="container mt-5 mb-5">
		<div class="d-flex justify-content-center row">
			<div class="col-md-10">
				<div class="d-flex justify-content-around p-2 bg-primary" >
					<div class="d-flex flex-column justify-content-start">
						<h3>Santiago Fagliano</h3>
  						<button class="btn btn-warning">SEGUIR</button>
					</div>
					<div class="d-flex flex-row user-info">
						<img class="rounded-circle" src="img/santiago.jpeg" width="100">
					</div>		
  					<div class="text-right">
  						<h4>${categoria}</h4>
  						<p class="text-white-50">${publicacion.getFechaHora().getHours()}:${publicacion.getFechaHora().getMinutes()}hs 
  						${publicacion.getFechaHora().getDate()}/${publicacion.getFechaHora().getMonth()}/${publicacion.getFechaHora().getYear()}</p>
  					</div>	
				</div>
  				<div class="text-left p-3 bg-light text-dark">
  					<p class="comment-text">${publicacion.getMensaje()}</p>
  				</div>
  				<div class="d-flex justify-content-around bg-primary p-2">
  					<i class="fa fa-thumbs-o-up btn btn-outline-warning"></i>
  					<i class="fa fa-commenting-o btn btn-outline-warning"></i>
  					<i class="fa fa-share-alt btn btn-outline-warning"></i>
  					<i class="fa fa-gg btn btn-outline-warning"></i>
  				</div>
  			</div>
  		</div>
	</div>
	<div class="text-center">
		<a class="btn btn-warning" href="registrarPublicacion">Hacer otra publicacion</a>
	</div>-->
	</main>
<%@ include file="footer.jsp"%>