<%@ include file="header.jsp"%>
<main>
    <section class="carousel">
        <%@ include file="homeCarousel.jsp"%>
    </section>
    <c:if test="${not empty usuarioLogeado}">
        <section class="crearPublicacion">
            <%@ include file="homeCrearPublicacion.jsp"%>
            <c:if test="${errorCategoria != 'null'}">
                <h5 class="text-danger"><span>${errorCategoria}</span></h5>
                <br>
            </c:if>
            <c:if test="${errorMensaje != 'null'}">
                <h5 class="text-danger"><span>${errorMensaje}</span></h5>
                <br>
            </c:if>
        </section>
    </c:if>
    <hr>
    <section class="filtrarPublicacionesPorCategoria">
        <%@ include file="homeFiltrarPublicacionesPorCategoria.jsp"%>
    </section>
    <section class="listaPublicaciones">
        <c:if test="${not empty errorComentarioVacio == 'true'}">
            <h5 class="text-danger text-center">No puede enviar un comentario vacio.</h5>
        </c:if>
        <c:if test="${errorBorrarPublicacion == 'true'}">
            <h5 class="text-danger text-center">Ocurrio un error al borrar la publicacion.</h5>
        </c:if>
        <c:if test="${errorBorrarPublicacion == 'false'}">
            <h5 class="text-success text-center">Se borro la publicacion con exito.</h5>
        </c:if>
        <%@ include file="homeListaPublicaciones.jsp"%>
    </section>
    <section class="modals">
        <%@ include file="homeModals.jsp"%>
    </section>
</main>
<%@ include file="footer.jsp"%>