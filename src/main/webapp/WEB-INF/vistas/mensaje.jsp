<%@ include file="header.jsp" %>
    <c:if test="${usuarioLogeado.getRol() != null}">
        <main>
            <section>

            </section>
        </main>
    </c:if>
    <c:if test="${usuarioLogeado.getRol() == 'null'}">
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
    <%@ include file="footer.jsp" %>