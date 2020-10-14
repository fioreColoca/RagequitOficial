package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Comentario;

public interface RepositorioComentario {
	
	 Long enviarComentario(Comentario comentario);

	 Comentario mostrarComentario(Long id);

	 void borrarComentario(Long id);
	 
	 List<Comentario> verListaComentarios();

	 List<Comentario> mostrarComentarioPorPublicacion(Long idPublicacion); 
	
}
