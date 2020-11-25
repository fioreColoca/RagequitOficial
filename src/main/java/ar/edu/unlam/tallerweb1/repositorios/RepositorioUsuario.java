package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Usuario;

// Interface que define los metodos del Repositorio de Usuarios.
public interface RepositorioUsuario {

	Usuario consultarUsuario(Usuario usuario);

	Usuario obtenerUsuarioPorId(Long id);

	Usuario obtenerUsuarioPorNombreUsuario(String nombreUsuario);

	void registrarUsuario(Usuario usuario);

	List<Usuario> listarUsuarios();
}
