package ar.edu.unlam.tallerweb1.controladores;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Usuario;

@Controller
public class ControladorPerfil {
	@RequestMapping(path = "/perfil")
	public ModelAndView registrar(HttpServletRequest request) {
		ModelMap modelo = new ModelMap();
		String rol = request.getSession().getAttribute("ROL") != null

				? (String) request.getSession().getAttribute("ROL")

				: "";
		String nombreUsuario = request.getSession().getAttribute("NOMBREUSUARIO") != null

				? (String) request.getSession().getAttribute("NOMBREUSUARIO")

				: "";
		String url_imagen = request.getSession().getAttribute("URLIMAGEN") != null

				? (String) request.getSession().getAttribute("URLIMAGEN")

				: "";
		Usuario usuario = request.getSession().getAttribute("USUARIO") != null
				? (Usuario) request.getSession().getAttribute("USUARIO")
				: null;
		modelo.put("usuarioRol", rol);
		modelo.put("nombreUsuario", nombreUsuario);
		modelo.put("url_imagen", url_imagen);
		modelo.put("title", "RageQuit | Perfil");
		return new ModelAndView("perfil", modelo);
	}
}
