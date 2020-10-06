<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ver comentario</title>
</head>
<body>
	<p>${comentario.getMensaje()}</p>
	<p>${comentario.getFechaHora()}</p>
	<p>Likes: ${comentario.getCantidadLikes()}</p>
</body>
</html>