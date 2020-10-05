package ar.edu.unlam.tallerweb1.controladores;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Categoria;
import ar.edu.unlam.tallerweb1.servicios.ServicioCategoria;

@Controller
public class ControladorCategoria {
	
	@Inject
	private ServicioCategoria servicioCategoria;
	
	@RequestMapping("/categoria")
	public ModelAndView irACategoria(){
		ModelMap modelo = new ModelMap();
		Categoria categoria = new Categoria();
		modelo.put("categoria", categoria);
		return new ModelAndView("categoria", modelo);
	}
	

}
