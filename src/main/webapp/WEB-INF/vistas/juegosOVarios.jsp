<%@ include file="header.jsp" %>
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
                <%@ include file="perfilMostrarSeguidores.jsp" %>
                    <c:if test="${not empty usuarioLogeado }">
                        <c:if test="${empty verificarSeguimientoCategoria}">
                            <form action="seguirCategoria" method="post">
                                <button name="categoriaId" value="${juegosOVarios.getId()}" class="btn btn-naranja">Seguir</button>
                            </form>
                        </c:if>
                        <c:if test="${not empty verificarSeguimientoCategoria}">
                            <form action="dejarSeguirCategoria" method="post">
                                <button name="categoriaId" value="${juegosOVarios.getId()}" class="btn btn-outline-secondary">Siguiendo</button>
                            </form>
                        </c:if>
                    </c:if>
                    <c:if test="${empty usuarioLogeado}">
                        <a href="login?errorSeguir=true" class="btn btn-naranja">Seguir</a>
                    </c:if>
            </article>
            <c:if test="${not empty usuarioLogeado}">
                <article class="container">
                    <h3>Realizar Critica</h3>

                    <form class="" action="crearCriticaCategoria" method="POST">
                        <div class="form-group">
                            <input class="col-12 form-control" name="usuarioCritico" type="hidden" value="${usuarioLogeado.getId()}" />
                            <input class="col-12 form-control" name="categoria" type="hidden" value="${juegosOVarios.getId()}" />
                        </div>
                        <div class="form-group">
                            <label for="">Calificacion</label>
                            <input class="col-12 form-control" name="calificacion" type="number" />
                        </div>
                        <div class="form-group">
                            <label for="">Mensaje de critica</label>
                            <textarea name="mensaje" class="form-control" rows="3"></textarea>

                        </div>
                        <div class="form-group">

                            <button class="btn btn-info btn-block">Crear Critica</button>
                        </div>
                        <form>
                        <form action="fagliano" method="post">
                            <button type="submit">sadasdas</button>
                        </form>
                </article>
            </c:if>
        </section>
        <hr>
		<section>
			<article class="col-12 col-md-8">
				<div class="text-center d-flex mt-4 border-bottom">
					<h4><a href="#" class="nombreUsuarioPublicacion"> Publicaciones</a></h4>
					<h4> | | </h4>
					<h4><a href="#" class="nombreUsuarioPublicacion"> Criticas</a></h4>
				</div>
				<%@ include file="homeListaPublicaciones.jsp" %>
			</article>
		</section>
		<section class="modals">
            <%@ include file="homeModals.jsp" %>
        </section>
    </main>
    <%@ include file="footer.jsp" %>