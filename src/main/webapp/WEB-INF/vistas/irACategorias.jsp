<%@ include file="header.jsp"%>
<main>
	<section>
		
		<section>
		<h3>¡Tu categoria se guard&oacute; con &eacute;xito!</h3>
		<p> Estas categorias fueron creadas: </p>
		<c:if test="${not empty categorias}">
    		<c:forEach items="${categorias}" var="categoria">
					<div class="container mt-5 mb-5">
                        <div class="d-flex justify-content-center row">
                            <div class="col-md-8">
                                <div class="d-flex justify-content-center p-2 bg-primary">
                                    <div class="d-flex flex-column justify-content-start">
						<div>
						<h4></h4>
						<p>Tipo: ${categoria.getTipoCategoria()} Nombre: ${categoria.getNombre()}</p>
						<button type="button" class="btn btn-outline-warning botonBorrar" data-toggle="modal" data-target="#borrarCategoria" data-id="${categoria.getId()}">
                            <i class="far fa-trash-alt"></i>
                        </button>
						</div>
  					</div>
				</div>
				</div>
                </div>
            </div>
		</c:forEach>
	</c:if>
	
	<div class="modal fade" id="borrarCategoria" tabindex="-1" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title text-dark">Borrar categoria</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                        </div>
                        <div class="modal-body text-dark">
                            <p>¿Seguro que deseas borrar la categoria?</p>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">No</button>
                            <form action="borrarCategoria">
                                <button type="submit" class="btn btn-danger" name="botonBorrar" id="botonBorrar">BORRAR</button>
                            </form>

                        </div>
                    </div>
                </div>
            </div>
	</section>

	</section>
</main>
<%@ include file="footer.jsp"%>

<!--Tipo: ${categoriaCreada.getTipoCategoria()} Nombre: ${categoriaCreada.getNombre()}-->