package ar.edu.unlam.tallerweb1.controladores;

import java.util.Date;
import java.util.List;
import java.util.TreeSet;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import ar.edu.unlam.tallerweb1.modelo.Categoria;
import ar.edu.unlam.tallerweb1.modelo.Comentario;
import ar.edu.unlam.tallerweb1.modelo.Publicacion;
import ar.edu.unlam.tallerweb1.modelo.PublicacionEstado;
import ar.edu.unlam.tallerweb1.modelo.Seguir;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioCategoria;
import ar.edu.unlam.tallerweb1.servicios.ServicioLikePublicacion;
import ar.edu.unlam.tallerweb1.servicios.ServicioComentario;
import ar.edu.unlam.tallerweb1.servicios.ServicioLikeComentario;
import ar.edu.unlam.tallerweb1.servicios.ServicioPublicacion;
import ar.edu.unlam.tallerweb1.servicios.ServicioSeguir;

@Controller
public class ControladorPublicacion {

	@Inject
	private ServicioPublicacion servicioPublicacion;
	@Inject
	private ServicioCategoria servicioCategoria;
	@Inject
	private ServicioComentario servicioComentario;
	@Inject
	private ServicioLikePublicacion servicioLike;
	@Inject
	private ServicioSeguir servicioSeguir;

	@RequestMapping(path = "home")
	public ModelAndView irAlHome(@RequestParam(value = "categoriaAMostrar", required = false) Long categoriaAMostrar,
			@RequestParam(value = "ordenPublicaciones", required = false) String ordenPublicaciones,
			@RequestParam(value = "errorComentarioVacio", required = false) String errorComentarioVacio,
			@RequestParam(value = "errorBorrarPublicacion", required = false) String errorBorrarPublicacion,
			HttpServletRequest request) {
		ModelMap modelo = new ModelMap();
		TreeSet<Publicacion> publicaciones = new TreeSet<>();

		ordenPublicaciones = ordenPublicaciones == null ? "ordenFechaRecienteAAntigua" : ordenPublicaciones;

		Usuario usuarioLogeado = request.getSession().getAttribute("USUARIO") != null
				? (Usuario) request.getSession().getAttribute("USUARIO")
				: null;

		if (categoriaAMostrar == null) {
			publicaciones = servicioPublicacion.devolverPublicacionesOrdenadasPor(ordenPublicaciones, usuarioLogeado);
		} else if (!(categoriaAMostrar == null)) {
			Categoria categoria = servicioCategoria.mostrarCategoriaPorId(categoriaAMostrar);
			List publicacionesList = servicioPublicacion.buscarPublicacionesPorCategoria(categoria);

			publicaciones = servicioPublicacion.ordenarUnaListaDePublicacionesPor(ordenPublicaciones, publicacionesList,
					usuarioLogeado);
		}

		List<Seguir> seguimientos = servicioSeguir.devolverListaDeSeguimientos();
		List<Categoria> categorias = servicioCategoria.mostrarCategorias();
		TreeSet<Comentario> comentarios = servicioComentario.devolverListaComentarioPorMasLikes();
		TreeSet<Comentario> respuestas = servicioComentario.devolverListaRespuestaPorMasLikes();

		modelo.put("title", "RageQuit | Inicio");
		modelo.put("publicaciones", publicaciones);
		modelo.put("categorias", categorias);
		modelo.put("ordenPublicaciones", ordenPublicaciones);
		modelo.put("comentario", new Comentario());
		modelo.put("comentarios", comentarios);
		modelo.put("respuestas", respuestas);
		modelo.put("usuarioLogeado", usuarioLogeado);
		modelo.put("errorComentarioVacio", errorComentarioVacio);
		modelo.put("errorBorrarPublicacion", errorBorrarPublicacion);
		modelo.put("seguimientos", seguimientos);

		return new ModelAndView("home", modelo);
	}

