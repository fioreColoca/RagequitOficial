package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;
import java.util.TreeSet;

import javax.inject.Inject;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import ar.edu.unlam.tallerweb1.modelo.Comentario;
import ar.edu.unlam.tallerweb1.modelo.ComentarioEstado;
import ar.edu.unlam.tallerweb1.modelo.ComentarioOrdenadoPorLikes;
import ar.edu.unlam.tallerweb1.modelo.ComentarioTipo;
import ar.edu.unlam.tallerweb1.modelo.LikeComentario;
import ar.edu.unlam.tallerweb1.modelo.Publicacion;
import ar.edu.unlam.tallerweb1.modelo.PublicacionOrdenPorFecha;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioComentario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioLikeComentario;

@Service
@Transactional
public class ServicioComentarioImpl implements ServicioComentario{

	@Inject
	private RepositorioComentario repositorioComentar;
	@Inject
	ServicioPublicacion servicioPublicacion;
	@Inject
	private RepositorioLikeComentario repositorioLikeComentario;

	@Override
	public Long guardarComentario(Comentario comentario) {
		if(comentario.getRespuesta() == null) {
			servicioPublicacion.aumentarCantidadComentariosDePublicacion(comentario.getPublicacion());
			return repositorioComentar.enviarComentario(comentario);
		}
		servicioPublicacion.aumentarCantidadComentariosDePublicacion(comentario.getRespuesta().getPublicacion());
		return repositorioComentar.enviarComentario(comentario);
		
	}

	@Override
	public Comentario mostrarComentario(Long id) {
		return repositorioComentar.mostrarComentario(id);
	}

	@Override
	public void borrarComentario(Long id) {
			Comentario comentario = mostrarComentario(id);
			List <Comentario> respuesta = respuestaListado(comentario);
					
			
			if(comentario.getRespuesta() == null) {
				Publicacion publicacion = comentario.getPublicacion();
				servicioPublicacion.disminuirCantidadComentariosDePublicacion(publicacion);
			}else {
				Publicacion publicacion = comentario.getRespuesta().getPublicacion();
				servicioPublicacion.disminuirCantidadComentariosDePublicacion(publicacion);
			}
			
			if ((respuesta == null || respuesta.size() == 0) && comentario.getCantidadLikes() == 0) {
				repositorioComentar.borrarComentario(id);
			} else {
				comentario.setEstado(ComentarioEstado.INACTIVO);
			}
	}


	@Override
	public void tipoComentario(String boton, Comentario comentario) {
		switch (boton) {
		case "comun":
			comentario.setTipo(ComentarioTipo.COMUN);
			break;
		case "premium":
			comentario.setTipo(ComentarioTipo.SUSCRIPTOR);
			break;
		default:
			break;
		}
	}

	@Override
	public List<Comentario> devolverComentarioPorPublicacion(Publicacion publicacion) {
		return repositorioComentar.obtenerComentariosPorPublicacion(publicacion);
	}

	@Override
	public List<Comentario> devolverTodosLosComentariosyRespuestas() {
		return repositorioComentar.mostrarTodosLosComentarios();
	}

	@Override
	public List<Comentario> respuestaListado(Comentario comentario) {
		return repositorioComentar.respuestaListado(comentario);
	}

	@Override
	public Boolean verificarUsuario(Usuario usuarioLogueado, Usuario usuarioIngresado) {
		if (usuarioLogueado == usuarioIngresado) {
			return true;
		}
		return false;
	}

	@Override
	public void aumentarCantidadLikes(Comentario comentario) {
		Comentario like = repositorioComentar.mostrarComentario(comentario.getId());
		Integer cantidadLikes = like.getCantidadLikes() + 1;
		like.setCantidadLikes(cantidadLikes);		
	}

	@Override
	public void disminuirCantidadLikes(Comentario comentario) {
		Comentario like = repositorioComentar.mostrarComentario(comentario.getId());
		Integer cantidadLikes = like.getCantidadLikes() - 1;
		like.setCantidadLikes(cantidadLikes);		
	}

	@Override
	public TreeSet<Comentario> ordenarComentarioPorMasLikes(List<Comentario> comentario) {
		TreeSet comentarioTreeSet = new TreeSet(comentario);
		ComentarioOrdenadoPorLikes orden = new ComentarioOrdenadoPorLikes(); 
		TreeSet<Comentario> ordenarPorMasLikes = new TreeSet<Comentario>(orden); 
		ordenarPorMasLikes.addAll(comentarioTreeSet); 
		return ordenarPorMasLikes; 
	}

	@Override
	public TreeSet<Comentario> devolverListaComentarioPorMasLikes() {
		 List <Comentario> comentarios = this.devolverTodosLosComentariosyRespuestas();
		 ComentarioOrdenadoPorLikes orden = new ComentarioOrdenadoPorLikes(); 
		 TreeSet<Comentario> comentarioOrdenadoPorLikes = new TreeSet<Comentario>(orden); 
		 comentarioOrdenadoPorLikes.addAll(comentarios); 
		 return comentarioOrdenadoPorLikes; 
	}

	@Override
	public List<Comentario> devolverSoloComentario() {
		List <Comentario> comentarioYrespuesta = devolverTodosLosComentariosyRespuestas();
		List <Comentario> soloComentario = null ;
		
		for (Comentario comentario : comentarioYrespuesta ) {
			if(comentario.getRespuesta() == null) {
				soloComentario.add(comentario);
			}
		}
		
		return soloComentario;
		
	}

	/*
	 * @Override public Integer devolverAnio(Comentario comentario) { Integer anio =
	 * ((Integer) comentario.getFechaHora().getYear()) + 1900; return anio; }
	 */
	
	

}
