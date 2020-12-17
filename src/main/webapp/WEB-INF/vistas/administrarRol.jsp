<%@ include file="header.jsp" %>
    <main>
        <c:if test="${usuarioLogeado.getRol() == 'admin'}">
            <section class="border-bottom mb-2">
                <h3>Administracion de roles</h3>
            </section>
            <section>
                <c:if test="${errorCambiarRol == 'true'}">
                    <div class="alert alert-danger alert-dismissible fade show" role="alert">
                        <strong>Ocurrio un error al cambiar rol.</strong>
                        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                </c:if>
                <div class="row">

                    <div class="container table-responsive mb-5 mt-3">
                        <table class="table table-dark table-striped table-bordered" style="width: 100%;" id="mydatatableUsuarios">
                            <thead>
                                <tr class="bg-fondo">
                                    <th>Nombre</th>
                                    <th>Nombre RageQuit</th>
                                    <th>Email</th>
                                    <th>Rol</th>
                                    <th></th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${listaUsuarios}" var="usuario">
                                    <tr class="bg-fondo-dos">
                                        <td>${usuario.getNombre()}</td>
                                        <td>${usuario.getNombreUsuario()}</td>
                                        <td>${usuario.getEmail()}</td>
                                        <td>${usuario.getRol()}</td>
                                        <td class="dropdown dropleft">
                                            <a class="btn btn-outline-info dropdown-toggle" href="#" role="button" id="dropdownMenuLink${usuario.getId()}" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                            </a>

                                            <div class="bg-dark dropdown-menu dropdown-menu-right row p-2" aria-labelledby="dropdownMenuLink${usuario.getId()}" style="right: 1em;">
                                                <button type="button" class="btn btn-naranja" data-toggle="modal" data-target="#staticBackdrop${usuario.getId()}">
                                                    Modificar Rol
                                                </button>
                                            </div>

                                        </td>
                                    </tr>
                                    <!-- Modal -->
                                    <div class="modal fade" id="staticBackdrop${usuario.getId()}" data-backdrop="static" data-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
                                        <div class="modal-dialog">
                                            <div class="modal-content">
                                                <div class="modal-header bg-fondo">
                                                    <h5 class="modal-title" id="staticBackdropLabel">Modificar Rol</h5>
                                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                        <span aria-hidden="true">&times;</span>
                                                    </button>
                                                </div>
                                                <div class="modal-body bg-fondo">
                                                    <form action="cambiarRol" method="post">
                                                        <div class="input-group mb-3">
                                                            <select class="custom-select" name="rolUsuario" id="rolUsuario">
                                                                <option selected disabled>Elija un rol...</option>
                                                                <option value="usuario">Usuario</option>
                                                                <option value="admin">Administrador</option>
                                                            </select>
                                                        </div>
                                                        <div class="text-center">
                                                            <button type="submit" class="btn btn-naranja mt-3 botonBloque" name="botonCambiarRol" id="botonCambiarRol" value="${usuario.getId()}">Cambiar
                                                                Rol</button>
                                                        </div>
                                                    </form>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </c:forEach>
                            </tbody>
                            <tfoot>
                                <tr class="bg-fondo">
                                    <th>Nombre</th>
                                    <th>Nombre RageQuit</th>
                                    <th>Email</th>
                                    <th>Rol</th>
                                    <th></th>
                                </tr>
                            </tfoot>
                        </table>
                    </div>
                    <!--
                        <div class="col-12 col-md-6 col-lg-4 p-2">
                            <div class="card mb-4 p-3 borde-naranja">
                                <h3 class="text-center border-bottom border-secondary">Descripcion del Usuario:</h3>
                                <p class="text-light">
                                    <span class="h5 font-weight-bold">Nombre</span>: ${usuario.getNombre()}
                                </p>
                                <p class="text-light">
                                    <span class="h5 font-weight-bold">Nombre RageQuit</span>: ${usuario.getNombreUsuario()}
                                </p>
                                <p class="text-light">
                                    <span class="h5 font-weight-bold">Email</span>: ${usuario.getEmail()}
                                </p>
                                <p class="text-light">
                                    <span class="h5 font-weight-bold">Rol</span>: ${usuario.getRol()}
                                </p>
                                <form action="cambiarRol" method="post">
                                    <div class="input-group mb-3">
                                        <select class="custom-select" name="rolUsuario" id="rolUsuario">
                                            <option selected disabled>Elija un rol...</option>
                                            <option value="usuario">Usuario</option>
                                            <option value="admin">Administrador</option>
                                        </select>
                                    </div>
                                    <div class="text-center">
                                        <button type="submit" class="btn btn-naranja mt-3 botonBloque" name="botonCambiarRol" id="botonCambiarRol" value="${usuario.getId()}">Cambiar
                                            Rol</button>
                                    </div>
                                </form>
                            </div>
                        </div>-->

                </div>
            </section>
        </c:if>
        <c:if test="${usuarioLogeado.getRol() != 'admin'}">
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