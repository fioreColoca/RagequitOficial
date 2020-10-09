<%@ include file="header.jsp"%>
<main>


	<div class="p-3 mb-2 bg-white text-dark">
	<p>Mensaje: ${comentario.getMensaje()}</p>
	 <small>${comentario.getFechaHora()}</small>
	</div>
	<form action="meGustaComentario">
	<button type="submit" >Like</button>
	</form> <!--  Esto tiene pìnta de hacerse de una manera mas limpia -->
	
	
	<p>Likes: ${comentario.getCantidadLikes()}</p>
	<button type="submit" >Responder</button>
	
	
	<form action="borrarComentario">
	<button type="submit" >Borrar</button>
	</form> <!--  Esto tiene pìnta de hacerse de una manera mas limpia -->
	
</main>	
<%@ include file="footer.jsp"%>