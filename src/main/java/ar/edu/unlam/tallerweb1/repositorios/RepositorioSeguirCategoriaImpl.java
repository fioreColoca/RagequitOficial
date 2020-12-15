package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Categoria;
import ar.edu.unlam.tallerweb1.modelo.Seguir;
import ar.edu.unlam.tallerweb1.modelo.SeguirCategoria;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioCategoria;
import ar.edu.unlam.tallerweb1.servicios.ServicioUsuario;

@Repository
public class RepositorioSeguirCategoriaImpl implements RepositorioSeguirCategoria {

	@Inject
	private SessionFactory sessionFactory;

	@Inject
	private ServicioUsuario servicioUsuario;

	@Inject
	private ServicioCategoria servicioCategoria;

	@Override
	public void seguirCategoria(Usuario usuario, Categoria categoria) {
		SeguirCategoria seguir = new SeguirCategoria();
		seguir.setUsuarioSeguidor(usuario);
		seguir.setCategoriaSeguida(categoria);

		sessionFactory.getCurrentSession().save(seguir);

	}

	@Override
	public SeguirCategoria buscarSeguirCategoriaPorUsuarioYCategoria(Usuario seguidor, Categoria categoriaSeguida) {
		return (SeguirCategoria) sessionFactory.getCurrentSession().createCriteria(SeguirCategoria.class)
				.add(Restrictions.and(Restrictions.eq("usuarioSeguidor", seguidor),
						Restrictions.eq("categoriaSeguida", categoriaSeguida)))
				.uniqueResult();
	}

	@Override
	public void dejarSeguirCategoria(Usuario seguidor, Categoria categoriaSeguida) {
		SeguirCategoria borrarSeguidor = buscarSeguirCategoriaPorUsuarioYCategoria(seguidor, categoriaSeguida);
		sessionFactory.getCurrentSession().delete(borrarSeguidor);
	}

	@Override
	public List<SeguirCategoria> devolverListaDeSeguidores(Categoria juegosOVarios) {
		Categoria categoriaSeguida = servicioCategoria.mostrarCategoriaPorId(juegosOVarios.getId());
		return sessionFactory.getCurrentSession().createCriteria(SeguirCategoria.class)
				.add(Restrictions.eq("categoriaSeguida", categoriaSeguida)).list();
	}

	@Override
	public List<SeguirCategoria> devolverListaDeSeguirCategoriasPorUsuario(Usuario usuario) {
		return sessionFactory.getCurrentSession().createCriteria(SeguirCategoria.class)
				.add(Restrictions.eq("usuarioSeguidor", usuario)).list();
	}
}
