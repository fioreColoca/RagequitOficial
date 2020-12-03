<%@ include file="header.jsp"%>
<main>
    <!-- This snippet uses Font Awesome 5 Free as a dependency. You can download it at fontawesome.io! -->
    <c:if test="${not empty errorLogin}">
        <h5 class="text-center text-danger">Usuario o clave incorrecta</h5>
    </c:if>
    <c:if test="${not empty errorAlSeguir}">
        <h5 class="text-center text-danger">Primero debes iniciar sesion para seguir a un usuario</h5>
    </c:if>
    <c:if test="${not empty errorLike}">
        <h5 class="text-center text-danger">Primero debes iniciar sesion para likear a una publicacion o comentario</h5>
    </c:if>
    <div class="container" id="login">
        <div class="row">
            <div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
                <div class="card card-signin m-3">
                    <div class="card-body">
                        <h5 class="card-title text-center text-white border-bottom">Iniciar
                            sesi&oacute;n</h5>
                        <form:form action="validar-login" method="POST" modelAttribute="usuario" class="form-signin">

                            <div class="form-label-group">
                                <form:input path="email" id="email" type="email" class="form-control"
                                    placeholder="Correo electrónico" />
                            </div>

                            <div class="form-label-group">
                                <form:input path="password" type="password" id="password" class="form-control"
                                    placeholder="Contraseña" />
                            </div>

                            <button class="btn btn-lg btn-primary btn-block text-uppercase" type="submit">Iniciar
                                sesi&oacute;n</button>
                            <hr class="my-4">
                            <button class="btn btn-lg btn-google btn-block text-uppercase" type="button">Iniciar
                                sesi&oacute;n con Google</button>
                            
                        </form:form>
                    </div>
                    <p class="text-center text-white">
                        ¿Todavia no tienes una cuenta? <a href="registrar" class="login">Registrate</a>
                    </p>
                </div>
            </div>
        </div>
    </div>

</main>

<%@ include file="footer.jsp"%>