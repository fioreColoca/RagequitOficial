package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Seguir;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioUsuario;

@Repository
public class RepositorioSeguirImpl implements RepositorioSeguir {

	@Inject
	private SessionFactory sessionFactory;

	@Inject
	private ServicioUsuario servicioUsuario;

	@Override
	public void seguirUsuario(Usuario usuarioSeguidor, Usuario usuarioSeguido) {
		Seguir seguir = new Seguir();
		seguir.setUsuarioSeguidor(usuarioSeguidor);
		seguir.setUsuarioSeguido(usuarioSeguido);

		sessionFactory.getCurrentSession().save(seguir);
	}

	@Override
	public Seguir buscarSeguirPorUsuarioSeguidorYUsuarioSeguido(Usuario usuarioSeguidor, Usuario usuarioSeguido) {
		return (Seguir) sessionFactory.getCurrentSession().createCriteria(Seguir.class)
				.add(Restrictions.and(Restrictions.eq("usuarioSeguidor", usuarioSeguidor),
						Restrictions.eq("usuarioSeguido", usuarioSeguido)))
				.uniqueResult();
	}

	@Override
	public void dejarDeSeguirUsuario(Usuario usuarioSeguidor, Usuario usuarioSeguido) {
		Seguir borrarSeguir = buscarSeguirPorUsuarioSeguidorYUsuarioSeguido(usuarioSeguidor, usuarioSeguido);
		sessionFactory.getCurrentSession().delete(borrarSeguir);
	}

	@Override
	public List<Seguir> devolverListaDeSeguidores(Usuario usuarioSeguido) {
		Usuario seguido = servicioUsuario.obtenerUsuarioPorId(usuarioSeguido.getId());
		return sessionFactory.getCurrentSession().createCriteria(Seguir.class)
				.add(Restrictions.eq("usuarioSeguido", seguido)).list();

	}

	@Override
	public List<Seguir> devolverListaDeSeguidos(Usuario usuarioSeguidor) {
		Usuario seguidor = servicioUsuario.obtenerUsuarioPorId(usuarioSeguidor.getId());
		return sessionFactory.getCurrentSession().createCriteria(Seguir.class)
				.add(Restrictions.eq("usuarioSeguidor", seguidor)).list();
	}

	@Override
	public List<Seguir> devolverListaDeSeguimientos() {
		return sessionFactory.getCurrentSession().createCriteria(Seguir.class).list();
	}

}
