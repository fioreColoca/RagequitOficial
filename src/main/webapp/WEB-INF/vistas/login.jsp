<%@ include file="header.jsp" %>
    <main>
        <c:if test="${not empty errorLogin}">
            <div class="alert alert-danger alert-dismissible fade show" role="alert">
                <strong>Usuario o clave incorrecta.</strong>
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
        </c:if>
        <c:if test="${not empty errorAlSeguir}">
            <div class="alert alert-danger alert-dismissible fade show" role="alert">
                <strong>Primero debes iniciar sesion para seguir a un usuario o categoria.</strong>
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
        </c:if>
        <c:if test="${not empty errorLike}">
            <div class="alert alert-danger alert-dismissible fade show" role="alert">
                <strong>Primero debes iniciar sesion para likear a una publicacion o comentario.</strong>
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
        </c:if>
        <div class="container" id="login">
            <div class="row">
                <div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
                    <div class="card card-signin m-3">
                        <div class="card-body">
                            <h5 class="card-title text-center text-white border-bottom">Iniciar sesi&oacute;n
                            </h5>
                            <form:form action="validar-login" method="POST" modelAttribute="usuario" class="form-signin">

                                <div class="form-label-group">
                                    <form:input path="email" id="email" type="email" class="form-control" placeholder="Correo electr�nico" />
                                </div>

                                <div class="form-label-group">
                                    <form:input path="password" type="password" id="password" class="form-control" placeholder="Contrase�a" />
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

    <%@ include file="footer.jsp" %>