package ar.edu.unlam.tallerweb1.repositorios;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Likee;
import ar.edu.unlam.tallerweb1.modelo.Publicacion;
import ar.edu.unlam.tallerweb1.modelo.Usuario;


@Repository
public class RepositorioLikeImpl implements RepositorioLike {
	
	@Inject
	private SessionFactory sessionFactory;
	
	@Override
	public Long guardarLike(Likee like) {
		Session session = sessionFactory.getCurrentSession();
		return (Long)session.save(like);
	}

	@Override
	public void borrarLike(Likee like) {
		sessionFactory.getCurrentSession().delete(like);
		
	}

	@Override
	public void borrarLikePorId(Long id) {
		Likee like = obtenerLikePorId(id);
		sessionFactory.getCurrentSession().delete(like);
	}

	@Override
	public Likee obtenerLikePorId(Long id) {
		return sessionFactory.getCurrentSession().get(Likee.class, id);
	}

	@Override
	public Likee obtenerLikePorPublicacionYUsuario(Publicacion publicacion, Usuario usuario) {
		return (Likee) sessionFactory.getCurrentSession()
				.createCriteria(Likee.class)
				.add(Restrictions.and(
						Restrictions.eq("publicacion",publicacion),
						Restrictions.eq("usuario", usuario))
						).uniqueResult();
				
	}

	

}
