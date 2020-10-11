<%@ include file="header.jsp"%>
	<main>
	<h1 class="text-center">Publicacion</h1>
	<!--<div>
		<p>	El ID de la publicacion es: ${idpublicacion}. </p>
		<p>	El Mensaje de la publicacion es: ${publicacion.getMensaje()}</p>
		<p>	La categoria de la publicacion es: ${categoria}</p>
		<a href="registrarPublicacion">Hacer otra publicacion</a>
	</div>  -->
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
  					<i class="fa fa-thumbs-o-up"></i>
  					<i class="fa fa-commenting-o"></i>
  					<i class="fa fa-share"></i>
  					<i class="fa fa-gg"></i>
  				</div>
  			</div>
  		</div>
	</div>
	<div class="text-center">
		<a class="btn btn-warning" href="registrarPublicacion">Hacer otra publicacion</a>
	</div>
	</main>
<%@ include file="footer.jsp"%>