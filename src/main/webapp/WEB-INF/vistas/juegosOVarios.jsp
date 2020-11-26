<%@ include file="header.jsp"%>
<main>
    <section class="row">
        <article class="col-12 col-md-3">
            <img class="imagenBiblioteca text-center borde-naranja float-right" src="${juegosOVarios.getUrlImagen()}">
        </article>
        <article class="col-12 col-md-9 p-4">
            <h2>${juegosOVarios.getNombre()}</h2>
            <a class="link-seguidos" data-toggle="modal" data-target="#seguidores">
                <h5 class="text-secondary ">Seguidores: </h5>
                <h5 class="text-secondary ml-1">${juegosOVarios.getContadorSeguidores()}</h5>
            </a>
            <div class="p-1">
                <h4 class=""><span class="border-bottom">Descripcion:</span></h4>
                <p class="h6">${juegosOVarios.getDescripcion()}</p>
            </div>
            <%@ include file="perfilMostrarSeguidores.jsp"%>
            <c:if test="${not empty usuarioLogeado }">
                <c:if test="${empty verificarSeguimientoCategoria}">
                    <form action="seguirCategoria" method="post">
                        <button name="categoriaId" value="${juegosOVarios.getId()}"
                            class="btn btn-naranja">Seguir</button>
                    </form>
                </c:if>
                <c:if test="${not empty verificarSeguimientoCategoria}">
                    <form action="dejarSeguirCategoria" method="post">
                        <button name="categoriaId" value="${juegosOVarios.getId()}"
                            class="btn btn-outline-secondary">Siguiendo</button>
                    </form>
                </c:if>
            </c:if>
            <c:if test="${empty usuarioLogeado}">
                <a href="login?errorSeguir=true" class="btn btn-naranja">Seguir</a>
            </c:if>
        </article>
    </section>

</main>
<%@ include file="footer.jsp"%>