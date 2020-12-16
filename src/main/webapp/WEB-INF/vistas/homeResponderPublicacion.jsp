<c:if test="${not empty usuarioLogeado}">

    <div class="container p-3 bg-fondo rounded">
        <form:form id="comentario" class="row justify-content-center" action="guardarComentario" method="POST" modelAttribute="comentario">

            <div class="col-12 col-md-10">
                <form:textarea path="mensaje" id="comentarioMandar" name="comentarioMandar" class="form-control ayudaComentario" placeholder="Escriba un comentario aqui..." rows="3" />
            </div>
            <div class="col-12 col-md-2">
                <form:input type="hidden" path="publicacionId" value="${publicacionDelFor.getId()}" />

                <button type="submit" class="btn btn-naranja" name="boton">Responder</button>

            </div>
        </form:form>

    </div>
</c:if>