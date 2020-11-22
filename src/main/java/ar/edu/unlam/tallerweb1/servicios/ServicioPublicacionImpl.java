package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;
import java.util.TreeSet;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.modelo.Categoria;
import ar.edu.unlam.tallerweb1.modelo.Comentario;
import ar.edu.unlam.tallerweb1.modelo.Publicacion;
import ar.edu.unlam.tallerweb1.modelo.PublicacionEstado;
import ar.edu.unlam.tallerweb1.modelo.PublicacionOrdenPorFecha;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioComentario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioPublicacion;

@Service
@Transactional
public class ServicioPublicacionImpl implements ServicioPublicacion {

	@Inject
	private RepositorioPublicacion repositorioPublicacion;
	@Inject
	private RepositorioComentario repositorioComentario;

	@Override
	public Long guardarPublicacion(Publicacion publicacion){
		
		return repositorioPublicacion.guardarPublicacion(publicacion);
	}

	@Override
	public List<Publicacion> buscarPublicacionesPorCategoria(Categoria categoria) {
		return repositorioPublicacion.buscarPublicacionesPorCategoria(categoria);
	}

	@Override
	public List<Publicacion> buscarPublicaciones() {
		return repositorioPublicacion.buscarPublicaciones();
	}
	
	@Override
	public Publicacion obtenerPublicacion(Long id) {
		
		return repositorioPublicacion.obtenerPublicacionPorId(id);
	}

	@Override
	public void borrarPublicacion(Long id) {
		Publicacion publicacionABorrar = repositorioPublicacion.obtenerPublicacionPorId(id);

		List<Comentario> comentariosEnPublicacionABorrar = repositorioComentario.obtenerComentariosPorPublicacion(publicacionABorrar);
		
		if(comentariosEnPublicacionABorrar != null) {
			publicacionABorrar.setEstado(PublicacionEstado.INACTIVO);
		}else {
			repositorioPublicacion.borrarPublicacion(id);
		}
		
	}
	
	public TreeSet<Publicacion> devolverPublicacionesOdenadasPorFechaRecienteAAntigua() { 

		 List <Publicacion> publicaciones = this.buscarPublicaciones();

		PublicacionOrdenPorFecha ordenFechaRecienteAAntigua = new PublicacionOrdenPorFecha(); 

		TreeSet<Publicacion> ordenadoPorFechaRecienteAAntigua = new TreeSet<Publicacion>(ordenFechaRecienteAAntigua); 

		ordenadoPorFechaRecienteAAntigua.addAll(publicaciones); 

		return ordenadoPorFechaRecienteAAntigua; 

		} 
	
	
	public TreeSet<Publicacion> ordenarUnaListaDePublicacionesPorFechaRecienteAAntigua(List listaPublicaciones) { 
		
		TreeSet publicacionesTreeSet = new TreeSet(listaPublicaciones);

		PublicacionOrdenPorFecha ordenFechaRecienteAAntigua = new PublicacionOrdenPorFecha(); 

		TreeSet<Publicacion> ordenadoPorFechaRecienteAAntigua = new TreeSet<Publicacion>(ordenFechaRecienteAAntigua); 

		ordenadoPorFechaRecienteAAntigua.addAll(publicacionesTreeSet); 

		return ordenadoPorFechaRecienteAAntigua; 

		}

	@Override
	public void aumentarCantidadComentariosDePublicacion(Publicacion publicacion) {
		Publicacion publicacionAAumentarComentarios = repositorioPublicacion.obtenerPublicacionPorId(publicacion.getId());
		Integer cantidadComentarios = publicacionAAumentarComentarios.getCantidadComentarios() + 1;
		
		publicacionAAumentarComentarios.setCantidadComentarios(cantidadComentarios);
		
	}

	@Override
	public void aumentarCantidadLikesDePublicacion(Publicacion publicacion) {
		Publicacion publicacionAAumentarLikes = repositorioPublicacion.obtenerPublicacionPorId(publicacion.getId());
		Integer cantidadLikes = publicacionAAumentarLikes.getCantidadLikes() + 1;
		
		publicacionAAumentarLikes.setCantidadLikes(cantidadLikes);
	}

	@Override
	public void disminuirCantidadLikesDePublicacion(Publicacion publicacion) {
		Publicacion publicacionADisminuirLikes = repositorioPublicacion.obtenerPublicacionPorId(publicacion.getId());
		Integer cantidadLikes = publicacionADisminuirLikes.getCantidadLikes() - 1;
		
		publicacionADisminuirLikes.setCantidadLikes(cantidadLikes);
		
	}

	@Override
	public void disminuirCantidadComentariosDePublicacion(Publicacion publicacion) {
		Publicacion publicacionADisminuirComentarios = repositorioPublicacion.obtenerPublicacionPorId(publicacion.getId());
		Integer cantidadComentarios = publicacionADisminuirComentarios.getCantidadComentarios() - 1;
		
		publicacionADisminuirComentarios.setCantidadComentarios(cantidadComentarios);
		
	}

}
