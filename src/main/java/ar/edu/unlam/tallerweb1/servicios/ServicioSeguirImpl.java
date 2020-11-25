package ar.edu.unlam.tallerweb1.servicios;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

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
			servicioUsuario.aumentarSeguidos(seguidor);
			repositorioSeguir.seguirUsuario(seguidor, seguido);
		}

	}

	@Override
	public void dejarDeSeguirUsuario(Usuario usuarioSeguidor, Usuario usuarioSeguido) {
		Usuario seguidor = repositorioUsuario.obtenerUsuarioPorId(usuarioSeguidor.getId());
		Usuario seguido = repositorioUsuario.obtenerUsuarioPorId(usuarioSeguido.getId());
		if (seguidor != null && seguido != null) {
			servicioUsuario.disminuirSeguidores(seguido);
			servicioUsuario.disminuirSeguidos(seguidor);
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

	@Override
	public List<Usuario> devolverListaDeSeguidores(Usuario seguido) {
		List<Seguir> seguidoresListaSeguir = repositorioSeguir.devolverListaDeSeguidores(seguido);
		List<Usuario> seguidores = new ArrayList<Usuario>();
		for (Seguir seguidor : seguidoresListaSeguir) {
			seguidores.add(seguidor.getUsuarioSeguidor());
		}

		return seguidores;
	}

	@Override
	public List<Usuario> devolverListaDeSeguidos(Usuario seguidor) {
		List<Seguir> seguidosListaSeguir = repositorioSeguir.devolverListaDeSeguidos(seguidor);
		List<Usuario> seguidores = new ArrayList<Usuario>();
		for (Seguir seguidos : seguidosListaSeguir) {
			seguidores.add(seguidos.getUsuarioSeguido());
		}

		return seguidores;
	}

	@Override
	public List<Seguir> devolverListaDeSeguimientos() {
		return repositorioSeguir.devolverListaDeSeguimientos();
	}

}
