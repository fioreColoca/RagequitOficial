package ar.edu.unlam.tallerweb1.controladores;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.excepciones.comentarioVacioException;
import ar.edu.unlam.tallerweb1.modelo.Comentario;
import ar.edu.unlam.tallerweb1.servicios.ServicioComentar;

@Controller
public class ControladorComentario {

	@Inject
	private ServicioComentar servicioComentario;

	/* ---------- Pagina para comentar ----------- */
	@RequestMapping(path = "/comentario")
	public ModelAndView comentar() {
		return new ModelAndView("comentarioEscribir");
	}
	

	/* ---------- Pagina para imprimir comentarios ----------- */
	@RequestMapping(path = "/comentarioVisualizacion")
	public ModelAndView verComentario() {
		Comentario comentario = new Comentario();
		ModelMap modelo = new ModelMap();
		List<Comentario> comentarios = servicioComentario.mostrarTodosLosComentarios();

		modelo.put("comentarios", comentarios);
		modelo.put("comentario", comentario);
		
		return new ModelAndView("comentarioVer", modelo);
	}
	

	/* ---------- Pagina para guardar comentarios ----------- */
	@RequestMapping(path = "/verComentario", method = RequestMethod.POST)
	public ModelAndView enviarComentario(
			@RequestParam(value = "comentarioMandar", required = true) String comentarioMensaje,
			@RequestParam(value = "boton", required = true) String tipoBoton) throws comentarioVacioException {

		java.util.Date fecha = new Date();
		Comentario comentario = new Comentario();
		comentario.setCantidadLikes(0);
		comentario.setFechaHora(fecha);
		comentario.setMensaje(comentarioMensaje);
		Integer anio = servicioComentario.devolverAnio(comentario);
		servicioComentario.tipoComentario(tipoBoton, comentario);
		ModelMap modelo = new ModelMap();
		modelo.put("comentario", comentario);
		modelo.put("anio", anio);

		try {
			servicioComentario.enviarComentario(comentario);
		} catch (comentarioVacioException e) {
			String error = e.getMessage();
			modelo.put("error", error);
			return new ModelAndView("redirect:/comentario", modelo);
		}
		return new ModelAndView("redirect:/comentarioVisualizacion", modelo);


	}

	
	/* ---------- Pagina para borrar comentarios ----------- */

	@RequestMapping(path = "/borrarComentario")
	public ModelAndView eliminarComentario(@RequestParam(value = "botonBorrar", required = true) Long idComentario) {

		servicioComentario.borrarComentario(idComentario);
		return new ModelAndView("redirect:/comentarioVisualizacion");
	}
	
	
	/* ---------- Pagina para borrar likear ----------- */
	@RequestMapping(path = "/meGustaComentario", method = RequestMethod.POST)
	public ModelAndView darLikeComentario(@RequestParam(value = "botonLike", required = true) Long idLike) {

		servicioComentario.darLikeComentario(idLike);
		return new ModelAndView("redirect:/comentarioVisualizacion");
	}
	

	/* ---------- Pagina para responder comentarios ----------- */
	@RequestMapping(path = "/comentarioMandar", method = RequestMethod.POST)
	public ModelAndView responderComentario(@RequestParam(value = "idComentario", required = true) Long idComentario,
			@RequestParam(value = "respuestaMandar", required = true) String comentarioMensaje,
			@RequestParam(value = "boton", required = true) String boton) throws comentarioVacioException {

		java.util.Date fecha = new Date();

		Comentario respuesta = new Comentario();
		Comentario comentario = servicioComentario.mostrarComentario(idComentario);
		servicioComentario.enviarComentario(respuesta);

		respuesta.setMensaje(comentarioMensaje);
		respuesta.setCantidadLikes(0);
		respuesta.setFechaHora(fecha);

		String direccion = "comentarioEscribir";
		try {
			servicioComentario.enviarComentario(comentario);
			direccion = "comentarioVer";
		} catch (comentarioVacioException e) {
			String error = e.getMessage();
			direccion = "comentarioEscribir";
		}

		servicioComentario.tipoComentario(boton, respuesta);
		servicioComentario.enviarComentario(respuesta);
		respuesta.setRespuesta(comentario);

		/*
		 * List<Comentario> respuestaListado =
		 * servicioComentario.respuestaListado(comentario);
		 */
		ModelMap modelo = new ModelMap();
		modelo.put("respuesta", respuesta);
		return new ModelAndView(direccion, modelo);

		/* no funciona todavia uhmm */

	}

	/*
	 * @RequestMapping(path="/mostrarRespuesta") public ModelAndView respuesta() {
	 * return new ModelAndView("comentarioEscribir"); }
	 */

}
