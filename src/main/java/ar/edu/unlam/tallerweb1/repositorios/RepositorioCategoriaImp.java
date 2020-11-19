package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;

import javax.inject.Inject;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;


import ar.edu.unlam.tallerweb1.modelo.Categoria;
import ar.edu.unlam.tallerweb1.modelo.CategoriaTipo;

@Repository
public class RepositorioCategoriaImp implements RepositorioCategoria {
	
	@Inject
	private SessionFactory sessionFactory;

	@Override
	public void guardarCategoria(Categoria categoria) {
		sessionFactory.getCurrentSession().save(categoria);
		
	}

	@Override
	public Categoria mostrarCategoriaPorId(Long id) {
		return sessionFactory.getCurrentSession().get(Categoria.class, id);
	}

	@Override
	public List<Categoria> mostrarCategorias() {
		return sessionFactory.getCurrentSession().createCriteria(Categoria.class).list();
	}

	@Override
	public void borrarCategoria(Long id) {
		Categoria categoria = mostrarCategoriaPorId(id);
		sessionFactory.getCurrentSession().delete(categoria);
	}

//	@Override
//	public void editarCategoria(Categoria categoria) {
//		sessionFactory.getCurrentSession().save(categoria);
//	}
	
//	@Override
//	public void editarNombre(Long id) {
//		Categoria categoria = mostrarCategoriaPorId(id);
//		sessionFactory.getCurrentSession().update(categoria);
//	}

	public List<Categoria> mostrarCategoriaPorTipo(CategoriaTipo tipoCategoria) {
		return sessionFactory.getCurrentSession().createCriteria(Categoria.class).add(Restrictions.eq("tipoCategoria", tipoCategoria)).list();

	}


}
