package ar.edu.unlam.tallerweb1.servicios;


import java.util.List;
import java.util.TreeSet;

import ar.edu.unlam.tallerweb1.modelo.Categoria;
import ar.edu.unlam.tallerweb1.modelo.Publicacion;

public interface ServicioPublicacion {

	Long guardarPublicacion(Publicacion publicacion);
	List<Publicacion> buscarPublicacionesPorCategoria(Categoria categoria);
	List<Publicacion> buscarPublicaciones();
	TreeSet<Publicacion> devolverPublicacionesOdenadasPorFechaRecienteAAntigua();
	Publicacion obtenerPublicacion(Long id);
	void borrarPublicacion(Long id);
}
