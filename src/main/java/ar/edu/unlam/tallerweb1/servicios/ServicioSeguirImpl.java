package ar.edu.unlam.tallerweb1.servicios;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.modelo.Seguir;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioSeguir;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioUsuario;

@Service
@Transactional
public class ServicioSeguirImpl implements ServicioSeguir {
	@Inject
	private RepositorioSeguir repositorioSeguir;
	@Inject
	private RepositorioUsuario repositorioUsuario;

	@Override
	public void seguirUsuario(Usuario usuarioSeguidor, Usuario usuarioSeguido) {
		Usuario seguidor = repositorioUsuario.obtenerUsuarioPorId(usuarioSeguidor.getId());
		Usuario seguido = repositorioUsuario.obtenerUsuarioPorId(usuarioSeguido.getId());
		if (seguidor != null && seguido != null) {
			repositorioSeguir.seguirUsuario(seguidor, seguido);
		}

	}

	@Override
	public Seguir buscarSeguirPorUsuarioSeguidorYUsuarioSeguido(Usuario usuarioSeguidor, Usuario usuarioSeguido) {
		Usuario seguidor = repositorioUsuario.obtenerUsuarioPorId(usuarioSeguidor.getId());
		Usuario seguido = repositorioUsuario.obtenerUsuarioPorId(usuarioSeguido.getId());
		if (seguidor != null && seguido != null) {
			return (Seguir) repositorioSeguir.buscarSeguirPorUsuarioSeguidorYUsuarioSeguido(seguidor, seguido);
		}
		return null;
	}

	@Override
	public void dejarDeSeguirUsuario(Usuario usuarioSeguidor, Usuario usuarioSeguido) {
		Usuario seguidor = repositorioUsuario.obtenerUsuarioPorId(usuarioSeguidor.getId());
		Usuario seguido = repositorioUsuario.obtenerUsuarioPorId(usuarioSeguido.getId());
		if (seguidor != null && seguido != null) {
			repositorioSeguir.dejarDeSeguirUsuario(seguidor, seguido);
		}
	}

}
