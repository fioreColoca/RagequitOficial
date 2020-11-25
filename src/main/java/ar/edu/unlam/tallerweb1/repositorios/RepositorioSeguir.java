package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Seguir;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

public interface RepositorioSeguir {
	void seguirUsuario(Usuario usuarioSeguidor, Usuario usuarioSeguido);

	void dejarDeSeguirUsuario(Usuario usuarioSeguidor, Usuario usuarioSeguido);

	Seguir buscarSeguirPorUsuarioSeguidorYUsuarioSeguido(Usuario usuarioSeguidor, Usuario usuarioSeguido);

	List<Seguir> devolverListaDeSeguidores(Usuario seguido);

	List<Seguir> devolverListaDeSeguidos(Usuario seguido);

	List<Seguir> devolverListaDeSeguimientos();
}
