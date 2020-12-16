package ar.edu.unlam.tallerweb1.servicios;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.modelo.Categoria;
import ar.edu.unlam.tallerweb1.modelo.Comentario;
import ar.edu.unlam.tallerweb1.modelo.Publicacion;
import ar.edu.unlam.tallerweb1.modelo.PublicacionEstado;
import ar.edu.unlam.tallerweb1.modelo.PublicacionOrdenPorFechaDescendente;
import ar.edu.unlam.tallerweb1.modelo.PublicacionOrdenPorLikeYComentario;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioComentario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioPublicacion;

@Service
@Transactional
public class ServicioPublicacionImpl implements ServicioPublicacion {

	@Inject
	private RepositorioPublicacion repositorioPublicacion;
	@Inject
	private RepositorioComentario repositorioComentario;
	@Inject
	private ServicioSeguir servicioSeguir;
	@Inject
	private ServicioUsuario servicioUsuario;

	@Override
	public Long guardarPublicacion(Publicacion publicacion) {

		return repositorioPublicacion.guardarPublicacion(publicacion);
	}

	@Override
	public List<Publicacion> buscarPublicacionesPorCategoria(Categoria categoria) {
		return repositorioPublicacion.buscarPublicacionesPorCategoria(categoria);
	}

	@Override
	public List<Publicacion> buscarPublicaciones() {
		return repositorioPublicacion.buscarPublicaciones();
	}

	@Override
	public Publicacion obtenerPublicacionPorId(Long id) {

		return repositorioPublicacion.obtenerPublicacionPorId(id);
	}

	@Override
	public void borrarPublicacion(Long id) {
		Publicacion publicacionABorrar = repositorioPublicacion.obtenerPublicacionPorId(id);
		publicacionABorrar.setEstado(PublicacionEstado.INACTIVO);

	}

	@Override
	public TreeSet<Publicacion> devolverPublicacionesOdenadasPorFechaRecienteAAntigua() {

		List<Publicacion> publicaciones = this.buscarPublicaciones();

		PublicacionOrdenPorFechaDescendente ordenFechaRecienteAAntigua = new PublicacionOrdenPorFechaDescendente();

		TreeSet<Publicacion> ordenadoPorFechaRecienteAAntigua = new TreeSet<Publicacion>(ordenFechaRecienteAAntigua);

		ordenadoPorFechaRecienteAAntigua.addAll(publicaciones);

		return ordenadoPorFechaRecienteAAntigua;

	}

	@Override
	public TreeSet<Publicacion> devolverPublicacionesOdenadasPorLikesYComentarios() {

		List<Publicacion> publicaciones = this.buscarPublicaciones();

		PublicacionOrdenPorLikeYComentario ordenPorLikesYComentarios = new PublicacionOrdenPorLikeYComentario();

		TreeSet<Publicacion> ordenadoPorLikesYComentarios = new TreeSet<Publicacion>(ordenPorLikesYComentarios);

		ordenadoPorLikesYComentarios.addAll(publicaciones);

		return ordenadoPorLikesYComentarios;

	}

	@Override
	public TreeSet<Publicacion> devolverYOrdenarUnaListaDePublicacionesPorFechaRecienteAAntigua(
			List listaPublicaciones) {

		PublicacionOrdenPorFechaDescendente ordenFechaRecienteAAntigua = new PublicacionOrdenPorFechaDescendente();

		TreeSet<Publicacion> ordenadoPorFechaRecienteAAntigua = new TreeSet<Publicacion>(ordenFechaRecienteAAntigua);

		ordenadoPorFechaRecienteAAntigua.addAll(listaPublicaciones);

		return ordenadoPorFechaRecienteAAntigua;

	}

	@Override
	public TreeSet<Publicacion> devolverYOrdenarUnaListaDePublicacionesPorPopular(List listaPublicaciones) {

		PublicacionOrdenPorLikeYComentario ordenPorLikesYComentarios = new PublicacionOrdenPorLikeYComentario();

		TreeSet<Publicacion> ordenadoPorLikesYComentarios = new TreeSet<Publicacion>(ordenPorLikesYComentarios);

		ordenadoPorLikesYComentarios.addAll(listaPublicaciones);

		return ordenadoPorLikesYComentarios;

	}

