<section class="perfil row bg-dark p-4">
    <div class="col-12 col-md-4">
        <img src="${usuarioPerfil.getUrl_imagen() }" alt="" class="rounded-circle border border-warning img-perfil">
    </div>
    <div class="col-6 col-md-4 d-flex flex-column">
        <h4 class="text-secondary ">Seguidores</h4>
        <a class="link-seguidos" data-toggle="modal" data-target="#seguidores">
            <h5 class="text-secondary ">${usuarioPerfil.getContadorSeguidores()}</h5>
        </a>
        <%@ include file="perfilMostrarSeguidores.jsp"%>
    </div>
    <div class="col-6 col-md-4 d-flex flex-column">
        <h4 class="text-secondary ">Seguidos</h4>
        <a class="link-seguidos" data-toggle="modal" data-target="#seguidoss">
            <h5 class="text-secondary ">${usuarioPerfil.getContadorSeguidos() }</h5>
        </a>
        <%@ include file="perfilMostrarSeguidos.jsp"%>

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
                    <button name="usuarioSeguido" value="${usuarioPerfil.getNombreUsuario()}"
                        class="btn btn-outline-success">Seguir</button>
                </form>
            </c:if>
            <c:if test="${not empty verificacionSeguir}">
                <form action="dejarSeguir" method="post">
                    <button name="usuarioSeguido" value="${usuarioPerfil.getNombreUsuario()}"
                        class="btn btn-outline-secondary">Siguiendo</button>
                </form>
            </c:if>
        </c:if>
        <c:if test="${empty usuarioLogeado}">
            <a href="login?errorSeguir=true" class="btn btn-outline-success">Seguir</a>
        </c:if>

    </article>
</section>
<hr>
<div class="">
    <div class="owl-carousel owl-theme">
        <c:if test="${not empty categorias}">
            <c:forEach items="${categorias}" var="categoria">
                <c:if test="${categoria.getTipoCategoria() == 'JUEGOS'}">
                    <div class="item">
                        <a href="juegosOVarios?categoriaId=${categoria.getId()}"> <img class="owl-lazy"
                                data-src="${categoria.getUrlImagen()}">
                        </a>
                    </div>
                </c:if>
            </c:forEach>
        </c:if>
    </div>
</div>