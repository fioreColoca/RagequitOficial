package ar.edu.unlam.tallerweb1.repositorios;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Biblioteca;

@Repository
public class RepositorioBibliotecaImpl implements RepositorioBiblioteca {
	
	@Inject
	private SessionFactory sessionFactory;

	@Override
	public Long crearBiblioteca(Biblioteca biblioteca) {
		Session session = sessionFactory.getCurrentSession();
		return (Long)session.save(biblioteca);
	}

}
