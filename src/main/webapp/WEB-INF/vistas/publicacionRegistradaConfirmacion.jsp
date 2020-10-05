<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Publicacion</title>
</head>
<body>
<h1>Confirmacion de la publicacion</h1>
	<main>
		<p>	El ID de la publicacion es: ${idpublicacion}. </p>
		<p>	El Mensaje de la publicacion es: ${publicacion.getMensaje()}</p>
		<p>	La categoria de la publicacion es: ${categoria}</p>
		<a href="registrarPublicacion">Hacer otra publicacion</a>
	</main>
</body>
</html>