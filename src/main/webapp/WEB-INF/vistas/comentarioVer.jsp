<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ver comentario</title>
</head>
<body>
	<p>Mensaje: ${comentario.getMensaje()}</p>
	<p>${comentario.getFechaHora()}</p>
	
	<form action="meGustaComentario">
	<button type="submit" >Like</button>
	</form> <!--  Esto tiene pìnta de hacerse de una manera mas limpia -->
	
	<p>Likes: ${comentario.getCantidadLikes()}</p>
	<button type="submit" >Responder</button>
	
	
	<form action="borrarComentario">
	<button type="submit" >Borrar</button>
	</form> <!--  Esto tiene pìnta de hacerse de una manera mas limpia -->
	

</body>
</html>