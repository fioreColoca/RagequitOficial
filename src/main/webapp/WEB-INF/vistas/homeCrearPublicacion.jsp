<div class="text-right mb-2 mt-4">
    <a type="button" class="btn btn-outline-naranja" data-toggle="collapse" href="#collapseCrearPublicacion"><i
            class="fas fa-chevron-down"></i></a>
</div>
<div class="collapse" id="collapseCrearPublicacion">
    <form action="guardarPublicacion" method="POST" id="crearPublicacionFormulario">
        <div class="form-inline justify-content-sm-end">
            <label class="my-1 mr-2" for="categoriaPublicacion"><b>Categoria</b></label>
            <select class="custom-select my-1 mr-sm-2" name="categoriaPublicacion" id="categoriaPublicacion">
                <option value="-1" selected>Elegir</option>
                <c:if test="${not empty categorias}">
                    <optgroup label="Juegos">
                        <c:forEach items="${categorias}" var="categoriaDelFor">
                            <c:if test="${categoriaDelFor.getTipoCategoria() == 'JUEGOS'}">
                                <c:if test="${categoriaDelFor.getEstado() == 'ACTIVO'}">
                                    <option value="${categoriaDelFor.getId()}">${categoriaDelFor.getNombre()}
                                    </option>
                                </c:if>
                            </c:if>
                        </c:forEach>
                    </optgroup>
                    <optgroup label="Otros">
                        <c:forEach items="${categorias}" var="categoriaDelFor">
                            <c:if test="${categoriaDelFor.getTipoCategoria() == 'VARIOS'}">
                                <c:if test="${categoriaDelFor.getEstado() == 'ACTIVO'}">
                                    <option value="${categoriaDelFor.getId()}">${categoriaDelFor.getNombre()}
                                    </option>
                                </c:if>
                            </c:if>
                        </c:forEach>
                    </optgroup>
                </c:if>
            </select>
        </div>
        <div class="form-group">
            <label for="mensajePublicacion"><b>Mensaje Gamer para Gamers:</b></label>
            <textarea id="mensajePublicacion" name="mensajePublicacion" class="form-control" rows="3"></textarea>
        </div>
        <div class="form-row">
            <svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-file-image col-auto" fill="currentColor" xmlns="http://www.w3.org/2000/svg" style="color:#f4a117">
                <path fill-rule="evenodd"
                    d="M4 0h8a2 2 0 0 1 2 2v12a2 2 0 0 1-2 2H4a2 2 0 0 1-2-2V2a2 2 0 0 1 2-2zm0 1a1 1 0 0 0-1 1v10l2.224-2.224a.5.5 0 0 1 .61-.075L8 11l2.157-3.02a.5.5 0 0 1 .76-.063L13 10V2a1 1 0 0 0-1-1H4z" />
                <path fill-rule="evenodd" d="M6.502 7a1.5 1.5 0 1 0 0-3 1.5 1.5 0 0 0 0 3z" />
            </svg>
            <label class="col-auto" for="archivoImagenVideo">Subir imagen o video</label>
            <input type="file" class="form-control-file col-md-2" name="archivoImagenVideo" id="archivoImagenVideo">
        </div>
        <div class="text-right">
            <button class="btn btn-naranja botonBloque mt-3" type="submit">Publicar</button>
        </div>
        <h5 class="text-danger" id="mensajeVacio"></h5>
        <h5 class="text-danger" id="categoriaVacia"></h5>
        <h5 class="text-success" id="creacionPublicacionExitosa"></h5>
    </form>
</div>