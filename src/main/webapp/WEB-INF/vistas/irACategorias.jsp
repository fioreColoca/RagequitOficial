<%@ include file="header.jsp"%>
<main>
    <section>

        <article class="" >
            <h3>¡Tu categoria se guard&oacute; con &eacute;xito!</h3>
            <p> Estas categorias fueron creadas: </p>
            <div class="text-right subirDiv">
            <a href="categoria" class="volverACategoria">Crear una categoria nuevamente</a>
            </div>
            <div class="row justify-content-center">
                <c:if test="${not empty categorias}">
                    <c:forEach items="${categorias}" var="categoria">

                        <div class="col-12 col-md-6 p-3 m-1 bg-fondo ajustarIrCategoria rounded-pill">
                            <div class="d-flex flex-wrap justify-content-around">
                                <h4></h4>
                                <p>Tipo: ${categoria.getTipoCategoria()} Nombre: ${categoria.getNombre()}
                                </p>
                                <button type="button" class="btn btn-outline-naranja botonBorrar" data-toggle="modal"
                                    data-target="#borrarCategoria" data-id="${categoria.getId()}">
                                    <i class="far fa-trash-alt"></i>
                                </button>
                            </div>
                        </div>

                    </c:forEach>
                </c:if>
            </div>

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
                                <button type="submit" class="btn btn-danger" name="botonBorrar"
                                    id="botonBorrar">BORRAR</button>
                            </form>

                        </div>
                    </div>
                </div>
            </div>
        </article>

    </section>
</main>
<%@ include file="footer.jsp"%>

<!--Tipo: ${categoriaCreada.getTipoCategoria()} Nombre: ${categoriaCreada.getNombre()}-->