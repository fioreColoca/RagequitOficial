package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Comentario;
import ar.edu.unlam.tallerweb1.modelo.LikeComentario;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

public interface ServicioLikeComentario {

	public Long guardarLike(LikeComentario like);

	public void darLikeAComentario(Comentario comentario, Usuario usuario);

	public void borrarLike(LikeComentario like);

	public LikeComentario obtenerLikePorId(Long id);

	List<Usuario> obtenerListaUsuariosLikeComentario();

}