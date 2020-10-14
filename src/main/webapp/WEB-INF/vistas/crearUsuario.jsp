<%@ include file="header.jsp"%>
    <div class="card bg-light">
        <article class="card-body mx-auto" style="max-width: 400px;">
            <h4 class="card-title mt-3 text-center">Crear Cuenta</h4>
            <p class="text-center">Empiece con su cuenta gratuita</p>
            <form class="registrarUsuario" action="registrando">
                <div class="form-group input-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text"> <i class="fa fa-user"></i> </span>
                    </div>
                    <input name="nombre" class="form-control" placeholder="Nombre(s)" type="text">
                </div>
                <div class="form-group input-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text"> <i class="fa fa-user"></i> </span>
                    </div>
                    <input name="apellido" class="form-control" placeholder="Apellido(s)" type="text">
                </div>
                <!-- form-group// -->
                <div class="form-group input-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text"> <i class="fa fa-envelope"></i> </span>
                    </div>
                    <input name="email" class="form-control" placeholder="Email" type="email">
                </div>
                <!-- form-group// -->
                <div class="form-group input-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text"> <i class="fa fa-phone"></i> </span>
                    </div>
                    
                    <input name="telefono" class="form-control" placeholder="Tel&eacute;fono M&oacute;vil" type="text">
                </div>
                <!-- form-group// -->
                <div class="form-group input-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text"> <i class="fas fa-calendar"></i> </span>
                    </div>
                    <input name="nacimiento" class="form-control" placeholder="Fecha de nacimiento" type="date">
                </div>
                <!-- form-group end.// -->
                <div class="form-group input-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text"> <i class="far fa-user"></i> </span>
                    </div>
                    <input name="usuario" class="form-control" placeholder="Nombre de Usuario" type="text">
                </div>
                <div class="form-group input-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text"> <i class="fa fa-lock"></i> </span>
                    </div>
                    <input name="contrasenia" class="form-control" placeholder="Contraseña" type="password">
                </div>
                <!-- form-group// -->
                <div class="form-group">
                    <button type="submit" class="btn btn-primary btn-block"> Crear Cuenta</button>
                </div>
                <!-- form-group// -->
                <p class="text-center">¿Ya tienes una cuenta? <a href="login">Iniciar Sesi&oacute;n</a> </p>
            </form>
        </article>
    </div>
    <!-- card.// -->

    </div>
    </main>
    <%@ include file="footer.jsp"%>