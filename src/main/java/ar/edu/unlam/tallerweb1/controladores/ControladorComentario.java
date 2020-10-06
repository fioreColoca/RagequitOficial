package ar.edu.unlam.tallerweb1.controladores;

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
	
	@RequestMapping(path="/Comentario")
	public ModelAndView comentar() {
		return new ModelAndView("comentarioEscribir");
	}
	
	
	@RequestMapping(path="/VerComentario", method = RequestMethod.GET)
	public ModelAndView enviarComentario(
			@RequestParam(value="comentarioMandar",required = true) String comentarioMensaje) {
					
		Comentario comentario= new Comentario();
		comentario.setMensaje(comentarioMensaje);
		comentario.setCantidadLikes(0);
		/*comentario.setCantidadLikes(cantidadLikes);*/
		
		Long idComentario = servicioComentario.enviarComentario(comentario);
		ModelMap modelo = new ModelMap();
		modelo.put("idpublicacion", idComentario);
		modelo.put("comentario",comentario);
		
		return new ModelAndView("comentarioEscribir",modelo);
	}
	
	

}
