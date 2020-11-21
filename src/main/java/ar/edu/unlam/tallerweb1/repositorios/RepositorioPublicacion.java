package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Categoria;
import ar.edu.unlam.tallerweb1.modelo.Publicacion;

public interface RepositorioPublicacion {

	Long guardarPublicacion(Publicacion publicacion);

	List<Publicacion> buscarPublicacionesPorCategoria(Categoria categoria);

	List<Publicacion> buscarPublicaciones();
	
	Publicacion obtenerPublicacionPorId(Long id);

	void borrarPublicacion(Long id);


}
