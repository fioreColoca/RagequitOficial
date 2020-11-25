package ar.edu.unlam.tallerweb1.repositorios;

import javax.inject.Inject;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Seguir;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

@Repository
public class RepositorioSeguirImpl implements RepositorioSeguir {

	@Inject
	private SessionFactory sessionFactory;

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

}
