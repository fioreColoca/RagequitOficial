package ar.edu.unlam.tallerweb1.servicios;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.modelo.Categoria;
import ar.edu.unlam.tallerweb1.modelo.Publicacion;
import ar.edu.unlam.tallerweb1.modelo.Seguir;
import ar.edu.unlam.tallerweb1.modelo.SeguirCategoria;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioSeguirCategoria;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioUsuario;

@Service
@Transactional
public class ServicioUsuarioImpl implements ServicioUsuario {

	@Inject
	private RepositorioUsuario repositorioUsuario;
	@Inject
	private RepositorioSeguirCategoria repositorioSeguirCategoria;

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
		String contrasenia2 = encriptarPassword(contrasenia);
		usuario.setPassword(contrasenia2);
	}

	@Override
	public void cambiarTelefono(Long id, Integer numero) {
		Usuario usuario = repositorioUsuario.obtenerUsuarioPorId(id);
		usuario.setTelefono(numero);
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

	@Override
	public void aumentarSeguidos(Usuario seguidorAumentarSeguidos) {
		Usuario seguidor1 = repositorioUsuario.obtenerUsuarioPorId(seguidorAumentarSeguidos.getId());
		Integer seguidos = seguidor1.getContadorSeguidos() + 1;
		seguidor1.setContadorSeguidos(seguidos);
	}

	@Override
	public void disminuirSeguidores(Usuario seguidoDisminuirSeguidores) {
		Usuario seguido1 = repositorioUsuario.obtenerUsuarioPorId(seguidoDisminuirSeguidores.getId());
		Integer seguidores = seguido1.getContadorSeguidores() - 1;
		seguido1.setContadorSeguidores(seguidores);
	}

	@Override
	public void disminuirSeguidos(Usuario seguidorDisminuirSeguidos) {
		Usuario seguidor1 = repositorioUsuario.obtenerUsuarioPorId(seguidorDisminuirSeguidos.getId());
		Integer seguidos = seguidor1.getContadorSeguidos() - 1;
		seguidor1.setContadorSeguidos(seguidos);
	}

	@Override
	public void aumentarCategoriasSeguidas(Usuario seguidor) {
		Usuario seguidorDeCategoria = repositorioUsuario.obtenerUsuarioPorId(seguidor.getId());
		Integer categoriasSeguidas = seguidorDeCategoria.getContadorCategoriasSeguidas() + 1;
		seguidorDeCategoria.setContadorCategoriasSeguidas(categoriasSeguidas);

	}

	@Override
	public void disminuirCategoriasSeguidas(Usuario seguidor) {
		Usuario seguidorDeCategoria = repositorioUsuario.obtenerUsuarioPorId(seguidor.getId());
		Integer categoriasSeguidas = seguidorDeCategoria.getContadorCategoriasSeguidas() - 1;
		seguidorDeCategoria.setContadorCategoriasSeguidas(categoriasSeguidas);
	}

	@Override
	public String encriptarPassword(String password) {
		return org.apache.commons.codec.digest.DigestUtils.sha256Hex(password);
	}

	@Override
	public List<Categoria> devolverListaDeCategoriasSeguidasPorUsuario(Usuario usuario) {
		List<SeguirCategoria> seguirCategoriaPorUsuario = repositorioSeguirCategoria
				.devolverListaDeSeguirCategoriasPorUsuario(usuario);
		List<Categoria> categoriasSeguidas = new ArrayList<Categoria>();

		for (SeguirCategoria seguirCategoria : seguirCategoriaPorUsuario) {
			categoriasSeguidas.add(seguirCategoria.getCategoriaSeguida());
		}
		return categoriasSeguidas;
	}

	@Override
	public void aumentarCantidadNotificacionesDeUsuario(Usuario usuario) {
		Usuario usuarioAAumentarNotificaciones = repositorioUsuario.consultarUsuario(usuario);
		Integer cantidadNotificaciones = usuarioAAumentarNotificaciones.getContadorNotificaciones() + 1;

		usuarioAAumentarNotificaciones.setContadorNotificaciones(cantidadNotificaciones);
	}

	@Override
	public void disminuirCantidadNotificacionesDeUsuario(Usuario usuario) {
		Usuario usuarioADisminuirNotificaciones = repositorioUsuario.consultarUsuario(usuario);
		Integer cantidadNotificaciones = usuarioADisminuirNotificaciones.getContadorNotificaciones() - 1;

		usuarioADisminuirNotificaciones.setContadorNotificaciones(cantidadNotificaciones);
	}

}
