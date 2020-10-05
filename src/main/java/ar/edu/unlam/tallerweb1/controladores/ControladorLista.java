package ar.edu.unlam.tallerweb1.controladores;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.servicios.ServicioLista;

@Controller
public class ControladorLista {
	
//	@Inject
//	private ServicioLista servicioLista;
	
	@RequestMapping(path="/Lista")
	public ModelAndView lista() {
		return new ModelAndView("lista");
	}
	
	
	
	

}
