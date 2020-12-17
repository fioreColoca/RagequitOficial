<%@ include file="header.jsp" %>
    <main>
        <section class="carousel">
            <%@ include file="homeCarousel.jsp" %>
        </section>
        <c:if test="${not empty usuarioLogeado}">
            <section class="crearPublicacion">
                <%@ include file="homeCrearPublicacion.jsp" %>
            </section>
        </c:if>
        <hr>
        <section class="filtrarPublicacionesPorCategoria">
            <%@ include file="homeFiltrarPublicacionesPorCategoria.jsp" %>
        </section>
        <section class="listaPublicaciones">
            <c:if test="${not empty errorComentarioVacio == 'true'}">
                <div class="alert alert-danger alert-dismissible fade show" role="alert">
                    <strong>No puede enviar un comentario vacio.</strong>
                    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
            </c:if>
            <c:if test="${errorBorrarPublicacion == 'true'}">
                <div class="alert alert-danger alert-dismissible fade show" role="alert">
                    <strong>Ocurrio un error al borrar la publicacion.</strong>
                    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
            </c:if>
            <c:if test="${errorBorrarPublicacion == 'false'}">
                <div class="alert alert-success alert-dismissible fade show" role="alert">
                    <strong>Se borro la publicacion con exito.</strong>
                    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
            </c:if>
            <%@ include file="homeListaPublicaciones.jsp" %>
        </section>
        <section class="modals">
            <%@ include file="homeModals.jsp" %>
        </section>
    </main>
    <%@ include file="footer.jsp" %>