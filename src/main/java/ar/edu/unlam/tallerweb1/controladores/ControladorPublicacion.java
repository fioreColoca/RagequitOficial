package ar.edu.unlam.tallerweb1.controladores;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ar.edu.unlam.tallerweb1.modelo.Publicacion;
import ar.edu.unlam.tallerweb1.modelo.PublicacionTipo;
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
			@RequestParam(value = "mensajePublicacion", required = true) String mensajePublicacion,
			@RequestParam(value = "categoriaPublicacion", required = true) String categoriaPublicacion
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
				
		modelo.put("title","Publicaci&oacute;n");
		modelo.put("publicacion",publicacion);
		modelo.put("categoria", categoriaPublicacion);
		
		return new ModelAndView("publicacionRegistradaConfirmacion", modelo);
	}
	/*****************************PROBAR TRAER UNA LISTA DE PUBLICACIONES*************************************/
	
	@RequestMapping(path= "/publicar", method = RequestMethod.GET)
	public ModelAndView publicarLista(
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
		
		List<Publicacion> publicaciones = servicioPublicacion.buscarPublicaciones();
		
	
		modelo.put("title","Publicaci&oacute;n");
		modelo.put("publicaciones",publicaciones);
		
		return new ModelAndView("publicacionLista", modelo);
	}
	
	@RequestMapping(path= "/borrarPublicacion", method = RequestMethod.GET)
	public ModelAndView borrarPublicacion(
			@RequestParam(value = "botonBorrar", required = false) Long id
			) throws Exception {
		
		ModelMap modelo = new ModelMap();
		
		servicioPublicacion.borrarPublicacion(id);
		
		String mensaje = "Publicacion borrada con exito!";
		
		List<Publicacion> publicaciones = servicioPublicacion.buscarPublicaciones();
		
		
		modelo.put("publicaciones",publicaciones);
		
		modelo.put("title","Publicaci&oacute;n");
		modelo.put("mensaje",mensaje);
		
		return new ModelAndView("publicacionRegistradaConfirmacion", modelo);
	}
}