	@RequestMapping(path = "/guardarPublicacion", produces = "application/json", method = RequestMethod.POST)
	@ResponseBody
	public String guardarPublicacion(@RequestParam(value = "categoriaId", required = false) Long categoriaId,
			@RequestParam(value = "mensaje", required = false) String mensaje, HttpServletRequest request) {
		Date fecha = new Date();
		Gson gson = new Gson();
		JsonObject json = new JsonObject();

		Publicacion publicacion = new Publicacion();
		Usuario usuario = request.getSession().getAttribute("USUARIO") != null
				? (Usuario) request.getSession().getAttribute("USUARIO")
				: null;

		Boolean errorCategoria = false;
		Boolean errorMensaje = false;
		if (categoriaId == -1) {
			errorCategoria = true;
		} else {
			Categoria categoria = servicioCategoria.mostrarCategoriaPorId(categoriaId);
			publicacion.setCategoria(categoria);
		}

		if (mensaje.isEmpty()) {
			errorMensaje = true;
		}
		json.addProperty("mensajeVacio", errorMensaje);
		json.addProperty("categoriaVacia", errorCategoria);
		if (errorCategoria == false && errorMensaje == false) {
			publicacion.setUsuario(usuario);
			publicacion.setFechaHora(fecha);
			publicacion.setCantidadLikes(0);
			publicacion.setCantidadComentarios(0);
			publicacion.setEstado(PublicacionEstado.ACTIVO);
			publicacion.setMensaje(mensaje);
			servicioPublicacion.guardarPublicacion(publicacion);
			json.addProperty("publicacion", gson.toJson(publicacion));
			return gson.toJson(json);
		}

		return gson.toJson(json);
	}

	@RequestMapping(path = "/borrarPublicacion", method = RequestMethod.POST)
	public ModelAndView borrarPublicacion(@RequestParam(value = "botonBorrar", required = false) Long id,
			HttpServletRequest request) {
		Usuario UsuarioQuePidioBorrarPublicacion = (Usuario) request.getSession().getAttribute("USUARIO");
		Long idUsuarioQuePidioBorrarPublicacion = UsuarioQuePidioBorrarPublicacion.getId();
		Publicacion publicacionABorrar = servicioPublicacion.obtenerPublicacionPorId(id);
		Long idUsuarioQueCreoLaPublicacion = publicacionABorrar.getUsuario().getId();

		if (!idUsuarioQuePidioBorrarPublicacion.equals(idUsuarioQueCreoLaPublicacion)) {
			return new ModelAndView("redirect:/home?errorBorrarPublicacion=true");
		}

		servicioPublicacion.borrarPublicacion(id);

		return new ModelAndView("redirect:/home?errorBorrarPublicacion=false");
	}

	@RequestMapping(path = "/filtrarCategoria", method = RequestMethod.GET)
	public ModelAndView filtrarPublicacion(
			@RequestParam(value = "ordenPublicaciones", required = false) String ordenPublicaciones,
			@RequestParam(value = "filtarPublicacionCategoria", required = false) Long idCategoria) {

		if (!(idCategoria == -1)) {
			Long categoriaAMostrar = null;
			categoriaAMostrar = idCategoria;
			return new ModelAndView("redirect:/home?categoriaAMostrar=" + categoriaAMostrar + "&ordenPublicaciones="
					+ ordenPublicaciones);
		}

		return new ModelAndView("redirect:/home?ordenPublicaciones=" + ordenPublicaciones);
	}

	@RequestMapping(path = "/darLikePublicacion", produces = "application/json", method = RequestMethod.POST)
	@ResponseBody
	public String darLikePublicacion(@RequestParam(value = "idPublicacionADarLike", required = false) Long id,
			HttpServletRequest request) {
		Gson gson = new Gson();
		JsonObject json = new JsonObject();
		Publicacion publicacion = servicioPublicacion.obtenerPublicacionPorId(id);
		Usuario usuario = request.getSession().getAttribute("USUARIO") != null
				? (Usuario) request.getSession().getAttribute("USUARIO")
				: null;
		servicioLike.darLikeAPublicacion(publicacion, usuario);

		Publicacion publicacionQueCambioLosLikes = servicioPublicacion.obtenerPublicacionPorId(id);
		Integer cantidadLikes = publicacionQueCambioLosLikes.getCantidadLikes();
		json.addProperty("cantidadLikesPublicacion", cantidadLikes);
		json.addProperty("idPublicacion", id);
		return gson.toJson(json);
	}

	public ServicioCategoria getServicioCategoria() {
		return servicioCategoria;
	}

	public void setServicioCategoria(ServicioCategoria servicioCategoria) {
		this.servicioCategoria = servicioCategoria;
	}

	public ServicioPublicacion getServicioPublicacion() {
		return servicioPublicacion;
	}

	public void setServicioPublicacion(ServicioPublicacion servicioPublicacion) {
		this.servicioPublicacion = servicioPublicacion;
	}

}
