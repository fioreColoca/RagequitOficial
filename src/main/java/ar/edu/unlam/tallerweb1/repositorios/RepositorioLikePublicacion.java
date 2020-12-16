package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.LikePublicacion;
import ar.edu.unlam.tallerweb1.modelo.Publicacion;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

public interface RepositorioLikePublicacion {

	Long guardarLikePublicacion(LikePublicacion like);

	void borrarLikePublicacion(LikePublicacion like);

	void borrarLikePublicacionPorId(Long id);

	LikePublicacion obtenerLikePublicacionPorId(Long id);

	LikePublicacion obtenerLikePublicacionPorPublicacionYUsuario(Publicacion publicacion, Usuario usuario);

}
