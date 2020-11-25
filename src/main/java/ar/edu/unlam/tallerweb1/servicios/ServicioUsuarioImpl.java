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

	@Override
	public void cambiarNombre(Long id, String nombre) {
		Usuario usuario = repositorioUsuario.obtenerUsuarioPorId(id);
		usuario.setNombre(nombre);
	}

	@Override
	public void cambiarApellido(Long id, String apellido) {
		Usuario usuario = repositorioUsuario.obtenerUsuarioPorId(id);
		usuario.setApellido(apellido);
	}

	@Override
	public void cambiarEmail(Long id, String email) {
		Usuario usuario = repositorioUsuario.obtenerUsuarioPorId(id);
		usuario.setEmail(email);
	}

	@Override
	public void cambiarNombreUsuario(Long id, String nombreUsuario) {
		Usuario usuario = repositorioUsuario.obtenerUsuarioPorId(id);
		usuario.setNombreUsuario(nombreUsuario);
	}

	@Override
	public void cambiarContrasenia(Long id, String contrasenia) {
		Usuario usuario = repositorioUsuario.obtenerUsuarioPorId(id);
		usuario.setPassword(contrasenia);
	}

	@Override
	public Usuario obtenerUsuarioPorId(Long id) {
		Usuario usuario = repositorioUsuario.obtenerUsuarioPorId(id);
		return usuario;
	}

	@Override
	public Usuario obtenerUsuarioPorNombreUsuario(String nombreUsuario) {
		return repositorioUsuario.obtenerUsuarioPorNombreUsuario(nombreUsuario);
	}

	@Override
	public void aumentarSeguidores(Usuario seguidoAumentarSeguidores) {
		Usuario seguido1 = repositorioUsuario.obtenerUsuarioPorId(seguidoAumentarSeguidores.getId());
		Integer seguidores = seguido1.getContadorSeguidores() + 1;
		seguido1.setContadorSeguidores(seguidores);
	}

}
