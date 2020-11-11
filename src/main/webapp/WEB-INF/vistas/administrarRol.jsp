<%@ include file="header.jsp"%>
 <c:if test="${usuarioRol == 'admin'}">
<main>
    <section class="border-bottom mb-2">
        <h3>Administracion de roles</h3>
    </section>
    <section>
    	<div class="row">
    	<c:forEach items="${listaUsuarios}" var="usuario">
    		<div class="col-md-4">
    			<div class="card mb-4 borde-naranja">
    				<p class="text-light">Nombre: ${usuario.getNombre()}</p>
    				<p class="text-light">Nombre de usuario: ${usuario.getNombreUsuario()}</p>
    				<p class="text-light">Rol: ${usuario.getRol()}</p>
    				<form action="cambiarRol">
        				<select name="rolUsuario" id="rolUsuario">
        					<option value="usuario">usuario</option>
  							<option value="admin">admin</option>
        				</select>
        				<div class="text-center">
            				<button type="submit" class="btn btn-naranja mt-3 botonBloque"  
            				name="botonCambiarRol" id="botonCambiarRol" value="${usuario.getId()}">cambiar rol</button>
            			</div>
        			</form>
            	</div>
    		</div>
    	</c:forEach>
    	</div>
    </section>
</main>
</c:if>

<%@ include file="footer.jsp"%>