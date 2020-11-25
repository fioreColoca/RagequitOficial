<article>
    <div class="container mt-5 mb-5">
        <div class="row">
            <c:if test="${not empty publicaciones}">
                <c:forEach items="${publicaciones}" var="publicacionDelFor">
                    <div class="col-12 mt-5 mb-5 rounded-lg">
                        <c:if test="${publicacionDelFor.getEstado() == 'INACTIVO'}">
                            <div class="p-2 bg-fondo rounded-top ">
                                <h3 class="comment-text text-light p-2 bg-fondo rounded-top">Publicacion borrada
                                </h3>
                            </div>
                            <div class="hoverIcons bg-fondo p-2 rounded-bottom border border-top-0 
                                border-right-0 border-left-0 border-warning">
                                <div class="d-flex justify-content-center">
                                    <a type="button" class="btn btn-outline-naranja botonCollapseComentarios"
                                        data-id="${publicacionDelFor.getId()}" data-toggle="collapse"
                                        href="#collapseComentarios"><i class="far fa-comment-dots"></i></a>
                                    <p>${publicacionDelFor.getCantidadComentarios()}</p>
                                </div>
                            </div>
                        </c:if>
                        <c:if test="${publicacionDelFor.getEstado() == 'ACTIVO'}">
                            <div class="d-flex justify-content-around p-2 bg-fondo rounded-top">
                                <div class="col-4 justify-content-start">
                                    <a
                                        href="perfil?usuarioNombre=${publicacionDelFor.getUsuario().getNombreUsuario() }">
                                        <h3>${publicacionDelFor.getUsuario().getNombreUsuario()}</h3>
                                    </a>
                                    <c:if test="${not empty usuarioLogeado}">
                                        <c:if
                                            test="${usuarioLogeado.getId() != publicacionDelFor.getUsuario().getId()}">
                                            <button class="btn btn-naranja">SEGUIR</button>
                                        </c:if>
                                    </c:if>
                                </div>
                                <div class="col-4 text-center user-info">
                                    <img class="rounded-circle" src="${publicacionDelFor.getUsuario().getUrl_imagen()}"
                                        width="100">
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
                                <h4 class="comment-text">${publicacionDelFor.getMensaje()}</h4>
                            </div>
                            <div class="hoverIcons d-flex justify-content-around bg-fondo p-2 rounded-bottom border border-top-0 
                                border-right-0 border-left-0 border-warning">
                                <form action="darLikePublicacion" method="post">
                                    <div class="d-flex justify-content-center">
                                        <button class="btn btn-outline-naranja" value="${publicacionDelFor.getId()}"
                                            name="idPublicacionADarLike">
                                            <i class="far fa-thumbs-up"></i>
                                        </button>
                                        <p>${publicacionDelFor.getCantidadLikes()}</p>
                                    </div>
                                </form>
                                <div class="d-flex justify-content-center">
                                    <a type="button" class="btn btn-outline-naranja botonCollapseComentarios"
                                        data-id="${publicacionDelFor.getId()}" data-toggle="collapse"
                                        href="#collapseComentarios"><i class="far fa-comment-dots"></i></a>
                                    <p>${publicacionDelFor.getCantidadComentarios()}</p>
                                </div>
                                <div>
                                    <button type="submit" class="btn btn-outline-naranja">
                                        <i class="fab fa-gg"></i>
                                    </button>
                                </div>
                                <div>
                                    <button type="submit" class="btn btn-outline-naranja">
                                        <i class="fas fa-share-alt"></i>
                                    </button>
                                </div>
                            </div>
                            <div>
                                <%@ include file="homeResponderPublicacion.jsp"%>
                            </div>
                        </c:if>
                        <div>
                            <%@ include file="homeListaComentarios.jsp"%>
                        </div>
                    </div>
                </c:forEach>
            </c:if>
        </div>
    </div>
    <div>
        <%@ include file="homeComentariosModals.jsp"%>
    </div>
</article>