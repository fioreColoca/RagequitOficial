package ar.edu.unlam.tallerweb1.controladores;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.excepciones.publicacionVaciaException;
import ar.edu.unlam.tallerweb1.modelo.Publicacion;
import ar.edu.unlam.tallerweb1.servicios.ServicioPublicacion;

@Controller
public class ControladorPublicacion {

	@Inject
	private ServicioPublicacion servicioPublicacion;

	@RequestMapping(path = "home")
	public ModelAndView irAlHome() {
		ModelMap modelo = new ModelMap();
		Publicacion publicacion = new Publicacion();
		List<Publicacion> publicaciones = servicioPublicacion.buscarPublicaciones();
		modelo.put("title", "Inicio");
		modelo.put("publicaciones", publicaciones);
		modelo.put("publicacion", publicacion);
		
		return new ModelAndView("home", modelo);
	}

	@RequestMapping(path = "/guardarPublicacion", method = RequestMethod.POST)
	public ModelAndView guardarPublicacion(@ModelAttribute("publicacion") Publicacion publicacion) {
		Date fecha = new Date();
		ModelMap modelo = new ModelMap();
		publicacion.setFechaHora(fecha);

		try {
			servicioPublicacion.guardarPublicacion(publicacion);
		} catch (publicacionVaciaException e) {
			String error = e.getMessage();
			
			List<Publicacion> publicaciones = servicioPublicacion.buscarPublicaciones();
			modelo.put("title", "Inicio");
			modelo.put("publicaciones", publicaciones);
			modelo.put("publicacion", publicacion);
			
			modelo.put("errorCategoriaVacia", error);
			return new ModelAndView("home", modelo);
		}
		
		return new ModelAndView("redirect:/home", modelo);
	}

	@RequestMapping(path = "/borrarPublicacion", method = RequestMethod.GET)
	public ModelAndView borrarPublicacion(
			@RequestParam(value = "botonBorrar", required = false) Long id){
		servicioPublicacion.borrarPublicacion(id);

		return new ModelAndView("redirect:/home");
	}

	@RequestMapping(path = "/filtrarCategoria", method = RequestMethod.GET)
	public ModelAndView filtrarPublicacion(
			@RequestParam(value = "filtarPublicacionCategoria", required = false) String filtrarPublicacionCategoria)
			throws Exception {
		ModelMap modelo = new ModelMap();
		Publicacion publicacion = new Publicacion();
		
		if(filtrarPublicacionCategoria.equals("todas")) {
			List<Publicacion> publicaciones = servicioPublicacion.buscarPublicaciones();
			modelo.put("publicaciones", publicaciones);
		}else {
			List<Publicacion> publicaciones = servicioPublicacion.buscarPublicacionesPorCategoria(filtrarPublicacionCategoria);
			modelo.put("publicaciones", publicaciones);
		}
		
		
		modelo.put("title", "Inicio");
		modelo.put("publicacion", publicacion);
		
		return new ModelAndView("home", modelo);
	}
}
