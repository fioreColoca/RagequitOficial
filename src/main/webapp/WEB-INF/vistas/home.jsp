<%@ include file="header.jsp"%>
<main>
    <section>
        <p>
            <a class="btn btn-naranja" data-toggle="collapse" href="#collapseExample" role="button"
                aria-expanded="false" aria-controls="collapseExample">
                Presione aqu&iacute; para mas informaci&oacute;n...
            </a>

        </p>
        <div class="collapse" id="collapseExample">
            <div class="card card-body info">
                Bienvenido a la p&aacute;gina oficial de RageQuit, en estos momentos la pagina se encuentra en
                construccion. Pero puede pasar a examinar nuestras diferentes ar&eacute;as. Saludos, comision directiva
                de RageQuit.
                <svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-joystick" fill="currentColor"
                    xmlns="http://www.w3.org/2000/svg" style="color: #f4a117">
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
        <div>
            <h3 class="border-bottom text-center mb-4">Inicio</h3>
        </div>
        <form:form action="guardarPublicacion" method="POST" modelAttribute="publicacion">
            <div class="form-inline justify-content-sm-end">
                <label class="my-1 mr-2" for="categoriaPublicacion"><b>Categoria</b></label>
                <form:select path="categoriaId" class="custom-select my-1 mr-sm-2" id="categoriaPublicacion">
                    <option value="-1" selected>Elegir</option>
                    <c:if test="${not empty categorias}">
                        <optgroup label="Juegos">
                            <c:forEach items="${categorias}" var="categoriaDelFor">
                                <c:if test="${categoriaDelFor.getTipoCategoria() == 'JUEGOS'}">
                                    <option value="${categoriaDelFor.getId()}">${categoriaDelFor.getNombre()}</option>
                                </c:if>
                            </c:forEach>
                        </optgroup>
                        <optgroup label="Otros">
                            <c:forEach items="${categorias}" var="categoriaDelFor">
                                <c:if test="${categoriaDelFor.getTipoCategoria() == 'VARIOS'}">
                                    <option value="${categoriaDelFor.getId()}">${categoriaDelFor.getNombre()}</option>
                                </c:if>
                            </c:forEach>
                        </optgroup>
                    </c:if>
                </form:select>
            </div>
            <div class="form-group">
                <label for="mensajePublicacion"><b>Mensaje Gamer para Gamers:</b></label>
                <form:textarea path="mensaje" id="mensajePublicacion" name="mensajePublicacion" class="form-control"
                    rows="3" />
            </div>
            <div class="form-row">
                <svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-file-image col-auto" fill="currentColor"
                    xmlns="http://www.w3.org/2000/svg" style="color:#f4a117">
                    <path fill-rule="evenodd"
                        d="M4 0h8a2 2 0 0 1 2 2v12a2 2 0 0 1-2 2H4a2 2 0 0 1-2-2V2a2 2 0 0 1 2-2zm0 1a1 1 0 0 0-1 1v10l2.224-2.224a.5.5 0 0 1 .61-.075L8 11l2.157-3.02a.5.5 0 0 1 .76-.063L13 10V2a1 1 0 0 0-1-1H4z" />
                    <path fill-rule="evenodd" d="M6.502 7a1.5 1.5 0 1 0 0-3 1.5 1.5 0 0 0 0 3z" />
                </svg>
                <label class="col-auto" for="archivoImagenVideo">Subir imagen o video</label>
                <input type="file" class="form-control-file col-md-2" name="archivoImagenVideo" id="archivoImagenVideo">
            </div>
            <div class="text-right">
                <button class="btn btn-naranja botonBloque mt-3" type="submit">Publicar</button>
            </div>
        </form:form>
        <c:if test="${errorCategoria != 'null'}">
            <h4 class="text-danger"><span>${errorCategoria}</span></h4>
            <br>
        </c:if>
        <c:if test="${errorMensaje != 'null'}">
            <h4 class="text-danger"><span>${errorMensaje}</span></h4>
            <br>
        </c:if>
    </section>
    <hr>
    <section>
        <form action="filtrarCategoria">
            <div class="form-inline justify-content-sm-end">
                <label class="my-1 mr-2" for="filtarPublicacionCategoria"><b>Filtrar publicaciones por
                        categorias</b></label>
                <select class="custom-select my-1 mr-sm-2" name="filtarPublicacionCategoria"
                    id="filtarPublicacionCategoria" required>
                    <option value="-1" selected>Todas</option>
                    <c:if test="${not empty categorias}">
                        <optgroup label="Juegos">
                            <c:forEach items="${categorias}" var="categoriaDelFor">
                                <c:if test="${categoriaDelFor.getTipoCategoria() == 'JUEGOS'}">
                                    <option value="${categoriaDelFor.getId()}">${categoriaDelFor.getNombre()}</option>
                                </c:if>
                            </c:forEach>
                        </optgroup>
                        <optgroup label="Otros">
                            <c:forEach items="${categorias}" var="categoriaDelFor">
                                <c:if test="${categoriaDelFor.getTipoCategoria() == 'VARIOS'}">
                                    <option value="${categoriaDelFor.getId()}">${categoriaDelFor.getNombre()}</option>
                                </c:if>
                            </c:forEach>
                        </optgroup>
                    </c:if>
                </select>
                <div class="text-right">
                    <button class="btn btn-naranja" type="submit">Filtrar</button>
                </div>
            </div>
        </form>
        <section>
        </section>
        <section>
            <c:if test="${not empty publicaciones}">
                <c:forEach items="${publicaciones}" var="publicacionDelFor">
                    <div class="container mt-5 mb-5">
                        <div class="d-flex justify-content-center row">
                            <div class="col-md-10">
                                <div class="d-flex justify-content-around p-2 bg-fondo">
                                    <div class="d-flex flex-column justify-content-start">
                                        <h3>Santiago Fagliano</h3>
                                        <button class="btn btn-naranja">SEGUIR</button>
                                    </div>
                                    <div class="d-flex flex-row user-info">
                                        <img class="rounded-circle" src="img/santiago.jpeg" width="100">
                                    </div>
                                    <div class="text-right">
                                        <h4>${publicacionDelFor.getCategoria().getNombre()}</h4>
                                        <p class="text-white-50">
                                            ${publicacionDelFor.getFechaHora().getHours()}:${publicacionDelFor.getFechaHora().getMinutes()}hs
                                            ${publicacionDelFor.getFechaHora().getDate()}/${publicacionDelFor.getFechaHora().getMonth()}
                                        </p>
                                        <button type="button" class="btn btn-outline-naranja botonBorrar"
                                            data-toggle="modal" data-target="#borrarPublicacion"
                                            data-id="${publicacionDelFor.getId()}">
                                            <i class="far fa-trash-alt"></i>
                                        </button>
                                    </div>
                                </div>
                                <div class="text-left p-3 bg-light text-dark">
                                    <p class="comment-text">${publicacionDelFor.getMensaje()}</p>
                                </div>
                                <div class="hoverIcons d-flex justify-content-around bg-fondo p-2">
                                    <form>
                                        <div>
                                            <button class="btn btn-outline-naranja" value="${publicacionDelFor.getId()}"
                                                name="idPublicacionADarLike"><i class="far fa-thumbs-up"></i></button>
                                        </div>
                                    </form>
                                    <form>
                                        <div>
                                            <button type="submit" class="btn btn-outline-naranja"><i
                                                    class="far fa-comment-dots"></i></button>
                                        </div>
                                    </form>
                                    <form>
                                        <div>
                                            <button type="submit" class="btn btn-outline-naranja"><i
                                                    class="fab fa-gg"></i></button>
                                        </div>
                                    </form>
                                    <form>
                                        <div>
                                            <button type="submit" class="btn btn-outline-naranja"><i
                                                    class="fas fa-share-alt"></i></button>
                                        </div>
                                    </form>
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
                                <button type="submit" class="btn btn-danger" name="botonBorrar"
                                    id="botonBorrar">BORRAR</button>
                            </form>

                        </div>
                    </div>
                </div>
            </div>
        </section>
</main>

<%@ include file="footer.jsp"%>