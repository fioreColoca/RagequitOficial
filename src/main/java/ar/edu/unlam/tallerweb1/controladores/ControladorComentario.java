package ar.edu.unlam.tallerweb1.controladores;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Comentario;
import ar.edu.unlam.tallerweb1.modelo.ComentarioEstado;
import ar.edu.unlam.tallerweb1.modelo.Notificacion;
import ar.edu.unlam.tallerweb1.modelo.NotificacionTipo;
import ar.edu.unlam.tallerweb1.modelo.Publicacion;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioComentario;
import ar.edu.unlam.tallerweb1.servicios.ServicioLikeComentario;
import ar.edu.unlam.tallerweb1.servicios.ServicioNotificacion;
import ar.edu.unlam.tallerweb1.servicios.ServicioPublicacion;
import ar.edu.unlam.tallerweb1.servicios.ServicioUsuario;

@Controller
public class ControladorComentario {

	@Inject
	private ServicioComentario servicioComentario;

	@Inject
	private ServicioPublicacion servicioPublicacion;

	@Inject
	private ServicioLikeComentario servicioLikesComentario;

	@Inject
	private ServicioNotificacion servicioNotificacion;

	@Inject
	private ServicioUsuario servicioUsuario;
	/* ---------- Pagina para guardar comentarios ----------- */

	@RequestMapping(path = "/guardarComentario", method = RequestMethod.POST)
	public ModelAndView enviarComentario(@ModelAttribute("comentario") Comentario comentario,
			HttpServletRequest request) {

		Usuario usuario = request.getSession().getAttribute("USUARIO") != null
				? (Usuario) request.getSession().getAttribute("USUARIO")
				: null;

		java.util.Date fecha = new Date();
		comentario.setUsuario(usuario);
		comentario.setCantidadLikes(0);
		comentario.setCantidadRespuesta(0);
		comentario.setFechaHora(fecha);
		comentario.setEstado(ComentarioEstado.ACTIVO);
		Publicacion publicacion = servicioPublicacion.obtenerPublicacionPorId(comentario.getPublicacionId());
		comentario.setPublicacion(publicacion);

		if (comentario.getMensaje().isEmpty() || comentario.getMensaje().substring(0, 1).equals(" ")) {
			return new ModelAndView("redirect:/home?errorComentarioVacio=true");
		}

		servicioUsuario.aumentarCantidadNotificacionesDeUsuario(publicacion.getUsuario());
		servicioComentario.guardarComentario(comentario);

		Notificacion notificacion = new Notificacion();
		notificacion.setComentarioDePublicacion(publicacion);
		notificacion.setUsuarioOtorgadorNotifi(usuario);
		notificacion.setUsuarioRecibidorNotifi(publicacion.getUsuario());
		notificacion.setTipo(NotificacionTipo.COMENTARIOPUBLICACION);
		notificacion.setComentario(comentario);
		notificacion.setVisto(false);
		servicioNotificacion.guardarNotificacion(notificacion);

		return new ModelAndView("redirect:/home");

	}

	/* ---------- Pagina para borrar comentarios ----------- */

	@RequestMapping(path = "/borrarComentario")
	public ModelAndView eliminarComentario(@RequestParam(value = "botonBorrar", required = true) Long idComentario,
			HttpServletRequest request) {

		Usuario usuarioLogueado = request.getSession().getAttribute("USUARIO") != null
				? (Usuario) request.getSession().getAttribute("USUARIO")
				: null;

		Comentario usuarioIngresado = servicioComentario.mostrarComentario(idComentario);
		Boolean resultado = servicioComentario.verificarUsuario(usuarioLogueado, usuarioIngresado.getUsuario());
		if (resultado = true) {
			servicioComentario.borrarComentario(idComentario);
			return new ModelAndView("redirect:/home");
		}
		String error = "Error inesperado";
		return new ModelAndView("redirect:/home?errorComentario=" + error);
	}

	/* ---------- Pagina para likear ----------- */

	@RequestMapping(path = "/meGustaComentario", method = RequestMethod.GET)
	public ModelAndView darLikeComentario(@RequestParam(value = "botonLike", required = true) Long id,
			HttpServletRequest request) {

		Comentario comentario = servicioComentario.mostrarComentario(id);
		Usuario usuario = request.getSession().getAttribute("USUARIO") != null
				? (Usuario) request.getSession().getAttribute("USUARIO")
				: null;

		Notificacion notificacion = new Notificacion();
		notificacion.setComentarioLike(comentario);
		notificacion.setUsuarioOtorgadorNotifi(usuario);
		notificacion.setUsuarioRecibidorNotifi(comentario.getUsuario());
		notificacion.setTipo(NotificacionTipo.LIKECOMENTARIO);
		notificacion.setVisto(false);
		servicioNotificacion.guardarNotificacion(notificacion);
		servicioLikesComentario.darLikeAComentario(comentario, usuario);
		servicioUsuario.aumentarCantidadNotificacionesDeUsuario(comentario.getUsuario());

		return new ModelAndView("redirect:/home");
	}

	/* ---------- Pagina para responder comentarios ----------- */

	@RequestMapping(path = "/responderComentario", method = RequestMethod.POST)
	public ModelAndView guardarRespuesta(@ModelAttribute("comentario") Comentario respuesta,
			HttpServletRequest request) {

		Usuario usuario = request.getSession().getAttribute("USUARIO") != null
				? (Usuario) request.getSession().getAttribute("USUARIO")
				: null;

		java.util.Date fecha = new Date();
		respuesta.setCantidadLikes(0);
		respuesta.setFechaHora(fecha);
		respuesta.setEstado(ComentarioEstado.ACTIVO);
		respuesta.setUsuario(usuario);

		Comentario comentario = servicioComentario.mostrarComentario(respuesta.getComentarioAResponderId());
		respuesta.setRespuesta(comentario);

		if (respuesta.getMensaje().isEmpty() || respuesta.getMensaje().substring(0, 1).equals(" ")) {
			return new ModelAndView("redirect:/home?errorComentarioVacio=true");
		}

		servicioComentario.guardarComentario(respuesta);
		servicioUsuario.aumentarCantidadNotificacionesDeUsuario(comentario.getUsuario());
		Notificacion notificacion = new Notificacion();
		notificacion.setRespuestaDeComentario(comentario);
		notificacion.setUsuarioOtorgadorNotifi(usuario);
		notificacion.setUsuarioRecibidorNotifi(comentario.getUsuario());
		notificacion.setTipo(NotificacionTipo.COMENTARIOCOMENTARIO);
		notificacion.setVisto(false);
		notificacion.setComentario(respuesta);
		servicioNotificacion.guardarNotificacion(notificacion);

		return new ModelAndView("redirect:/home");
	}

	/* GETTERS AND SETTERS */

	public ServicioComentario getServicioComentario() {
		return servicioComentario;
	}

	public void setServicioComentario(ServicioComentario servicioComentario) {
		this.servicioComentario = servicioComentario;
	}

	public ServicioPublicacion getServicioPublicacion() {
		return servicioPublicacion;
	}

	public void setServicioPublicacion(ServicioPublicacion servicioPublicacion) {
		this.servicioPublicacion = servicioPublicacion;
	}

}
