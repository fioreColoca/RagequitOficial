package ar.edu.unlam.tallerweb1.controladores;

import java.util.TreeSet;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Comentario;
import ar.edu.unlam.tallerweb1.modelo.Notificacion;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioComentario;
import ar.edu.unlam.tallerweb1.servicios.ServicioNotificacion;

@Controller
public class ControladorNotificacionComentario {

	@Inject
	private ServicioComentario servicioComentario;
	@Inject
	private ServicioNotificacion servicioNotificacion;

	@RequestMapping(path = "/comentario")
	public ModelAndView comentario(@RequestParam(value = "id", required = false) Long id, HttpServletRequest request) {

		ModelMap modelo = new ModelMap();

		Usuario usuarioLogeado = request.getSession().getAttribute("USUARIO") != null
				? (Usuario) request.getSession().getAttribute("USUARIO")
				: null;

		Notificacion notificacion = servicioNotificacion.obtenerNotificacionPorId(id);
		if (notificacion == null) {
			return new ModelAndView("redirect:/home", modelo);
		}
		Comentario comentario = servicioComentario.mostrarComentario(notificacion.getComentario().getId());

		if (comentario == null) {
			return new ModelAndView("redirect:/home", modelo);
		}

		if (notificacion.getUsuarioRecibidorNotifi().getId() != usuarioLogeado.getId()) {
			return new ModelAndView("redirect:/home", modelo);
		}
		if (notificacion.getRespuestaDeComentario() == null) {
			TreeSet<Comentario> respuestas = servicioComentario.devolverListaRespuestaPorMasLikes();

			modelo.put("title", "RageQuit | Comentario");
			modelo.put("comentario", comentario);
			modelo.put("usuarioLogeado", usuarioLogeado);
			modelo.put("respuestas", respuestas);

			return new ModelAndView("notificacionComentario", modelo);
		} else {
			Comentario respuesta = notificacion.getRespuestaDeComentario();
			modelo.put("title", "RageQuit | Respuesta");
			modelo.put("respuesta", comentario);
			modelo.put("usuarioLogeado", usuarioLogeado);
			modelo.put("comentario", respuesta);
			return new ModelAndView("notificacionRespuesta", modelo);
		}

	}

	@RequestMapping(path = "/comentarioLike")
	public ModelAndView comentarioLike(@RequestParam(value = "id", required = false) Long id,
			HttpServletRequest request) {

		ModelMap modelo = new ModelMap();

		Usuario usuarioLogeado = request.getSession().getAttribute("USUARIO") != null
				? (Usuario) request.getSession().getAttribute("USUARIO")
				: null;

		Notificacion notificacion = servicioNotificacion.obtenerNotificacionPorId(id);
		if (notificacion == null) {
			return new ModelAndView("redirect:/home", modelo);
		}
		Comentario comentario = servicioComentario.mostrarComentario(notificacion.getComentarioLike().getId());

		if (comentario == null) {
			return new ModelAndView("redirect:/home", modelo);
		}

		if (notificacion.getUsuarioRecibidorNotifi().getId() != usuarioLogeado.getId()) {
			return new ModelAndView("redirect:/home", modelo);
		}

		TreeSet<Comentario> respuestas = servicioComentario.devolverListaRespuestaPorMasLikes();

		modelo.put("title", "RageQuit | Comentario");
		modelo.put("comentario", comentario);
		modelo.put("usuarioLogeado", usuarioLogeado);
		modelo.put("respuestas", respuestas);

		return new ModelAndView("notificacionComentario", modelo);

	}

}
