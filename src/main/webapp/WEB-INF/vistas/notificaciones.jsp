<%@ include file="header.jsp" %>
    <main>
        <c:if test="${usuarioLogeado.getRol() != null}">
            <h1 class="text-center">Notificaciones</h1>
            <section>
                <c:if test="${not empty notificaciones}">
                    <c:forEach items="${notificaciones}" var="notificacion">
                        <div class="col-12 col-md-8 p-3 m-1 bg-fondo rounded-pill">
                            <div class="d-flex flex-wrap justify-content-around">
                                <c:if test="${notificacion.getVisto() == false}">
                                    <c:if test="${notificacion.getTipo() == 'LIKEPUBLICACION'}">

                                        <p class="text-center">A <a href="perfil?usuarioNombre=${notificacion.getUsuarioOtorgadorNotifi().getNombreUsuario()}" class="nombreUsuarioPublicacion">${notificacion.getUsuarioOtorgadorNotifi().getNombreUsuario()}</a> le ha gustado tu
                                            <a href="publicacion?id=${notificacion.getPublicacion().getId()}" class="nombreUsuarioPublicacion">publicacion</a>.
                                        </p>

                                        <button type="button" class="btn btn-outline-naranja botonEditar" value="${notificacion.getId()}" id="notificacionNoVista${notificacion.getId()}">
                                            <i class="fas fa-eye"></i>
                                        </button>
                                    </c:if>
                                    <c:if test="${notificacion.getTipo() == 'LIKECOMENTARIO'}">
                                        <p class="text-center">A <a href="perfil?usuarioNombre=${notificacion.getUsuarioOtorgadorNotifi().getNombreUsuario()}" class="nombreUsuarioPublicacion">${notificacion.getUsuarioOtorgadorNotifi().getNombreUsuario()}</a> le ha gustado tu
                                            <a href="comentarioLike?id=${notificacion.getId()}" class="nombreUsuarioPublicacion">comentario</a>.
                                        </p>

                                        <button type="button" class="btn btn-outline-naranja botonEditar" value="${notificacion.getId()}" id="notificacionNoVista${notificacion.getId()}">
                                            <i class="fas fa-eye"></i>
                                        </button>
                                    </c:if>
                                    <c:if test="${notificacion.getTipo() == 'COMENTARIOPUBLICACION'}">
                                        <p class="text-center">A <a href="perfil?usuarioNombre=${notificacion.getUsuarioOtorgadorNotifi().getNombreUsuario()}" class="nombreUsuarioPublicacion">${notificacion.getUsuarioOtorgadorNotifi().getNombreUsuario()}</a> ha comentado a
                                            tu
                                            <a href="publicacion?id=${notificacion.getComentarioDePublicacion().getId()}" class="nombreUsuarioPublicacion">publicacion</a>.
                                        </p>
                                        <button type="button" class="btn btn-outline-naranja botonEditar" value="${notificacion.getId()}" id="notificacionNoVista${notificacion.getId()}">
                                            <i class="fas fa-eye"></i>
                                        </button>
                                    </c:if>
                                    <c:if test="${notificacion.getTipo() == 'COMENTARIOCOMENTARIO'}">
                                        <p class="text-center">A <a href="perfil?usuarioNombre=${notificacion.getUsuarioOtorgadorNotifi().getNombreUsuario()}" class="nombreUsuarioPublicacion">${notificacion.getUsuarioOtorgadorNotifi().getNombreUsuario()}</a> ha respondido a
                                            tu
                                            <a href="comentario?id=${notificacion.getId()}" class="nombreUsuarioPublicacion">comentario</a>.
                                        </p>
                                        <button type="button" class="btn btn-outline-naranja botonEditar" value="${notificacion.getId()}" id="notificacionNoVista${notificacion.getId()}">
                                            <i class="fas fa-eye"></i>
                                        </button>
                                    </c:if>
                                    <c:if test="${notificacion.getTipo() == 'SEGUIRUSUARIO'}">
                                        <p class="text-center"><a href="perfil?usuarioNombre=${notificacion.getUsuarioOtorgadorNotifi().getNombreUsuario()}" class="nombreUsuarioPublicacion">${notificacion.getUsuarioOtorgadorNotifi().getNombreUsuario()}</a> te ha seguido.</p>
                                        <button type="button" class="btn btn-outline-naranja botonEditar" value="${notificacion.getId()}" id="notificacionNoVista${notificacion.getId()}">
                                            <i class="fas fa-eye"></i>
                                        </button>
                                    </c:if>
                                </c:if>
                                <c:if test="${notificacion.getVisto() == true}">

                                    <c:if test="${notificacion.getTipo() == 'LIKEPUBLICACION'}">
                                        <p class="text-center">
                                            <a href="perfil?usuarioNombre=${notificacion.getUsuarioOtorgadorNotifi().getNombreUsuario()}" class="nombreUsuarioPublicacion">${notificacion.getUsuarioOtorgadorNotifi().getNombreUsuario()}</a> le ha gustado
                                            tu <a href="#" class="nombreUsuarioPublicacion">publicacion</a>.
                                        </p>
                                    </c:if>
                                    <c:if test="${notificacion.getTipo() == 'LIKECOMENTARIO'}">
                                        <p class="text-center">
                                            <a href="perfil?usuarioNombre=${notificacion.getUsuarioOtorgadorNotifi().getNombreUsuario()}" class="nombreUsuarioPublicacion">${notificacion.getUsuarioOtorgadorNotifi().getNombreUsuario()}</a> le ha gustado
                                            tu <a href="" class="nombreUsuarioPublicacion">comentario</a>.
                                        </p>
                                    </c:if>
                                    <c:if test="${notificacion.getTipo() == 'COMENTARIOPUBLICACION'}">
                                        <p class="text-center">
                                            <a href="perfil?usuarioNombre=${notificacion.getUsuarioOtorgadorNotifi().getNombreUsuario()}" class="nombreUsuarioPublicacion">${notificacion.getUsuarioOtorgadorNotifi().getNombreUsuario()}</a> ha comentado
                                            tu <a href="#" class="nombreUsuarioPublicacion">publicacion</a>.
                                        </p>
                                    </c:if>
                                    <c:if test="${notificacion.getTipo() == 'COMENTARIOCOMENTARIO'}">
                                        <p class="text-center">
                                            <a href="perfil?usuarioNombre=${notificacion.getUsuarioOtorgadorNotifi().getNombreUsuario()}" class="nombreUsuarioPublicacion">${notificacion.getUsuarioOtorgadorNotifi().getNombreUsuario()}</a> ha respondido
                                            tu <a href="#" class="nombreUsuarioPublicacion">comentario</a>.
                                        </p>

                                    </c:if>
                                    <c:if test="${notificacion.getTipo() == 'SEGUIRUSUARIO'}">
                                        <p class="text-center">
                                            <a href="perfil?usuarioNombre=${notificacion.getUsuarioOtorgadorNotifi().getNombreUsuario()}" class="nombreUsuarioPublicacion">${notificacion.getUsuarioOtorgadorNotifi().getNombreUsuario()}</a> te ha seguido.
                                        </p>
                                    </c:if>
                                </c:if>
                            </div>
                        </div>
                    </c:forEach>
                </c:if>
                <c:if test="${empty notificaciones}">
                    <h3 class="text-secondary text-center">No tiene notificaciones.</h3>
                </c:if>
            </section>
        </c:if>

        <c:if test="${usuarioLogeado.getRol() == null}">
            <section>
                <div id="notfound" style="margin: -1em">
                    <div class="notfound">
                        <div class="notfound-404">
                            <h1>
                                4<span>0</span>4
                            </h1>
                        </div>
                        <p>Es posible que la p&aacute;gina que est&aacute; buscando se haya eliminado, no est&aacute; disponible temporalmente o no tienes acceso a ella.</p>
                        <a href=" home" class="btn btn-outline-naranja">Ir al inicio</a>
                    </div>
                </div>
            </section>
        </c:if>

    </main>
    <%@ include file="footer.jsp" %>