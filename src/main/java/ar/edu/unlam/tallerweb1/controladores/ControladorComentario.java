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

import ar.edu.unlam.tallerweb1.modelo.Comentario;
import ar.edu.unlam.tallerweb1.servicios.ServicioComentar;


@Controller
public class ControladorComentario {
	
	@Inject
	private ServicioComentar servicioComentario;
	
	
	@RequestMapping(path="/comentario")
	public ModelAndView comentar() {
		return new ModelAndView("comentarioEscribir");
	}
	
	
	@RequestMapping(path="/verComentario", method = RequestMethod.GET)
	public ModelAndView enviarComentario(
			@RequestParam(value="comentarioMandar",required = true)String comentarioMensaje,
			@RequestParam(value="boton",required = true)String tipoBoton){
		
		java.util.Date fecha = new Date(); /* DATE DE JAVA NO DE SQL, NO SE COMO LO TRABAJARA SQL*/
					
		Comentario comentario= new Comentario();
		comentario.setMensaje(comentarioMensaje);
		comentario.setCantidadLikes(0);
		comentario.setFechaHora(fecha);
		servicioComentario.tipoComentario(tipoBoton, comentario);
		/*comentario.setCantidadLikes(cantidadLikes);*/
		Long id = comentario.getId();
		
		
		Long idComentario = servicioComentario.enviarComentario(comentario);
		
		List<Comentario>comentarios = servicioComentario.mostrarTodosLosComentarios();
		/*Comentario mostrarComentario = servicioComentario.mostrarComentario(id);*/
		
		ModelMap modelo = new ModelMap();
		modelo.put("comentarios",comentarios);
		modelo.put("comentario",comentario);

		
		return new ModelAndView("comentarioVer",modelo);
	}
		
	
	@RequestMapping(path="/borrarComentario")
	public ModelAndView eliminarComentario(
			@RequestParam(value="botonBorrar",required = true)Long idComentario) {
		
		servicioComentario.borrarComentario(idComentario);
		return new ModelAndView("redirect:/comentario");
	}
	
	
	@RequestMapping(path="/meGustaComentario")
	public ModelAndView darLikeComentario(
		@RequestParam(value="botonLike",required = true)Long idLike) {
		
		
		servicioComentario.darLikeComentario(idLike);
		Comentario comentario =servicioComentario.mostrarComentario(idLike);
		List<Comentario>comentarios = servicioComentario.mostrarTodosLosComentarios();

		ModelMap modelo = new ModelMap();
		modelo.put("comentarios",comentarios);
		modelo.put("comentario",comentario);
		
		return new ModelAndView("comentarioVer",modelo);
	}
	
	
	/*@RequestMapping(path="/mostrarRespuesta")
	public ModelAndView respuesta() {
		return new ModelAndView("comentarioEscribir");
	}*/

}
