<%@ include file="header.jsp"%>
<main>
<h1 class = "text-center">Publicar</h1>
<section>
	<form action="">
		<div class="form-inline justify-content-sm-end">
    		<label class="my-1 mr-2" for="categoriaPublicacion"><b>Categoria</b></label>
      		<select class="custom-select my-1 mr-sm-2" name="categoriaPublicacion" id="categoriaPublicacion" required>
      			<option value="" selected disabled>Elegir</option>
        			<optgroup label="Juegos">
         				<option value="valorant">Valorant</option>
         				<option value="smite">Smite</option>
         				<option value="counter-strike">Counter-Strike</option>
         				<option value="among us">Among Us</option>
         			</optgroup>
  					<optgroup label="Otros">
         				<option value="anime">Anime</option>
         				<option value="arte">Arte</option>
         				<option value="uwu">uwu</option>
         				<option value="comida">Comida</option>
         				<option value="social">Social</option>
						<option value="social">Reggeton</option>
         			</optgroup>	
			</select>    	
      </div>
      <div class="form-group">
      	<label for="mensajePublicacion"><b>Mensaje Gamer para Gamers:</b></label>
      	<textarea id="mensajePublicacion" name="mensajePublicacion" class="form-control" rows="3" required></textarea>
      </div>
      <div class="form-row">
      	<svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-file-image col-auto" fill="currentColor" xmlns="http://www.w3.org/2000/svg" style="color:#f4a117">
  			<path fill-rule="evenodd" d="M4 0h8a2 2 0 0 1 2 2v12a2 2 0 0 1-2 2H4a2 2 0 0 1-2-2V2a2 2 0 0 1 2-2zm0 1a1 1 0 0 0-1 1v10l2.224-2.224a.5.5 0 0 1 .61-.075L8 11l2.157-3.02a.5.5 0 0 1 .76-.063L13 10V2a1 1 0 0 0-1-1H4z"/>
  			<path fill-rule="evenodd" d="M6.502 7a1.5 1.5 0 1 0 0-3 1.5 1.5 0 0 0 0 3z"/>
		</svg>
    	<label class="col-auto" for="archivoImagenVideo">Subir imagen o video</label>
    	<input type="file" class="form-control-file col-md-2" name="archivoImagenVideo" id="archivoImagenVideo">
	  </div>
      <div class="text-right">
      	<button class="btn btn-warning" type="submit">Publicar</button>
      </div>    
    </form>
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
</section>
</main>
<%@ include file="footer.jsp"%>