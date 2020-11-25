<c:if test="${not empty usuarioLogeado}">
    <div class="container p-3 bg-fondo rounded">
        <form:form action="guardarComentario" method="POST" class="container" modelAttribute="comentario">
            <div>
                <form:textarea path="mensaje" id="comentarioMandar" name="comentarioMandar" class="form-control"
                    placeholder="Escriba un comentario aqui..." rows="3" />
            </div>
            <div class="row">
                <form:input type="hidden" path="publicacionId" value="${publicacionDelFor.getId()}" />
                <div class="col-6 mt-2">
                    <button type="submit" class="btn btn-naranja" name="boton">Responder</button>
                </div>
            </div>
        </form:form>
    </div>
</c:if>