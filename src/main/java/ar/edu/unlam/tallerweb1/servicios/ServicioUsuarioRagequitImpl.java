package ar.edu.unlam.tallerweb1.servicios;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.modelo.UsuarioRagequit;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioUsuarioRagequit;

@Service
@Transactional
public class ServicioUsuarioRagequitImpl implements ServicioUsuarioRagequit {

	@Inject
	private RepositorioUsuarioRagequit repositorioUsuarioRagequit;

	@Override
	public void crearUsuario(UsuarioRagequit usuarioRagequit) {
		repositorioUsuarioRagequit.guardarUsuario(usuarioRagequit);
	}

	@Override
	public UsuarioRagequit mostrarUsuario(Long id) {

		return repositorioUsuarioRagequit.mostrarUsuarioPorId(id);
	}

//	@Override
//	public Boolean seguirUsuarioRagequit(UsuarioRagequit usuarioRagequit) {
//		
//		return null;
//	}

}
