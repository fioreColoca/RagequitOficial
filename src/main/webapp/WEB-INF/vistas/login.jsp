<%-- <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> --%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> --%>
<!-- <!DOCTYPE html> -->
<!-- <html> -->
<!-- 	<head> -->
<!-- 	<!-- Bootstrap core CSS -->
<!-- 	    <link href="css/bootstrap.min.css" rel="stylesheet" > -->
<!-- 	    Bootstrap theme -->
<!-- 	    <link href="css/bootstrap-theme.min.css" rel="stylesheet"> -->
<!-- 	</head> -->
<!-- 	<body> -->
<!-- 		<div class = "container"> -->
<!-- 			<div id="loginbox" style="margin-top:50px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2"> -->
<%-- 				Definicion de un form asociado a la accion /validar-login por POST. Se indica ademas que el model attribute se --%>
<%-- 				debe referenciar con el nombre usuario, spring mapea los elementos de la vista con los atributos de dicho objeto --%>
<%-- 					para eso debe coincidir el valor del elemento path de cada input con el nombre de un atributo del objeto --%>
<%-- 				<form:form action="validar-login" method="POST" modelAttribute="usuario"> --%>
<!-- 			    	<h3 class="form-signin-heading">Taller Web I</h3> -->
<!-- 					<hr class="colorgraph"><br> -->

<%-- 					Elementos de entrada de datos, el elemento path debe indicar en que atributo del objeto usuario se guardan los datos ingresados --%>
<%-- 					<form:input path="email" id="email" type="email" class="form-control" /> --%>
<%-- 					<form:input path="password" type="password" id="password" class="form-control"/>     		   --%>

<!-- 					<button class="btn btn-lg btn-primary btn-block" Type="Submit"/>Login</button> -->
<%-- 				</form:form> --%>

<%-- 				Bloque que es visible si el elemento error no está vacío	 --%>
<%-- 				<c:if test="${not empty error}"> --%>
<%-- 			        <h4><span>${errorCategoriaVacia}</span></h4> --%>
<!-- 			        <br> -->
<%-- 		        </c:if>	 --%>
<!-- 			</div> -->
<!-- 		</div> -->

<!-- 		<!-- Placed at the end of the document so the pages load faster -->
<!-- 		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" ></script> -->
<!-- 		<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script> -->
<!-- 		<script src="js/bootstrap.min.js" type="text/javascript"></script> -->
<!-- 	</body> -->
<!-- </html> -->
<%@ include file="header.jsp"%>
<main>
    <!-- This snippet uses Font Awesome 5 Free as a dependency. You can download it at fontawesome.io! -->
    <c:if test="${not empty error}">
        <h5 class="text-center text-danger">${error}</h5>
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
                            <button class="btn btn-lg btn-google btn-block text-uppercase" type="submit">Iniciar
                                sesi&oacute;n con Google</button>
                            <button class="btn btn-lg btn-facebook btn-block text-uppercase" type="submit">Iniciar
                                sesi&oacute;n con Facebook</button>
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