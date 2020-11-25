<%@ include file="header.jsp"%>
<main>
    <div>
        <img class="imagenBiblioteca text-center borde-naranja" src="${juegosOVarios.getUrlImagen()}">
        <h2>${juegosOVarios.getNombre()}</h2>
        <p>${juegosOVarios.getDescripcion()}</p>
    </div>

</main>
<%@ include file="footer.jsp"%>