package ar.edu.unlam.tallerweb1.repositorios;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.NotificacionLikePublicacion;

@Repository
public class RepositorioNotificacionLikePublicacionImpl implements RepositorioNotificacionLikePublicacion {
	
	@Inject
	private SessionFactory sessionFactory;
	
	@Override
	public Long guardarNotificacionLikePublicacion(NotificacionLikePublicacion notificacion) {
		Session session = sessionFactory.getCurrentSession();
		return (Long)session.save(notificacion);
	}

}
