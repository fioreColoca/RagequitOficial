package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.UsuarioRagequit;

public interface RepositorioUsuarioRagequit {
	void guardarUsuario(UsuarioRagequit usuarioRagequit);

	UsuarioRagequit mostrarUsuarioPorId(Long id);
}
