package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Comentario;
import ar.edu.unlam.tallerweb1.modelo.Publicacion;

@Repository
public class RepositorioComentarioImpl implements RepositorioComentario {

	@Inject
	private SessionFactory sessionFactory;

	@Override
	public Long enviarComentario(Comentario comentario) {
		Session session = sessionFactory.getCurrentSession();
		return (Long) session.save(comentario);
	}

	@Override
	public Comentario mostrarComentario(Long id) {
		return sessionFactory.getCurrentSession().get(Comentario.class, id);
	}

	@Override
	public void borrarComentario(Long id) {
		Comentario comentario = mostrarComentario(id);
		Session session = sessionFactory.getCurrentSession();
		session.delete(comentario);
	}

	@Override
	public List<Comentario> obtenerComentariosPorPublicacion(Publicacion publicacion) {
		return sessionFactory.getCurrentSession().createCriteria(Comentario.class)
				.add(Restrictions.eq("publicacion", publicacion)).list();
	}

	@Override
	public List<Comentario> mostrarTodosLosComentarios() {
		return sessionFactory.getCurrentSession().createCriteria(Comentario.class).list();
	}

	@Override
	public List<Comentario> respuestaListado(Comentario comentario) {
		return sessionFactory.getCurrentSession().createCriteria(Comentario.class)
				.add(Restrictions.eq("respuesta", comentario)).list();
	}

}
