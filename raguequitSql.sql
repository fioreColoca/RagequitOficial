select * from usuario;
select * from categoria;
select * from publicacion;
select * from comentario;
select * from seguir;

use ragequit;

insert into categoria(id, descripcion, nombre, tipoCategoria, urlIcono, urlImagen)
value(1, "Paladins es una curiosa mezcla de acción en primera persona de carácter competitivo y estrategia de manos de los creadores de Smite que, con formato free-to-play (gratuito).", "Paladins", 0, "img/categoriaIcon/paladinsIcon.png", "https://static-cdn.jtvnw.net/ttv-boxart/Paladins-144x192.jpg"),
(2, "Se utiliza con frecuencia para demostrar que algo te parece muy lindo o quieres expresar ternura, esto de acuerdo con el Urban Dictionary. Otra forma de decirlo es que se utiliza 'uwu' cuando algo es sumamente kawaii.", "UWU", 1,"img/categoriaIcon/uwuIcon.png","https://wallpaperaccess.com/full/2108555.jpg"),
(3, "Las siglas 'Lol' corresponden a las iniciales del popular videojuego 'League of Legends'. El objetivo de los jugadores de 'Lol' es proteger la base propia mientras en el mapa se localizan y destruyen las bases de los enemigos.", "LoL", 0,"img/categoriaIcon/leagueOfLegendsIcon.png", "https://static-cdn.jtvnw.net/ttv-boxart/League%20of%20Legends-144x192.jpg"),
(4, "Todo el contenido referido a musica", "Musica", 1,"img/categoriaIcon/musicIcon.png","https://static-cdn.jtvnw.net/ttv-boxart/Music-285x380.jpg") ,
(5, "Minecraft es un videojuego de construcción, de tipo mundo abierto o sandbox creado originalmente por el sueco Markus Persson (conocido comúnmente como 'Notch').", "Minecraft", 0,"img/categoriaIcon/minecraftIcon.png", "https://static-cdn.jtvnw.net/ttv-boxart/Minecraft-144x192.jpg"),
(6, "El juego se basa en dos equipos, cada uno formado por cinco dioses, enfrentados en un campo de batalla con la finalidad de destruir el titán enemigo situado en cada una de las bases.", "Smite",0, "img/categoriaIcon/smiteIcon.png", "https://static-cdn.jtvnw.net/ttv-boxart/SMITE-144x192.jpg"),
(7, "Dota 2 es un juego multijugador de estrategia en tiempo real, distribuido por la plataforma Steam de Valve. En este, dos equipos de cinco jugadores tienen el objetivo de destruir las estructuras rivales controlando a personajes denominados héroes.", "DOTA2",0, "img/categoriaIcon/DOTA2Icon.png", "https://static-cdn.jtvnw.net/ttv-boxart/Dota%202-144x192.jpg"),
(8, "Garena Free Fire es un juego de battle royal de acción y aventuras solo en línea que se juega en una perspectiva en tercera persona. El juego consta de hasta 50 jugadores.", "FreeFire",0, "img/categoriaIcon/freeFireIcon.png", "https://static-cdn.jtvnw.net/ttv-boxart/Garena%20Free%20Fire-144x192.jpg"),
(9, "Among Us es un juego donde hay que encontrar a un impostor entre varios jugadores. A uno o dos usuarios les es asignado la tarea del asesinar o sabotear la nave donde todos van a viajar, pero nadie sabe quiénes son, sólo ellos.", "Among Us",0, "img/categoriaIcon/amongUsIcon.png", "https://static-cdn.jtvnw.net/ttv-boxart/Among%20Us-144x192.jpg"),
(10, "Sector's Edge es un juego de disparos en primera persona con un entorno completamente destructible.", "Sector's Edge",0, "img/categoriaIcon/sectorEdgeIcon.png", "https://static-cdn.jtvnw.net/ttv-boxart/Sector%27s%20Edge-144x192.jpg"),
(11, "Old School RuneScape (a veces llamado 2007scape) es el nombre oficial de Jagex para una versión antigua de RuneScape que han introducidos de un backup del código fuente de RuneScape del 10 de agosto, 2007.", "Old School RuneScape",0, "img/categoriaIcon/oldSchoolRunEscapeIcon.png", "https://static-cdn.jtvnw.net/ttv-boxart/Old%20School%20RuneScape-144x192.jpg"),
(12, "Super Mario Bros es un videojuego de plataformas, diseñado por Shigeru Miyamoto, lanzado el 13 de septiembre de 1985 y producido por la compañía Nintendo, para la consola Nintendo Entertainment System (NES).", "Mario Bros",0, "img/categoriaIcon/marioBrosIcon.png", "https://static-cdn.jtvnw.net/ttv-boxart/Super%20Mario%20Bros.-144x192.jpg"),
(13, "The Legend of Zelda es una serie de videojuegos de acción-aventura creada por los diseñadores japoneses Shigeru Miyamoto y Takashi Tezuka, y desarrollada por Nintendo, empresa que también se encarga de su distribución internacional.", "Zelda",0, "img/categoriaIcon/zeldaIcon.png", "https://static-cdn.jtvnw.net/ttv-boxart/./The%20Legend%20of%20Zelda:%20Breath%20of%20the%20Wild-144x192.jpg"),
(14, "Sonic the Hedgehog debe salvar a los inocentes animales que están siendo secuestrados por el Dr. Robotnik con la finalidad de usarlos para hacer funcionar sus robots. Sonic debe recolectar las 6 Esmeraldas del Caos.", "Sonic",0, "img/categoriaIcon/sonicIcon.png", "https://static-cdn.jtvnw.net/ttv-boxart/Sonic%20the%20Hedgehog-144x192.jpg");



insert into usuario(id, apellido, email, nombre, nombreUsuario, password, rol, url_imagen,contadorSeguidores,contadorSeguidos)
value(1, "Sanchez", "matias@email.com", "Matias", "Pewmafe", "123", "admin", "img/imgUsuario/matias.jpeg",0,0),
(2, "Fagliano", "santi@email.com", "Santiago", "ElSanti", "123", "admin", "img/imgUsuario/santiago.jpeg",0,0),
(3, "Fiora", "fiore@email.com", "Fiore", "LadyFio", "123", "usuario", "img/imgUsuario/fio.jpeg",0,0),
(4, "ElRey", "franco@email.com", "Franco", "Furanko", "123", "usuario", "img/imgUsuario/franco.jpeg",0,0),
(5, "Abi", "abril@email.com", "Abril", "Abi", "123", "admin", "img/imgUsuario/abril.jpeg",0,0);



insert into publicacion(id, cantidadComentarios, cantidadLikes, estado, fechaHora, mensaje, categoria_id, usuario_id)
value(1, 0, 0, 0, 20200512,"Aguante LoL ", 3, 4),
(2, 0, 0, 0, 20200516,"UwU de los UwUs", 2, 3),
(3, 0, 0, 0, 20200517,"sale maincra?", 14, 1),
(4, 0, 0, 0, 20200614,"Soy el mejor Zeus", 6, 2),
(5, 0, 0, 0, 20200801,"Estoy chikita", 4, 5);



