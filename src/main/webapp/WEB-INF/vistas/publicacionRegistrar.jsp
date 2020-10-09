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
      <div class="text-right">
      	<button class="btn btn-warning " type="submit">Publicar</button>
      </div>
      
    </form>
</main>
<%@ include file="footer.jsp"%>

