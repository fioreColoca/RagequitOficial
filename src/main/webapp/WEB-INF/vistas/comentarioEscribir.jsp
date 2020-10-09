<%@ include file="header.jsp"%>


<div class="container">
	<form action="verComentario" class="container">
	
		<div class="aling-center"><label for="comentarioMandar"><p > Escribe tu comentario </p></label></div>
        <div><textarea   id="comentarioMandar" name="comentarioMandar" class="form-control" rows="3" placeholder="comentar"></textarea></div>
        <div><button type="submit" >Responder</button></div>
	</form>
	
</div>	
	
<%@ include file="footer.jsp"%>