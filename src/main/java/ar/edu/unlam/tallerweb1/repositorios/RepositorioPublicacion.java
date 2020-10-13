package ar.edu.unlam.tallerweb1.repositorios;

import java.util.Date;
import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Publicacion;

public interface RepositorioPublicacion {

	Long guardarPublicacion(Publicacion publicacion);

	List<Publicacion> buscarPublicacionesPorCategoria(String categoria);

	List<Publicacion> buscarPublicaciones();
	
	Publicacion obtenerPublicacion(Long id);

	void borrarPublicacion(Long id);


}
