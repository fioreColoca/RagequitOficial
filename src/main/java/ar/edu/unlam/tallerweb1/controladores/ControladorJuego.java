package ar.edu.unlam.tallerweb1.controladores;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Juego;
import ar.edu.unlam.tallerweb1.servicios.ServicioJuego;

@Controller
public class ControladorJuego {

	@Inject
	private ServicioJuego servicioJuego;
	
	@RequestMapping(path="/Juego")
	public ModelAndView juego() {
		
		Juego juego = new Juego();
		ModelMap modelo = new ModelMap();
		
		Long idJuego= servicioJuego.guardarJuego(juego);
		
		modelo.put("idJuego", idJuego);
		modelo.put("Juego", juego);
		
		return new ModelAndView("Juego");
	}
}