	@Override
	public void aumentarCantidadComentariosDePublicacion(Publicacion publicacion) {
		Publicacion publicacionAAumentarComentarios = repositorioPublicacion
				.obtenerPublicacionPorId(publicacion.getId());
		Integer cantidadComentarios = publicacionAAumentarComentarios.getCantidadComentarios() + 1;

		publicacionAAumentarComentarios.setCantidadComentarios(cantidadComentarios);

	}

	@Override
	public void aumentarCantidadLikesDePublicacion(Publicacion publicacion) {
		Publicacion publicacionAAumentarLikes = repositorioPublicacion.obtenerPublicacionPorId(publicacion.getId());
		Integer cantidadLikes = publicacionAAumentarLikes.getCantidadLikes() + 1;

		publicacionAAumentarLikes.setCantidadLikes(cantidadLikes);
	}

	@Override
	public void disminuirCantidadLikesDePublicacion(Publicacion publicacion) {
		Publicacion publicacionADisminuirLikes = repositorioPublicacion.obtenerPublicacionPorId(publicacion.getId());
		Integer cantidadLikes = publicacionADisminuirLikes.getCantidadLikes() - 1;

		publicacionADisminuirLikes.setCantidadLikes(cantidadLikes);

	}

	@Override
	public void disminuirCantidadComentariosDePublicacion(Publicacion publicacion) {
		Publicacion publicacionADisminuirComentarios = repositorioPublicacion
				.obtenerPublicacionPorId(publicacion.getId());
		Integer cantidadComentarios = publicacionADisminuirComentarios.getCantidadComentarios() - 1;

		publicacionADisminuirComentarios.setCantidadComentarios(cantidadComentarios);

	}

	@Override
	public List<Publicacion> devolverPublicacionesPorUsuariosSeguidos(Usuario usuario) {
		List<Publicacion> publicaciones = buscarPublicaciones();
		List<Usuario> usuariosSeguidos = servicioSeguir.devolverListaDeSeguidos(usuario);
		List<Publicacion> publicacionesUsuariosSeguidos = new ArrayList<>();
		for (Publicacion publicacion : publicaciones) {
			Usuario usuarioDeLaPublicacion = publicacion.getUsuario();
			if (usuariosSeguidos.contains(usuarioDeLaPublicacion)) {
				publicacionesUsuariosSeguidos.add(publicacion);
			}
		}
		return publicacionesUsuariosSeguidos;
	}

	@Override
	public List<Publicacion> devolverPublicacionesPorCategoriasSeguidas(Usuario usuario) {
		List<Publicacion> publicaciones = buscarPublicaciones();
		List<Categoria> categoriasSeguidas = servicioUsuario.devolverListaDeCategoriasSeguidasPorUsuario(usuario);
		List<Publicacion> publicacionesCategoriasSeguidas = new ArrayList<>();
		for (Publicacion publicacion : publicaciones) {
			Categoria categoriaDeLaPublicacion = publicacion.getCategoria();
			if (categoriasSeguidas.contains(categoriaDeLaPublicacion)) {
				publicacionesCategoriasSeguidas.add(publicacion);
			}
		}
		return publicacionesCategoriasSeguidas;
	}

	@Override
	public List<Publicacion> devolverUnaListaDePublicacionesPorUsuariosSeguidos(List publicaciones, Usuario usuario) {
		List<Publicacion> publicacionesLista = publicaciones;
		List<Usuario> usuariosSeguidos = servicioSeguir.devolverListaDeSeguidos(usuario);
		List<Publicacion> publicacionesUsuariosSeguidos = new ArrayList<>();
		for (Publicacion publicacion : publicacionesLista) {
			Long usuarioId = publicacion.getUsuario().getId();
			Usuario usuarioDeLaPublicacion = servicioUsuario.obtenerUsuarioPorId(usuarioId);
			if (usuariosSeguidos.contains(usuarioDeLaPublicacion)) {
				publicacionesUsuariosSeguidos.add(publicacion);
			}
		}
		return publicacionesUsuariosSeguidos;
	}

