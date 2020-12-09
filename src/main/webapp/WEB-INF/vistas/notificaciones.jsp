<%@ include file="header.jsp"%>
<main>
	<c:if test="${usuarioLogeado.getRol() != null}">
		<h1 class="text-center">Notificaciones</h1>
    <section>
    	<c:if test="${not empty notificaciones}">
    		<c:forEach items="${notificaciones}" var="notificacion">
    			<div class="col-12 col-md-8 p-3 m-1 bg-fondo rounded-pill">
                	<div class="d-flex flex-wrap justify-content-around">
                		<c:if test="${notificacion.getVisto() == false}">
                			<p class="text-center">A ${notificacion.getUsuarioOtorgadorNotifi().getNombreUsuario()} le ha gustado tu publicacion.</p>
    						<button type="button" class="btn btn-outline-naranja botonEditar"
                                value="${notificacion.getId()}" id="notificacionNoVista${notificacion.getId()}">
                                <i class="fas fa-eye"></i>
                        	</button>
                		</c:if>
                		<c:if test="${notificacion.getVisto() == true}">
                			<p class="text-center">${notificacion.getUsuarioOtorgadorNotifi().getNombreUsuario()} le ha gustado tu publicacion.</p>
                		</c:if>
    				</div>
    			</div>	
    		</c:forEach>
    	</c:if>
    	<c:if test="${empty notificaciones}">
    		<h3 class="text-secondary text-center">No tiene notificaciones.</h3>
    	</c:if>
    </section>
	</c:if>
    
    <c:if test="${usuarioLogeado.getRol() == 'null'}">
    	<section>
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
        </section>
    </c:if>
    
</main>
<%@ include file="footer.jsp"%>