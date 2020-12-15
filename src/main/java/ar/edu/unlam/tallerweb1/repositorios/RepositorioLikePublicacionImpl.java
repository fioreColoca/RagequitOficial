package ar.edu.unlam.tallerweb1.repositorios;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.LikePublicacion;
import ar.edu.unlam.tallerweb1.modelo.Publicacion;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

@Repository
public class RepositorioLikePublicacionImpl implements RepositorioLikePublicacion {

	@Inject
	private SessionFactory sessionFactory;

	@Override
	public Long guardarLikePublicacion(LikePublicacion like) {
		Session session = sessionFactory.getCurrentSession();
		return (Long) session.save(like);
	}

	@Override
	public void borrarLikePublicacion(LikePublicacion like) {
		sessionFactory.getCurrentSession().delete(like);

	}

	@Override
	public void borrarLikePublicacionPorId(Long id) {
		LikePublicacion like = obtenerLikePublicacionPorId(id);
		sessionFactory.getCurrentSession().delete(like);
	}

	@Override
	public LikePublicacion obtenerLikePublicacionPorId(Long id) {
		return sessionFactory.getCurrentSession().get(LikePublicacion.class, id);
	}

	@Override
	public LikePublicacion obtenerLikePublicacionPorPublicacionYUsuario(Publicacion publicacion, Usuario usuario) {
		return (LikePublicacion) sessionFactory.getCurrentSession().createCriteria(LikePublicacion.class)
				.add(Restrictions.and(Restrictions.eq("publicacion", publicacion), Restrictions.eq("usuario", usuario)))
				.uniqueResult();

	}

}
