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
        <%@ include file="perfilMostrarSeguidores.jsp"%>

    </div>
    <div class="col-6 col-md-4 d-flex flex-column">
        <h4 class="text-secondary ">Seguidos</h4>
        <h5 class="text-secondary ">
            <a class="link-seguidos" data-toggle="modal" data-target="#seguidoss">
                ${usuarioPerfil.getContadorSeguidos() }
            </a>
        </h5>
        <%@ include file="perfilMostrarSeguidos.jsp"%>

    </div>
</section>
<section class="row mt-3">
    <article class="col-12 col-md-4">
        <h3>${usuarioPerfil.getNombreUsuario()}</h3>
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