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
	public Long guardarLike(LikePublicacion like) {
		Session session = sessionFactory.getCurrentSession();
		return (Long)session.save(like);
	}

	@Override
	public void borrarLike(LikePublicacion like) {
		sessionFactory.getCurrentSession().delete(like);
		
	}

	@Override
	public void borrarLikePorId(Long id) {
		LikePublicacion like = obtenerLikePorId(id);
		sessionFactory.getCurrentSession().delete(like);
	}

	@Override
	public LikePublicacion obtenerLikePorId(Long id) {
		return sessionFactory.getCurrentSession().get(LikePublicacion.class, id);
	}

	@Override
	public LikePublicacion obtenerLikePorPublicacionYUsuario(Publicacion publicacion, Usuario usuario) {
		return (LikePublicacion) sessionFactory.getCurrentSession()
				.createCriteria(LikePublicacion.class)
				.add(Restrictions.and(
						Restrictions.eq("publicacion",publicacion),
						Restrictions.eq("usuario", usuario))
						).uniqueResult();
				
	}

	

}
