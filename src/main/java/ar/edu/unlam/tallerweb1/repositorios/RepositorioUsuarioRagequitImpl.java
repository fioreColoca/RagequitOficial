package ar.edu.unlam.tallerweb1.repositorios;

import javax.inject.Inject;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import ar.edu.unlam.tallerweb1.modelo.UsuarioRagequit;

@Repository
public class RepositorioUsuarioRagequitImpl implements RepositorioUsuarioRagequit {

	@Inject
	private SessionFactory sessionFactory;

	@Override
	public void guardarUsuario(UsuarioRagequit usuarioRagequit) {
		sessionFactory.getCurrentSession().save(usuarioRagequit);
	}

	@Override
	public UsuarioRagequit mostrarUsuarioPorId(Long id) {
		return sessionFactory.getCurrentSession().get(UsuarioRagequit.class, id);
	}

}
