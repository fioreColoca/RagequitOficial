package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.LikePublicacion;
import ar.edu.unlam.tallerweb1.modelo.Publicacion;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

public interface ServicioLikePublicacion {
	Long guardarLikePublicacion(LikePublicacion like);

	void borrarLikePublicacionPorId(Long id);

	void borrarLikePublicacion(LikePublicacion like);

	void darLikeAPublicacion(Publicacion publicacion, Usuario usuario);

	LikePublicacion obtenerLikePublicacionPorId(Long id);

}
