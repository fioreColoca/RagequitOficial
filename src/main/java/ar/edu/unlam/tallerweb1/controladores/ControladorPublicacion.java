package ar.edu.unlam.tallerweb1.controladores;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Publicacion;
@Controller
public class ControladorPublicacion {
	
	@Inject
	private ServicioPublicacion servicioPublicacion;

	@RequestMapping(path="/registrarPublicacion")
	public ModelAndView registrarPublicacion() {
		return new ModelAndView("publicacionRegistrar");
	}
	
	@RequestMapping(path= "/confirmacionRegistroPublicacion", method = RequestMethod.GET)
	public ModelAndView confirmacionPublicacion(
			/*@RequestParam(value = "nombreCampeon", required = false) String nombreCampeon,
			@RequestParam(value = "rolCampeon", required = false) String rolCampeon*/
			) {
		Publicacion publicacion = new Publicacion();
		ModelMap modelo = new ModelMap();
		
		
		Long idpublicacion = servicioPublicacion.guardarPublicacion(publicacion);
		
		modelo.put("idpublicacion", idpublicacion);
		
		
		
		return new ModelAndView("publicacionRegistradaConfirmacion", modelo);
	}
}	
