package ar.edu.unlam.tallerweb1.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControladorIndex {

	@RequestMapping(path = "/home")
	public ModelAndView crearUsuario() {
		ModelMap modelo = new ModelMap();
		String aux = "Inicio";
		modelo.put("title", aux);
		return new ModelAndView("home", modelo);
	}
}
