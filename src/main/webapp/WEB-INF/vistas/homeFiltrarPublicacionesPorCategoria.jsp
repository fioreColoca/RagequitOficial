<article>
    <form action="filtrarCategoria">
        <div class="form-inline justify-content-sm-end">
            <label class="my-1 mr-2" for="filtarPublicacionCategoria"><b>Filtrar publicaciones por
                    categorias</b></label>
            <select class="custom-select my-1 mr-sm-2" name="filtarPublicacionCategoria" id="filtarPublicacionCategoria"
                required>
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