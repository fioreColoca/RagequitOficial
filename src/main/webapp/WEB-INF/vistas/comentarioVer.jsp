<%@ include file="header.jsp"%>
    <main>

        <div class="container p-3 mb-2 colorCeleste text-white">

            <div class="row">

                <div class="d-flex flex-row user-info mb-3 col-md-2 col-lg-1 justify-content-center">
                    <img class="rounded-circle" src="img/santiago.jpeg" width="50" height="50">
                </div>

                <div class="container col-md-10 col-lg-11 justify-content-center">

                    <h5>Nombre de usuario</h5>
                    <small> ${comentario.getFechaHora().getHours()}:${comentario.getFechaHora().getMinutes()} hs
                    ${comentario.getFechaHora().getDate()} / ${comentario.getFechaHora().getMonth()} /
                    ${comentario.getFechaHora().getYear() + 1900 } </small>
                    <p>En respuesta a: </p>

                    <div class="container colorComentario">
                        <p class="text-dark !important p-3">${comentario.getMensaje()}</p>
                    </div>

                    <p> ${comentario.getTipo()}</p>

                    <div class=" container row">

                        <div>
                            <form action="meGustaComentario">
                                <button type="submit" value=" ${comentario.getId()}" name="botonLike" class="text-warning btn btn-outline-warning">
                                <i class="fas fa-star"></i>
                            </button>
                            </form>
                            <!--  Esto tiene pìnta de hacerse de una manera mas limpia -->

                        </div>

                        <div class="ml-1">
                            <p>${comentario.getCantidadLikes()}</p>
                        </div>

                        <div class="ml-3">
                            <button type="submit" class="text-warning btn btn-outline-warning">
                            <i class="far fa-comment-dots"></i>
                        </button>
                        </div>

                        <div class="ml-3">
                            <form action="borrarComentario">
                                <button type="submit" value="${comentario.getId()}" name="botonBorrar" class="text-warning btn btn-outline-warning botonBorrar">
                                <i class="far fa-trash-alt"></i>
                            </button>
                            </form>
                        </div>

                    </div>
                </div>
            </div>

    </main>

    <!--  ACA NO VA EL ESTILO, ES PROVISORIO -->
    <style>
        .colorCeleste {
            background: #287EB0;
        }
        
        .colorComentario {
            background: #eceff0;
        }
    </style>


    <%@ include file="footer.jsp"%>