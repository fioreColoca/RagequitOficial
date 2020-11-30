package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.LikePublicacion;
import ar.edu.unlam.tallerweb1.modelo.Publicacion;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

public interface ServicioLikePublicacion {
	Long guardarLike(LikePublicacion like);
	
	void borrarLikePorId(Long id);
	
	void borrarLike(LikePublicacion like);

	void darLikeAPublicacion(Publicacion publicacion, Usuario usuario);
	
	LikePublicacion obtenerLikePorId(Long id);
	
}
