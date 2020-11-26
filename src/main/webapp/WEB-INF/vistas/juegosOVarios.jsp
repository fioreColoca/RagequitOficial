<%@ include file="header.jsp"%>
<main>
    <div>
        <img class="imagenBiblioteca text-center borde-naranja" src="${juegosOVarios.getUrlImagen()}">
        <h2>${juegosOVarios.getNombre()}</h2>
        <a class="link-seguidos" data-toggle="modal" data-target="#seguidores">
            <h5 class="text-secondary ">${juegosOVarios.getContadorSeguidores()}</h5>
        </a>
        <p>${juegosOVarios.getDescripcion()}</p>
        <%@ include file="perfilMostrarSeguidores.jsp"%>
        <c:if test="${not empty usuarioLogeado }">
            <c:if test="${empty verificarSeguimientoCategoria}">
                <form action="seguirCategoria" method="post">
                    <button name="categoriaId" value="${juegosOVarios.getId()}"
                        class="btn btn-outline-success">Seguir</button>
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
            <a href="login?errorSeguir=true" class="btn btn-outline-success">Seguir</a>
        </c:if>
    </div>

</main>
<%@ include file="footer.jsp"%>