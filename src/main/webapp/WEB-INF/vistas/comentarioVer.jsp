<%@ include file="header.jsp"%>
<main>

    <br>

    <c:if test="${not empty comentarios}">

        <c:forEach items="${comentarios}" var="comentario">

            <!--  COMUN  -->
            <c:set var="tipoComentario" value="${comentario.getTipo()}"></c:set>
            <c:if test="${tipoComentario=='COMUN'}">
                <c:set var="comentarioNOrespuesta" value="${comentario.getRespuesta()}"></c:set>
                <c:if test="${comentarioNOrespuesta==null}">

                    <div class="container p-3 mb-2 bg-fondo text-white">

                        <div class="row mb-4">

                            <div class="d-flex flex-row user-info mb-3 col-md-2 col-lg-1 justify-content-center">
                                <img class="rounded-circle border border-dark"
                                    src="${comentario.getUsuario().getUrl_imagen()}" width="50" height="50">

                            </div>
                            <div class="container col-md-10 col-lg-11 justify-content-center">

                                <h5 class="border-bottom">${comentario.getUsuario().getNombreUsuario()}</h5>

                                <c:set var="estadoComentario" value="${comentario.getEstado()}"></c:set>
                                <c:if test="${estadoComentario=='INACTIVO'}">
                                    <p>Comentario Eliminado</p>
                                </c:if>

                                <c:if test="${estadoComentario=='ACTIVO'}">
                                    <small class="text-white-50">
                                        ${comentario.getFechaHora().getHours()}:${comentario.getFechaHora().getMinutes()}
                                        hs ${comentario.getFechaHora().getDate()} /
                                        ${comentario.getFechaHora().getMonth()} /
                                        ${comentario.getFechaHora().getYear()+ 1900} </small>

                                    <p>En respuesta a: X publicación</p>

                                    <div class="container colorComentario rounded">
                                        <p class="text-dark !important p-3">${comentario.getMensaje()}</p>
                                    </div>
                                    <c:if test="${not empty usuarioRol}">
                                        <div class="hoverIcons d-flex justify-content-around bg-fondo p-2">
                                            <form action="meGustaComentario">
                                                <div>
                                                    <button class="btn btn-outline-naranja"
                                                        value="${comentario.getId()}" name="botonLike">
                                                        <i class="far fa-thumbs-up"></i>
                                                    </button>
                                                    <a class="verListadoLikes" data-toggle="modal" href="#verListado"
                                                        data-id="${comentario.getId()}">
                                                        ${comentario.getCantidadLikes()}</a>
                                                </div>
                                            </form>
                                            <div class="ml-3">
                                                <button type="button"
                                                    class="btn btn-outline-naranja responderComentario"
                                                    data-toggle="modal" data-target="#responderComentario"
                                                    data-id="${comentario.getId()}">
                                                    <i class="far fa-comment-dots"></i>
                                                </button>
                                            </div>
                                            <c:set var="idUsuario" value="${comentario.getUsuario().getId()}"></c:set>
                                            <c:set var="IdUsuarioComentario" value="${usuarioId}"></c:set>
                                            <c:if test="${idUsuario == IdUsuarioComentario}">
                                                <form action="borrarComentario">
                                                    <div>
                                                        <button type="button"
                                                            class="btn btn-outline-naranja botonBorrar"
                                                            data-toggle="modal" data-target="#borrarComentario"
                                                            data-id="${comentario.getId()}">
                                                            <i class="far fa-trash-alt"></i>
                                                        </button>
                                                    </div>
                                                </form>
                                            </c:if>
                                            <form>
                                                <div>
                                                    <button type="submit" class="btn btn-outline-naranja">
                                                        <i class="fas fa-share-alt"></i>
                                                    </button>
                                                </div>
                                            </form>
                                        </div>
                                    </c:if>
                                </c:if>
                            </div>
                        </div>
                    </div>
                </c:if>
            </c:if>
            <!--  COMUN  -->


            <!--  PREMIUM -->

            <c:if test="${tipoComentario=='SUSCRIPTOR'}">
                <c:set var="comentarioNOrespuesta" value="${comentario.getRespuesta()}"></c:set>
                <c:if test="${comentarioNOrespuesta==null}">
                    <div class="container p-3 mb-2 colorPremium text-white">

                        <div class="row mb-4">
                            <div class="d-flex flex-row user-info mb-3 col-md-2 col-lg-1 justify-content-center">
                                <img class="rounded-circle border border-dark"
                                    src="${comentario.getUsuario().getUrl_imagen()}" width="50" height="50">
                            </div>
                            <div class="container col-md-10 col-lg-11 justify-content-center">

                                <h4 class="border-bottom">${comentario.getUsuario().getNombreUsuario()}</h4>

                                <c:set var="estadoComentario" value="${comentario.getEstado()}"></c:set>
                                <c:if test="${estadoComentario=='INACTIVO'}">
                                    <p>Comentario Eliminado</p>
                                </c:if>

                                <c:if test="${estadoComentario=='ACTIVO'}">
                                    <p>${respuesta.getTipo()}</p>
                                    <small class="text-white-50">
                                        ${comentario.getFechaHora().getHours()}:${comentario.getFechaHora().getMinutes()}
                                        hs ${comentario.getFechaHora().getDate()} /
                                        ${comentario.getFechaHora().getMonth()}
                                        /${comentario.getFechaHora().getYear()+ 1900 } </small>
                                    <p>En respuesta a: X publicación</p>

                                    <div class="container colorComentario rounded">
                                        <p class="text-dark !important p-3">${comentario.getMensaje()}</p>
                                    </div>
                                    <c:if test="${not empty usuarioRol}">
                                        <div class="hoverIcons d-flex justify-content-around p-2">
                                            <form action="meGustaComentario">
                                                <div>
                                                    <button class="btn btn-outline-naranja"
                                                        value="${comentario.getId()}" name="botonLike">
                                                        <i class="far fa-thumbs-up"></i>
                                                    </button>
                                                    <a class="verListadoLikes" data-toggle="modal" href="#verListado"
                                                        data-id="${comentario.getId()}">
                                                        ${comentario.getCantidadLikes()}</a>
                                                </div>
                                            </form>
                                            <div class="ml-3">
                                                <button type="button"
                                                    class="btn btn-outline-naranja responderComentario"
                                                    data-toggle="modal" data-target="#responderComentario"
                                                    data-id="${comentario.getId()}">
                                                    <i class="far fa-comment-dots"></i>
                                                </button>
                                            </div>
                                            <c:set var="idUsuario" value="${comentario.getUsuario().getId()}"></c:set>
                                            <c:set var="IdUsuarioComentario" value="${usuarioId}"></c:set>
                                            <c:if test="${idUsuario == IdUsuarioComentario}">
                                                <form action="borrarComentario">
                                                    <div>
                                                        <button type="button"
                                                            class="btn btn-outline-naranja botonBorrar"
                                                            data-toggle="modal" data-target="#borrarComentario"
                                                            data-id="${comentario.getId()}">
                                                            <i class="far fa-trash-alt"></i>
                                                        </button>
                                                    </div>
                                                </form>
                                            </c:if>
                                            <form>
                                                <div>
                                                    <button type="submit" class="btn btn-outline-naranja">
                                                        <i class="fas fa-share-alt"></i>
                                                    </button>
                                                </div>
                                            </form>
                                        </div>
                                    </c:if>

                                </c:if>
                            </div>
                        </div>


                    </div>
                </c:if>
            </c:if>

            <div class="ml-5">
                <c:forEach items="${comentarios}" var="respuesta">

                    <!--  RESPUESTA COMUN  -->
                    <c:set var="tipoRespuesta" value="${respuesta.getTipo()}"></c:set>
                    <c:if test="${tipoRespuesta=='COMUN'}">
                        <c:set var="RespuestaDe" value="${respuesta.getRespuesta().getId()}"></c:set>
                        <c:set var="comentarioId" value="${comentario.getId()}"></c:set>
                        <c:if test="${RespuestaDe==comentarioId}">
                            <div class="container p-3 mb-2 bg-fondo text-white">
                                <div class="row mb-4">

                                    <div
                                        class="d-flex flex-row user-info mb-3 col-md-2 col-lg-1 justify-content-center">
                                        <img class="rounded-circle border border-dark"
                                            src="${respuesta.getUsuario().getUrl_imagen()}" width="50" height="50">
                                    </div>
                                    <div class="container col-md-10 col-lg-11 justify-content-center">

                                        <h5 class="border-bottom">${respuesta.getUsuario().getNombreUsuario()}</h5>

                                        <c:set var="estadoRespuesta" value="${respuesta.getEstado()}"></c:set>
                                        <c:if test="${estadoRespuesta=='INACTIVO'}">
                                            <p>Respuesta Eliminada</p>
                                        </c:if>

                                        <c:if test="${estadoRespuesta=='ACTIVO'}">
                                            <small class="text-white-50">
                                                ${comentario.getFechaHora().getHours()}:${respuesta.getFechaHora().getMinutes()}
                                                hs ${respuesta.getFechaHora().getDate()} /
                                                ${respuesta.getFechaHora().getMonth()} /
                                                ${respuesta.getFechaHora().getYear()+ 1900} </small>
                                            <c:set var="respuestaRespuesta" value="${respuesta.getRespuesta()}"></c:set>
                                            <p>En respuesta a: ${respuestaRespuesta.getUsuario().getNombreUsuario()}</p>
                                            <div class="container colorComentario rounded">
                                                <p class="text-dark !important p-3">${respuesta.getMensaje()}</p>
                                            </div>
                                            <c:if test="${not empty usuarioRol}">
                                                <div class="hoverIcons d-flex justify-content-around bg-fondo p-2">
                                                    <form action="meGustaComentario">
                                                        <div>
                                                            <button class="btn btn-outline-naranja"
                                                                value="${respuesta.getId()}" name="botonLike">
                                                                <i class="far fa-thumbs-up"></i>
                                                            </button>
                                                            <a class="verListadoLikes" data-toggle="modal"
                                                                href="#verListado" data-id="${comentario.getId()}">
                                                                ${respuesta.getCantidadLikes()}</a>
                                                        </div>
                                                    </form>


                                                    <c:set var="idUsuario" value="${respuesta.getUsuario().getId()}">
                                                    </c:set>
                                                    <c:set var="IdUsuarioRespuesta" value="${usuarioId}"></c:set>
                                                    <c:if test="${idUsuario == IdUsuarioRespuesta}">
                                                        <form action="borrarComentario">
                                                            <div>
                                                                <button type="button"
                                                                    class="btn btn-outline-naranja botonBorrar"
                                                                    data-toggle="modal" data-target="#borrarComentario"
                                                                    data-id="${respuesta.getId()}">
                                                                    <i class="far fa-trash-alt"></i>
                                                                </button>
                                                            </div>
                                                        </form>
                                                    </c:if>

                                                    <form>
                                                        <div>
                                                            <button type="submit" class="btn btn-outline-naranja">
                                                                <i class="fas fa-share-alt"></i>
                                                            </button>
                                                        </div>
                                                    </form>

                                                </div>
                                            </c:if>

                                        </c:if>
                                    </div>
                                </div>
                            </div>
                        </c:if>
                    </c:if>

                    <!--  COMUN  -->

                    <!--  RESPUESTA PREMIUM  -->

                    <c:if test="${tipoRespuesta=='SUSCRIPTOR'}">
                        <c:set var="RespuestaDe" value="${respuesta.getRespuesta().getId()}"></c:set>
                        <c:set var="comentarioId" value="${comentario.getId()}"></c:set>
                        <c:if test="${RespuestaDe==comentarioId}">
                            <div class="container p-3 mb-2 colorPremium text-white">
                                <div class="row mb-4">

                                    <div
                                        class="d-flex flex-row user-info mb-3 col-md-2 col-lg-1 justify-content-center">
                                        <img class="rounded-circle border border-dark"
                                            src="${respuesta.getUsuario().getUrl_imagen()}" width="50" height="50">
                                    </div>


                                    <div class="container col-md-10 col-lg-11 justify-content-center">

                                        <h4 class="border-bottom">${respuesta.getUsuario().getNombreUsuario()}</h4>


                                        <c:set var="estadoRespuesta" value="${respuesta.getEstado()}"></c:set>
                                        <c:if test="${estadoRespuesta=='INACTIVO'}">
                                            <p>Respuesta Eliminada</p>
                                        </c:if>
                                        <c:if test="${estadoRespuesta=='ACTIVO'}">
                                            <p>${respuesta.getTipo()}</p>
                                            <small class="text-white-50">
                                                ${comentario.getFechaHora().getHours()}:${respuesta.getFechaHora().getMinutes()}
                                                hs ${respuesta.getFechaHora().getDate()} /
                                                ${respuesta.getFechaHora().getMonth()} /
                                                ${respuesta.getFechaHora().getYear()+ 1900} </small>
                                            <c:set var="respuestaRespuesta" value="${respuesta.getRespuesta()}"></c:set>
                                            <p>En respuesta a: ${respuestaRespuesta.getUsuario().getNombreUsuario()}</p>
                                            <div class="container colorComentario rounded">
                                                <p class="text-dark !important p-3">${respuesta.getMensaje()}</p>
                                            </div>
                                            <c:if test="${not empty usuarioRol}">
                                                <div class="hoverIcons d-flex justify-content-around p-2">
                                                    <form action="meGustaComentario">
                                                        <div>
                                                            <button class="btn btn-outline-naranja"
                                                                value="${respuesta.getId()}" name="botonLike">
                                                                <i class="far fa-thumbs-up"></i>
                                                            </button>
                                                            <a class="verListadoLikes" data-toggle="modal"
                                                                href="#verListado" data-id="${comentario.getId()}">
                                                                ${respuesta.getCantidadLikes()}</a>
                                                        </div>
                                                    </form>



                                                    <c:set var="idUsuario" value="${respuesta.getUsuario().getId()}">
                                                    </c:set>
                                                    <c:set var="IdUsuarioRespuesta" value="${usuarioId}"></c:set>
                                                    <c:if test="${idUsuario == IdUsuarioRespuesta}">
                                                        <form action="borrarComentario">
                                                            <div>
                                                                <button type="button"
                                                                    class="btn btn-outline-naranja botonBorrar"
                                                                    data-toggle="modal" data-target="#borrarComentario"
                                                                    data-id="${respuesta.getId()}">
                                                                    <i class="far fa-trash-alt"></i>
                                                                </button>
                                                            </div>
                                                        </form>
                                                    </c:if>

                                                    <form>
                                                        <div>
                                                            <button type="submit" class="btn btn-outline-naranja">
                                                                <i class="fas fa-share-alt"></i>
                                                            </button>
                                                        </div>
                                                    </form>

                                                </div>
                                            </c:if>
                                        </c:if>
                                    </div>
                                </div>
                            </div>

                        </c:if>
                    </c:if>
                </c:forEach>
            </div>
        </c:forEach>
    </c:if>



    <!--  MODALS -->

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
                    <p>¿Seguro que deseas borrar el comentario?.</p>
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
            <div class="modal-content">
                <div class="modal-header bg-fondo p-3">
                    <form action="responderComentario" class="container" method="GET">
                        <p>Respondiendo a</p>
                        <div>
                            <textarea id="respuestaMandar" name="respuestaMandar" class="form-control" rows="3"
                                placeholder="Escribe tu respuesta" required></textarea>
                        </div>

                        <br>
                        <div class="row responderComent" id="">
                            <!--<label class="sr-only" name="boton" value="comun">-->
                            <div class="col-6 mt-6 mb-3">
                                <input type="hidden" name="idComentario" id="responderComentario" />
                                <button type="submit" class="btn btn-naranja" name="boton"
                                    value="comun">Responder</button>
                            </div>

                            <!--  <label class="sr-only" name="boton" value="comun">-->
                            <div class="col-6 text-right mt-6">
                                <button type="submit" class="btn btn-naranja" value="premium" name="boton">Responder
                                    Premium</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>



    <!-- Modal -->
    <div class="modal fade" id="verListado" role="dialog">
        <div class="modal-dialog">
            <!-- Modal content-->
            <div class="modal-content">
                <div class="modal-header bg-fondo p-3 container">
                    <h4>Marcado como Me gusta por</h4>

                </div>
            </div>
        </div>
    </div>


</main>

<!--  ACA NO VA EL ESTILO, ES PROVISORIO -->
<style>
    .colorCeleste {
        background: #010b1c;
    }

    .colorComentario {
        background: #eceff0;
    }

    .colorPremium {
        background: #173650;
    }
</style>

<!--  ACA NO VA EL ESTILO, ES PROVISORIO -->


<%@ include file="footer.jsp"%>