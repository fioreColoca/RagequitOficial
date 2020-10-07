package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Comentario;

@Repository
public class RepositorioComentarioImpl implements RepositorioComentario {
	
	@Inject
	private SessionFactory sessionFactory;
	

	@Override
	public Long enviarComentario(Comentario comentario) {
		Session session = sessionFactory.getCurrentSession();
		return (Long)session.save(comentario);	
	}


	@Override
	public Comentario mostrarComentario(Long id) {
		return sessionFactory.getCurrentSession().get(Comentario.class,id);
	}


	@Override /* COMO HACER ESTO FUNCIONAL A LA PAGINA */
	public void borrarComentario(Long id) {
		Comentario comentario = mostrarComentario(id);
		Session session = sessionFactory.getCurrentSession();
		session.delete(comentario);
	}


	@Override /* DUDA SI TENGO QUE LLEGAR HASTA ACÁ PARA MODIFICAR DATOS */
	public void darLikeComentario(Long id) {
		Comentario comentario = mostrarComentario(id);
		comentario.setCantidadLikes(comentario.getCantidadLikes()+1);
	}


	@Override
	public List<Comentario> verListaComentarios() {
		return sessionFactory.getCurrentSession().createCriteria(Comentario.class).list();
	}


}
