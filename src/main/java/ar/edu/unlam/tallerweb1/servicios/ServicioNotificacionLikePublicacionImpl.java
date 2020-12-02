package ar.edu.unlam.tallerweb1.servicios;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.modelo.NotificacionLikePublicacion;
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

}
