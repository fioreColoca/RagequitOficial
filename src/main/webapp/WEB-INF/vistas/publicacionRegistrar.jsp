<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Publicar</title>
</head>
<body>
<h1>Publicar</h1>
<form action="confirmacionRegistroPublicacion">
        <label for="mensajePublicacion"><b>Mensaje Gamer para Gamers:</b></label>
        <input  type="text" id="mensajePublicacion" name="mensajePublicacion">
        <label for="categoriaPublicacion"><b>Categoria:</b></label>
        <!-- <input type="text" id="rolCampeon" name="rolCampeon"> -->
        <select name="categoriaPublicacion" id="categoriaPublicacion">
         	<optgroup label="Juegos">
         		<option value="valorant">Valorant</option>
         		<option value="smite">Smite</option>
         		<option value="counter-strike">Counter-Strike</option>
         		<option value="among us">Among Us</option>
         	</optgroup>
  			<optgroup label="Otros">
         		<option value="anime">Anime</option>
         		<option value="arte">Arte</option>
         		<option value="uwu">uwu</option>
         		<option value="comida">Comida</option>
         		<option value="social">Social</option>
         	</optgroup>	
		</select>
        <button type="submit">Publicar</button>
    </form>
</body>
</html>