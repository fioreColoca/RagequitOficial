<section class="perfil row bg-dark p-4">
    <div class="col-12 col-md-4">
        <img src="${usuarioPerfil.getUrl_imagen() }" alt="" class="rounded-circle border border-warning img-perfil">
    </div>
    <div class="col-6 col-md-4 d-flex flex-column">
        <h4 class="text-secondary ">Seguidores</h4>
        <h5 class="text-secondary ">
            <a class="link-seguidos" data-toggle="modal" data-target="#seguidores" id="contadorSeguidores">
                ${usuarioPerfil.getContadorSeguidores()} </a>
        </h5>
        <%@ include file="perfilMostrarSeguidores.jsp" %>
    </div>
    <div class="col-6 col-md-4 d-flex flex-column">
        <h4 class="text-secondary ">Seguidos</h4>
        <h5 class="text-secondary ">
            <a class="link-seguidos" data-toggle="modal" data-target="#seguidoss">
                ${usuarioPerfil.getContadorSeguidos() } </a>
        </h5>
        <%@ include file="perfilMostrarSeguidos.jsp" %>

    </div>
</section>
<section class="row mt-3">
    <article class="col-12 col-md-4">
        <h3>${usuarioPerfil.getNombreUsuario()}</h3>
    </article>
    <article class="col-12 col-md-4">
        <c:if test="${not empty usuarioLogeado }">

            <c:if test="${empty verificacionSeguir}">
                <form action="seguir" method="post">
                    <button name="usuarioSeguido" value="${usuarioPerfil.getNombreUsuario()}" class="btn btn-naranja">Seguir</button>
                </form>
            </c:if>
            <c:if test="${not empty verificacionSeguir}">
                <form action="dejarSeguir" method="post">
                    <button name="usuarioSeguido" value="${usuarioPerfil.getNombreUsuario()}" class="btn btn-outline-secondary">Siguiendo</button>
                </form>
            </c:if>
            <c:if test="${not empty usuarioLogeado}">
                <input class="col-12 form-control" type="hidden" value="${usuarioLogeado.getId()}" id="idUsuarioEnviaMensaje" />
                <input class="col-12 form-control" id="idUsuarioRecibeMensaje" type="hidden" value="${usuarioPerfil.getId()}" />
                <input class="col-12 form-control" id="nombreUsuarioRecibeMensaje" type="hidden" value="${usuarioPerfil.getNombreUsuario()}" />
                <button type="submit" class="btn btn-naranja mt-3" data-toggle="modal" data-target="#enviarMensaje" id="enviarMensajeAUsuarioBoton">Enviar mensaje</button>
            </c:if>
        </c:if>
        <c:if test="${empty usuarioLogeado}">
            <a href="login?errorSeguir=true" class="btn btn-naranja">Seguir</a>
        </c:if>
        <div class="mt-3" id="resultadoEnviarMensaje">
        </div>
    </article>
