<%@ include file="header.jsp"%>
<main>
    <section class="">
        <div class="">
            <div class="owl-carousel owl-theme">
                <c:if test="${not empty categorias}">
                    <c:forEach items="${categorias}" var="categoriaDelFor">
                        <c:if test="${categoriaDelFor.getTipoCategoria() == 'JUEGOS'}">
                            <div class="item">
                            	<a href="juegosOVarios?categoriaId=${categoriaDelFor.getId()}">
                                	<img class="owl-lazy" data-src="${categoriaDelFor.getUrlImagen()}">
                                </a>
                            </div>
                        </c:if>
                    </c:forEach>
                </c:if>
            </div>
        </div>
    </section>
    <c:if test="${not empty usuarioLogeado}">
        <section class="">
            <form:form action="guardarPublicacion" method="POST" modelAttribute="publicacion">
                <div class="form-inline justify-content-sm-end">
                    <label class="my-1 mr-2" for="categoriaPublicacion"><b>Categoria</b></label>
                    <form:select path="categoriaId" class="custom-select my-1 mr-sm-2" id="categoriaPublicacion">
                        <option value="-1" selected>Elegir</option>
                        <c:if test="${not empty categorias}">
                            <optgroup label="Juegos">
                                <c:forEach items="${categorias}" var="categoriaDelFor">
                                    <c:if test="${categoriaDelFor.getTipoCategoria() == 'JUEGOS'}">
                                        <option value="${categoriaDelFor.getId()}">${categoriaDelFor.getNombre()}
                                        </option>
                                    </c:if>
                                </c:forEach>
                            </optgroup>
                            <optgroup label="Otros">
                                <c:forEach items="${categorias}" var="categoriaDelFor">
                                    <c:if test="${categoriaDelFor.getTipoCategoria() == 'VARIOS'}">
                                        <option value="${categoriaDelFor.getId()}">${categoriaDelFor.getNombre()}
                                        </option>
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
                    <svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-file-image col-auto"
                        fill="currentColor" xmlns="http://www.w3.org/2000/svg" style="color:#f4a117">
                        <path fill-rule="evenodd"
                            d="M4 0h8a2 2 0 0 1 2 2v12a2 2 0 0 1-2 2H4a2 2 0 0 1-2-2V2a2 2 0 0 1 2-2zm0 1a1 1 0 0 0-1 1v10l2.224-2.224a.5.5 0 0 1 .61-.075L8 11l2.157-3.02a.5.5 0 0 1 .76-.063L13 10V2a1 1 0 0 0-1-1H4z" />
                        <path fill-rule="evenodd" d="M6.502 7a1.5 1.5 0 1 0 0-3 1.5 1.5 0 0 0 0 3z" />
                    </svg>
                    <label class="col-auto" for="archivoImagenVideo">Subir imagen o video</label>
                    <input type="file" class="form-control-file col-md-2" name="archivoImagenVideo"
                        id="archivoImagenVideo">
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
    </c:if>
    <hr>
    <section>
        <article>
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
                                        <option value="${categoriaDelFor.getId()}">${categoriaDelFor.getNombre()}
                                        </option>
                                    </c:if>
                                </c:forEach>
                            </optgroup>
                            <optgroup label="Otros">
                                <c:forEach items="${categorias}" var="categoriaDelFor">
                                    <c:if test="${categoriaDelFor.getTipoCategoria() == 'VARIOS'}">
                                        <option value="${categoriaDelFor.getId()}">${categoriaDelFor.getNombre()}
                                        </option>
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
        </article>
        <c:if test="${not empty errorComentarioVacio == 'true'}">
        	<h5 class="text-danger">No puede enviar un comentario vacio.</h5>
        </c:if>
        <c:if test="${errorBorrarPublicacion == 'true'}">
        	<h5 class="text-danger">Ocurrio un error al borrar la publicacion.</h5>
        </c:if>
        <c:if test="${errorBorrarPublicacion == 'false'}">
        	<h5 class="text-success">Se borro la publicacion con exito.</h5>
        </c:if>
        <article>
            <div class="container mt-5 mb-5">
                <div class="row">
                    <c:if test="${not empty publicaciones}">
                        <c:forEach items="${publicaciones}" var="publicacionDelFor">
                            <div class="col-12 mt-5 mb-5 rounded-lg">
                                <div class="d-flex justify-content-around p-2 bg-fondo rounded-top">
                                    <div class="col-4 justify-content-start">
                                        <h3>${publicacionDelFor.getUsuario().getNombreUsuario()}</h3>
                                        <button class="btn btn-naranja">SEGUIR</button>
                                    </div>
                                    <div class="col-4 text-center user-info">
                                        <img class="rounded-circle"
                                            src="${publicacionDelFor.getUsuario().getUrl_imagen()}" width="100">
                                    </div>
                                    <div class="col-4 text-right">
                                        <div class="d-flex justify-content-end">
                                            <img alt="logo" class="categoria-icon pr-1"
                                                src="${publicacionDelFor.getCategoria().getUrlIcono()}">
                                            <h4>${publicacionDelFor.getCategoria().getNombre()}</h4>
                                        </div>
                                        <p class="text-white-50">
                                            ${publicacionDelFor.getFechaHora().getHours()}:${publicacionDelFor.getFechaHora().getMinutes()}hs
                                            ${publicacionDelFor.getFechaHora().getDate()}/${publicacionDelFor.getFechaHora().getMonth()}
                                        </p>
                                        <c:if test="${publicacionDelFor.getUsuario().getId() == usuarioLogeado.getId()}">
                                        	<button type="button" class="btn btn-outline-naranja botonBorrar"
                                            	data-toggle="modal" data-target="#borrarPublicacion"
                                            	data-id="${publicacionDelFor.getId()}">
                                            	<i class="far fa-trash-alt"></i>
                                        	</button>
                                        </c:if>
                                    </div>
                                </div>
                                <div class="text-left p-3 bg-light text-dark">
                                    <p class="comment-text">${publicacionDelFor.getMensaje()}</p>
                                </div>
                                <div class="hoverIcons d-flex justify-content-around bg-fondo p-2 rounded-bottom">
                                    <form>
                                        <div>
                                            <button class="btn btn-outline-naranja" value="${publicacionDelFor.getId()}"
                                                name="idPublicacionADarLike">
                                                <i class="far fa-thumbs-up"></i>
                                            </button>
                                        </div>
                                    </form>
                                    <form>
                                        <div>
                                            <button type="submit" class="btn btn-outline-naranja">
                                                <i class="far fa-comment-dots"></i>
                                            </button>
                                        </div>
                                    </form>
                                    <form>
                                        <div>
                                            <button type="submit" class="btn btn-outline-naranja">
                                                <i class="fab fa-gg"></i>
                                            </button>
                                        </div>
                                    </form>
                                    <form>
                                        <div>
                                            <button type="submit" class="btn btn-outline-naranja">
                                                <i class="fas fa-share-alt"></i>
                                            </button>
                                        </div>
                                    </form>
                                </div>
                                <c:if test="${not empty usuarioLogeado}">
                                    <div>
                                        <div class="container p-3 bg-fondo rounded">
                                            <form:form action="guardarComentario" method="POST" class="container"
                                                modelAttribute="comentario">
                                                <div>
                                                	<form:textarea path="mensaje" id="comentarioMandar" name="comentarioMandar"
                                                        class="form-control" placeholder="Escriba un comentario aqui..." rows="3"/>
                                                </div>
                                                <div class="row">
                                                	<form:input type="hidden" path="publicacionId" value="${publicacionDelFor.getId()}"/>
                                                    <div class="col-6 mt-2">
                                                        <button type="submit" class="btn btn-naranja"
                                                            name="boton">Responder</button>
                                                    </div>
                                                </div>
                                            </form:form>
                                        </div>
                                    </div>
                                </c:if>
                                <div>
                                    <c:if test="${not empty comentarios}">
                                        <c:forEach items="${comentarios}" var="comentario">
                                            <!--  COMUN  -->
                                            <c:if test="${comentario.getPublicacion().getId() == publicacionDelFor.getId()}">
                                            <c:set var="tipoComentario" value="${comentario.getTipo()}"></c:set>
                                            <c:if test="${tipoComentario=='COMUN'}">
                                                <c:set var="comentarioNOrespuesta" value="${comentario.getRespuesta()}">
                                                </c:set>
                                                <c:if test="${comentarioNOrespuesta==null}">

                                                    <div class="container p-3 bg-fondo border border-top-0 
                                                    	border-right-0 border-left-0 border-warning text-white">

                                                        <div class="row mb-4">

                                                            <div
                                                                class="d-flex flex-row user-info mb-3 col-md-2 col-lg-1 justify-content-center">
                                                                <img class="rounded-circle border border-dark"
                                                                    src="${comentario.getUsuario().getUrl_imagen()}"
                                                                    width="50" height="50">

                                                            </div>
                                                            <div
                                                                class="container col-md-10 col-lg-11 justify-content-center">

                                                                <h5 class="border-bottom">
                                                                    ${comentario.getUsuario().getNombreUsuario()}</h5>

                                                                <c:set var="estadoComentario"
                                                                    value="${comentario.getEstado()}"></c:set>
                                                                <c:if test="${estadoComentario=='INACTIVO'}">
                                                                    <p>Comentario Eliminado</p>
                                                                </c:if>

                                                                <c:if test="${estadoComentario=='ACTIVO'}">
                                                                    <small class="text-white-50">
                                                                        ${comentario.getFechaHora().getHours()}:${comentario.getFechaHora().getMinutes()}
                                                                        hs ${comentario.getFechaHora().getDate()} /
                                                                        ${comentario.getFechaHora().getMonth()} /
                                                                        ${comentario.getFechaHora().getYear()+ 1900}
                                                                    </small>


                                                                    <div class="container colorComentario rounded bg-light">
                                                                        <p class="text-dark !important p-3">
                                                                            ${comentario.getMensaje()}</p>
                                                                    </div>
                                                                    <c:if test="${not empty usuarioLogeado}">
                                                                        <div
                                                                            class="hoverIcons d-flex justify-content-around bg-fondo p-2">
                                                                            <form action="meGustaComentario">
                                                                                <div>
                                                                                    <button
                                                                                        class="btn btn-outline-naranja"
                                                                                        value="${comentario.getId()}"
                                                                                        name="botonLike">
                                                                                        <i class="far fa-thumbs-up"></i>
                                                                                    </button>
                                                                                    <a class="verListadoLikes"
                                                                                        data-toggle="modal"
                                                                                        href="#verListado"
                                                                                        data-id="${comentario.getId()}">
                                                                                        ${comentario.getCantidadLikes()}</a>
                                                                                </div>
                                                                            </form>
                                                                            <div class="ml-3">
                                                                                <button type="button"
                                                                                    class="btn btn-outline-naranja responderComentario"
                                                                                    data-toggle="modal"
                                                                                    data-target="#responderComentario"
                                                                                    data-id="${comentario.getId()}">
                                                                                    <i class="far fa-comment-dots"></i>
                                                                                </button>
                                                                            </div>
                                                                            <c:set var="idUsuario"
                                                                                value="${comentario.getUsuario().getId()}">
                                                                            </c:set>
                                                                            <c:set var="IdUsuarioComentario"
                                                                                value="${usuarioLogeado.getId()}"></c:set>
                                                                            <c:if
                                                                                test="${idUsuario == IdUsuarioComentario}">
                                                                                <form action="borrarComentario">
                                                                                    <div>
                                                                                        <button type="button"
                                                                                            class="btn btn-outline-naranja botonBorrar"
                                                                                            data-toggle="modal"
                                                                                            data-target="#borrarComentario"
                                                                                            data-id="${comentario.getId()}">
                                                                                            <i
                                                                                                class="far fa-trash-alt"></i>
                                                                                        </button>
                                                                                    </div>
                                                                                </form>
                                                                            </c:if>
                                                                            <form>
                                                                                <div>
                                                                                    <button type="submit"
                                                                                        class="btn btn-outline-naranja">
                                                                                        <i class="fas fa-share-alt"></i>
                                                                                    </button>
                                                                                </div>
                                                                            </form>
                                                                        </div>
                                                                    </c:if>
                                                                </c:if>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </c:if>
                                                <div class="ml-5">
                                                <c:forEach items="${comentarios}" var="respuesta">
                                                    <!--  RESPUESTA COMUN  -->
                                                    <c:set var="tipoRespuesta" value="${respuesta.getTipo()}"></c:set>
                                                    <c:if test="${tipoRespuesta=='COMUN'}">
                                                        <c:set var="RespuestaDe"
                                                            value="${respuesta.getRespuesta().getId()}"></c:set>
                                                        <c:set var="comentarioId" value="${comentario.getId()}"></c:set>
                                                        <c:if test="${RespuestaDe==comentarioId}">
                                                            <div class="container p-3 bg-fondo border border-top-0 
                                                    	border-right-0 border-left-0 border-warning text-white">
                                                                <div class="row mb-4">

                                                                    <div
                                                                        class="d-flex flex-row user-info mb-3 col-md-2 col-lg-1 justify-content-center">
                                                                        <img class="rounded-circle border border-dark"
                                                                            src="${respuesta.getUsuario().getUrl_imagen()}"
                                                                            width="50" height="50">
                                                                    </div>
                                                                    <div
                                                                        class="container col-md-10 col-lg-11 justify-content-center">

                                                                        <h5 class="border-bottom">
                                                                            ${respuesta.getUsuario().getNombreUsuario()}
                                                                        </h5>

                                                                        <c:set var="estadoRespuesta"
                                                                            value="${respuesta.getEstado()}"></c:set>
                                                                        <c:if test="${estadoRespuesta=='INACTIVO'}">
                                                                            <p>Respuesta Eliminada</p>
                                                                        </c:if>

                                                                        <c:if test="${estadoRespuesta=='ACTIVO'}">
                                                                            <small class="text-white-50">
                                                                                ${comentario.getFechaHora().getHours()}:${respuesta.getFechaHora().getMinutes()}
                                                                                hs ${respuesta.getFechaHora().getDate()}
                                                                                /
                                                                                ${respuesta.getFechaHora().getMonth()} /
                                                                                ${respuesta.getFechaHora().getYear()+
                                                                                1900} </small>
                                                                            <c:set var="respuestaRespuesta"
                                                                                value="${respuesta.getRespuesta()}">
                                                                            </c:set>
                                                                            <p>En respuesta a:
                                                                                ${respuestaRespuesta.getUsuario().getNombreUsuario()}
                                                                            </p>
                                                                            <div
                                                                                class="container colorComentario rounded">
                                                                                <p class="text-dark !important p-3 bg-light">
                                                                                    ${respuesta.getMensaje()}</p>
                                                                            </div>
                                                                            <c:if test="${not empty usuarioLogeado}">
                                                                                <div
                                                                                    class="hoverIcons d-flex justify-content-around bg-fondo p-2">
                                                                                    <form action="meGustaComentario">
                                                                                        <div>
                                                                                            <button
                                                                                                class="btn btn-outline-naranja"
                                                                                                value="${respuesta.getId()}"
                                                                                                name="botonLike">
                                                                                                <i
                                                                                                    class="far fa-thumbs-up"></i>
                                                                                            </button>
                                                                                            <a class="verListadoLikes"
                                                                                                data-toggle="modal"
                                                                                                href="#verListado"
                                                                                                data-id="${comentario.getId()}">
                                                                                                ${respuesta.getCantidadLikes()}</a>
                                                                                        </div>
                                                                                    </form>

                                                                                    <div class="ml-3">
                                                                                        <button type="button"
                                                                                            class="btn btn-outline-naranja responderComentario"
                                                                                            data-toggle="modal"
                                                                                            data-target="#responderComentario"
                                                                                            data-id="${respuesta.getId()}">
                                                                                            <i
                                                                                                class="far fa-comment-dots"></i>
                                                                                        </button>
                                                                                    </div>
                                                                                    <c:set var="idUsuario"
                                                                                        value="${respuesta.getUsuario().getId()}">
                                                                                    </c:set>
                                                                                    <c:set var="IdUsuarioRespuesta"
                                                                                        value="${usuarioLogeado.getId()}"></c:set>
                                                                                    <c:if
                                                                                        test="${idUsuario == IdUsuarioRespuesta}">
                                                                                        <form action="borrarComentario">
                                                                                            <div>
                                                                                                <button type="button"
                                                                                                    class="btn btn-outline-naranja botonBorrar"
                                                                                                    data-toggle="modal"
                                                                                                    data-target="#borrarComentario"
                                                                                                    data-id="${respuesta.getId()}">
                                                                                                    <i
                                                                                                        class="far fa-trash-alt"></i>
                                                                                                </button>
                                                                                            </div>
                                                                                        </form>
                                                                                    </c:if>

                                                                                    <form>
                                                                                        <div>
                                                                                            <button type="submit"
                                                                                                class="btn btn-outline-naranja">
                                                                                                <i
                                                                                                    class="fas fa-share-alt"></i>
                                                                                            </button>
                                                                                        </div>
                                                                                    </form>

                                                                                </div>
                                                                            </c:if>

                                                                        </c:if>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </c:if>
                                                    </c:if>
                                                    <!--  COMUN  -->
                                                </c:forEach>
                                            </div>
                                            </c:if>
                                            </c:if>
                                            <!--  COMUN  -->
                                        </c:forEach>
                                    </c:if>

                                </div>
                            </div>
                        </c:forEach>
                    </c:if>
                </div>
            </div>
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
                            <form action="borrarPublicacion" method ="post">
                                <button type="submit" class="btn btn-danger" name="botonBorrar"
                                    id="botonBorrar">BORRAR</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            <div class="modal fade" id="borrarComentario" tabindex="-1" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title text-dark">Borrar comentario</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body text-dark">
                            <p>¿Seguro que deseas borrar el comentario?.</p>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">No</button>
                            <form action="borrarComentario">
                                <button type="submit" class="btn btn-danger" name="botonBorrar"
                                    id="botonBorrar">BORRAR</button>
                            </form>

                        </div>
                    </div>
                </div>
            </div>


            <div class="modal fade" id="responderComentario" tabindex="-1" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header bg-fondo p-3">
                            <form:form  action="responderComentario" class="container" method="POST" modelAttribute="comentario">
                                <div>
                                    <form:textarea path="mensaje" id="comentarioMandar" name="comentarioMandar"
                                                        class="form-control" rows="3"/>
                                </div>

                                <br>
                                <div class="row responderComent" id="">
                                    <!--<label class="sr-only" name="boton" value="comun">-->
                                    <div class="col-6 mt-6 mb-3">
                                        <form:input type="hidden" name="idComentario"  path="comentarioAResponderId" id="responderComentario" />
                                        <button type="submit" class="btn btn-naranja" name="boton"
                                            >Responder</button>
                                    </div>
                                </div>
                            </form:form>
                        </div>
                    </div>
                </div>
            </div>


            <!-- Modal -->
            <div class="modal fade" id="verListado" role="dialog">
                <div class="modal-dialog">
                    <!-- Modal content-->
                    <div class="modal-content">
                        <div class="modal-header bg-fondo p-3 container">
                            <h4>Marcado como Me gusta por</h4>

                        </div>
                    </div>
                </div>
            </div>

        </article>
    </section>
</main>

<%@ include file="footer.jsp"%>