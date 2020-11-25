package ar.edu.unlam.tallerweb1.controladores;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioUsuario;

@Controller
public class ControladorConfiguracion {

	@Inject
	private ServicioUsuario servicioUsuario;

	@RequestMapping(path = "/configuracion", method = RequestMethod.GET)
	public ModelAndView mostrarPerfil(@RequestParam(value = "resultado", required = false) String resultado,
			HttpServletRequest request) {
		ModelMap modelo = new ModelMap();
		Usuario usuarioLogeado = request.getSession().getAttribute("USUARIO") != null
				? (Usuario) request.getSession().getAttribute("USUARIO")
				: null;

		String apellido = (String) usuarioLogeado.getApellido() != null ? (String) usuarioLogeado.getApellido() : null;
		String nombre = (String) usuarioLogeado.getNombre() != null ? (String) usuarioLogeado.getNombre() : null;
		String email = (String) usuarioLogeado.getEmail() != null ? (String) usuarioLogeado.getEmail() : null;
		String nombreUsuarioo = (String) usuarioLogeado.getNombreUsuario() != null
				? (String) usuarioLogeado.getNombreUsuario()
				: null;
		String contrasenia = (String) usuarioLogeado.getPassword() != null ? (String) usuarioLogeado.getPassword()
				: null;

		modelo.put("cambioExitoso", resultado);
		modelo.put("apellido", apellido);
		modelo.put("email", email);
		modelo.put("nombre", nombre);
		modelo.put("nombreUsuarioo", nombreUsuarioo);
		modelo.put("usuarioLogeado", usuarioLogeado);
		modelo.put("contrasenia", contrasenia);

		modelo.put("title", "RageQuit | Configuracion");
		return new ModelAndView("configuracion", modelo);
	}

	@RequestMapping("editarNombre")
	public ModelAndView modificarNombre(@RequestParam(value = "nombre") String nombre, HttpServletRequest request) {
		Usuario usuario = request.getSession().getAttribute("USUARIO") != null
				? (Usuario) request.getSession().getAttribute("USUARIO")
				: null;

		servicioUsuario.cambiarNombre(usuario.getId(), nombre);

		if (usuario.getId().equals(request.getSession().getAttribute("ID"))) {
			usuario.setNombre(nombre);
		}

		return new ModelAndView("redirect:/configuracion?resultado=1");
	}

	@RequestMapping("editarApellido")
	public ModelAndView modificarApellido(@RequestParam(value = "apellido") String apellido,
			HttpServletRequest request) {
		Usuario usuario = request.getSession().getAttribute("USUARIO") != null
				? (Usuario) request.getSession().getAttribute("USUARIO")
				: null;

		servicioUsuario.cambiarApellido(usuario.getId(), apellido);

		if (usuario.getId().equals(request.getSession().getAttribute("ID"))) {
			usuario.setApellido(apellido);
		}

		return new ModelAndView("redirect:/configuracion?resultado=1");
	}

	@RequestMapping("editarEmail")
	public ModelAndView modificarEmail(@RequestParam(value = "email") String email, HttpServletRequest request) {
		Usuario usuario = request.getSession().getAttribute("USUARIO") != null
				? (Usuario) request.getSession().getAttribute("USUARIO")
				: null;

		servicioUsuario.cambiarEmail(usuario.getId(), email);

		if (usuario.getId().equals(request.getSession().getAttribute("ID"))) {
			usuario.setEmail(email);
		}

		return new ModelAndView("redirect:/configuracion?resultado=1");
	}

	@RequestMapping("editarNombreUsuario")
	public ModelAndView modificarNombreUsuario(@RequestParam(value = "nombreUsuario") String nombreUsuario,
			HttpServletRequest request) {
		Usuario usuario = request.getSession().getAttribute("USUARIO") != null
				? (Usuario) request.getSession().getAttribute("USUARIO")
				: null;

		servicioUsuario.cambiarNombreUsuario(usuario.getId(), nombreUsuario);

		if (usuario.getId().equals(request.getSession().getAttribute("ID"))) {
			usuario.setNombreUsuario(nombreUsuario);
		}

		return new ModelAndView("redirect:/configuracion?resultado=1");
	}

	@RequestMapping("editarContrasenia")
	public ModelAndView modificarContrasenia(@RequestParam(value = "contrasenia") String contrasenia,
			HttpServletRequest request) {
		Usuario usuario = request.getSession().getAttribute("USUARIO") != null
				? (Usuario) request.getSession().getAttribute("USUARIO")
				: null;

		servicioUsuario.cambiarContrasenia(usuario.getId(), contrasenia);

		if (usuario.getId().equals(request.getSession().getAttribute("ID"))) {
			usuario.setPassword(contrasenia);
		}

		return new ModelAndView("redirect:/configuracion?resultado=1");
	}
}
