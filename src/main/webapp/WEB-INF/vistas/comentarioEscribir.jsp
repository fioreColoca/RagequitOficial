<%@ include file="header.jsp"%>

<main>
<div class="container">
	<form action="verComentario" class="container">
	
		<div class="aling-center"><label for="comentarioMandar"><p > Escribe tu comentario </p></label></div>
        <div><textarea   id="comentarioMandar" name="comentarioMandar" class="form-control" rows="3" placeholder="comentar"></textarea></div>
        <div><button type="submit" class="btn btn-warning" >Responder</button></div>
	</form>
	
</div>	
</main>
	
<%@ include file="footer.jsp"%>