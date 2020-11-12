package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Biblioteca;
import ar.edu.unlam.tallerweb1.modelo.Categoria;
import ar.edu.unlam.tallerweb1.modelo.CategoriaTipo;


@Repository
public class RepositorioBibliotecaImpl implements RepositorioBiblioteca {
	
	@Inject
	private SessionFactory sessionFactory;

	@Override
	public Long crearBiblioteca(Biblioteca biblioteca) {
		Session session = sessionFactory.getCurrentSession();
		return (Long)session.save(biblioteca);
	}

	@Override
	public Biblioteca obtenerBiblioteca(Long id) {
		
		return sessionFactory.getCurrentSession().get(Biblioteca.class, id);
	}

	@Override
	public List<Categoria> obtenerBibliotecaFiltradaPorCategoria(Categoria categoria) {
		return sessionFactory.getCurrentSession()
				.createCriteria(Categoria.class)
				.add(Restrictions.eq("tipoCategoria", categoria.getTipoCategoria())).list();
	}


}
