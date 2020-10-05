package ar.edu.unlam.tallerweb1.repositorios;

import javax.inject.Inject;

import org.hibernate.SessionFactory;

import ar.edu.unlam.tallerweb1.modelo.UsuarioRagequit;

public class ServicioUsuarioRagequitImpl implements ServicioUsuarioRagequit {

	@Inject
	private SessionFactory sessionFactory;
	
	@Override
	public void guardarUsuario(UsuarioRagequit usuarioRagequit) {
		sessionFactory.getCurrentSession().save(usuarioRagequit);
	}

}
