package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.UsuarioRagequit;

public interface ServicioUsuarioRagequit {
	void crearUsuario(UsuarioRagequit usuarioRagequit);

	UsuarioRagequit mostrarUsuario(Long id);
	//Boolean seguirUsuarioRagequit(UsuarioRagequit usuarioRagequit);
}
