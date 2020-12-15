package ar.edu.unlam.tallerweb1.servicios;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.modelo.Categoria;
import ar.edu.unlam.tallerweb1.modelo.Seguir;
import ar.edu.unlam.tallerweb1.modelo.SeguirCategoria;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioCategoria;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioSeguirCategoria;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioUsuario;

@Service
@Transactional
public class ServicioSeguirCategoriaImpl implements ServicioSeguirCategoria {

	@Inject
	private RepositorioSeguirCategoria repositorioSeguirCategoria;

	@Inject
	private RepositorioUsuario repositorioUsuario;

	@Inject
	private ServicioUsuario servicioUsuario;

	@Inject
	private RepositorioCategoria repositorioCategoria;

	@Inject
	private ServicioCategoria servicioCategoria;

	@Override
	public void seguirCategoria(Usuario usuario, Categoria categoria) {
		Usuario seguidor = repositorioUsuario.obtenerUsuarioPorId(usuario.getId());
		Categoria categoriaSeguida = repositorioCategoria.mostrarCategoriaPorId(categoria.getId());

		if (seguidor != null && categoriaSeguida != null) {
			servicioCategoria.aumentarSeguidores(categoriaSeguida);
			servicioUsuario.aumentarCategoriasSeguidas(seguidor);
			repositorioSeguirCategoria.seguirCategoria(seguidor, categoriaSeguida);
		}

	}

	@Override
	public SeguirCategoria buscarSeguirCategoriaPorUsuarioYCategoria(Usuario usuario, Categoria categoria) {
		Usuario seguidor = repositorioUsuario.obtenerUsuarioPorId(usuario.getId());
		Categoria categoriaSeguida = repositorioCategoria.mostrarCategoriaPorId(categoria.getId());
		if (seguidor != null && categoriaSeguida != null) {
			return repositorioSeguirCategoria.buscarSeguirCategoriaPorUsuarioYCategoria(seguidor, categoriaSeguida);
		}
		return null;

	}

	@Override
	public void dejarDeSeguirCategoria(Usuario usuario, Categoria categoria) {
		Usuario seguidor = repositorioUsuario.obtenerUsuarioPorId(usuario.getId());
		Categoria categoriaSeguida = repositorioCategoria.mostrarCategoriaPorId(categoria.getId());

		if (seguidor != null && categoriaSeguida != null) {
			servicioCategoria.disminuirSeguidores(categoriaSeguida);
			servicioUsuario.disminuirCategoriasSeguidas(seguidor);
			repositorioSeguirCategoria.dejarSeguirCategoria(seguidor, categoriaSeguida);
		}
	}

	@Override
	public List<Usuario> devolverListaDeSeguidores(Categoria juegosOVarios) {
		List<SeguirCategoria> seguidoresListaSeguir = repositorioSeguirCategoria
				.devolverListaDeSeguidores(juegosOVarios);
		List<Usuario> seguidores = new ArrayList<Usuario>();
		for (SeguirCategoria seguidor : seguidoresListaSeguir) {
			seguidores.add(seguidor.getUsuarioSeguidor());
		}

		return seguidores;
	}

}
