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
import ar.edu.unlam.tallerweb1.modelo.Publicacion;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioComentario;
import ar.edu.unlam.tallerweb1.servicios.ServicioPublicacion;

@Controller
public class ControladorNotificacionPublicacion {
	@Inject
	private ServicioPublicacion servicioPublicacion;
	@Inject
	private ServicioComentario servicioComentario;

	@RequestMapping(path = "/publicacion")
	public ModelAndView irAlHome(@RequestParam(value = "id", required = false) Long id, HttpServletRequest request) {

		ModelMap modelo = new ModelMap();

		Usuario usuarioLogeado = request.getSession().getAttribute("USUARIO") != null
				? (Usuario) request.getSession().getAttribute("USUARIO")
				: null;

		Publicacion publicacion = servicioPublicacion.obtenerPublicacionPorId(id);

		TreeSet<Comentario> comentarios = servicioComentario.devolverListaComentarioPorMasLikes();
		TreeSet<Comentario> respuestas = servicioComentario.devolverListaRespuestaPorMasLikes();

		modelo.put("title", "RageQuit | Publicacion");
		modelo.put("publicacion", publicacion);
		modelo.put("comentarios", comentarios);
		modelo.put("usuarioLogeado", usuarioLogeado);
		modelo.put("comentario", new Comentario());
		modelo.put("respuestas", respuestas);

		return new ModelAndView("notificacionPublicacion", modelo);
	}
}
