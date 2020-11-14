package ar.edu.unlam.tallerweb1.controladores;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioUsuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioUsuario;

@Controller
public class ControladorAdministrarRol {

	@Inject
	private ServicioUsuario servicioUsuario;

	@RequestMapping(path = "administrar")
	public ModelAndView irAAdministracionRol(HttpServletRequest request) {
		ModelMap modelo = new ModelMap();
		List<Usuario> usuarios = servicioUsuario.listarUsuarios();

		String rol = request.getSession().getAttribute("ROL") != null

				? (String) request.getSession().getAttribute("ROL")

				: "";
		String nombreUsuario = request.getSession().getAttribute("NOMBREUSUARIO") != null

				? (String) request.getSession().getAttribute("NOMBREUSUARIO")

				: "";

		modelo.put("listaUsuarios", usuarios);
		modelo.put("usuarioRol", rol);
		modelo.put("nombreUsuario", nombreUsuario);

		return new ModelAndView("administrarRol", modelo);
	}

	@RequestMapping(path = "/cambiarRol", method = RequestMethod.GET)
	public ModelAndView cambiarRolUsuario(@RequestParam(value = "rolUsuario", required = false) String rol,
			@RequestParam(value = "botonCambiarRol", required = false) Long id, HttpServletRequest request) {

		servicioUsuario.cambiarRol(id, rol);

		if (id.equals(request.getSession().getAttribute("ID"))) {

			request.getSession().setAttribute("ROL", rol);
		}

		return new ModelAndView("redirect:/administrar");
	}

	public ServicioUsuario getServicioUsuario() {
		return servicioUsuario;
	}

	public void setServicioUsuario(ServicioUsuario servicioUsuario) {
		this.servicioUsuario = servicioUsuario;
	}
	
	
}
