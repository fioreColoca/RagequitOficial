package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Likee;
import ar.edu.unlam.tallerweb1.modelo.Publicacion;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

public interface ServicioLike {
	Long guardarLike(Likee like);
	
	void borrarLikePorId(Long id);
	
	void borrarLike(Likee like);

	void darLikeAPublicacion(Publicacion publicacion, Usuario usuario);
	
	Likee obtenerLikePorId(Long id);
	
}
