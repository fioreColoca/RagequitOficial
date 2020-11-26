package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.LikePublicacion;
import ar.edu.unlam.tallerweb1.modelo.Publicacion;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

public interface RepositorioLikePublicacion {

	Long guardarLike(LikePublicacion like);

	void borrarLike(LikePublicacion like);

	void borrarLikePorId(Long id);
	
	LikePublicacion obtenerLikePorId(Long id);

	LikePublicacion obtenerLikePorPublicacionYUsuario(Publicacion publicacion, Usuario usuario);

}
