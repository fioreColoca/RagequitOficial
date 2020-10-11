package ar.edu.unlam.tallerweb1.servicios;

import java.util.Date;
import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Publicacion;

public interface ServicioPublicacion {

	Long guardarPublicacion(Publicacion publicacion);
	List<Publicacion> buscarPublicacionesPorCategoria(String categoria);

}
