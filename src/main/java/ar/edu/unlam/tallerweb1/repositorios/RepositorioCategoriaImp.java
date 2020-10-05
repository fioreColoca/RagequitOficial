package ar.edu.unlam.tallerweb1.repositorios;

import javax.inject.Inject;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;


import ar.edu.unlam.tallerweb1.modelo.Categoria;

@Repository
public class RepositorioCategoriaImp implements RepositorioCategoria {
	
	@Inject
	private SessionFactory sessionFactory;

	@Override
	public Long crearCategoria(Categoria categoria) {
		return (Long)sessionFactory.getCurrentSession().save(categoria);
	}

}
