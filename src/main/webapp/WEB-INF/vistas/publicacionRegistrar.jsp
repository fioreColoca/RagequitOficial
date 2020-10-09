<%@ include file="header.jsp"%>
<main>
<h1 class = "text-center">Publicar</h1>
<form action="confirmacionRegistroPublicacion">
	<div class="form-inline justify-content-sm-end">
    	<label class="my-1 mr-2" for="categoriaPublicacion"><b>Categoria</b></label>
      	<select class="custom-select my-1 mr-sm-2" name="categoriaPublicacion" id="categoriaPublicacion" >
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
      	<textarea id="mensajePublicacion" name="mensajePublicacion" class="form-control" rows="3"></textarea>
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
      	<button class="btn btn-warning " type="submit">Publicar</button>
      </div>
      
    </form>
</main>
<%@ include file="footer.jsp"%>

