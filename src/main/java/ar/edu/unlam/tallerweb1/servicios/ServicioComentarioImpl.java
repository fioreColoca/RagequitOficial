package ar.edu.unlam.tallerweb1.servicios;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import javax.inject.Inject;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import ar.edu.unlam.tallerweb1.modelo.Comentario;
import ar.edu.unlam.tallerweb1.modelo.ComentarioEstado;
import ar.edu.unlam.tallerweb1.modelo.ComentarioOrdenadoPorLikes;
import ar.edu.unlam.tallerweb1.modelo.LikeComentario;
import ar.edu.unlam.tallerweb1.modelo.Notificacion;
import ar.edu.unlam.tallerweb1.modelo.NotificacionTipo;
import ar.edu.unlam.tallerweb1.modelo.Publicacion;
import ar.edu.unlam.tallerweb1.modelo.PublicacionOrdenPorFechaDescendente;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioComentario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioComentarioImpl;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioLikeComentario;

@Service
@Transactional
public class ServicioComentarioImpl implements ServicioComentario {

	@Inject
	private RepositorioComentario repositorioComentar;
	@Inject
	ServicioPublicacion servicioPublicacion;
	@Inject
	private RepositorioLikeComentario repositorioLikeComentario;
	@Inject
	ServicioUsuario servicioUsuario;
	@Inject
	ServicioNotificacion servicioNotificacion;

	@Override
	public Long guardarComentario(Comentario comentario) {
		if (comentario.getRespuesta() == null) {
			servicioPublicacion.aumentarCantidadComentariosDePublicacion(comentario.getPublicacion());
			return repositorioComentar.enviarComentario(comentario);
		}
		servicioPublicacion.aumentarCantidadComentariosDePublicacion(comentario.getRespuesta().getPublicacion());
		aumentarCantidadRespuestas(comentario.getRespuesta());
		return repositorioComentar.enviarComentario(comentario);

	}

	@Override
	public Comentario mostrarComentario(Long id) {
		return repositorioComentar.mostrarComentario(id);
	}

	@Override
	public void borrarComentario(Long id) {
		Comentario comentario = mostrarComentario(id);
		List<Comentario> respuesta = respuestaListado(comentario);
		List<Notificacion> notificaciones = servicioNotificacion
				.obtenerListaDeNotificacionPorTipo(NotificacionTipo.COMENTARIOPUBLICACION);
		List<Notificacion> notificacionesRespuesta = servicioNotificacion
				.obtenerListaDeNotificacionPorTipo(NotificacionTipo.COMENTARIOCOMENTARIO);

		if (comentario.getRespuesta() == null) {
			Publicacion publicacion = comentario.getPublicacion();
			servicioPublicacion.disminuirCantidadComentariosDePublicacion(publicacion);
		} else {
			Publicacion publicacion = comentario.getRespuesta().getPublicacion();
			disminuirCantidadRespuestas(comentario.getRespuesta());
			servicioPublicacion.disminuirCantidadComentariosDePublicacion(publicacion);
		}

		if (comentario.getRespuesta() == null) {

			for (Notificacion notificacion : notificaciones) {
				if (notificacion.getComentario().getId() == id) {
					if (notificacion.getVisto() == false) {
						servicioUsuario
								.disminuirCantidadNotificacionesDeUsuario(notificacion.getUsuarioRecibidorNotifi());
						servicioNotificacion.borrarNotificacionPorId(notificacion.getId());
						comentario.setEstado(ComentarioEstado.INACTIVO);
						break;
					} else {
						comentario.setEstado(ComentarioEstado.INACTIVO);
						break;
					}
				}
			}
		} else {
			for (Notificacion notificacionRespuesta : notificacionesRespuesta) {
				if (notificacionRespuesta.getComentario().getId() == id) {
					if (notificacionRespuesta.getVisto() == false) {
						servicioUsuario.disminuirCantidadNotificacionesDeUsuario(
								notificacionRespuesta.getUsuarioRecibidorNotifi());
						servicioNotificacion.borrarNotificacionPorId(notificacionRespuesta.getId());
						comentario.setEstado(ComentarioEstado.INACTIVO);
						break;
					} else {
						comentario.setEstado(ComentarioEstado.INACTIVO);
						break;
					}
				}
			}

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
	public TreeSet<Comentario> devolverListaComentarioPorMasLikes() {
		List<Comentario> comentarios = this.devolverSoloComentario();
		ComentarioOrdenadoPorLikes orden = new ComentarioOrdenadoPorLikes();
		TreeSet<Comentario> comentarioOrdenadoPorLikes = new TreeSet<Comentario>(orden);
		comentarioOrdenadoPorLikes.addAll(comentarios);
		return comentarioOrdenadoPorLikes;
	}

	@Override
	public List<Comentario> devolverSoloComentario() {
		List<Comentario> comentarioYrespuesta = devolverTodosLosComentariosyRespuestas();
		List<Comentario> nuevaLista = new ArrayList();
		for (Comentario comentario : comentarioYrespuesta) {
			if (comentario.getRespuesta() == null) {
				nuevaLista.add(comentario);
			}
		}
		return nuevaLista;
	}

	@Override
	public List<Comentario> devolverSoloRespuesta() {
		List<Comentario> comentarioYrespuesta = devolverTodosLosComentariosyRespuestas();
		List<Comentario> nuevaLista = new ArrayList();
		for (Comentario comentario : comentarioYrespuesta) {
			if (comentario.getRespuesta() != null) {
				nuevaLista.add(comentario);
			}
		}
		return nuevaLista;
	}

	@Override
	public TreeSet<Comentario> devolverListaRespuestaPorMasLikes() {
		List<Comentario> comentarios = this.devolverSoloRespuesta();
		ComentarioOrdenadoPorLikes orden = new ComentarioOrdenadoPorLikes();
		TreeSet<Comentario> comentarioOrdenadoPorLikes = new TreeSet<Comentario>(orden);
		comentarioOrdenadoPorLikes.addAll(comentarios);
		return comentarioOrdenadoPorLikes;
	}

	@Override
	public void disminuirCantidadRespuestas(Comentario comentario) {
		Comentario comentarioDisminuirRespuesta = repositorioComentar.mostrarComentario(comentario.getId());
		Integer cantidadRespuesta = comentarioDisminuirRespuesta.getCantidadRespuesta() - 1;
		comentarioDisminuirRespuesta.setCantidadRespuesta(cantidadRespuesta);
	}

	@Override
	public void aumentarCantidadRespuestas(Comentario comentario) {
		Comentario comentarioAumentarRespuesta = repositorioComentar.mostrarComentario(comentario.getId());
		Integer cantidadRespuesta = comentarioAumentarRespuesta.getCantidadRespuesta() + 1;
		comentarioAumentarRespuesta.setCantidadRespuesta(cantidadRespuesta);
	}

}
