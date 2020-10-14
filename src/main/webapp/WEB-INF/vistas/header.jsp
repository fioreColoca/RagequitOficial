<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
    <!DOCTYPE html>
    <html lang="es">

    <head>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
            <meta charset="utf-8">
            <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
            <link rel="shortcut icon" href="img/ragequit.ico" type="image/x-icon" />
            <title>${title}</title>
            <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
            <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
            <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css" integrity="sha512-+4zCK9k+qNFUR5X+cKL9EIR+ZOhtIloNl9GIKS57V1MyNsYpYcUrUeQc9vNfzsWfV28IaLL3i96P9sdNyeRssA==" crossorigin="anonymous" />
            <link rel="stylesheet" href="css/estilosV2.css">
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
                            <input type="text" id="search" class="form-control" placeholder="Buscar"> <span class="input-group-addon"><i class="fas fa-search"></i></span>
                        </div>
                    </form>
                    <div class="navbar-nav ml-auto">
                        <div class="nav-item dropdown">
                            <a href="#" data-toggle="dropdown" class="nav-item nav-link dropdown-toggle user-action"><img src="img/santiago.jpeg" class="avatar" alt="Avatar"> Santiago Fagliano <b class="caret"></b></a>
                            <div class="dropdown-menu">
                                <a href="#" class="dropdown-item"><i class="fas fa-user-circle"></i>
                                Perfil</a><a href="#" class="dropdown-item"><i class="fas fa-sliders-h"></i></i>
                                Configuraci&oacute;n</a>
                                <div class="divider dropdown-divider"></div>
                                <a href="#" class="dropdown-item"><i class="fas fa-power-off"></i>
                                Cerrar sesi&oacute;n</a>
                            </div>
                        </div>
                        <a href="home" class="nav-item nav-link active"><i class="fa fa-home"></i><span>Inicio</span></a>
                        <a href="comentario" class="nav-item nav-link"><i
                            class="fas fa-comments"></i><span>Comentarios</span></a>
                        <a href="categoria" class="nav-item nav-link"><i
                            class="fas fa-gamepad"></i><span>Categoria</span></a>
                        <a href="#" class="nav-item nav-link"><i class="fas fa-list-ul"></i><span>Lista</span></a>
                        <a href="registrar" class="nav-item nav-link"><i
                            class="fas fa-sign-in-alt"></i><span>Login</span></a>
                        <a href="#" class="nav-item nav-link"><i class="fas fa-trophy"></i><span>xd</span></a>
                        <a href="#" class="nav-item nav-link"><i class="fas fa-gamepad"></i><span>jejje</span></a>
                    </div>
                </div>
            </nav>
        </header>