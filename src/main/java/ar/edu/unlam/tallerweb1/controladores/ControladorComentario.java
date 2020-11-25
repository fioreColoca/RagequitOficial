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
import ar.edu.unlam.tallerweb1.modelo.Publicacion;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioComentar;
import ar.edu.unlam.tallerweb1.servicios.ServicioLikeComentario; 
import ar.edu.unlam.tallerweb1.servicios.ServicioPublicacion;

@Controller
public class ControladorComentario {

	@Inject
	private ServicioComentar servicioComentario;
	
	@Inject
	private ServicioPublicacion servicioPublicacion;

	@Inject
	private ServicioLikeComentario servicioLikesComentario; 
	/* ---------- Pagina para guardar comentarios ----------- */
	
	@RequestMapping(path = "/guardarComentario", method = RequestMethod.POST)
	public ModelAndView enviarComentario(
			@ModelAttribute("comentario") Comentario comentario, HttpServletRequest request) {
		
		Usuario usuario = request.getSession().getAttribute("USUARIO") != null
				? (Usuario) request.getSession().getAttribute("USUARIO")
				: null;
				
		java.util.Date fecha = new Date();
		comentario.setUsuario(usuario);
		comentario.setCantidadLikes(0);
		comentario.setFechaHora(fecha);
		comentario.setEstado(ComentarioEstado.ACTIVO);
		servicioComentario.tipoComentario("comun", comentario);
		Publicacion publicacion = servicioPublicacion.obtenerPublicacion(comentario.getPublicacionId());
		
		comentario.setPublicacion(publicacion);

		if (comentario.getMensaje().isEmpty() || comentario.getMensaje().substring(0, 1).equals(" ")) { 
			return new ModelAndView("redirect:/home?errorComentarioVacio=true");
		}
		servicioComentario.enviarComentario(comentario);
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
		Boolean resultado = servicioComentario.verificarUsuario(usuarioLogueado,usuarioIngresado.getUsuario());
		if(resultado = true) {
			servicioComentario.borrarComentario(idComentario);
			return new ModelAndView("redirect:/home");
		} 
			String error = "Error inesperado";
			return new ModelAndView("redirect:/home?errorComentario=" + error);
	}

	/* ---------- Pagina para  likear ----------- */
	
	@RequestMapping(path = "/meGustaComentario", method = RequestMethod.GET)
	public ModelAndView darLikeComentario(@RequestParam(value = "botonLike", required = true) Long id,
			 HttpServletRequest request) {
		
		Comentario comentario = servicioComentario.mostrarComentario(id);
		Usuario usuario = request.getSession().getAttribute("USUARIO") != null
				? (Usuario) request.getSession().getAttribute("USUARIO")
				: null;
							
		servicioLikesComentario.darLikeAComentario(comentario, usuario);
		return new ModelAndView("redirect:/home");
	}

	/* ---------- Pagina para responder comentarios ----------- */

	@RequestMapping(path = "/responderComentario", method = RequestMethod.POST)
	public ModelAndView guardarRespuesta(
			@ModelAttribute("comentario") Comentario respuesta, HttpServletRequest request) {

		Usuario usuario = request.getSession().getAttribute("USUARIO") != null
				? (Usuario) request.getSession().getAttribute("USUARIO")
				: null;

		java.util.Date fecha = new Date();
		respuesta.setCantidadLikes(0);
		respuesta.setFechaHora(fecha);
		respuesta.setEstado(ComentarioEstado.ACTIVO);
		respuesta.setUsuario(usuario);
		servicioComentario.tipoComentario("comun", respuesta);

		Comentario comentario = servicioComentario.mostrarComentario(respuesta.getComentarioAResponderId());
		respuesta.setRespuesta(comentario);

		if (respuesta.getMensaje().isEmpty() || respuesta.getMensaje().substring(0, 1).equals(" ")) {
			return new ModelAndView("redirect:/home?errorComentarioVacio=true");
		}

		servicioComentario.enviarComentario(respuesta);
		return new ModelAndView("redirect:/home");
	}
	
	
	/* GETTERS AND SETTERS */
	
	
	public ServicioComentar getServicioComentario() {
		return servicioComentario;
	}

	public void setServicioComentario(ServicioComentar servicioComentario) {
		this.servicioComentario = servicioComentario;
	}
	
	public ServicioPublicacion getServicioPublicacion() {
		return servicioPublicacion;
	}

	public void setServicioPublicacion(ServicioPublicacion servicioPublicacion) {
		this.servicioPublicacion = servicioPublicacion;
	}
	

}
