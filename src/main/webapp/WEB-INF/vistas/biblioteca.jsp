<%@ include file="header.jsp"%>

<main>

    <section class="border-bottom mb-2">
        <h3>¡Bienvenido a la seccion Biblioteca!</h3>
    </section>
    <section class="anchoCategoria">
        <form action="biblioteca">
            <label for="filtro">Filtrar contenido por Genero</label>
            <select class="custom-select" name="categoriaId" id="filtro">
                <option value="-1" selected disabled>Elegir</option>
                <c:if test="${not empty categorias}">
                    <c:forEach items="${categorias}" var="categoriaDelFor">
                        <option value="${categoriaDelFor.getTipoCategoria()}">${categoriaDelFor.getTipoCategoria()}</option>
                    </c:forEach>
                </c:if>
            </select>
            <div class="text-right">
            <button class="btn btn-naranja mt-3 botonBloque" type="submit">Filtrar</button>
            </div>
        </form>
        <br>
        
        <c:if test="${not empty categorias}">
        <div class="album py-5 ">
            <div class="container">

                <div class="row">
                
                    <c:forEach items="${categorias}" var="categoriaDelFor">
                        <div class="col-md-4">
                            <div class="card mb-4 borde-naranja">
                            	<h4 class="text-white">${categoriaDelFor.getNombre()}</h4>                              
                                <p class="text-center text-naranjaClaro">${categoriaDelFor.getTipoCategoria()}</p>
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