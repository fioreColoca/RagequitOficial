<%@ include file="header.jsp"%>
<main>
    <section>

        <article class="">
            <h3 class="border-bottom text-center mb-4">Categorias</h3>
            <p> Estas categorias fueron creadas: </p>

            <div class="row justify-content-center">
                <c:if test="${not empty categorias}">
                    <c:forEach items="${categorias}" var="categoria">

                        <div class="col-12 col-md-6 p-3 m-1 bg-fondo ajustarIrCategoria rounded-pill">
                            <div class="d-flex flex-wrap justify-content-around">
                                <img alt="logo" class="categoria-icon" src="${categoria.getUrlIcono()}">
                                <p>Nombre: ${categoria.getNombre()} <br> Tipo: ${categoria.getTipoCategoria()} </p>
                                <div class="d-flex flex-wrap justify-content-end p-3">
                                    <button type="button" class="btn btn-outline-naranja botonEditar"
                                        data-toggle="modal" data-target="#editarCategoria"
                                        data-id="${categoria.getId()}">
                                        <i class="far fa-edit"></i>
                                    </button>

                                    <button type="button" class="btn btn-outline-naranja botonBorrar"
                                        data-toggle="modal" data-target="#borrarCategoria"
                                        data-id="${categoria.getId()}">
                                        <i class="far fa-trash-alt"></i>
                                    </button>

                                </div>
                            </div>
                        </div>

                    </c:forEach>
                </c:if>
            </div>

            <div class="modal fade" id="editarCategoria" tabindex="-1" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content p-3 m-1">
                        <div class="modal-header">
                            <h5 class="modal-title text-dark">Editar categoría</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>

                        <form action="editarCategoria">
                            <div class="text-dark form-group">
                                <label for="nombre">Nombre de la categoria:</label>
                                <input type="text" name="nombre" id="nombre" class="form-control"
                                    placeholder="Valorant, Anime, Musica ...">
                            </div>
                            <div class="text-dark">
                                <label for="filtro">Tipo de categoria</label>
                                <select name="categoria" id="categoria" class="custom-select">
                                    <option disabled selected>Seleccione una opción</option>
                                    <option value="0">Juegos</option>
                                    <option value="1">Varios</option>
                                </select>
                            </div>

                            <label class="text-dark pt-3" for="archivoImagenVideo">Subir imagen o video</label>
                            <input type="file" class="form-control-file col-md-2" name="archivoImagenVideo"
                                id="archivoImagenVideo">

                            <div class="text-right modal-footer">
                                <button type="submit" class="btn btn-naranja mt-3 botonBloque" name="botonGuardar"
                                    id="botonGuardar">GUARDAR</button>
                            </div>
                        </form>

                        <c:if test="${errorNombre != 'null'}">
                            <h4 class="text-danger"><span>${errorNombre}</span></h4>
                            <br>
                        </c:if>

                        <c:if test="${errorTipo != 'null'}">
                            <h4 class="text-danger"><span>${errorTipo}</span></h4>
                            <br>
                        </c:if>

                    </div>
                </div>
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
            <div class="text-right subirDiv">
                <a href="categoria" class="btn btn-outline-naranja volverACategoria">Crear una nueva categoria</a>
            </div>
        </article>

    </section>
</main>
<%@ include file="footer.jsp"%>

<!--Tipo: ${categoriaCreada.getTipoCategoria()} Nombre: ${categoriaCreada.getNombre()}-->