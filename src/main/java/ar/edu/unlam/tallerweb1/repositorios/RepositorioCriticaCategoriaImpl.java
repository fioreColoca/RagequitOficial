package ar.edu.unlam.tallerweb1.repositorios;

import javax.inject.Inject;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.CriticaCategoria;

@Repository
public class RepositorioCriticaCategoriaImpl implements RepositorioCriticaCategoria {
	@Inject
	private SessionFactory sessionFactory;

	@Override
	public void crearUnaCriticaCategoria(CriticaCategoria criticaCategoria) {
		sessionFactory.getCurrentSession().save(criticaCategoria);
	}

}
