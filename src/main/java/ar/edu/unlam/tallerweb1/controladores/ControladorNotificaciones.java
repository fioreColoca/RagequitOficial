package ar.edu.unlam.tallerweb1.controladores;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Usuario;

@Controller
public class ControladorNotificaciones {
	
	@RequestMapping(path = "/notificaciones")
	public ModelAndView irAlHome(HttpServletRequest request) {
		ModelMap modelo = new ModelMap();
		
		Usuario usuarioLogeado = request.getSession().getAttribute("USUARIO") != null
				? (Usuario) request.getSession().getAttribute("USUARIO")
				: null;
				
		modelo.put("title", "RageQuit | Notificaciones");		
		modelo.put("usuarioLogeado", usuarioLogeado);
		return new ModelAndView("notificaciones", modelo);
	}
}
