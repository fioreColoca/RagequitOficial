package ar.edu.unlam.tallerweb1.servicios;


import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Publicacion;

public interface ServicioPublicacion {

	Long guardarPublicacion(Publicacion publicacion)throws Exception;
	List<Publicacion> buscarPublicacionesPorCategoria(String categoria);
	List<Publicacion> buscarPublicaciones();
	Publicacion obtenerPublicacion(Long id);
	void borrarPublicacion(Long id);

}
