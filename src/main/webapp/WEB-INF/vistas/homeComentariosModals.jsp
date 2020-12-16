<div class="modal fade" id="borrarComentario" tabindex="-1" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title text-dark">Borrar comentario</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body text-dark">
                <p>�Seguro que deseas borrar el comentario?.</p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">No</button>
                <form action="borrarComentario">
                    <button type="submit" class="btn btn-danger" name="botonBorrar" id="botonBorrar">BORRAR</button>
                </form>
            </div>
        </div>
    </div>
</div>

<div class="modal fade" id="responderComentario" tabindex="-1" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content bg-fondo ">
            <div class="modal-header">
                <h5 class="modal-title text-white">Responder comentario</h5>
                <button type="button" class="close text-white" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <br>
            <div class="modal-headerp-3 pt-3">
                <form:form action="responderComentario" class="container" method="POST" modelAttribute="comentario">
                    <div>
                        <form:textarea path="mensaje" id="comentarioMandar" name="comentarioMandar" class="form-control " rows="3" />
                    </div>
                    <br>
                    <div class="row responderComent" id="">
                        <!--<label class="sr-only" name="boton" value="comun">-->
                        <div class="col-6 mt-6 mb-3">
                            <form:input type="hidden" name="idComentario" path="comentarioAResponderId" id="responderComentario" />
                            <button type="submit" class="btn btn-naranja" name="boton">Responder</button>
                        </div>
                    </div>
                </form:form>
            </div>
        </div>
    </div>
</div>