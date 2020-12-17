<%@ include file="header.jsp" %>
    <main>
        <c:if test="${usuarioLogeado.getRol() == 'admin'}">
            <section>
                <article>
                    <div>
                        <h3 class="border-bottom text-center mb-4">Crear Categoria</h3>
                    </div>
                    <div class="text-center ">
                        <p class="pl-3 text-justify text-size-categoria">
                            Dentro de esta secci&oacute;n podr&aacute;s crear categor&iacute;as para los distintos tipos de Videojuegos, M&uacute;sica, Anime, entre otras.
                        </p>
                    </div>
                    <div class="anchoCategoria pad-2">

                        <form:form action="agregarCategoria" method="POST" modelAttribute="categoria" enctype="multipart/form-data">
                            <div class="form-group">
                                <label for="nombre">Elija el nombre de la categoria:</label>
                                <form:input path="nombre" class="form-control" id="nombre" placeholder="Valorant, Anime, Musica ..." />
                            </div>
                            <div>
                                <label for="tipoCategoriaNum">Elegir el tipo de categoria</label>
                                <form:select path="tipoCategoriaNum" name="tipoCategoriaNum" class="custom-select" id="tipoCategoriaNum">
                                    <option disabled selected>Seleccione una opci&oacute;n</option>
                                    <option value="0">Juegos</option>
                                    <option value="1">Varios</option>

                                </form:select>
                            </div>

                            <label class="pt-3" for="subida">Subir imagen</label>
                            <input type="file" class="form-control-file col-md-2" name="subida" id="subida">

                            <div class="text-right">
                                <button type="submit" class="btn btn-naranja mt-3 botonBloque">Crear</button>
                            </div>
                        </form:form>
                        <c:if test="${errorNombre != 'null'}">
                            <h4 class="text-danger"><span>${errorNombre}</span></h4>
                            <br>
                        </c:if>

                        <c:if test="${errorTipo != 'null'}">
                            <h4 class="text-danger"><span>${errorTipo}</span></h4>
                            <br>
                        </c:if>
                    </div>


                    <div class="text-right subirDiv">
                        <a href="irACategorias" class="btn btn-outline-naranja irACategorias volverACategoria">Ver
                            categorias creadas</a>
                    </div>
                </article>
            </section>
        </c:if>
        <c:if test="${usuarioLogeado.getRol() != 'admin'}">
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
        </c:if>

    </main>
    <%@ include file="footer.jsp" %>