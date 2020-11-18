<%@ include file="header.jsp"%>
<main>
	<section>
		<div class=" mt-5 md-5">
			<div class="owl-carousel owl-theme">
			<c:if test="${not empty categorias}">
				<c:forEach items="${categorias}" var="categoriaDelFor">
					<c:if test="${categoriaDelFor.getTipoCategoria() == 'JUEGOS'}">				
						<div class="item">
         					<img class="owl-lazy" data-src="${categoriaDelFor.getUrlImagen()}">
     					</div>
     				</c:if>
				</c:forEach>
			</c:if>
			</div>
 		</div>
	</section>
    <c:if test="${not empty usuarioRol}">
        <section class="">
            <div>
                <h3 class="border-bottom text-center mb-4">Inicio</h3>
            </div>
            <form:form action="guardarPublicacion" method="POST" modelAttribute="publicacion">
                <div class="form-inline justify-content-sm-end">
                    <label class="my-1 mr-2" for="categoriaPublicacion"><b>Categoria</b></label>
                    <form:select path="categoriaId" class="custom-select my-1 mr-sm-2" id="categoriaPublicacion">
                        <option value="-1" selected>Elegir</option>
                        <c:if test="${not empty categorias}">
                            <optgroup label="Juegos">
                                <c:forEach items="${categorias}" var="categoriaDelFor">
                                    <c:if test="${categoriaDelFor.getTipoCategoria() == 'JUEGOS'}">
                                        <option value="${categoriaDelFor.getId()}">${categoriaDelFor.getNombre()}
                                        </option>
                                    </c:if>
                                </c:forEach>
                            </optgroup>
                            <optgroup label="Otros">
                                <c:forEach items="${categorias}" var="categoriaDelFor">
                                    <c:if test="${categoriaDelFor.getTipoCategoria() == 'VARIOS'}">
                                        <option value="${categoriaDelFor.getId()}">${categoriaDelFor.getNombre()}
                                        </option>
                                    </c:if>
                                </c:forEach>
                            </optgroup>
                        </c:if>
                    </form:select>
                </div>
                <div class="form-group">
                    <label for="mensajePublicacion"><b>Mensaje Gamer para Gamers:</b></label>
                    <form:textarea path="mensaje" id="mensajePublicacion" name="mensajePublicacion" class="form-control"
                        rows="3" />
                </div>
                <div class="form-row">
                    <svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-file-image col-auto"
                        fill="currentColor" xmlns="http://www.w3.org/2000/svg" style="color:#f4a117">
                        <path fill-rule="evenodd"
                            d="M4 0h8a2 2 0 0 1 2 2v12a2 2 0 0 1-2 2H4a2 2 0 0 1-2-2V2a2 2 0 0 1 2-2zm0 1a1 1 0 0 0-1 1v10l2.224-2.224a.5.5 0 0 1 .61-.075L8 11l2.157-3.02a.5.5 0 0 1 .76-.063L13 10V2a1 1 0 0 0-1-1H4z" />
                        <path fill-rule="evenodd" d="M6.502 7a1.5 1.5 0 1 0 0-3 1.5 1.5 0 0 0 0 3z" />
                    </svg>
                    <label class="col-auto" for="archivoImagenVideo">Subir imagen o video</label>
                    <input type="file" class="form-control-file col-md-2" name="archivoImagenVideo"
                        id="archivoImagenVideo">
                </div>
                <div class="text-right">
                    <button class="btn btn-naranja botonBloque mt-3" type="submit">Publicar</button>
                </div>
            </form:form>
            <c:if test="${errorCategoria != 'null'}">
                <h4 class="text-danger"><span>${errorCategoria}</span></h4>
                <br>
            </c:if>
            <c:if test="${errorMensaje != 'null'}">
                <h4 class="text-danger"><span>${errorMensaje}</span></h4>
                <br>
            </c:if>
        </section>
    </c:if>
    <hr>
    <section>
        <article>
            <form action="filtrarCategoria">
                <div class="form-inline justify-content-sm-end">
                    <label class="my-1 mr-2" for="filtarPublicacionCategoria"><b>Filtrar publicaciones por
                            categorias</b></label>
                    <select class="custom-select my-1 mr-sm-2" name="filtarPublicacionCategoria"
                        id="filtarPublicacionCategoria" required>
                        <option value="-1" selected>Todas</option>
                        <c:if test="${not empty categorias}">
                            <optgroup label="Juegos">
                                <c:forEach items="${categorias}" var="categoriaDelFor">
                                    <c:if test="${categoriaDelFor.getTipoCategoria() == 'JUEGOS'}">
                                        <option value="${categoriaDelFor.getId()}">${categoriaDelFor.getNombre()}
                                        </option>
                                    </c:if>
                                </c:forEach>
                            </optgroup>
                            <optgroup label="Otros">
                                <c:forEach items="${categorias}" var="categoriaDelFor">
                                    <c:if test="${categoriaDelFor.getTipoCategoria() == 'VARIOS'}">
                                        <option value="${categoriaDelFor.getId()}">${categoriaDelFor.getNombre()}
                                        </option>
                                    </c:if>
                                </c:forEach>
                            </optgroup>
                        </c:if>
                    </select>
                    <div class="text-right">
                        <button class="btn btn-naranja" type="submit">Filtrar</button>
                    </div>
                </div>
            </form>
        </article>
        <article>
            <div class="container mt-5 mb-5">
                <div class="row">
                    <c:if test="${not empty publicaciones}">
                        <c:forEach items="${publicaciones}" var="publicacionDelFor">
                            <div class="col-12 mt-5 mb-5 rounded-lg">
                                <div class="d-flex justify-content-around p-2 bg-fondo rounded-top">
                                    <div class="col-4 justify-content-start">
                                        <h3>${publicacionDelFor.getUsuario().getNombreUsuario()}</h3>
                                        <button class="btn btn-naranja">SEGUIR</button>
                                    </div>
                                    <div class="col-4 text-center user-info">
                                        <img class="rounded-circle" src="${publicacionDelFor.getUsuario().getUrl_imagen()}" width="100">
                                    </div>
                                    <div class="col-4 text-right">
                                    	<div class="d-flex justify-content-end">
                                    		<img alt="logo" class="categoria-icon" src="${publicacionDelFor.getCategoria().getUrlIcono()}">
                                    		<h4>${publicacionDelFor.getCategoria().getNombre()}</h4>
                                    	</div>
                                        <p class="text-white-50">
                                            ${publicacionDelFor.getFechaHora().getHours()}:${publicacionDelFor.getFechaHora().getMinutes()}hs
                                            ${publicacionDelFor.getFechaHora().getDate()}/${publicacionDelFor.getFechaHora().getMonth()}
                                        </p>
                                        <button type="button" class="btn btn-outline-naranja botonBorrar"
                                            data-toggle="modal" data-target="#borrarPublicacion"
                                            data-id="${publicacionDelFor.getId()}">
                                            <i class="far fa-trash-alt"></i>
                                        </button>
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
                            </div>
                        </c:forEach>
                    </c:if>
                </div>
            </div>
            <div class="modal fade" id="borrarPublicacion" tabindex="-1" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title text-dark">Borrar publicacion</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body text-dark">
                            <p>¿Seguro que deseas borrar la publicacion?.</p>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">No</button>
                            <form action="borrarPublicacion">
                                <button type="submit" class="btn btn-danger" name="botonBorrar"
                                    id="botonBorrar">BORRAR</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </article>
    </section>
</main>

<%@ include file="footer.jsp"%>