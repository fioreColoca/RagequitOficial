package ar.edu.unlam.tallerweb1.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControladorIndex {
	@RequestMapping(path="home")
	public ModelAndView index() {
		ModelMap modelo= new ModelMap();
		modelo.put("title","RageQuit | Inicio");
		return new ModelAndView("home",modelo);
	}
}
