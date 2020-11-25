<%@ include file="header.jsp"%>
<main>
    <c:if test="${usuarioLogeado.getRol() == 'admin'}">
        <section class="border-bottom mb-2">
            <h3>Administracion de roles</h3>
        </section>
        <section>
            <c:if test="${errorCambiarRol == 'true'}">
                <h5 class="text-danger">Ocurrio un error al cambiar rol</h5>
            </c:if>
            <div class="row">
                <c:forEach items="${listaUsuarios}" var="usuario">
                    <div class="col-12 col-md-6 col-lg-4 p-2">
                        <div class="card mb-4 p-3 borde-naranja">
                            <h3 class="text-center border-bottom border-secondary">Descripcion
                                del Usuario:</h3>
                            <p class="text-light">
                                <span class="h5 font-weight-bold">Nombre</span>:
                                ${usuario.getNombre()}
                            </p>
                            <p class="text-light">
                                <span class="h5 font-weight-bold">Nombre RageQuit</span>:
                                ${usuario.getNombreUsuario()}
                            </p>
                            <p class="text-light">
                                <span class="h5 font-weight-bold">Email</span>:
                                ${usuario.getEmail()}
                            </p>
                            <p class="text-light">
                                <span class="h5 font-weight-bold">Rol</span>:
                                ${usuario.getRol()}
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
                                    <button type="submit" class="btn btn-naranja mt-3 botonBloque"
                                        name="botonCambiarRol" id="botonCambiarRol" value="${usuario.getId()}">Cambiar
                                        Rol</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </c:forEach>
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
                <p>Es posible que la página que está buscando se haya eliminado,
                    no está disponible temporalmente o no tienes acceso a ella.</p>
                <a href=" home" class="btn btn-outline-naranja">Ir al inicio</a>
            </div>
        </div>
    </c:if>
</main>

<%@ include file="footer.jsp"%>