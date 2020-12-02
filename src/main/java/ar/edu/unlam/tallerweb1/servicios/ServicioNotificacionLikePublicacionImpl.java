package ar.edu.unlam.tallerweb1.servicios;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.modelo.NotificacionLikePublicacion;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioNotificacionLikePublicacion;

@Service
@Transactional
public class ServicioNotificacionLikePublicacionImpl implements ServicioNotificacionLikePublicacion {
	
	@Inject
	private RepositorioNotificacionLikePublicacion repositorioNotificacionLikePublicacion;
	
	@Override
	public Long guardarNotificacionLikePublicacion(NotificacionLikePublicacion notificacion) {
		return repositorioNotificacionLikePublicacion.guardarNotificacionLikePublicacion(notificacion);
	}

	@Override
	public NotificacionLikePublicacion obtenerNotificacionLikePublicacionPorUsuario1YUsuario2(Usuario usuario1,
			Usuario usuario2) {
		NotificacionLikePublicacion notificacion = repositorioNotificacionLikePublicacion
		.obtenerNotificacionLikePublicacionPorUsuario1YUsuario2(usuario1,usuario2);
		return notificacion;
	}

	@Override
	public void borrarNotificacionLikePublicacionPorId(Long notificacionId) {
		repositorioNotificacionLikePublicacion.borrarNotificacionLikePublicacionPorId(notificacionId);
	}

	@Override
	public NotificacionLikePublicacion obtenerNotificacionLikePublicacionPorId(Long id) {
		
		return repositorioNotificacionLikePublicacion.obtenerNotificacionLikePublicacionPorId(id);
	}

}
