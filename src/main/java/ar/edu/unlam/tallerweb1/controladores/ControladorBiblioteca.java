package ar.edu.unlam.tallerweb1.controladores;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Biblioteca;
import ar.edu.unlam.tallerweb1.servicios.ServicioBiblioteca;

@Controller
public class ControladorBiblioteca {
	
	@Inject
	private ServicioBiblioteca servicioBiblioteca;
	
	@RequestMapping(path="/biblioteca")
	public ModelAndView biblioteca() {
		
		Biblioteca biblioteca = new Biblioteca();
		ModelMap modelo = new ModelMap();
		
		Long idbiblioteca = servicioBiblioteca.crearBiblioteca(biblioteca);
		
		modelo.put("idBiblioteca", idbiblioteca);
		modelo.put("Biblioteca", biblioteca);
		
		return new ModelAndView("Biblioteca");
	}
	
	@RequestMapping(path="/biblioteca", method = RequestMethod.GET)
	public ModelAndView bibliotecaDesplegada(
			@RequestParam(value = "filtro", required = false) String filtro
			) {
		Biblioteca biblioteca = new Biblioteca();
		ModelMap modelo = new ModelMap();
		
		Long idbiblioteca = servicioBiblioteca.crearBiblioteca(biblioteca);
		
		modelo.put("idBiblioteca", idbiblioteca);
		modelo.put("Biblioteca", biblioteca);
		
		modelo.put("filtro", filtro);
		
		return new ModelAndView("Biblioteca", modelo);
	}
	
	
	
	

}
