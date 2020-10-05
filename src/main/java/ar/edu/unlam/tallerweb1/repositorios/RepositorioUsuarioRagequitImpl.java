package ar.edu.unlam.tallerweb1.repositorios;

import javax.inject.Inject;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;

import ar.edu.unlam.tallerweb1.modelo.UsuarioRagequit;

@Service
public class RepositorioUsuarioRagequitImpl implements RepositorioUsuarioRagequit {

	@Inject
	private SessionFactory sessionFactory;
	
	@Override
	public void guardarUsuario(UsuarioRagequit usuarioRagequit) {
		sessionFactory.getCurrentSession().save(usuarioRagequit);
	}

}
