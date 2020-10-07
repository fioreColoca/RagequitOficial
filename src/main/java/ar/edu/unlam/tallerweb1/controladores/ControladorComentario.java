package ar.edu.unlam.tallerweb1.controladores;

import java.util.Date;

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
			@RequestParam(value="comentarioMandar",required = true) String comentarioMensaje) {
		
		java.util.Date fecha = new Date(); /* DATE DE JAVA NO DE SQL, NO SE COMO LO TRABAJARA SQL*/
					
		Comentario comentario= new Comentario();
		comentario.setMensaje(comentarioMensaje);
		comentario.setCantidadLikes(0);
		comentario.setFechaHora(fecha);
		/*comentario.setCantidadLikes(cantidadLikes);*/
		Long id = comentario.getId();
		
		Long idComentario = servicioComentario.enviarComentario(comentario);
		/*Comentario mostrarComentario = servicioComentario.mostrarComentario(id);*/
		
		ModelMap modelo = new ModelMap();
		modelo.put("comentario",comentario);
		
		return new ModelAndView("comentarioVer",modelo);
	}
	
	
	@RequestMapping(path="/borrarComentario")
	public ModelAndView eliminarComentario() {
		
		Long id = (long) 1;
		servicioComentario.borrarComentario(id);
		return new ModelAndView("comentarioVer");
	}
	
	
	@RequestMapping(path="/meGustaComentario")
	public ModelAndView darLikeComentario() {
		Long id = (long) 1;
		servicioComentario.darLikeComentario(id);
		return new ModelAndView("comentarioVer");
	}
	
	
	/*@RequestMapping(path="/mostrarRespuesta")
	public ModelAndView respuesta() {
		return new ModelAndView("comentarioEscribir");
	}*/

}
