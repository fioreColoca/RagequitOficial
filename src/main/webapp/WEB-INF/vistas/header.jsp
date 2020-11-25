<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="shortcut icon" href="img/ragequit.ico" type="image/x-icon" />
    <title>${title}</title>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css"
        integrity="sha512-+4zCK9k+qNFUR5X+cKL9EIR+ZOhtIloNl9GIKS57V1MyNsYpYcUrUeQc9vNfzsWfV28IaLL3i96P9sdNyeRssA=="
        crossorigin="anonymous" />
    <link rel="stylesheet" href="OwlCarousel2-2.3.4/dist/assets/owl.carousel.min.css">
    <link rel="stylesheet" href="OwlCarousel2-2.3.4/dist/assets/owl.theme.default.min.css">
    <link rel="stylesheet" href="css/estilosV2.css">
</head>

<body>
    <header>
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <a class="navbar-brand logo" href="#"><img src="img/logo.png" alt="LogoRagequit" srcset=""
                    class="img-fluid"></a>

            <form class="form-inline my-2 my-lg-0 buscador">
                <div class="search-box">
                    <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
                    <span class="input-group-addon"><i class="fas fa-search"></i></span>
                </div>
                <!--<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>-->
            </form>
            <a class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <img src="img/logo.png" alt="LogoRagequit" srcset="" class="img-fluid">
            </a>
            <div class="d-flex flex-wrap m-auto">
                <a href="#" class="p-2">
                    <i class="fas fa-user-friends"></i>
                </a>
                <a href="home" class="p-2" style="color:#f4a117">
                    <i class="fas fa-house-user"></i>
                </a>
                <a href="#" class="p-2">
                    <i class="fas fa-fire-alt"></i>
                </a>
                <a href="biblioteca" class="p-2">
                    <i class="fas fa-list-ul"></i>
                </a>
            </div>
            <c:if test="${empty usuarioLogeado}">
                <div class="menu justify-content-end">
                    <ul class="navbar-nav justify-content-end sub-menu">
                        <li class="nav-item ">
                            <a class="nav-link text-center p-2" href="login">
                                <i class="fas fa-sign-in-alt"></i><span>Login</span>
                            </a>
                        </li>
                    </ul>
                </div>
            </c:if>
            <c:if test="${not empty usuarioLogeado}">
                <div class="dropdown d-flex flex-wrap">
                    <img alt="" src="${usuarioLogeado.getUrl_imagen()}" class="m-auto">
                    <a data-toggle="dropdown" class="nav-item nav-link dropdown-toggle user-action text-white "><span>
                            ${usuarioLogeado.getNombreUsuario()}
                        </span></a>
                    <div class="dropdown-menu dropdown-menu-right ">
                        <a href="perfil?usuarioNombre=${usuarioLogeado.getNombreUsuario() }"
                            class="dropdown-item text-secondary"><i class="fas fa-user-circle"></i> Perfil</a>
                        <a href="configuracion" class="dropdown-item text-secondary"><i class="fas fa-sliders-h"></i>
                            Configuracion</a>
                        <c:if test="${usuarioLogeado.getRol() == 'admin'}">
                            <a href="administrar" class="dropdown-item text-secondary"><i class="fas fa-trophy"></i>
                                Roles</a>
                        </c:if>
                        <a href="categoria" class="dropdown-item text-secondary"><i class="fas fa-gamepad"></i>
                            Categoria</a>
                        <div class="divider dropdown-divider"></div>
                        <a href="cerrarSesion" class="dropdown-item text-secondary"><i class="fas fa-power-off"></i>
                            Cerrar
                            sesi&oacute;n</a>
                    </div>

                </div>
            </c:if>
        </nav>
    </header>