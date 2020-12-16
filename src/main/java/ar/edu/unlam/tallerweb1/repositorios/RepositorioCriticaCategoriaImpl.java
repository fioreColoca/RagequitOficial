package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Categoria;
import ar.edu.unlam.tallerweb1.modelo.CriticaCategoria;
import ar.edu.unlam.tallerweb1.modelo.Seguir;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioCategoria;

@Repository
public class RepositorioCriticaCategoriaImpl implements RepositorioCriticaCategoria {
	@Inject
	private SessionFactory sessionFactory;
	@Inject
	private ServicioCategoria servicioCategoria;

	@Override
	public void crearUnaCriticaCategoria(CriticaCategoria criticaCategoria) {
		sessionFactory.getCurrentSession().save(criticaCategoria);
	}

	@Override
	public CriticaCategoria obtenerCriticaCategoriaPorId(Long id) {
		return sessionFactory.getCurrentSession().get(CriticaCategoria.class, id);
	}

	@Override
	public List<CriticaCategoria> obtenerListaCriticasPorMismaCategoria(Categoria categoria) {
		Categoria categorias = servicioCategoria.mostrarCategoriaPorId(categoria.getId());
		return sessionFactory.getCurrentSession().createCriteria(CriticaCategoria.class)
				.add(Restrictions.eq("categoria", categorias)).list();
	}

}
