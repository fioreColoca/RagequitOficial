package ar.edu.unlam.tallerweb1.controladores;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Lista;
import ar.edu.unlam.tallerweb1.servicios.ServicioLista;

@Controller
public class ControladorLista {
	
	@Inject
	private ServicioLista servicioLista;
	
	@RequestMapping(path="/Lista")
	public ModelAndView lista() {
		return new ModelAndView("Lista");
	}
	
	@RequestMapping(path="/Lista", method = RequestMethod.GET)
	public ModelAndView listaDesplegada(
			@RequestParam(value = "filtro", required = false) String filtro
			) {
		Lista lista = new Lista();
		ModelMap modelo = new ModelMap();
		
		Long idLista = servicioLista.crearLista(lista);
		
		modelo.put("idLista", idLista);
		modelo.put("Lista", lista);
		
		modelo.put("filtro", filtro);
		
		return new ModelAndView("Lista", modelo);
	}
	
	
	
	

}
