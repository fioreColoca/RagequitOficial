package ar.edu.unlam.tallerweb1.controladores;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Publicacion;
import ar.edu.unlam.tallerweb1.servicios.ServicioPublicacion;
@Controller
public class ControladorPublicacion {
	
	@Inject
	private ServicioPublicacion servicioPublicacion;

	@RequestMapping(path="/registrarPublicacion")
	public ModelAndView registrarPublicacion() {
		ModelMap modelo = new ModelMap();
		
		modelo.put("title","Publicar");
		return new ModelAndView("publicacionRegistrar", modelo);
	}
	
	@RequestMapping(path= "/confirmacionRegistroPublicacion", method = RequestMethod.GET)
	public ModelAndView confirmacionPublicacion(
			@RequestParam(value = "mensajePublicacion", required = false) String mensajePublicacion,
			@RequestParam(value = "categoriaPublicacion", required = false) String categoriaPublicacion
			) {
		Publicacion publicacion = new Publicacion();
		ModelMap modelo = new ModelMap();
		
		publicacion.setMensaje(mensajePublicacion);
		
		Long idpublicacion = servicioPublicacion.guardarPublicacion(publicacion);
		
		modelo.put("title","Publicaci&oacute;n");
		modelo.put("idpublicacion", idpublicacion);
		modelo.put("publicacion",publicacion);
		
		modelo.put("categoria", categoriaPublicacion);
		
		return new ModelAndView("publicacionRegistradaConfirmacion", modelo);
	}
}	
