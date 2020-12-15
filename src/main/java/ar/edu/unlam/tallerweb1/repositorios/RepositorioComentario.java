package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Comentario;
import ar.edu.unlam.tallerweb1.modelo.Publicacion;

public interface RepositorioComentario {

	Long enviarComentario(Comentario comentario);

	Comentario mostrarComentario(Long id);

	void borrarComentario(Long id);

	List<Comentario> obtenerComentariosPorPublicacion(Publicacion publicacion);

	List<Comentario> mostrarTodosLosComentarios();

	List<Comentario> respuestaListado(Comentario comentario);

}
