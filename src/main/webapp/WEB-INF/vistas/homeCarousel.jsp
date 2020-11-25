<div class="">
    <div class="owl-carousel owl-theme">
        <c:if test="${not empty categorias}">
            <c:forEach items="${categorias}" var="categoriaDelFor">
                <c:if test="${categoriaDelFor.getTipoCategoria() == 'JUEGOS'}">
                    <div class="item">
                        <a href="juegosOVarios?categoriaId=${categoriaDelFor.getId()}">
                            <img class="owl-lazy" data-src="${categoriaDelFor.getUrlImagen()}">
                        </a>
                    </div>
                </c:if>
            </c:forEach>
        </c:if>
    </div>
</div>