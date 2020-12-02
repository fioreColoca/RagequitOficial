<%@ include file="header.jsp"%>
<main>
    <h1 class="text-center">Notificaciones</h1>
    <section>
    	<c:if test="${not empty notificaciones}">
    		<c:forEach items="${notificaciones}" var="notificacion">
    			<p class="text-center">${notificacion.getUsuarioOtorgadorNotifi().getNombreUsuario()} le ha gustado tu publicacion.</p>
    		</c:forEach>
    	</c:if>
    	<c:if test="${empty notificaciones}">
    		<h3 class="text-secondary text-center">No tiene notificaciones.</h3>
    	</c:if>
    </section>
    <section>
    	<c:if test="${usuarioLogeado.getRol() != 'admin'}">
        	<div id="notfound" style="margin: -1em">
            	<div class="notfound">
                	<div class="notfound-404">
                    	<h1>
                        	4<span>0</span>4
                    	</h1>
                	</div>
                	<p>Es posible que la página que está buscando se haya eliminado,
                    	no está disponible temporalmente o no tienes acceso a ella.</p>
                	<a href=" home" class="btn btn-outline-naranja">Ir al inicio</a>
            	</div>
        	</div>
    	</c:if>
    </section>
</main>
<%@ include file="footer.jsp"%>