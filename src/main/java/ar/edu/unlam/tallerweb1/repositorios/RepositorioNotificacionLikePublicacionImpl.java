package ar.edu.unlam.tallerweb1.repositorios;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.LikePublicacion;
import ar.edu.unlam.tallerweb1.modelo.NotificacionLikePublicacion;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

@Repository
public class RepositorioNotificacionLikePublicacionImpl implements RepositorioNotificacionLikePublicacion {
	
	@Inject
	private SessionFactory sessionFactory;
	
	@Override
	public Long guardarNotificacionLikePublicacion(NotificacionLikePublicacion notificacion) {
		Session session = sessionFactory.getCurrentSession();
		return (Long)session.save(notificacion);
	}

	@Override
	public NotificacionLikePublicacion obtenerNotificacionLikePublicacionPorUsuario1YUsuario2(Usuario usuario1,
			Usuario usuario2) {
		return (NotificacionLikePublicacion) sessionFactory.getCurrentSession()
				.createCriteria(NotificacionLikePublicacion.class)
				.add(Restrictions.and(
						Restrictions.eq("usuarioOtorgadorNotifi",usuario1),
						Restrictions.eq("usuarioRecibidorNotifi", usuario2))
						).uniqueResult();
	}

	@Override
	public void borrarNotificacionLikePublicacionPorId(Long notificacionId) {
		NotificacionLikePublicacion notificacion = obtenerNotificacionLikePublicacionPorId(notificacionId);
		sessionFactory.getCurrentSession().delete(notificacion);
		
	}
	
	@Override
	public NotificacionLikePublicacion obtenerNotificacionLikePublicacionPorId(Long id) {
		return sessionFactory.getCurrentSession().get(NotificacionLikePublicacion.class, id);
	}
}
