<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
    <!DOCTYPE html>
    <html lang="es">

    <head>
    	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="shortcut icon" href="img/ragequit.ico" type="image/x-icon"/>
        <title>${title}</title>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.8/css/all.css">
        
        <link rel="stylesheet" href="css/estilos.css">
    </head>
    <body>
        <header>
            <nav class="navbar navbar-expand-xl navbar-dark bg-dark">
                <button type="button" class="navbar-toggler" data-toggle="collapse" data-target="#navbarCollapse">
               		<img src="img/logo.png" alt="Perfil">
            	</button>
                <img src="https://i.ibb.co/mvKDgT3/Logo-Rage-Quit-PNG.png" alt="Logo" class="logo">
                <!-- Collection of nav links, forms, and other content for toggling -->
                <div id="navbarCollapse" class="collapse navbar-collapse justify-content-start">
                    <form class="navbar-form form-inline">
                        <div class="input-group search-box">
                            <input type="text" id="search" class="form-control" placeholder="Search here..."> <span class="input-group-addon"><i class="material-icons">&#xE8B6;</i></span>
                        </div>
                    </form>
                    <div class="navbar-nav ml-auto">
                        <div class="nav-item dropdown">
                            <a href="#" data-toggle="dropdown" class="nav-item nav-link dropdown-toggle user-action"><img src="img/santiago.jpeg" class="avatar" alt="Avatar"> Santiago Fagliano <b class="caret"></b></a>
                            <div class="dropdown-menu">
                                <a href="#" class="dropdown-item"><i class="fa fa-user-o"></i>
                                Perfil</a> <a href="#" class="dropdown-item"><i class="fa fa-calendar-o"></i>
                                Calendario</a> <a href="#" class="dropdown-item"><i class="fa fa-sliders"></i>
                                Configuracion</a>
                                <div class="divider dropdown-divider"></div>
                                <a href="#" class="dropdown-item"><i class="material-icons">&#xE8AC;</i>
                                Cerrar sesi&oacute;n</a>
                            </div>
                        </div>
				    	 <a href="home" class="nav-item nav-link active"><i class="fa fa-home"></i><span>Inicio</span></a> 
                        <a href="comentario" class="nav-item nav-link"><i class="fa fa-gears"></i><span>Comentarios</span></a>
                        <a href="#" class="nav-item nav-link"><i class="fa fa-users"></i><span>Lista</span></a>
                        <a href="registrar" class="nav-item nav-link"><i class="fa fa-pie-chart"></i><span>Login</span></a> 
                        <a href="publicar" class="nav-item nav-link"><i class="fa fa-briefcase"></i><span>Publicacion</span></a>
                        <a href="#" class="nav-item nav-link"><i class="fa fa-envelope"></i><span>xd</span></a>
                        <a href="#" class="nav-item nav-link"><i class="fa fa-bell"></i><span>jejje</span></a>
                    </div>
                </div>
            </nav>
        </header>