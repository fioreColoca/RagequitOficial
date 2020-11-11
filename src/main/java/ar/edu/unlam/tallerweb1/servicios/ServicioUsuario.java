package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Usuario;

public interface ServicioUsuario {
	List<Usuario> listarUsuarios();

	void cambiarRol(Long id, String rol);
}
