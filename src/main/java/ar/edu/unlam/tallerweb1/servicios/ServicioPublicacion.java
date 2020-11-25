package ar.edu.unlam.tallerweb1.servicios;


import java.util.List;
import java.util.TreeSet;

import ar.edu.unlam.tallerweb1.modelo.Categoria;
import ar.edu.unlam.tallerweb1.modelo.Publicacion;

public interface ServicioPublicacion {

	Long guardarPublicacion(Publicacion publicacion);
	
	Publicacion obtenerPublicacion(Long id);
	
	void borrarPublicacion(Long id);
	void aumentarCantidadComentariosDePublicacion(Publicacion publicacion);
	void aumentarCantidadLikesDePublicacion(Publicacion publicacion);
	void disminuirCantidadLikesDePublicacion(Publicacion publicacion);
	void disminuirCantidadComentariosDePublicacion(Publicacion publicacion);
	
	List<Publicacion> buscarPublicacionesPorCategoria(Categoria categoria);
	List<Publicacion> buscarPublicaciones();
	
	TreeSet<Publicacion> devolverPublicacionesPorUsuariosSeguidos();
	TreeSet<Publicacion> devolverPublicacionesOrdenadasPor(String ordenPublicaciones);
	TreeSet<Publicacion> devolverPublicacionesOdenadasPorLikesYComentarios();
	TreeSet<Publicacion> ordenarUnaListaDePublicacionesPor(String ordenPublicaciones, List publicacionesList);
	TreeSet<Publicacion> ordenarUnaListaDePublicacionesPorPopular(List listaPublicaciones);
	TreeSet<Publicacion> devolverPublicacionesOdenadasPorFechaRecienteAAntigua();
	TreeSet<Publicacion> ordenarUnaListaDePublicacionesPorFechaRecienteAAntigua(List listaPublicaciones);
}
