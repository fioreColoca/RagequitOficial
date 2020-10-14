<%@ include file="header.jsp"%>
          <main>
            <section>
                    <p>
                        <a class="btn btn-warning " data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample" >
                        Presione aqu&iacute; para mas informaci&oacute;n...
                    </a>

                    </p>
                <div class="collapse" id="collapseExample">
                    <div class="card card-body info">
                        Bienvenido a la p&aacute;gina oficial de RageQuit, en estos momentos la pagina se encuentra en construccion. Pero puede pasar a examinar nuestras diferentes ar&eacute;as. Saludos, comision directiva de RageQuit.
                        <svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-joystick" fill="currentColor" xmlns="http://www.w3.org/2000/svg" style="color: #f4a117">
                        <path
                            d="M7.106 15.553L.553 12.276A1 1 0 0 1 0 11.382V9.471a1 1 0 0 1 .606-.89L6 6.269v1.088L1 9.5l5.658 2.83a3 3 0 0 0 2.684 0L15 9.5l-5-2.143V6.27l5.394 2.312a1 1 0 0 1 .606.89v1.911a1 1 0 0 1-.553.894l-6.553 3.277a2 2 0 0 1-1.788 0z" />
                        <path fill-rule="evenodd" d="M7.5 9.5v-6h1v6h-1z" />
                        <path
                            d="M10 9.75c0 .414-.895.75-2 .75s-2-.336-2-.75S6.895 9 8 9s2 .336 2 .75zM10 2a2 2 0 1 1-4 0 2 2 0 0 1 4 0z" />
                    </svg>
                    </div>
                </div>
            </section>
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
<hr>
<section>
	<form action="filtrarCategoria">
		<div class="form-inline justify-content-sm-end">
    		<label class="my-1 mr-2" for="filtarPublicacionCategoria"><b>Filtrar publicaciones por categorias</b></label>
      		<select class="custom-select my-1 mr-sm-2" name="filtarPublicacionCategoria" id="filtarPublicacionCategoria" required>
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
			<div class="text-right">
      			<button class="btn btn-warning" type="submit">Filtrar</button>
      		</div> 	
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
  									${publicacion.getFechaHora().getDate()}/${publicacion.getFechaHora().getMonth()}/${anio}</p>
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
        </main>

<%@ include file="footer.jsp"%>