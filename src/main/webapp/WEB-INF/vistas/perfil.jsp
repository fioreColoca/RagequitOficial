<%@ include file="header.jsp"%>
    <main>
        <!--<c:if test="${not empty usuarioInfo}">-->
asd
            <section class="ancho p-3 row">
                <article class="col-12 col-md-3">
                    <h4><i class="fas fa-caret-right"></i> Configuracion de Usuario</h4>
                </article>
                <article class="col-12 col-md-9 pt-4">
                    <div class="row border-bottom">
                        <h5 class="col-4 font-weight-bold">Nombre de Usuario: </h5>
                        <h7 class="col-4">${usuario.getNombreUsuario()}</h7>
                        <h5 class="col-4 text-right">
                            <button type="button" class="btn btn-outline-info" data-toggle="modal" data-target="#cambiarNombre" href="#">
                            Editar
                        </button>
                        </h5>
                        <div class="modal fade" id="cambiarNombre" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                            <div class="modal-dialog">
                                <div class="modal-content">
                                    <div class="modal-header bg-dark text-white">
                                        <h5 class="modal-title" id="exampleModalLabel">Editar Nombre de Usuario</h5>
                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                                    </div>
                                    <div class="modal-body bg-dark text-white">
                                        <form action="/ModificarUsuario/modificarNombreUsuario" class="form-horizontal" method="post">
                                            <div class="form-group">
                                                <label for="nombre" class="control-label">Nombre de usuario actual:
                                                {{nombreUsuario}}</label>
                                                <div class="col-12">
                                                    <input type="text" name="nombre" id="nombre" class="form-control bg-dark text-white" placeholder="Ingrese el nuevo nombre de usuario">
                                                </div>
                                            </div>
                                            <div class="modal-footer">
                                                <button type="button" class="btn btn-outline-secondary" data-dismiss="modal">
                                                Cerrar
                                            </button>
                                                <button type="submit" class="btn btn-outline-success">Guardar
                                                Cambios</button>
                                            </div>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </article>
            </section>
        <!--</c:if>-->

    </main>
    <%@ include file="footer.jsp"%>