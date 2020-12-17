<%@ include file="header.jsp" %>
    <main>
        <section>
            <article>

                <c:if test="${comentario != null}">
                    <div class="container p-3 bg-fondo border border-top-0 
                                border-right-0 border-left-0 border-warning text-white">
                        <div class="row mb-4">
                            <div class="d-flex flex-row user-info mb-3 col-md-2 col-lg-1 justify-content-center">
                                <img class="rounded-circle border border-dark" src="${comentario.getUsuario().getUrl_imagen()}" width="50" height="50">
                            </div>
                            <div class="container col-md-10 col-lg-11 justify-content-center">
                                <h5 class="border-bottom">${comentario.getUsuario().getNombreUsuario()}</h5>
                                <c:set var="estadoComentario" value="${comentario.getEstado()}"></c:set>
                                <c:if test="${estadoComentario=='INACTIVO'}">
                                    <p>Comentario Eliminado</p>
                                </c:if>

                                <c:if test="${estadoComentario=='ACTIVO'}">
                                    <small class="text-white-50">
										${comentario.getFechaHora().getHours()}:${comentario.getFechaHora().getMinutes()}
										hs ${comentario.getFechaHora().getDate()} /
										${comentario.getFechaHora().getMonth()} /
										${comentario.getFechaHora().getYear()+ 1900} </small>


                                    <div class="container colorComentario rounded bg-light">
                                        <p class="text-dark !important p-3">
                                            ${comentario.getMensaje()}</p>
                                    </div>
                                    <c:if test="${not empty usuarioLogeado}">
                                        <div class="hoverIcons d-flex justify-content-around bg-fondo">
                                            <form action="meGustaComentario">
                                                <div>
                                                    <button class="btn btn-outline-naranja hoverIconsBotonIcono" value="${comentario.getId()}" name="botonLike">
														<i class="far fa-thumbs-up"></i>
													</button>
                                                    <span>${comentario.getCantidadLikes()}</span>
                                                </div>
                                            </form>
                                            <div class="ml-3">
                                                <button type="button" class="btn btn-outline-naranja responderComentario hoverIconsBotonIcono" data-toggle="modal" data-target="#responderComentario" data-id="${comentario.getId()}">
													<i class="far fa-comment-dots"></i>
												</button>
                                            </div>
                                            <c:set var="idUsuario" value="${comentario.getUsuario().getId()}">
                                            </c:set>
                                            <c:set var="IdUsuarioComentario" value="${usuarioLogeado.getId()}">
                                            </c:set>
                                            <c:if test="${idUsuario == IdUsuarioComentario}">
                                                <form action="borrarComentario">
                                                    <div>
                                                        <button type="button" class="btn btn-outline-naranja botonBorrar hoverIconsBotonIcono" data-toggle="modal" data-target="#borrarComentario" data-id="${comentario.getId()}">
															<i class="far fa-trash-alt"></i>
														</button>
                                                    </div>
                                                </form>
                                            </c:if>
                                        </div>
                                    </c:if>

                                </c:if>
                            </div>
                        </div>
                    </div>
                    <div class="container p-3 bg-fondo border border-top-0 
                                                    	border-right-0 border-left-0 border-warning text-white" style=" box-shadow: 0px 0px 20px orange;">
                        <div class="row mb-4">

                            <div class="d-flex flex-row user-info mb-3 col-md-2 col-lg-1 justify-content-center">
                                <img class="rounded-circle border border-dark" src="${respuesta.getUsuario().getUrl_imagen()}" width="50" height="50">
                            </div>
                            <div class="container col-md-10 col-lg-11 justify-content-center">

                                <h5 class="border-bottom">
                                    ${respuesta.getUsuario().getNombreUsuario()}</h5>

                                <c:set var="estadoRespuesta" value="${respuesta.getEstado()}"></c:set>
                                <c:if test="${estadoRespuesta=='INACTIVO'}">
                                    <p>Respuesta Eliminada</p>
                                </c:if>

                                <c:if test="${estadoRespuesta=='ACTIVO'}">
                                    <small class="text-white-50">
										${comentario.getFechaHora().getHours()}:${respuesta.getFechaHora().getMinutes()}
										hs ${respuesta.getFechaHora().getDate()} /
										${respuesta.getFechaHora().getMonth()} /
										${respuesta.getFechaHora().getYear()+
										1900}
									</small>
                                    <c:set var="respuestaRespuesta" value="${respuesta.getRespuesta()}">
                                    </c:set>
                                    <p>En respuesta a: ${respuestaRespuesta.getUsuario().getNombreUsuario()}
                                    </p>
                                    <div class="container colorComentario rounded">
                                        <p class="text-dark !important p-3 bg-light">
                                            ${respuesta.getMensaje()}</p>
                                    </div>
                                    <c:if test="${not empty usuarioLogeado}">
                                        <div class="hoverIcons d-flex justify-content-around bg-fondo p-2">
                                            <form action="meGustaComentario">
                                                <div>
                                                    <button class="btn btn-outline-naranja hoverIconsBotonIcono" value="${respuesta.getId()}" name="botonLike">
														<i class="far fa-thumbs-up"></i>
													</button>
                                                    <span>${respuesta.getCantidadLikes()}</span>
                                                </div>
                                            </form>


                                            <c:set var="idUsuario" value="${respuesta.getUsuario().getId()}">
                                            </c:set>
                                            <c:set var="IdUsuarioRespuesta" value="${usuarioLogeado.getId()}">
                                            </c:set>
                                            <c:if test="${idUsuario == IdUsuarioRespuesta}">
                                                <form action="borrarComentario">
                                                    <div>
                                                        <button type="button" class="btn btn-outline-naranja hoverIconsBotonIcono botonBorrar" data-toggle="modal" data-target="#borrarComentario" data-id="${respuesta.getId()}">
															<i class="far fa-trash-alt"></i>
														</button>
                                                    </div>
                                                </form>
                                            </c:if>
                                        </div>
                                    </c:if>

                                </c:if>
                            </div>
                        </div>
                    </div>
                </c:if>


            </article>
        </section>
    </main>

    <%@ include file="footer.jsp" %>