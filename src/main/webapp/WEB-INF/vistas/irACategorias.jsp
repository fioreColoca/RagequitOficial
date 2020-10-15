<%@ include file="header.jsp"%>
<main>
	<section>
		
		<section>
		<h3>¡Tu categoria se guard&oacute; con &eacute;xito!</h3>
		<p> Estas categorias fueron creadas: </p>
		<c:if test="${not empty categorias}">
    		<c:forEach items="${categorias}" var="categoria">
       			<div class="container mt-2 mb-2">
					<div class="d-flex justify-content-center row">
						<div>
						<p>Tipo: ${categoria.getTipoCategoria()} Nombre: ${categoria.getNombre()}</p>
						</div>
  					</div>
				</div>
		</c:forEach>
	</c:if>
	</section>

	</section>
</main>
<%@ include file="footer.jsp"%>

<!--Tipo: ${categoriaCreada.getTipoCategoria()} Nombre: ${categoriaCreada.getNombre()}-->