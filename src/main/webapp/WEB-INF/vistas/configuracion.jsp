<%@ include file="header.jsp" %>
    <main>
        <c:if test="${not empty usuarioLogeado}">

            <section class="ancho p-3 row">
                <article class="col-12 col-md-3">
                    <h4>
                        <i class="fas fa-caret-right"></i> Configuracion de Usuario
                    </h4>
                    <c:if test="${cambioExitoso == '1'}">
                        <div class="alert alert-success" role="alert">Actualizacio Exitosa
                        </div>
                    </c:if>
                </article>
                <article class="col-12 col-md-9 pt-4">

                    <div class="row border-bottom">
                        <h5 class="col-4 font-weight-bold">Nombre:</h5>
                        <h7 class="col-4">${nombre}</h7>
                        <h5 class="col-4 text-right">
                            <button type="button" class="btn btn-outline-info" data-toggle="modal" data-target="#cambiarNombre" href="#">
                                Editar</button>
                        </h5>
                        <div class="modal fade" id="cambiarNombre" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                            <div class="modal-dialog">
                                <div class="modal-content">
                                    <div class="modal-header bg-dark text-white">
                                        <h5 class="modal-title" id="exampleModalLabel">Editar Nombre
                                        </h5>
                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                            <span aria-hidden="true">&times;</span>
                                        </button>
                                    </div>
                                    <div class="modal-body bg-dark text-white">
                                        <form action="editarNombre" class="form-horizontal" method="get">
                                            <div class="form-group">
                                                <label for="nombre" class="control-label">Nombre de
                                                    usuario actual: ${nombre}</label>
                                                <div class="col-12">
                                                    <input type="text" name="nombre" id="nombre" class="form-control bg-dark text-white" placeholder="Ingrese el nuevo nombre de usuario">
                                                </div>
                                            </div>
                                            <div class="modal-footer">
                                                <button type="button" class="btn btn-outline-secondary" data-dismiss="modal">Cerrar</button>
                                                <button type="submit" class="btn btn-outline-success">Guardar
                                                    Cambios</button>
                                            </div>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="row mt-2 border-bottom">
                        <h5 class="col-4 font-weight-bold">Apellido:</h5>
                        <h7 class="col-4">${apellido}</h7>
                        <h5 class="col-4 text-right">
                            <button type="button" class="btn btn-outline-info" data-toggle="modal" data-target="#cambiarApellido" href="#">
                                Editar</button>
                        </h5>
                        <div class="modal fade" id="cambiarApellido" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                            <div class="modal-dialog">
                                <div class="modal-content">
                                    <div class="modal-header bg-dark text-white">
                                        <h5 class="modal-title" id="exampleModalLabel">Editar Apellido
                                        </h5>
                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                            <span aria-hidden="true">&times;</span>
                                        </button>
                                    </div>
                                    <div class="modal-body bg-dark text-white">
                                        <form action="editarApellido" class="form-horizontal" method="post">
                                            <div class="form-group">
                                                <label for="apellido" class="control-label">Apellido
                                                    de usuario actual: ${apellido}</label>
                                                <div class="col-12">
                                                    <input type="text" name="apellido" id="apellido" class="form-control bg-dark text-white" placeholder="Ingrese su nueva contrase&ntilde;a de usuario">
                                                </div>
                                            </div>
                                            <div class="modal-footer">
                                                <button type="button" class="btn btn-outline-secondary" data-dismiss="modal">Cerrar</button>
                                                <button type="submit" class="btn btn-outline-success">Guardar
                                                    Cambios</button>
                                            </div>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="row mt-2 border-bottom">
                        <h5 class="col-4 font-weight-bold">Email:</h5>
                        <h7 class="col-4">${email}</h7>
                        <h5 class="col-4 text-right">
                            <button type="button" class="btn btn-outline-info" data-toggle="modal" data-target="#cambiarEmail" href="#">
                                Editar</button>
                        </h5>
                        <div class="modal fade" id="cambiarEmail" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                            <div class="modal-dialog">
                                <div class="modal-content">
                                    <div class="modal-header bg-dark text-white">
                                        <h5 class="modal-title" id="exampleModalLabel">Editar e-mail
                                        </h5>
                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                            <span aria-hidden="true">&times;</span>
                                        </button>
                                    </div>
                                    <div class="modal-body bg-dark text-white">
                                        <form action="editarEmail" class="form-horizontal" method="post">
                                            <div class="form-group">
                                                <label for="email" class="control-label">Email de
                                                    usuario actual: ${email}</label>
                                                <div class="col-12">
                                                    <input type="text" name="email" id="email" class="form-control bg-dark text-white" placeholder="Ingrese su nueva contrase&ntilde;a de usuario">
                                                </div>
                                            </div>
                                            <div class="modal-footer">
                                                <button type="button" class="btn btn-outline-secondary" data-dismiss="modal">Cerrar</button>
                                                <button type="submit" class="btn btn-outline-success">Guardar
                                                    Cambios</button>
                                            </div>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="row mt-2 border-bottom">
                        <h5 class="col-4 font-weight-bold">Nombre de Usuario:</h5>
                        <h7 class="col-4">${nombreUsuarioo}</h7>
                        <h5 class="col-4 text-right">
                            <button type="button" class="btn btn-outline-info" data-toggle="modal" data-target="#cambiarNombreUsuario" href="#">
                                Editar</button>
                        </h5>
                        <div class="modal fade" id="cambiarNombreUsuario" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                            <div class="modal-dialog">
                                <div class="modal-content">
                                    <div class="modal-header bg-dark text-white">
                                        <h5 class="modal-title" id="exampleModalLabel">Editar nombre de Usuario RageQuit
                                        </h5>
                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                            <span aria-hidden="true">&times;</span>
                                        </button>
                                    </div>
                                    <div class="modal-body bg-dark text-white">
                                        <form action="editarNombreUsuario" class="form-horizontal" method="post">
                                            <div class="form-group">
                                                <label for="nombreUsuario" class="control-label">Nombre
                                                    de usuario RageQuit actual: ${nombreUsuarioo}</label>
                                                <div class="col-12">
                                                    <input type="text" name="nombreUsuario" id="nombreUsuario" class="form-control bg-dark text-white" placeholder="Ingrese su nueva contrase&ntilde;a de usuario">
                                                </div>
                                            </div>
                                            <div class="modal-footer">
                                                <button type="button" class="btn btn-outline-secondary" data-dismiss="modal">Cerrar</button>
                                                <button type="submit" class="btn btn-outline-success">Guardar
                                                    Cambios</button>
                                            </div>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="row mt-2 border-bottom">
                        <h5 class="col-4 font-weight-bold">Contrase&ntilde;a:</h5>
                        <h7 class="col-4">${contrasenia}</h7>
                        <h5 class="col-4 text-right">
                            <button type="button" class="btn btn-outline-info" data-toggle="modal" data-target="#cambiarPass" href="#">
                                Editar</button>
                        </h5>
                        <div class="modal fade" id="cambiarPass" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                            <div class="modal-dialog">
                                <div class="modal-content">
                                    <div class="modal-header bg-dark text-white">
                                        <h5 class="modal-title" id="exampleModalLabel">Editar Contrase&ntilde;a de Usuario
                                        </h5>
                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                            <span aria-hidden="true">&times;</span>
                                        </button>
                                    </div>
                                    <div class="modal-body bg-dark text-white">
                                        <form action="editarContrasenia" class="form-horizontal" method="post">
                                            <div class="form-group">
                                                <label for="contrasenia" class="control-label">Contrase&ntilde;a
                                                    de usuario actual: ${contrasenia}</label>
                                                <div class="col-12">
                                                    <input type="password" name="contrasenia" id="contrasenia" class="form-control bg-dark text-white" placeholder="Ingrese su nueva contrase&ntilde;a de usuario">
                                                </div>
                                            </div>
                                            <div class="modal-footer">
                                                <button type="button" class="btn btn-outline-secondary" data-dismiss="modal">Cerrar</button>
                                                <button type="submit" class="btn btn-outline-success">Guardar
                                                    Cambios</button>
                                            </div>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="row mt-2 border-bottom">
                        <h5 class="col-4 font-weight-bold">Numero de telefono</h5>
                        <h7 class="col-4">${telefono}</h7>
                        <h5 class="col-4 text-right">
                            <button type="button" class="btn btn-outline-info" data-toggle="modal" data-target="#cambiarTelefono" href="#">
                                Editar</button>
                        </h5>
                        <div class="modal fade" id="cambiarTelefono" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                            <div class="modal-dialog">
                                <div class="modal-content">
                                    <div class="modal-header bg-dark text-white">
                                        <h5 class="modal-title" id="exampleModalLabel">Editar numero de telefono de Usuario
                                        </h5>
                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                            <span aria-hidden="true">&times;</span>
                                        </button>
                                    </div>
                                    <div class="modal-body bg-dark text-white">
                                        <form action="editarTelefono" class="form-horizontal" method="post">
                                            <div class="form-group">
                                                <label for="tel" class="control-label">Numero de telefono
                                                    de usuario actual: ${telefono}</label>
                                                <div class="col-12">
                                                    <input type="number" name="tel" id="tel" class="form-control bg-dark text-white" placeholder="Ingrese su nuevo numero de telefono de usuario">
                                                </div>
                                            </div>
                                            <div class="modal-footer">
                                                <button type="button" class="btn btn-outline-secondary" data-dismiss="modal">Cerrar</button>
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
        </c:if>
        <c:if test="${empty usuarioLogeado}">
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
        </c:if>

    </main>
    <%@ include file="footer.jsp" %>