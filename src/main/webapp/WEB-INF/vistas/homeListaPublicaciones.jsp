<article>
            <div class="container mt-5 mb-5">
                <div class="row">
                    <c:if test="${not empty publicaciones}">
                        <c:forEach items="${publicaciones}" var="publicacionDelFor">
                            <div class="col-12 mt-5 mb-5 rounded-lg">
                                <div class="d-flex justify-content-around p-2 bg-fondo rounded-top">
                                    <div class="col-4 justify-content-start">
                                        <h3>${publicacionDelFor.getUsuario().getNombreUsuario()}</h3>
                                        <c:if test="${not empty usuarioLogeado}">
                                        <button class="btn btn-naranja">SEGUIR</button>
                                        </c:if>
                                    </div>
                                    <div class="col-4 text-center user-info">
                                        <img class="rounded-circle"
                                            src="${publicacionDelFor.getUsuario().getUrl_imagen()}" width="100">
                                    </div>
                                    <div class="col-4 text-right">
                                        <div class="d-flex justify-content-end">
                                            <img alt="logo" class="categoria-icon pr-1"
                                                src="${publicacionDelFor.getCategoria().getUrlIcono()}">
                                            <h4>${publicacionDelFor.getCategoria().getNombre()}</h4>
                                        </div>
                                        <p class="text-white-50">
                                            ${publicacionDelFor.getFechaHora().getHours()}:${publicacionDelFor.getFechaHora().getMinutes()}hs
                                            ${publicacionDelFor.getFechaHora().getDate()}/${publicacionDelFor.getFechaHora().getMonth()}
                                        </p>
                                        <c:if test="${publicacionDelFor.getUsuario().getId() == usuarioLogeado.getId()}">
                                        	<button type="button" class="btn btn-outline-naranja botonBorrar"
                                            	data-toggle="modal" data-target="#borrarPublicacion"
                                            	data-id="${publicacionDelFor.getId()}">
                                            	<i class="far fa-trash-alt"></i>
                                        	</button>
                                        </c:if>
                                    </div>
                                </div>
                                <div class="text-left p-3 bg-light text-dark">
                                    <p class="comment-text">${publicacionDelFor.getMensaje()}</p>
                                </div>
                                <div class="hoverIcons d-flex justify-content-around bg-fondo p-2 rounded-bottom">
                                    <form>
                                        <div>
                                            <button class="btn btn-outline-naranja" value="${publicacionDelFor.getId()}"
                                                name="idPublicacionADarLike">
                                                <i class="far fa-thumbs-up"></i>
                                            </button>
                                        </div>
                                    </form>
                                    <form>
                                        <div>
                                            <button type="submit" class="btn btn-outline-naranja">
                                                <i class="far fa-comment-dots"></i>
                                            </button>
                                        </div>
                                    </form>
                                    <form>
                                        <div>
                                            <button type="submit" class="btn btn-outline-naranja">
                                                <i class="fab fa-gg"></i>
                                            </button>
                                        </div>
                                    </form>
                                    <form>
                                        <div>
                                            <button type="submit" class="btn btn-outline-naranja">
                                                <i class="fas fa-share-alt"></i>
                                            </button>
                                        </div>
                                    </form>
                                </div>
                                <div>
                                	<%@ include file="homeResponderPublicacion.jsp"%>
                                </div>
                                <div>
                                    <%@ include file="homeListaComentarios.jsp"%>
                                </div>
                            </div>
                        </c:forEach>
                    </c:if>
                </div>
            </div>
            <div>
            	<%@ include file="homePublicacionesComentariosModals.jsp"%>
            </div>
</article>