</section>
<hr>
<section class="row">
    <article class="col-12 col-md-4">
        <h4 class="text-center text-secondary">Categorias seguidas por ${usuarioPerfil.getNombreUsuario()}
        </h4>
        <div class="">
            <c:if test="${empty categorias}">
                <div class="alert alert-warning p-2 text-center" role="alert">
                    Este usuario no sigue a ninguna Categoria!</div>

            </c:if>

            <c:if test="${not empty categorias}">
                <c:if test="${categorias.size() > 3}">
                    <div class="owl-carousel owl-theme">
                        <c:forEach items="${categorias}" var="categoria">
                            <c:if test="${categoria.getTipoCategoria() == 'JUEGOS'}">
                                <div class="item">
                                    <a href="juegosOVarios?categoriaId=${categoria.getId()}"> <img class="owl-lazy" data-src="${categoria.getUrlImagen()}">
                                    </a>
                                </div>
                            </c:if>
                        </c:forEach>
                    </div>
                </c:if>
                <c:if test="${categorias.size() <= 3}">
                    <div class="d-flex justify-content-center">
                        <c:forEach items="${categorias}" var="categoria">
                            <c:if test="${categoria.getTipoCategoria() == 'JUEGOS'}">

                                <a href="juegosOVarios?categoriaId=${categoria.getId()}" class="m-3"> <img class="img-fluid" src="${categoria.getUrlImagen()}">
                                </a>

                            </c:if>
                        </c:forEach>
                    </div>
                </c:if>
            </c:if>

        </div>
    </article>
    <article class="col-12 col-md-8">
        <div class="">
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
                                        <a type="button" class="btn btn-outline-naranja botonCollapseComentarios" data-id="${publicacionDelFor.getId()}" data-toggle="collapse" href="#collapseComentarios"><i class="far fa-comment-dots"></i></a>
                                        <p>${publicacionDelFor.getCantidadComentarios()}</p>
                                    </div>
                                </div>
                            </c:if>
                            <c:if test="${publicacionDelFor.getEstado() == 'ACTIVO'}">


                                <div class="d-flex justify-content-between p-2 bg-fondo rounded-top">
                                    <div class="col-4">
                                        <h3>
                                            <a href="perfil?usuarioNombre=${publicacionDelFor.getUsuario().getNombreUsuario() }" class="nombreUsuarioPublicacion">
                                                ${publicacionDelFor.getUsuario().getNombreUsuario()} </a>
                                        </h3>
                                        <c:if test="${not empty usuarioLogeado}">

                                            <c:if test="${usuarioLogeado.getId() != publicacionDelFor.getUsuario().getId()}">

                                                <c:set var="validarSeguimiento" value="false"></c:set>
                                                <c:forEach items="${seguimientos}" var="seguidos">
                                                    <c:if test="${seguidos.getUsuarioSeguido().getId() == publicacionDelFor.getUsuario().getId()}">

                                                        <c:if test="${seguidos.getUsuarioSeguidor().getId() == usuarioLogeado.getId()}">

                                                            <c:set var="validarSeguimiento" value="true"></c:set>

                                                        </c:if>
                                                    </c:if>
                                                </c:forEach>

                                                <c:if test="${validarSeguimiento == true}">
                                                    <form action="dejarSeguir" method="post">
                                                        <button name="usuarioSeguido" value="${publicacionDelFor.getUsuario().getNombreUsuario()}" class="btn btn-outline-secondary">Siguiendo</button>
                                                    </form>
                                                </c:if>
                                                <c:if test="${validarSeguimiento == false}">
                                                    <form action="seguir" method="post">
                                                        <button name="usuarioSeguido" value="${publicacionDelFor.getUsuario().getNombreUsuario()}" class="btn btn-naranja">Seguir</button>
                                                    </form>
                                                </c:if>
                                            </c:if>

                                        </c:if>
                                        <c:if test="${empty usuarioLogeado}">
                                            <a href="login?errorSeguir=true" class="btn btn-naranja">Seguir</a>
                                        </c:if>
                                    </div>
                                    <div class="col-4 text-center user-info ">
                                        <img class="rounded-circle" src="${publicacionDelFor.getUsuario().getUrl_imagen()}" width="100">
                                    </div>
                                    <div class="col-4 text-right ">
                                        <div class="d-flex justify-content-end">
                                            <img alt="logo" class="categoria-icon pr-1" src="${publicacionDelFor.getCategoria().getUrlIcono()}">
                                            <a href="juegosOVarios?categoriaId=${publicacionDelFor.getCategoria().getId()}">
                                                <h4 class="nombreUsuarioPublicacion">
                                                    ${publicacionDelFor.getCategoria().getNombre()}</h4>
                                            </a>
                                        </div>
                                        <p class="text-white-50">
                                            ${publicacionDelFor.getFechaHora().getHours()}:${publicacionDelFor.getFechaHora().getMinutes()}hs ${publicacionDelFor.getFechaHora().getDate()}/${publicacionDelFor.getFechaHora().getMonth()}
                                        </p>
                                        <c:if test="${publicacionDelFor.getUsuario().getId() == usuarioLogeado.getId()}">
                                            <button type="button" class="btn btn-outline-naranja botonBorrar" data-toggle="modal" data-target="#borrarPublicacion" data-id="${publicacionDelFor.getId()}">
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
                                    <c:if test="${not empty usuarioLogeado}">
                                        <div class="d-flex justify-content-center">
                                            <button type="submit" class="btn btn-outline-naranja hoverIconsBotonIcono" value="${publicacionDelFor.getId()}" name="idPublicacionADarLike${publicacionDelFor.getId()}" id="idPublicacionADarLike${publicacionDelFor.getId()}">
                                                <i class="far fa-thumbs-up"></i>
                                            </button>
                                            <p class="text-secondary" id="cantidadLikesPublicacion${publicacionDelFor.getId()}">
                                                ${publicacionDelFor.getCantidadLikes()}</p>
                                        </div>
                                    </c:if>
                                    <c:if test="${empty usuarioLogeado}">
                                        <div class="d-flex justify-content-center">
                                            <a href="login?errorLike=true" class="btn btn-outline-naranja hoverIconsBotonIcono"> <i class="far fa-thumbs-up"></i>
                                            </a>
                                            <p class="text-secondary">${publicacionDelFor.getCantidadLikes()}</p>
                                        </div>
                                    </c:if>
                                    <div class="d-flex justify-content-center">
                                        <a type="button" class="btn btn-outline-naranja botonCollapseComentarios hoverIconsBotonIcono" data-id="${publicacionDelFor.getId()}" data-toggle="collapse" href="#collapseComentarios"><i class="far fa-comment-dots"></i></a>
                                        <p class="text-secondary">${publicacionDelFor.getCantidadComentarios()}</p>
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
                                    <%@ include file="homeResponderPublicacion.jsp" %>
                                </div>
                            </c:if>
                            <div>
                                <%@ include file="homeListaComentarios.jsp" %>
                            </div>
                        </div>
                    </c:forEach>
                </c:if>
            </div>
        </div>
        <div>
            <%@ include file="homeComentariosModals.jsp" %>
                <div class="modal fade" id="enviarMensaje" tabindex="-1" aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content bg-fondo ">
                            <div class="modal-header">
                                <h5 class="modal-title text-white">Enviar mensaje a <span id="nombreUsuarioRecibeMensajeModal"></span></h5>
                                <button type="button" class="close text-white" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <br>
                            <div class="modal-headerp-3 pt-3">
                                <form action="crearMensaje" class="container" method="POST" id="mandarMensajeUsuarioFormulario">
                                    <div>
                                        <textarea id="mensajeAMandarAUsuario" name="mensajeAMandarAUsuario" class="form-control " rows="3"></textarea>
                                    </div>
                                    <div class="modal-footer">
                                        <input class="col-12 form-control" type="hidden" name="idUsuarioEnviaMensaje" id="idUsuarioEnviaMensaje" />
                                        <input class="col-12 form-control" id="idUsuarioRecibeMensaje" type="hidden" name="idUsuarioRecibeMensaje" />
                                        <button type="button" class="btn btn-outline-secondary" data-dismiss="modal">Volver
                                        </button>
                                        <button type="submit" class="btn btn-naranja botonMandarMensajeUsuarioModal" id="botonMandarMensajeUsuarioModal" name="botonMandarMensajeUsuarioModal">Enviar mensaje</button>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
        </div>
    </article>
</section>