package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Comentario;
import ar.edu.unlam.tallerweb1.modelo.LikeComentario;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

public interface RepositorioLikeComentario {

	Long guardar(LikeComentario like);

	void borrar(LikeComentario like);
	
	LikeComentario obtenerLikePorId(Long id);

	LikeComentario obtenerLikePorComentarioYUsuario(Comentario comentario, Usuario usuario);
	
	List <Usuario> obtenerListaLikes();

}
