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

import ar.edu.unlam.tallerweb1.modelo.Publicacion;
import ar.edu.unlam.tallerweb1.servicios.ServicioPublicacion;

@Controller
public class ControladorIndex {
	
	@Inject
	private ServicioPublicacion servicioPublicacion;
	
	@RequestMapping(path= "/home", method = RequestMethod.GET)
	public ModelAndView irAlHome(
			@RequestParam(value = "mensajePublicacion", required = false) String mensajePublicacion,
			@RequestParam(value = "categoriaPublicacion", required = false) String categoriaPublicacion
			) throws Exception {
		Date fecha = new Date();
		Publicacion publicacion = new Publicacion();
		ModelMap modelo = new ModelMap();
		
		publicacion.setMensaje(mensajePublicacion);
		publicacion.setFechaHora(fecha);
		publicacion.setCategoria(categoriaPublicacion);
		
		
		try {
			servicioPublicacion.guardarPublicacion(publicacion);
		}catch(Exception e){
			String error = e.getMessage();
			modelo.put("error", error);
		}
		Integer anio = servicioPublicacion.devolverAnio(publicacion);
		

		List<Publicacion> publicaciones = servicioPublicacion.buscarPublicaciones();
	
		modelo.put("title", "Inicio");
		modelo.put("publicaciones",publicaciones);
		modelo.put("anio", anio);
		
		return new ModelAndView("home", modelo);
	}
	
	@RequestMapping(path= "/borrarPublicacion", method = RequestMethod.GET)
	public ModelAndView borrarPublicacion(
			@RequestParam(value = "botonBorrar", required = false) Long id
			) throws Exception {
		servicioPublicacion.borrarPublicacion(id);
		
		return new ModelAndView("redirect:/home");
	}
	
	@RequestMapping(path= "/filtrarCategoria", method = RequestMethod.GET)
	public ModelAndView borrarPublicacion(
			@RequestParam(value = "filtarPublicacionCategoria", required = false) String filtrarPublicacionCategoria
			) throws Exception {
		
		List<Publicacion> publicaciones = servicioPublicacion.buscarPublicacionesPorCategoria(filtrarPublicacionCategoria);
		
		return new ModelAndView("redirect:/home");
	}
}
