<div class="perfil text-center bg-dark p-4">
    <img src="${usuarioPerfil.getUrl_imagen() }" alt="" class="rounded-circle border border-warning img-perfil">
</div>
<section class="row mt-3">
    <article class="col-12 col-md-4">
        <h3>${usuarioPerfil.getNombreUsuario()}</h3>
    </article>
    <article class="col-12 col-md-4">
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