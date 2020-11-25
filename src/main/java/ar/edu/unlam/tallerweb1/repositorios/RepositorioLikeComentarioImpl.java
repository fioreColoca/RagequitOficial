package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Comentario;
import ar.edu.unlam.tallerweb1.modelo.LikeComentario;
import ar.edu.unlam.tallerweb1.modelo.Likee;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

@Repository
public class RepositorioLikeComentarioImpl implements RepositorioLikeComentario {

	@Inject
	private SessionFactory sessionFactory;
	
	@Override
	public Long guardar(LikeComentario like) {
		Session session = sessionFactory.getCurrentSession();
		return (Long)session.save(like);
	}

	@Override
	public void borrar(LikeComentario like) {
		sessionFactory.getCurrentSession().delete(like);
	}

	@Override
	public LikeComentario obtenerLikePorId(Long id) {
		return sessionFactory.getCurrentSession().get(LikeComentario.class, id);
	}


	@Override
	public LikeComentario obtenerLikePorComentarioYUsuario(Comentario comentario, Usuario usuario) {
		return (LikeComentario) sessionFactory.getCurrentSession()
				.createCriteria(LikeComentario.class)
				.add(Restrictions.and(
						Restrictions.eq("comentario",comentario),
						Restrictions.in("usuario", usuario))
						).uniqueResult();
	}

	@Override
	public List<Usuario> obtenerListaLikes() {
		return sessionFactory.getCurrentSession().createCriteria(LikeComentario.class).list();

	}

}
