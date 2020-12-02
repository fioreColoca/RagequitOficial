package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.LikePublicacion;
import ar.edu.unlam.tallerweb1.modelo.Notificacion;
import ar.edu.unlam.tallerweb1.modelo.Publicacion;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

@Repository
public class RepositorioNotificacionImpl implements RepositorioNotificacion {
	
	@Inject
	private SessionFactory sessionFactory;
	
	@Override
	public Long guardarNotificacionLikePublicacion(Notificacion notificacion) {
		Session session = sessionFactory.getCurrentSession();
		return (Long)session.save(notificacion);
	}

	@Override
	public Notificacion obtenerNotificacionLikePublicacionPorUsuario1Usuario2YPublicacion(Usuario usuario1,
			Usuario usuario2, Publicacion publicacion) {
		return (Notificacion) sessionFactory.getCurrentSession()
				.createCriteria(Notificacion.class)
				.add(Restrictions.and(
						Restrictions.eq("publicacion",publicacion),
						Restrictions.eq("usuarioOtorgadorNotifi",usuario1),
						Restrictions.eq("usuarioRecibidorNotifi", usuario2))
						).uniqueResult();
	}

	@Override
	public void borrarNotificacionLikePublicacionPorId(Long notificacionId) {
		Notificacion notificacion = obtenerNotificacionLikePublicacionPorId(notificacionId);
		sessionFactory.getCurrentSession().delete(notificacion);
		
	}
	
	@Override
	public Notificacion obtenerNotificacionLikePublicacionPorId(Long id) {
		return sessionFactory.getCurrentSession().get(Notificacion.class, id);
	}

	@Override
	public List<Notificacion> obtenerListaDeNotificacionesDelUsuario(Usuario usuario) {
		return sessionFactory.getCurrentSession()
				.createCriteria(Notificacion.class)
				.add(Restrictions.eq("usuarioRecibidorNotifi", usuario))
				.list();
	}
}
