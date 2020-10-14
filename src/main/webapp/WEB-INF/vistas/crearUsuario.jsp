<%@ include file="header.jsp"%>
        <main style="background: linear-gradient(#04233b, #f4a117);">
        <form action="mostrarUsuario">
            <label for="nombre">Nombre</label>
            <input type="text" name="nombre" id="nombre">
            <br>
            <label for="apellido">Apellido</label>
            <input type="text" name="apellido" id="apellido">
            <br>
            <label for="email">Email:</label>
            <input type="email" id="email" name="email">
            <br>
            <input type="submit" >

        </form>
        </main>
<%@ include file="footer.jsp"%>