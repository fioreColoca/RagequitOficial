package ar.edu.unlam.tallerweb1.controladores;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Comentario;
import ar.edu.unlam.tallerweb1.modelo.ComentarioEstado;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioComentar;
import ar.edu.unlam.tallerweb1.servicios.ServicioUsuario;

@Controller
public class ControladorComentario {

	@Inject
	private ServicioComentar servicioComentario;

	@Inject
	private ServicioUsuario servicioUsuario;

	/* ---------- Pagina para comentar ----------- */
	@RequestMapping(path = "/comentario")
	public ModelAndView comentar(HttpServletRequest request) {
		String rol = request.getSession().getAttribute("ROL") != null
				? (String) request.getSession().getAttribute("ROL")
				: "";
		String nombreUsuario = request.getSession().getAttribute("NOMBREUSUARIO") != null

				? (String) request.getSession().getAttribute("NOMBREUSUARIO")

				: "";
		String url_imagen = request.getSession().getAttribute("URLIMAGEN") != null

				? (String) request.getSession().getAttribute("URLIMAGEN")

				: "";

		if (request.getSession().getAttribute("ROL") != null) {
			ModelMap modelo = new ModelMap();
			modelo.put("title", "RageQuit | Comentarios");
			modelo.put("usuarioRol", rol);
			modelo.put("url_imagen", url_imagen);
			modelo.put("nombreUsuario", nombreUsuario);

			return new ModelAndView("comentarioEscribir", modelo);
		}
		return new ModelAndView("redirect:/login");
	}

	/* ---------- Pagina para imprimir comentarios ----------- */
	@RequestMapping(path = "/comentarioVisualizacion")
	public ModelAndView verComentario(HttpServletRequest request,
			@RequestParam(value = "nombreUsuario", required = false) String usuarioNombre

	) {
		String rol = request.getSession().getAttribute("ROL") != null
				? (String) request.getSession().getAttribute("ROL")
				: "";
		String nombreUsuario = request.getSession().getAttribute("NOMBREUSUARIO") != null
				? (String) request.getSession().getAttribute("NOMBREUSUARIO")
				: "";

		String url_imagen = request.getSession().getAttribute("URLIMAGEN") != null

				? (String) request.getSession().getAttribute("URLIMAGEN")

				: "";

		Long usuarioId = request.getSession().getAttribute("ID") != null
				? (Long) request.getSession().getAttribute("ID")
				: null;

		Comentario comentario = new Comentario();
		ModelMap modelo = new ModelMap();
		modelo.put("usuarioRol", rol);
		modelo.put("nombreUsuario", nombreUsuario);

		modelo.put("url_imagen", url_imagen);

		modelo.put("usuarioId", usuarioId);

		List<Comentario> comentarios = servicioComentario.mostrarTodosLosComentarios();
		if (comentarios.isEmpty()) {
			return new ModelAndView("redirect:/comentario", modelo);
		}
		modelo.put("comentarios", comentarios);
		modelo.put("comentario", comentario);
		modelo.put("title", "RageQuit | Comentarios Hechos");

		return new ModelAndView("comentarioVer", modelo);
	}

	/* ---------- Pagina para guardar comentarios ----------- */
	@RequestMapping(path = "/guardarComentario", method = RequestMethod.GET)
	public ModelAndView enviarComentario(
			@RequestParam(value = "comentarioMandar", required = true) String comentarioMensaje,
			@RequestParam(value = "boton", required = true) String tipoBoton, HttpServletRequest request) {
		Usuario usuario = request.getSession().getAttribute("USUARIO") != null
				? (Usuario) request.getSession().getAttribute("USUARIO")
				: null;
		java.util.Date fecha = new Date();
		Comentario comentario = new Comentario();
		comentario.setUsuario(usuario);
		comentario.setCantidadLikes(0);
		comentario.setFechaHora(fecha);
		comentario.setMensaje(comentarioMensaje);
		comentario.setEstado(ComentarioEstado.ACTIVO);
		servicioComentario.tipoComentario(tipoBoton, comentario);

		if (comentario.getMensaje().isEmpty() || comentario.getMensaje().substring(0, 1).equals(" ")) {
			return new ModelAndView("redirect:/comentario");
		}
		servicioComentario.enviarComentario(comentario);
		return new ModelAndView("redirect:/comentarioVisualizacion");

	}

	/* ---------- Pagina para borrar comentarios ----------- */

	@RequestMapping(path = "/borrarComentario")
	public ModelAndView eliminarComentario(@RequestParam(value = "botonBorrar", required = true) Long idComentario) {

		servicioComentario.borrarComentario(idComentario);
		return new ModelAndView("redirect:/comentarioVisualizacion");
	}

	/* ---------- Pagina para borrar likear ----------- */
	@RequestMapping(path = "/meGustaComentario", method = RequestMethod.GET)
	public ModelAndView darLikeComentario(@RequestParam(value = "botonLike", required = true) Long idLike) {

		servicioComentario.darLikeComentario(idLike);
		return new ModelAndView("redirect:/comentarioVisualizacion");
	}

	/* ---------- Pagina para responder comentarios ----------- */
	@RequestMapping(path = "/responderComentario", method = RequestMethod.GET)
	public ModelAndView guardarRespuesta(
			@RequestParam(value = "respuestaMandar", required = true) String respuestaMensaje,
			@RequestParam(value = "idComentario", required = true) Long idComentario,
			@RequestParam(value = "boton", required = true) String tipoBoton, HttpServletRequest request) {

		Usuario usuario = request.getSession().getAttribute("USUARIO") != null
				? (Usuario) request.getSession().getAttribute("USUARIO")
				: null;

		java.util.Date fecha = new Date();
		Comentario respuesta = new Comentario();
		respuesta.setCantidadLikes(0);
		respuesta.setFechaHora(fecha);
		respuesta.setMensaje(respuestaMensaje);
		respuesta.setEstado(ComentarioEstado.ACTIVO);
		respuesta.setUsuario(usuario);
		servicioComentario.tipoComentario(tipoBoton, respuesta);

		Comentario comentario = servicioComentario.mostrarComentario(idComentario);
		respuesta.setRespuesta(comentario);

		if (respuesta.getMensaje().isEmpty() || respuesta.getMensaje().substring(0, 1).equals(" ")) {
			return new ModelAndView("redirect:/comentario");
		}

		servicioComentario.enviarComentario(respuesta);
		return new ModelAndView("redirect:/comentarioVisualizacion");
	}

}
