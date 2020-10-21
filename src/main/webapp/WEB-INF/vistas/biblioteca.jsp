<%@ include file="header.jsp"%>

<main>
	<form action="biblioteca">
		<label for="filtro">Filtrar contenido por Genero</label>
		<select name="categoriaId" id="filtro">
		<option value="-1" selected>Elegir</option>
		<c:if test="${not empty categorias}">
			<c:forEach items="${categorias}" var="categoriaDelFor">
					<option value="${categoriaDelFor.getId()}">${categoriaDelFor.getTipoCategoria()}</option>
			</c:forEach>
		</c:if>
		</select>
		<button type="submit">Filtrar</button>
	</form>
	<br>



</main>

<%@ include file="footer.jsp"%>