<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista de Contenido</title>
</head>

<body>
	<form action="Lista">
		<label for="filtro">Filtrar contenido por Genero</label> 
			<select name="filtro" id="filtro">
				<option value="Juego">Juego</option>
				<option value="Anime">Anime</option>
				<option value="Marvel">Marvel</option>
				<option value="Comic">Comic</option>
				<option value="Manga">Manga</option>
				<option value="Cosplay">Cosplay</option>
				<option value="Arte">Arte</option>
				<option value="UWU">UWU</option>
				<option value="Furry">Furry</option>
				<option value="Stream">Stream</option>
				<option value="Social">Social</option>
			</select>
			<button type="submit">Filtrar</button>
	</form>


</body>
</html>