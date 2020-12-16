package ar.edu.unlam.tallerweb1.controladores;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.CriticaCategoria;
import ar.edu.unlam.tallerweb1.servicios.ServicioCriticaCategoria;

@Controller
public class ControladorCriticaCategoria {

	@Inject
	private ServicioCriticaCategoria servicioCriticaCategoria;

	@RequestMapping(path = "/crearCriticaCategoria", method = RequestMethod.POST)
	public ModelAndView crearCriticaCategoria(@ModelAttribute("criticaCategoria") CriticaCategoria criticaCategoria) {
		System.out.println("******************************************");
		servicioCriticaCategoria.crearUnaCriticaCategoria(criticaCategoria);
		return new ModelAndView("redirect: /juegosOVarios?categoriaId=1");
	}

}
