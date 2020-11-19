<%@ include file="header.jsp"%>

<main>

    <section class="border-bottom mb-2">
        <h3>�Bienvenido a la seccion Biblioteca!</h3>
    </section>
    <section class="anchoCategoria">
        <form action="bibliotecaFiltrada">
            <label for="filtro">Filtrar contenido por Genero</label>
            <select class="custom-select" name="categoriaId" id="filtro">
                <option value="-1" selected disabled>Elegir</option>
                <c:if test="${not empty categorias}">
                    
                        <option value="1">JUEGOS</option>
                        <option value="2">VARIOS</option>
                   
                </c:if>
            </select>
            <div class="text-right">
            <button class="btn btn-naranja mt-3 botonBloque" type="submit">Filtrar</button>
            </div>
        </form>
        <br>
        
        <c:if test="${not empty categorias}">
        <div class="album py-5 contenedorAlbum">
            <div class="container">

                <div class="row text-center">
                
                    <c:forEach items="${categorias}" var="categoriaDelFor">
                        <div class="col-md-4" style="height: fit-content;">
                            <div class="divImagenBiblioteca">
                            <img class="imagenBiblioteca text-center borde-naranja" src="${categoriaDelFor.getUrlImagen()}">                                                            

                            <div class="nombreYCategoria nombreYCategoriaDesenfoque">

                            <h2 class="nombreDeCategoria">${categoriaDelFor.getNombre()}</h2>
                            <p class="tipoCategoria">${categoriaDelFor.getTipoCategoria()}</p>
                            
                            </div>
                            </div>
                        </div>
                    </c:forEach>
                    
                </div>
            </div>
        </div>
        </c:if>
    </section>


</main>

<%@ include file="footer.jsp"%>