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
	@Inject
	private ServicioUsuario servicioUsuario;

	@Override
	public void seguirUsuario(Usuario usuarioSeguidor, Usuario usuarioSeguido) {
		Usuario seguidor = repositorioUsuario.obtenerUsuarioPorId(usuarioSeguidor.getId());
		Usuario seguido = repositorioUsuario.obtenerUsuarioPorId(usuarioSeguido.getId());
		if (seguidor != null && seguido != null) {
			servicioUsuario.aumentarSeguidores(seguido);
			repositorioSeguir.seguirUsuario(seguidor, seguido);
		}

	}

	@Override
	public void dejarDeSeguirUsuario(Usuario usuarioSeguidor, Usuario usuarioSeguido) {
		Usuario seguidor = repositorioUsuario.obtenerUsuarioPorId(usuarioSeguidor.getId());
		Usuario seguido = repositorioUsuario.obtenerUsuarioPorId(usuarioSeguido.getId());
		System.out.println("verifique los seguidores*********************************");
		if (seguidor != null && seguido != null) {
			System.out.println("Verifique los seguidores*******************");
			repositorioSeguir.dejarDeSeguirUsuario(seguidor, seguido);
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

}
