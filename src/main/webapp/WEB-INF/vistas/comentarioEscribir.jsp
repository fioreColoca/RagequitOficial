<%@ include file="header.jsp"%>

<main>
<div class="container p-3 colorCeleste">
	<form:form action="verComentario" class="container" modelAttribute="comentario">	
		<div class="aling-center"><label for="comentarioMandar"><p > Respondiendo a  </p></label></div>
        <div><textarea path=" " id="comentarioMandar" name="comentarioMandar" class="form-control" rows="3" placeholder="Escribe tu respuesta"></textarea></div>
        
        <br>
        <div class="row">
        	<div class="col-md-3 col-lg-2 mt-2"><button type="submit" class="btn btn-warning" value="comun" name="boton" >Responder</button></div>
        	<div class="col-md-5 col-lg-4 mt-2"><button type="submit" class="btn btn-warning" value="premium" name="boton" >Responder Premium</button></div>
        </div> <!--  TENDRA SENTIDO DSP -->
	</form:form>
	
	<c:set var="error" value="${error}"></c:set>
	
	<c:if test="${error!=null}">
		<div>
			<p> ${error}</p>
		</div>
	
	</c:if>
</div>	
</main>
	
	<!-- LO PUSE X AHORA ACA PARA NO JER CODIGO CSSS -->
	<style> 
	.colorCeleste{background: #287EB0;}
	</style>
	
<%@ include file="footer.jsp"%>