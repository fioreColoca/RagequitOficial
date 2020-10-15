<%@ include file="header.jsp"%>
<main>
	<section>
		<div>
	 		<form action="agregarCategoria">
		<label for="filtro">Filtrar contenido por categoria</label> 
			<select name="categoria" id="categoria">
				<option value="Juegos">Juegos</option>
				<option value="Varios">Varios</option>
			</select>
			
		<div class="form-group">
      	<label for="crearCategoria"><b>¿De qu&eacute; quieres hablar?</b></label>
      	<textarea id="crearCategoria" name="crearCategoria" class="form-control" rows="3" required></textarea>
      </div>
			<button type="submit">Crear</button>
	</form>
		</div>
	</section>
</main>
<%@ include file="footer.jsp"%>