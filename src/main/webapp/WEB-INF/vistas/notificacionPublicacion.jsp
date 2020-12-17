<%@ include file="header.jsp" %>
    <main>
        <section>
            <article>
                <div class="container mt-5 mb-5">
                    <div class="row">
                        <c:if test="${not empty publicacion}">
                            <div class="col-12 mt-5 mb-5 rounded-lg">
                                <c:if test="${publicacion.getEstado() == 'INACTIVO'}">
                                    <div class="p-2 bg-fondo rounded-top ">
                                        <h3 class="comment-text text-light p-2 bg-fondo rounded-top">Publicacion borrada
                                        </h3>
                                    </div>
                                    <div class="hoverIcons bg-fondo p-2 rounded-bottom border border-top-0 
                                border-right-0 border-left-0 border-warning">
                                        <div class="d-flex justify-content-center">
                                            <a type="button" class="btn btn-outline-naranja botonCollapseComentarios" data-id="${publicacionDelFor.getId()}" data-toggle="collapse" href="#collapseComentarios"><i class="far fa-comment-dots"></i></a>
                                            <p>${publicacion.getCantidadComentarios()}</p>
                                        </div>
                                    </div>
                                </c:if>
                                <c:if test="${publicacion.getEstado() == 'ACTIVO'}">
                                    <div class="d-flex justify-content-around p-2 bg-fondo rounded-top">
                                        <div class="col-4 justify-content-start">
                                            <h3><a href="perfil?usuarioNombre=${publicacion.getUsuario().getNombreUsuario()}" class="nombreUsuarioPublicacion">
                                                    ${publicacion.getUsuario().getNombreUsuario()}
                                                </a></h3>
                                            <c:if test="${not empty usuarioLogeado}">

                                                <c:if test="${usuarioLogeado.getId() != publicacion.getUsuario().getId()}">
                                                    <c:set var="validarSeguimiento" value="false"></c:set>
                                                    <c:forEach items="${seguimientos}" var="seguidos">
                                                        <c:if test="${seguidos.getUsuarioSeguido().getId() == publicacion.getUsuario().getId()}">

                                                            <c:if test="${seguidos.getUsuarioSeguidor().getId() == usuarioLogeado.getId()}">

                                                                <c:set var="validarSeguimiento" value="true"></c:set>

                                                            </c:if>
                                                        </c:if>
                                                    </c:forEach>

                                                    <c:if test="${validarSeguimiento == true}">
                                                        <form action="dejarSeguir" method="post">
                                                            <input type="hidden" name="usuarioSeguidoHome" value="1">
                                                            <button name="usuarioSeguido" value="${publicacion.getUsuario().getNombreUsuario()}" class="btn btn-outline-secondary">Siguiendo</button>
                                                        </form>
                                                    </c:if>
                                                    <c:if test="${validarSeguimiento == false}">
                                                        <form action="seguir" method="post">
                                                            <input type="hidden" name="usuarioSeguidoHome" value="1">
                                                            <button name="usuarioSeguido" value="${publicacion.getUsuario().getNombreUsuario()}" class="btn btn-naranja">Seguir</button>
                                                        </form>
                                                    </c:if>
                                                </c:if>

                                            </c:if>
                                            <c:if test="${empty usuarioLogeado}">
                                                <a href="login?errorSeguir=true" class="btn btn-naranja">Seguir</a>
                                            </c:if>
                                        </div>
                                        <div class="col-4 text-center user-info">
                                            <img class="rounded-circle" src="${publicacion.getUsuario().getUrl_imagen()}" width="100">
                                        </div>
                                        <div class="col-4 text-right">
                                            <div class="d-flex justify-content-end">
                                                <img alt="logo" class="categoria-icon pr-1" src="${publicacion.getCategoria().getUrlIcono()}">
                                                <a href="juegosOVarios?categoriaId=${publicacion.getCategoria().getId()}">
                                                    <h4 class="nombreUsuarioPublicacion">
                                                        ${publicacion.getCategoria().getNombre()}</h4>
                                                </a>
                                            </div>
                                            <p class="text-white-50">
                                                ${publicacion.getFechaHora().getHours()}:${publicacion.getFechaHora().getMinutes()}hs ${publicacion.getFechaHora().getDate()}/${publicacion.getFechaHora().getMonth()}
                                            </p>
                                            <c:if test="${publicacion.getUsuario().getId() == usuarioLogeado.getId()}">
                                                <button type="button" class="btn btn-outline-naranja botonBorrar" data-toggle="modal" data-target="#borrarPublicacion" data-id="${publicacion.getId()}">
                                                    <i class="far fa-trash-alt"></i>
                                                </button>
                                            </c:if>
                                        </div>
                                    </div>
                                    <div class="text-left p-3 bg-light text-dark">
                                        <h4 class="comment-text">${publicacion.getMensaje()}</h4>
                                    </div>
                                    <div class="hoverIcons d-flex justify-content-around bg-fondo p-2 rounded-bottom border border-top-0 
                                border-right-0 border-left-0 border-warning">
                                        <c:if test="${not empty usuarioLogeado}">
                                            <div class="d-flex justify-content-center">
                                                <button type="submit" class="btn btn-outline-naranja hoverIconsBotonIcono" value="${publicacion.getId()}" name="idPublicacionADarLike${publicacion.getId()}" id="idPublicacionADarLike${publicacion.getId()}">
                                                    <i class="far fa-thumbs-up"></i>
                                                </button>
                                                <p class="text-secondary" id="cantidadLikesPublicacion${publicacion.getId()}">
                                                    ${publicacion.getCantidadLikes()}</p>
                                            </div>
                                        </c:if>
                                        <c:if test="${empty usuarioLogeado}">
                                            <div class="d-flex justify-content-center">
                                                <a href="login?errorLike=true" class="btn btn-outline-naranja hoverIconsBotonIcono">
                                                    <i class="far fa-thumbs-up"></i>
                                                </a>
                                                <p class="text-secondary">${publicacion.getCantidadLikes()}</p>
                                            </div>
                                        </c:if>
                                        <div class="d-flex justify-content-center">
                                            <a type="button" class="btn btn-outline-naranja botonCollapseComentarios hoverIconsBotonIcono" data-id="${publicacion.getId()}" data-toggle="collapse" href="#collapseComentarios"><i class="far fa-comment-dots"></i></a>
                                            <p class="text-secondary">${publicacion.getCantidadComentarios()}</p>
                                        </div>
                                        <div>
                                            <button type="submit" class="btn btn-outline-naranja hoverIconsBotonIcono">
                                                <i class="fab fa-gg"></i>
                                            </button>
                                        </div>
                                        <div>
                                            <button type="submit" class="btn btn-outline-naranja hoverIconsBotonIcono">
                                                <i class="fas fa-share-alt"></i>
                                            </button>
                                        </div>
                                    </div>
                                    <div>
                                        <%@ include file="notificacionPublicacionResponderPublicacion.jsp" %>
                                    </div>
                                </c:if>
                                <div>
                                    <%@ include file="notificacionPublicacionListaComentarios.jsp" %>
                                </div>
                            </div>
                        </c:if>
                    </div>
                </div>
                <div>
                    <%@ include file="homeComentariosModals.jsp" %>
                </div>
            </article>
        </section>
        <section class="modals">
            <%@ include file="homeModals.jsp" %>
        </section>
    </main>
    <%@ include file="footer.jsp" %>