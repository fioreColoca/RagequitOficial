<%@ include file="header.jsp" %>
    <main>
        <section class="row">
            <article class="col-12 col-md-3" style="width: fit-content; background-color: #04233b; padding: 2% 4.5% 2% 4.5%;">
                <img class="imagenBiblioteca text-center borde-naranja" style="margin-bottom: 5%;" src="${juegosOVarios.getUrlImagen()}">

                <a class="link-seguidos" data-toggle="modal" data-target="#seguidores">
                    <h5 class="text-secondary ">Seguidores: ${juegosOVarios.getContadorSeguidores()}
                    </h5>
                </a>

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
                <br>
                <h5>Valoracion General: ${juegosOVarios.getCalificacion()}</h5>

            </article>
            <article class="col-12 col-md-9 p-4" style="background-color: #04233b; border-left-style: solid; border-left-color: #0A4573;">
                <h2>${juegosOVarios.getNombre()}</h2>

                <div class="p-1">
                    <h4 class="">
                        <span class="border-bottom">Descripcion:</span>
                    </h4>
                    <p class="h6">${juegosOVarios.getDescripcion()}</p>
                </div>
                <%@ include file="perfilMostrarSeguidores.jsp" %>

                    <c:if test="${not empty usuarioLogeado}">

                        <h3>�Que piensas del ${juegosOVarios.getNombre()} ?</h3>

                        <form class="" action="crearCriticaCategoria" method="POST">
                            <div class="form-group">
                                <input class="col-12 form-control" name="usuarioCritico" type="hidden" value="${usuarioLogeado.getId()}" /> <input class="col-12 form-control" name="categoria" type="hidden" value="${juegosOVarios.getId()}" />
                            </div>
                            <div class="form-group">
                                <p class="clasificacion">

                                    <input id="radio1" type="radio" name="calificacion" value="5">

                                    <label for="radio1"><i class="fas fa-star"></i></label> <input id="radio2" type="radio" name="calificacion" value="4">

                                    <label for="radio2"><i class="fas fa-star"></i></label> <input id="radio3" type="radio" name="calificacion" value="3">

                                    <label for="radio3"><i class="fas fa-star"></i></label> <input id="radio4" type="radio" name="calificacion" value="2">

                                    <label for="radio4"><i class="fas fa-star"></i></label> <input id="radio5" type="radio" name="calificacion" value="1">

                                    <label for="radio5"><i class="fas fa-star"></i></label>
                                </p>
                            </div>
                            <div class="form-group">
                                <p>Mensaje de critica</p>
                                <textarea name="mensaje" class="form-control" rows="3" required></textarea>

                            </div>
                            <div class="form-group">

                                <button class="btn btn-info btn-block" style="background-color: #f4a117; border-color: #04233b;">Crear
									Critica</button>
                            </div>
                        </form>
                    </c:if>
                    <section>

                        <article class="col-12">
                            <div class="text-center d-flex mt-4 border-bottom">
                                <h4>
                                    <a href="#" class="nombreUsuarioPublicacion"> Publicaciones</a>
                                </h4>
                                <h4>| |</h4>
                                <h4>
                                    <a href="#" class="nombreUsuarioPublicacion"> Criticas</a>
                                </h4>
                            </div>

                            <%@ include file="homeListaPublicaciones.jsp" %>
                        </article>
                    </section>
                    <section class="modals">
                        <%@ include file="homeModals.jsp" %>
                    </section>
            </article>

        </section>


    </main>
    <%@ include file="footer.jsp" %>