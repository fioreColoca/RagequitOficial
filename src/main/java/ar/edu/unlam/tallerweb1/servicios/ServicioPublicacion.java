package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;
import java.util.TreeSet;

import ar.edu.unlam.tallerweb1.modelo.Categoria;
import ar.edu.unlam.tallerweb1.modelo.Publicacion;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

public interface ServicioPublicacion {

	Long guardarPublicacion(Publicacion publicacion);

	Publicacion obtenerPublicacionPorId(Long id);

	void borrarPublicacion(Long id);

	void aumentarCantidadComentariosDePublicacion(Publicacion publicacion);

	void aumentarCantidadLikesDePublicacion(Publicacion publicacion);

	void disminuirCantidadLikesDePublicacion(Publicacion publicacion);

	void disminuirCantidadComentariosDePublicacion(Publicacion publicacion);

	List<Publicacion> buscarPublicacionesPorCategoria(Categoria categoria);

	List<Publicacion> buscarPublicaciones();

	List<Publicacion> devolverPublicacionesPorUsuariosSeguidos(Usuario usuario);

	List<Publicacion> devolverUnaListaDePublicacionesPorUsuariosSeguidos(List publicaciones, Usuario usuario);

	List<Publicacion> devolverPublicacionesPorCategoriasSeguidas(Usuario usuario);

	List<Publicacion> devolverUnaListaDePublicacionesPorCategoriasSegidas(List publicacionesList, Usuario usuario);

	List<Publicacion> devolverUnaListaDePublicacionesHechasPorUnUsuario(Usuario usuario);

	TreeSet<Publicacion> devolverPublicacionesOrdenadasPor(String ordenPublicaciones, Usuario usuario);

	TreeSet<Publicacion> devolverPublicacionesOdenadasPorLikesYComentarios();

	TreeSet<Publicacion> ordenarUnaListaDePublicacionesPor(String ordenPublicaciones, List publicacionesList,
			Usuario usuario);

	TreeSet<Publicacion> devolverYOrdenarUnaListaDePublicacionesPorPopular(List listaPublicaciones);

	TreeSet<Publicacion> devolverPublicacionesOdenadasPorFechaRecienteAAntigua();

	TreeSet<Publicacion> devolverYOrdenarUnaListaDePublicacionesPorFechaRecienteAAntigua(List listaPublicaciones);
}
