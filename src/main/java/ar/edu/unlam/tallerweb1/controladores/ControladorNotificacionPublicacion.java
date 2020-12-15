package ar.edu.unlam.tallerweb1.controladores;



import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Publicacion;
import ar.edu.unlam.tallerweb1.servicios.ServicioPublicacion;


@Controller
public class ControladorNotificacionPublicacion {
	@Inject
	private ServicioPublicacion servicioPublicacion;
	
	@RequestMapping(path = "/notificacionPublicacion")
	public ModelAndView irAlHome(@RequestParam(value = "id", required = false) Long id,
			HttpServletRequest request) {
		
		ModelMap modelo = new ModelMap();
		
		Publicacion publicacion = servicioPublicacion.obtenerPublicacionPorId(id);
		
		modelo.put("title", "RageQuit | Publicacion");
		modelo.put("publicacion", publicacion);
		return new ModelAndView("notificacionPublicacion", modelo);
	}
}
