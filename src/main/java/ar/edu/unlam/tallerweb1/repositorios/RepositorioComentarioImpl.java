package ar.edu.unlam.tallerweb1.repositorios;

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

}
