package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Likee;
import ar.edu.unlam.tallerweb1.modelo.Publicacion;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

public interface RepositorioLike {

	Long guardarLike(Likee like);

	void borrarLike(Likee like);

	void borrarLikePorId(Long id);
	
	Likee obtenerLikePorId(Long id);

	Likee obtenerLikePorPublicacionYUsuario(Publicacion publicacion, Usuario usuario);

}
