package ar.edu.unlam.tallerweb1.repositorios;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Lista;

@Repository
public class RepositorioListaImpl implements RepositorioLista {
	
	@Inject
	private SessionFactory sessionFactory;

	@Override
	public Long crearLista(Lista lista) {
		Session session = sessionFactory.getCurrentSession();
		return (Long)session.save(lista);
	}

}
