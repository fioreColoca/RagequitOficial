<section class="perfil row bg-dark p-4">
    <div class="col-12 col-md-4">
        <img src="${usuarioPerfil.getUrl_imagen() }" alt="" class="rounded-circle border border-warning img-perfil">
    </div>
    <div class="col-6 col-md-4 d-flex flex-column">
        <h4 class="text-secondary ">Seguidores</h4>
        <h5 class="text-secondary ">
            <a class="link-seguidos" data-toggle="modal" data-target="#seguidores">
                ${usuarioPerfil.getContadorSeguidores()}
            </a>
        </h5>
        <%@ include file="perfilMostrarSeguidores.jsp" %>

    </div>
    <div class="col-6 col-md-4 d-flex flex-column">
        <h4 class="text-secondary ">Seguidos</h4>
        <h5 class="text-secondary ">
            <a class="link-seguidos" data-toggle="modal" data-target="#seguidoss">
                ${usuarioPerfil.getContadorSeguidos() }
            </a>
        </h5>
        <%@ include file="perfilMostrarSeguidos.jsp" %>

    </div>
</section>
<section class="row mt-3">
    <article class="col-12 col-md-4">
        <h3>${usuarioPerfil.getNombreUsuario()}</h3>
    </article>

</section>
<hr>
<section class="row">
    <article class="col-12 col-md-4">
        <h4 class="text-center">Categorias seguidas por ${usuarioPerfil.getNombreUsuario()}</h4>
        <div class="carrusel">
            <c:if test="${empty categorias}">

                <div class="alert alert-warning p-2 text-center" role="alert">
                    No sigues a ninguna Categoria! <a href="biblioteca" class="alert-link">Visita aqui nuestra
                        Biblioteca de Categorias</a>.
                </div>
            </c:if>
            <c:if test="${not empty categorias}">
                <c:if test="${categorias.size() > 3}">
                    <div class="owl-carousel owl-theme">
                        <c:forEach items="${categorias}" var="categoria">
                            <div class="item">
                                <a href="juegosOVarios?categoriaId=${categoria.getId()}"> <img class="owl-lazy" data-src="${categoria.getUrlImagen()}" style="max-width: 100%">
                                </a>
                            </div>
                        </c:forEach>
                    </div>
                </c:if>
                <c:if test="${categorias.size() <= 3}">
                    <div class="d-flex justify-content-center">
                        <c:forEach items="${categorias}" var="categoria">
                            <a href="juegosOVarios?categoriaId=${categoria.getId()}" class="m-3"> <img class="img-fluid" src="${categoria.getUrlImagen()}">
                            </a>
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
                                        <h3><a href="perfil?usuarioNombre=${publicacionDelFor.getUsuario().getNombreUsuario() }" class="nombreUsuarioPublicacion">
                                                ${publicacionDelFor.getUsuario().getNombreUsuario()}
                                            </a></h3>
                                        <c:if test="${not empty usuarioLogeado}">

                                            <c:if test="${usuarioLogeado.getId() != publicacionDelFor.getUsuario().getId()}">

                                                <c:forEach items="${seguimientos}" var="seguidos">
                                                    <c:if test="${seguidos.getUsuarioSeguido().getId() == publicacionDelFor.getUsuario().getId()}">

                                                        <c:if test="${seguidos.getUsuarioSeguidor().getId() == usuarioLogeado.getId()}">
                                                            <form action="dejarSeguir" method="post">
                                                                <input type="hidden" name="usuarioSeguidoHome" value="home">
                                                                <button name="usuarioSeguido" value="${publicacionDelFor.getUsuario().getNombreUsuario()}" class="btn btn-outline-secondary">Siguiendo</button>
                                                            </form>
                                                        </c:if>
                                                    </c:if>
                                                </c:forEach>
                                                <!--
                                                <c:forEach items="${seguimientos }" var="seguidos">
                                                    <p>${ usuarioLogeado.getId()} ----- ${ seguidos.getUsuarioSeguidor().getId() }</p>
                                                    <c:if
                                                        test="${seguidos.getUsuarioSeguido().getId() != publicacionDelFor.getUsuario().getId()}">

                                                        <c:if
                                                            test="${seguidos.getUsuarioSeguidor().getId() == usuarioLogeado.getId()}">
                                                            <c:set var="noSeguimiento" value="true"></c:set>

                                                        </c:if>
                                                    </c:if>
                                                </c:forEach>
                                                <c:if test="${noSeguimiento}"> 
                                                    <form action="seguir" method="post" id="h">
                                                        <input type="hidden" name="usuarioSeguidoHome" value="home">
                                                        <button name="usuarioSeguido"
                                                        value="${publicacionDelFor.getUsuario().getNombreUsuario()}"
                                                        class="btn btn btn-naranja">Seguir</button>
                                                    </form>
                                                </c:if>
                                                -->
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
                                            <a href="login?errorLike=true" class="btn btn-outline-naranja hoverIconsBotonIcono">
                                                <i class="far fa-thumbs-up"></i>
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
        </div>
    </article>
</section>
<section class="modals">
    <%@ include file="homeModals.jsp" %>
</section>