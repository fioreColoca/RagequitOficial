package ar.edu.unlam.tallerweb1.servicios;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.modelo.Categoria;
import ar.edu.unlam.tallerweb1.modelo.Comentario;
import ar.edu.unlam.tallerweb1.modelo.Publicacion;
import ar.edu.unlam.tallerweb1.modelo.PublicacionEstado;
import ar.edu.unlam.tallerweb1.modelo.PublicacionOrdenPorFecha;
import ar.edu.unlam.tallerweb1.modelo.PublicacionOrdenPorLikeYComentario;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioComentario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioPublicacion;

@Service
@Transactional
public class ServicioPublicacionImpl implements ServicioPublicacion {

	@Inject
	private RepositorioPublicacion repositorioPublicacion;
	@Inject
	private RepositorioComentario repositorioComentario;
	@Inject
	private ServicioSeguir servicioSeguir;
	@Inject
	private ServicioUsuario servicioUsuario;

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
	
	@Override
	public TreeSet<Publicacion> devolverPublicacionesOdenadasPorFechaRecienteAAntigua() { 

		List <Publicacion> publicaciones = this.buscarPublicaciones();

		PublicacionOrdenPorFecha ordenFechaRecienteAAntigua = new PublicacionOrdenPorFecha(); 

		TreeSet<Publicacion> ordenadoPorFechaRecienteAAntigua = new TreeSet<Publicacion>(ordenFechaRecienteAAntigua); 

		ordenadoPorFechaRecienteAAntigua.addAll(publicaciones); 

		return ordenadoPorFechaRecienteAAntigua; 

		} 
	
	@Override
	public TreeSet<Publicacion> devolverPublicacionesOdenadasPorLikesYComentarios() { 

		List <Publicacion> publicaciones = this.buscarPublicaciones();

		PublicacionOrdenPorLikeYComentario ordenPorLikesYComentarios = new PublicacionOrdenPorLikeYComentario(); 

		TreeSet<Publicacion> ordenadoPorLikesYComentarios = new TreeSet<Publicacion>(ordenPorLikesYComentarios); 

		ordenadoPorLikesYComentarios.addAll(publicaciones); 

		return ordenadoPorLikesYComentarios; 

		} 
	
	@Override
	public TreeSet<Publicacion> ordenarUnaListaDePublicacionesPorFechaRecienteAAntigua(List listaPublicaciones) { 

		PublicacionOrdenPorFecha ordenFechaRecienteAAntigua = new PublicacionOrdenPorFecha(); 

		TreeSet<Publicacion> ordenadoPorFechaRecienteAAntigua = new TreeSet<Publicacion>(ordenFechaRecienteAAntigua); 

		ordenadoPorFechaRecienteAAntigua.addAll(listaPublicaciones); 

		return ordenadoPorFechaRecienteAAntigua; 

		}
	
	@Override
	public TreeSet<Publicacion> ordenarUnaListaDePublicacionesPorPopular(List listaPublicaciones) { 

		PublicacionOrdenPorLikeYComentario ordenPorLikesYComentarios = new PublicacionOrdenPorLikeYComentario(); 

		TreeSet<Publicacion> ordenadoPorLikesYComentarios = new TreeSet<Publicacion>(ordenPorLikesYComentarios);

		ordenadoPorLikesYComentarios.addAll(listaPublicaciones); 

		return ordenadoPorLikesYComentarios; 

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

	@Override
	public TreeSet<Publicacion> devolverPublicacionesOrdenadasPor(
			String ordenPublicaciones,
			Usuario usuario) {
		TreeSet<Publicacion> listaPublicacionesOrdenadas = null;
		switch(ordenPublicaciones) {
		case "popular":
			listaPublicacionesOrdenadas = devolverPublicacionesOdenadasPorLikesYComentarios();
			break;
		case "seguidos":
			List<Publicacion> listaPublicacionesPorUsuariosSeguidos = devolverPublicacionesPorUsuariosSeguidos(usuario);
			listaPublicacionesOrdenadas = ordenarUnaListaDePublicacionesPorFechaRecienteAAntigua(listaPublicacionesPorUsuariosSeguidos);
			break;
		default:
			listaPublicacionesOrdenadas = devolverPublicacionesOdenadasPorFechaRecienteAAntigua();
		}
		return listaPublicacionesOrdenadas;
	}

	@Override
	public TreeSet<Publicacion> ordenarUnaListaDePublicacionesPor(
			String ordenPublicaciones, List publicacionesList,
			Usuario usuario
			) {
		TreeSet<Publicacion> listaPublicacionesOrdenadas = null;
		switch(ordenPublicaciones) {
		case "popular":
			listaPublicacionesOrdenadas = ordenarUnaListaDePublicacionesPorPopular(publicacionesList);
			break;
		case "seguidos":
			List<Publicacion> listaPublicacionesPorUsuariosSeguidos = devolverUnaListaDePublicacionesPorUsuariosSeguidos(publicacionesList,usuario);
			listaPublicacionesOrdenadas = ordenarUnaListaDePublicacionesPorFechaRecienteAAntigua(listaPublicacionesPorUsuariosSeguidos);
			break;
		default:
			listaPublicacionesOrdenadas = devolverPublicacionesOdenadasPorFechaRecienteAAntigua();
		}
		return listaPublicacionesOrdenadas;
	}

	@Override
	public List<Publicacion> devolverPublicacionesPorUsuariosSeguidos(Usuario usuario) {
		List<Publicacion> publicaciones =buscarPublicaciones();
		List <Usuario> usuariosSeguidos = servicioSeguir.devolverListaDeSeguidos(usuario);
		List<Publicacion> publicacionesUsuariosSeguidos= new ArrayList<>();
		for (Publicacion publicacion : publicaciones) {
			Usuario usuarioDeLaPublicacion = publicacion.getUsuario();
			if(usuariosSeguidos.contains(usuarioDeLaPublicacion)) {
				publicacionesUsuariosSeguidos.add(publicacion);
			}
		}
		return publicacionesUsuariosSeguidos;
	}
	
	@Override
	public List<Publicacion> devolverUnaListaDePublicacionesPorUsuariosSeguidos(List publicaciones,Usuario usuario) {
		List <Publicacion> publicacionesLista = publicaciones;
		List <Usuario> usuariosSeguidos = servicioSeguir.devolverListaDeSeguidos(usuario);
		List<Publicacion> publicacionesUsuariosSeguidos= new ArrayList<>();
		for (Publicacion publicacion : publicacionesLista) {
			Long usuarioId = publicacion.getUsuario().getId();
			Usuario usuarioDeLaPublicacion = servicioUsuario.obtenerUsuarioPorId(usuarioId);
			if(usuariosSeguidos.contains(usuarioDeLaPublicacion)) {
				publicacionesUsuariosSeguidos.add(publicacion);
			}
		}
		return publicacionesUsuariosSeguidos;
	}

}
