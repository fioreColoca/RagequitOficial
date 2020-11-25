<%@ include file="header.jsp"%>
<main>
    <c:set var="NombreUsuarioPerfil" value="${usuarioPerfil.getNombreUsuario()}"></c:set>
    <c:set var="NombreUsuarioLogeado" value="${usuarioLogeado.getNombreUsuario()}"></c:set>

    <c:if test="${NombreUsuarioPerfil  == NombreUsuarioLogeado }">
        <%@ include file="perfilLogeado.jsp"%>
    </c:if>
    <c:if test="${NombreUsuarioPerfil  != NombreUsuarioLogeado }">
        <%@ include file="perfilMostrado.jsp"%>
    </c:if>

</main>
<%@ include file="footer.jsp"%>