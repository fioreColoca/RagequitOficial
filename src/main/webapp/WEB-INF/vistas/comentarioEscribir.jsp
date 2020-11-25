<%@ include file="header.jsp"%>
<main>
    <div>
        <h3 class="border-bottom text-center mb-4">Comentarios</h3>
    </div>
    <section>
        <div class="container p-3 bg-fondo rounded">
            <form action="guardarComentario" class="container" modelAttribute="comentario">
                <div class="aling-center">
                    <label for="comentarioMandar">
                        <p> Respondiendo a </p>
                    </label>
                </div>
                <div>
                    <textarea path="" id="comentarioMandar" name="comentarioMandar" class="form-control" rows="3"
                        placeholder="Escribe tu respuesta"></textarea>
                </div>

                <br>
                <div class="row">
                    <div class="col-6 mt-2">
                        <button type="submit" class="btn btn-naranja" value="comun" name="boton">Responder</button>
                    </div>
                    <div class="col-6 text-right mt-2">
                        <button type="submit" class="btn btn-naranja" value="premium" name="boton">Responder
                            Premium</button>
                    </div>
                </div>
            </form>
        </div>
    </section>
</main>

<%@ include file="footer.jsp"%>