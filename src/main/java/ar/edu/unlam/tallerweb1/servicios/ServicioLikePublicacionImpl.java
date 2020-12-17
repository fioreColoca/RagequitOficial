package ar.edu.unlam.tallerweb1.servicios;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.modelo.LikePublicacion;
import ar.edu.unlam.tallerweb1.modelo.Notificacion;
import ar.edu.unlam.tallerweb1.modelo.NotificacionTipo;
import ar.edu.unlam.tallerweb1.modelo.Publicacion;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioLikePublicacion;

@Service
@Transactional
public class ServicioLikePublicacionImpl implements ServicioLikePublicacion {

	@Inject
	private RepositorioLikePublicacion repositorioLike;
	@Inject
	private ServicioUsuario servicioUsuario;
	@Inject
	private ServicioPublicacion servicioPublicacion;
	@Inject
	private ServicioNotificacion servicioNotificacionLikePublicacion;

	@Override
	public Long guardarLikePublicacion(LikePublicacion like) {

		return repositorioLike.guardarLikePublicacion(like);
	}

	@Override
	public void darLikeAPublicacion(Publicacion publicacion, Usuario usuario) {

		Usuario usuarioQueLikeo = servicioUsuario.obtenerUsuarioPorId(usuario.getId());
		LikePublicacion like = repositorioLike.obtenerLikePublicacionPorPublicacionYUsuario(publicacion,
				usuarioQueLikeo);
		Usuario usuarioDeLaPublicacion = publicacion.getUsuario();
		if (like == null) {
			LikePublicacion nuevoLike = new LikePublicacion();
			nuevoLike.setPublicacion(publicacion);
			nuevoLike.setUsuario(usuarioQueLikeo);
			this.guardarLikePublicacion(nuevoLike);
			Notificacion notificacion = new Notificacion();

			notificacion.setUsuarioOtorgadorNotifi(usuarioQueLikeo);
			notificacion.setUsuarioRecibidorNotifi(usuarioDeLaPublicacion);
			notificacion.setPublicacion(publicacion);
			notificacion.setTipo(NotificacionTipo.LIKEPUBLICACION);
			notificacion.setVisto(false);

			servicioNotificacionLikePublicacion.guardarNotificacion(notificacion);
			servicioUsuario.aumentarCantidadNotificacionesDeUsuario(usuarioDeLaPublicacion);
			servicioPublicacion.aumentarCantidadLikesDePublicacion(publicacion);
		} else {
			borrarLikePublicacion(like);

			Notificacion notificacion = servicioNotificacionLikePublicacion
					.obtenerNotificacionPorUsuario1Usuario2YPublicacion(usuarioQueLikeo, usuarioDeLaPublicacion,
							publicacion);
			Long notificacionId = notificacion.getId();
			servicioNotificacionLikePublicacion.borrarNotificacionPorId(notificacionId);

			if (notificacion.getVisto() == false) {
				servicioUsuario.disminuirCantidadNotificacionesDeUsuario(usuarioDeLaPublicacion);
			}

			servicioPublicacion.disminuirCantidadLikesDePublicacion(publicacion);
		}

	}

	@Override
	public void borrarLikePublicacionPorId(Long id) {
		repositorioLike.borrarLikePublicacionPorId(id);

	}

	@Override
	public void borrarLikePublicacion(LikePublicacion like) {
		repositorioLike.borrarLikePublicacion(like);

	}

	@Override
	public LikePublicacion obtenerLikePublicacionPorId(Long id) {
		return repositorioLike.obtenerLikePublicacionPorId(id);
	}

}
