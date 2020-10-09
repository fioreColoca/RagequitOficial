<%@ include file="header.jsp"%>
	<main>
		<h1>Confirmamos el registro del nuevo Gamer:</h1>
		<p>El nombre del usuario es : ${nombre} </p>
		<p>El apellido del usuario es : ${apellido}</p>
		<p>El email del usuario es : ${email}</p>
		<div class="alert alert-success" role="alert">
  			<h4 class="alert-heading">¡Bienvenido a la familia!</h4>
  		</div>
		<a href="loginUsuarioRagequit" class="badge badge-light">Registrar Nuevo Usuario</a>
	</main>
<%@ include file="footer.jsp"%>