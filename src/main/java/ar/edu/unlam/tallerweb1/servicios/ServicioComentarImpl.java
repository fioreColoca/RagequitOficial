package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import javax.inject.Inject;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import ar.edu.unlam.tallerweb1.modelo.Comentario;
import ar.edu.unlam.tallerweb1.modelo.ComentarioEstado;
import ar.edu.unlam.tallerweb1.modelo.ComentarioTipo;
import ar.edu.unlam.tallerweb1.modelo.Publicacion;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioComentario;

@Service
@Transactional
public class ServicioComentarImpl implements ServicioComentar{

	@Inject
	private RepositorioComentario repositorioComentar;
	@Inject ServicioPublicacion servicioPublicacion;

	@Override
	public Long enviarComentario(Comentario comentario) {
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
			List <Comentario> resultado = respuestaListado(comentario);
			
			if(comentario.getRespuesta() == null) {
				Publicacion publicacion = comentario.getPublicacion();
				servicioPublicacion.disminuirCantidadComentariosDePublicacion(publicacion);
			}else {
				Publicacion publicacion = comentario.getRespuesta().getPublicacion();
				servicioPublicacion.disminuirCantidadComentariosDePublicacion(publicacion);
			}
			
			if (resultado == null || resultado.size() == 0) {
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
	public List<Comentario> mostrarComentarioPorPublicacion(Publicacion publicacion) {
		return repositorioComentar.obtenerComentariosPorPublicacion(publicacion);
	}

	@Override
	public List<Comentario> mostrarTodosLosComentarios() {
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

	/*
	 * @Override public Integer devolverAnio(Comentario comentario) { Integer anio =
	 * ((Integer) comentario.getFechaHora().getYear()) + 1900; return anio; }
	 */
	
	

}
