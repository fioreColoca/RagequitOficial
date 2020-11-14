package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioUsuario;

@Service
@Transactional
public class ServicioUsuarioImpl implements ServicioUsuario {
	
	@Inject
	private RepositorioUsuario repositorioUsuario;
	
	@Override
	public List<Usuario> listarUsuarios() {
		return repositorioUsuario.listarUsuarios();
	}

	@Override
	public void cambiarRol(Long id, String rol) {
		Usuario usuario = repositorioUsuario.obtenerUsuarioPorId(id);
		usuario.setRol(rol);
	}
	
	@Override
	public RepositorioUsuario getRepositorioUsuario() {
		return repositorioUsuario;
	}
	
	@Override
	public void setRepositorioUsuario(RepositorioUsuario repositorioUsuario) {
		this.repositorioUsuario = repositorioUsuario;
	}

}
