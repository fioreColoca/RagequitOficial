package ar.edu.unlam.tallerweb1.repositorios;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Publicacion;

@Repository
public class RepositorioPublicacionImpl implements RepositorioPublicacion {

	@Inject
	private SessionFactory sessionFactory;
	
	@Override
	public Long guardarPublicacion(Publicacion publicacion) {
		Session session = sessionFactory.getCurrentSession();
		return (Long)session.save(publicacion);
	}

}