	@Override
	public List<Publicacion> devolverUnaListaDePublicacionesPorCategoriasSegidas(List publicaciones, Usuario usuario) {
		List<Publicacion> publicacionesLista = publicaciones;
		List<Categoria> categoriasSeguidas = servicioUsuario.devolverListaDeCategoriasSeguidasPorUsuario(usuario);
		List<Publicacion> publicacionesCategoriasSeguidas = new ArrayList<>();
		for (Publicacion publicacion : publicacionesLista) {
			Categoria categoriaDeLaPublicacion = publicacion.getCategoria();
			for (Categoria categoria : categoriasSeguidas) {
				if (categoria.getId().equals(categoriaDeLaPublicacion.getId())) {
					publicacionesCategoriasSeguidas.add(publicacion);
				}
			}
		}
		return publicacionesCategoriasSeguidas;
	}

	@Override
	public List<Publicacion> devolverUnaListaDePublicacionesHechasPorUnUsuario(Usuario usuario) {
		return repositorioPublicacion.devolverUnaListaDePublicacionesHechasPorUnUsuario(usuario);
	}

	@Override
	public TreeSet<Publicacion> devolverPublicacionesOrdenadasPor(String ordenPublicaciones, Usuario usuario) {
		TreeSet<Publicacion> listaPublicacionesOrdenadas = null;
		switch (ordenPublicaciones) {
		case "popular":
			listaPublicacionesOrdenadas = devolverPublicacionesOdenadasPorLikesYComentarios();
			break;
		case "usuariosSeguidos":
			List<Publicacion> listaPublicacionesPorUsuariosSeguidos = devolverPublicacionesPorUsuariosSeguidos(usuario);
			listaPublicacionesOrdenadas = devolverYOrdenarUnaListaDePublicacionesPorFechaRecienteAAntigua(
					listaPublicacionesPorUsuariosSeguidos);
			break;
		case "categoriasSeguidas":
			List<Publicacion> listaPublicacionesPorCategoriasSeguidas = devolverPublicacionesPorCategoriasSeguidas(
					usuario);
			listaPublicacionesOrdenadas = devolverYOrdenarUnaListaDePublicacionesPorFechaRecienteAAntigua(
					listaPublicacionesPorCategoriasSeguidas);
			break;
		case "hechasPorUsuario":
			List<Publicacion> hechasPorUnUsuario = devolverUnaListaDePublicacionesHechasPorUnUsuario(usuario);
			listaPublicacionesOrdenadas = devolverYOrdenarUnaListaDePublicacionesPorFechaRecienteAAntigua(
					hechasPorUnUsuario);
			break;
		default:
			listaPublicacionesOrdenadas = devolverPublicacionesOdenadasPorFechaRecienteAAntigua();
		}
		return listaPublicacionesOrdenadas;
	}

	@Override
	public TreeSet<Publicacion> ordenarUnaListaDePublicacionesPor(String ordenPublicaciones, List publicacionesList,
			Usuario usuario) {
		TreeSet<Publicacion> listaPublicacionesOrdenadas = null;
		switch (ordenPublicaciones) {
		case "popular":
			listaPublicacionesOrdenadas = devolverYOrdenarUnaListaDePublicacionesPorPopular(publicacionesList);
			break;
		case "usuariosSeguidos":
			List<Publicacion> listaPublicacionesPorUsuariosSeguidos = devolverUnaListaDePublicacionesPorUsuariosSeguidos(
					publicacionesList, usuario);
			listaPublicacionesOrdenadas = devolverYOrdenarUnaListaDePublicacionesPorFechaRecienteAAntigua(
					listaPublicacionesPorUsuariosSeguidos);
			break;
		case "categoriasSeguidas":
			List<Publicacion> listaPublicacionesPorCategoriasSeguidas = devolverUnaListaDePublicacionesPorCategoriasSegidas(
					publicacionesList, usuario);
			listaPublicacionesOrdenadas = devolverYOrdenarUnaListaDePublicacionesPorFechaRecienteAAntigua(
					listaPublicacionesPorCategoriasSeguidas);
			break;
		default:
			listaPublicacionesOrdenadas = devolverYOrdenarUnaListaDePublicacionesPorFechaRecienteAAntigua(
					publicacionesList);
		}
		return listaPublicacionesOrdenadas;
	}

}
