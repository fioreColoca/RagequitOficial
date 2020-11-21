package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Categoria;
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

	@Override
	public List<Publicacion> buscarPublicacionesPorCategoria(Categoria categoria) {
		return sessionFactory.getCurrentSession()
				.createCriteria(Publicacion.class)
				.add(Restrictions.eq("categoria", categoria))
				.list();
	}

	@Override
	public List<Publicacion> buscarPublicaciones() {
		return sessionFactory.getCurrentSession()
				.createCriteria(Publicacion.class)
				.list();
	}
	
	@Override
	public Publicacion obtenerPublicacionPorId(Long id) {
		
		return sessionFactory.getCurrentSession().get(Publicacion.class, id);
	}

	@Override
	public void borrarPublicacion(Long id) {
		Publicacion publicacion = obtenerPublicacionPorId(id);
		sessionFactory.getCurrentSession().delete(publicacion);
		
	}

	
	
	

}
