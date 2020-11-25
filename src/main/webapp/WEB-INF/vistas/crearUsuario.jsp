<%@ include file="header.jsp"%>
<main style="padding:0;">
    <div class="card bg-normal">

        <article class="card-body mx-auto" style="max-width: 400px;">

            <h4 class="card-title mt-3 text-center text-white">Crear Cuenta</h4>
            <p class="text-center text-white">Empiece con su cuenta gratuita</p>

            <form:form class="registrarUsuario" action="registrando" method="POST" modelAttribute="usuario">

                <div class="form-group input-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text"> <i class="fa fa-user"></i> </span>
                    </div>
                    <form:input path="nombre" id="nombre" class="form-control" placeholder="Nombre(s)" type="text" />
                </div>

                <div class="form-group input-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text"> <i class="fa fa-user"></i> </span>
                    </div>
                    <form:input path="apellido" id="apellido" class="form-control" placeholder="Apellido(s)"
                        type="text" />

                </div>

                <!-- form-group// -->
                <div class="form-group input-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text"> <i class="fa fa-envelope"></i> </span>
                    </div>
                    <form:input path="email" id="email" type="email" class="form-control" placeholder="Email" />
                </div>

                <!-- form-group// -->
                <div class="form-group input-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text"> <i class="fa fa-phone"></i> </span>
                    </div>
                    <input path="telefono" id="telefono" class="form-control" placeholder="Tel&eacute;fono M&oacute;vil"
                        type="text">
                </div>

                <!-- form-group// -->
                <div class="form-group input-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text"> <i class="fas fa-calendar"></i> </span>
                    </div>
                    <input path="fechaNacimiento" id="fechaNacimiento" class="form-control"
                        placeholder="Fecha de nacimiento" type="date">
                </div>

                <!-- form-group end.// -->
                <div class="form-group input-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text"> <i class="far fa-user"></i> </span>
                    </div>
                    <form:input path="nombreUsuario" id="nombreUsuario" class="form-control"
                        placeholder="Nombre de Usuario" type="text" />
                </div>

                <div class="form-group input-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text"> <i class="fa fa-lock"></i> </span>
                    </div>
                    <form:input path="password" id="" class="form-control" placeholder="Contraseña" type="password" />
                </div>

                <!-- form-group// -->
                <div class="form-group">
                    <button type="submit" class="btn btn-primary btn-block"> Crear Cuenta</button>
                </div>

                <!-- form-group// -->
                <p class="text-center text-white">¿Ya tienes una cuenta? <a href="login" class="login">Iniciar
                        Sesi&oacute;n</a></p>

            </form:form>
        </article>
    </div>
    <!-- card.// -->


</main>
<%@ include file="footer.jsp"%>