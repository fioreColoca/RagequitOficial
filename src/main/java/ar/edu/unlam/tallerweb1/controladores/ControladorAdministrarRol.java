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
	public ModelAndView irAAdministracionRol(
			@RequestParam(value = "errorCambiarRol", required = false) String errorCambiarRol,
			HttpServletRequest request) {
		ModelMap modelo = new ModelMap();
		List<Usuario> usuarios = servicioUsuario.listarUsuarios();

		Usuario usuarioLogeado = request.getSession().getAttribute("USUARIO") != null
				? (Usuario) request.getSession().getAttribute("USUARIO")
				: null;

		modelo.put("usuarioLogeado", usuarioLogeado);
		modelo.put("listaUsuarios", usuarios);
		modelo.put("errorCambiarRol", errorCambiarRol);

		return new ModelAndView("administrarRol", modelo);
	}

	@RequestMapping(path = "/cambiarRol", method = RequestMethod.POST)
	public ModelAndView cambiarRolUsuario(@RequestParam(value = "rolUsuario", required = false) String rol,
			@RequestParam(value = "botonCambiarRol", required = false) Long id, HttpServletRequest request) {
		Usuario usuarioQuePidioCambiarUnRol = (Usuario) request.getSession().getAttribute("USUARIO");
		String rolDelUsuarioQuePidioCambiarUnRol = usuarioQuePidioCambiarUnRol.getRol();
		Long idDelUsuarioQuePidioCambiarUnRol = usuarioQuePidioCambiarUnRol.getId();
		if (!rolDelUsuarioQuePidioCambiarUnRol.equals("admin")) {
			return new ModelAndView("redirect:/administrar?errorCambiarRol=true");
		}

		servicioUsuario.cambiarRol(id, rol);

		if (id.equals(idDelUsuarioQuePidioCambiarUnRol)) {

			Usuario usuario = servicioUsuario.obtenerUsuarioPorId(id);
			request.getSession().setAttribute("USUARIO", usuario);
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
