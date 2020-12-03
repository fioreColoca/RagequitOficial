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
		if (usuarioLogeado != null) {
			String apellido = (String) usuarioLogeado.getApellido() != null ? (String) usuarioLogeado.getApellido()
					: null;
			String nombre = (String) usuarioLogeado.getNombre() != null ? (String) usuarioLogeado.getNombre() : null;
			String email = (String) usuarioLogeado.getEmail() != null ? (String) usuarioLogeado.getEmail() : null;
			String nombreUsuarioo = (String) usuarioLogeado.getNombreUsuario() != null
					? (String) usuarioLogeado.getNombreUsuario()
					: null;
			String contrasenia = request.getSession().getAttribute("CONTRASENIA") != null
					? (String) request.getSession().getAttribute("CONTRASENIA")
					: null;
			Integer telefono = usuarioLogeado.getTelefono() != null ? (Integer) usuarioLogeado.getTelefono() : null;

			modelo.put("cambioExitoso", resultado);
			modelo.put("apellido", apellido);
			modelo.put("email", email);
			modelo.put("nombre", nombre);
			modelo.put("nombreUsuarioo", nombreUsuarioo);
			modelo.put("usuarioLogeado", usuarioLogeado);
			modelo.put("contrasenia", contrasenia);
			modelo.put("telefono", telefono);
		}
		modelo.put("title", "RageQuit | Configuracion");
		return new ModelAndView("configuracion", modelo);
	}

	@RequestMapping("editarNombre")
	public ModelAndView modificarNombre(@RequestParam(value = "nombre", required = false) String nombre,
			HttpServletRequest request) {
		Usuario usuario = request.getSession().getAttribute("USUARIO") != null
				? (Usuario) request.getSession().getAttribute("USUARIO")
				: null;
		Usuario usuarioVerificar = servicioUsuario.obtenerUsuarioPorId(usuario.getId());

		servicioUsuario.cambiarNombre(usuario.getId(), nombre);

		if (usuario.getId().equals(usuarioVerificar.getId())) {
			usuario.setNombre(nombre);
		}

		return new ModelAndView("redirect:/configuracion?resultado=1");
	}

	@RequestMapping("editarApellido")
	public ModelAndView modificarApellido(@RequestParam(value = "apellido", required = false) String apellido,
			HttpServletRequest request) {
		Usuario usuario = request.getSession().getAttribute("USUARIO") != null
				? (Usuario) request.getSession().getAttribute("USUARIO")
				: null;
		Usuario usuarioVerificar = servicioUsuario.obtenerUsuarioPorId(usuario.getId());

		servicioUsuario.cambiarApellido(usuario.getId(), apellido);

		if (usuario.getId().equals(usuarioVerificar.getId())) {
			usuario.setApellido(apellido);
		}

		return new ModelAndView("redirect:/configuracion?resultado=1");
	}

	@RequestMapping("editarEmail")
	public ModelAndView modificarEmail(@RequestParam(value = "email", required = false) String email,
			HttpServletRequest request) {
		Usuario usuario = request.getSession().getAttribute("USUARIO") != null
				? (Usuario) request.getSession().getAttribute("USUARIO")
				: null;
		Usuario usuarioVerificar = servicioUsuario.obtenerUsuarioPorId(usuario.getId());

		servicioUsuario.cambiarEmail(usuario.getId(), email);

		if (usuario.getId().equals(usuarioVerificar.getId())) {
			usuario.setEmail(email);
		}

		return new ModelAndView("redirect:/configuracion?resultado=1");
	}

	@RequestMapping("editarNombreUsuario")
	public ModelAndView modificarNombreUsuario(
			@RequestParam(value = "nombreUsuario", required = false) String nombreUsuario, HttpServletRequest request) {
		Usuario usuario = request.getSession().getAttribute("USUARIO") != null
				? (Usuario) request.getSession().getAttribute("USUARIO")
				: null;
		Usuario usuarioVerificar = servicioUsuario.obtenerUsuarioPorId(usuario.getId());
		servicioUsuario.cambiarNombreUsuario(usuario.getId(), nombreUsuario);

		if (usuario.getId().equals(usuarioVerificar.getId())) {
			usuario.setNombreUsuario(nombreUsuario);
		}

		return new ModelAndView("redirect:/configuracion?resultado=1");
	}

	@RequestMapping("editarContrasenia")
	public ModelAndView modificarContrasenia(@RequestParam(value = "contrasenia", required = false) String contrasenia,
			HttpServletRequest request) {
		Usuario usuario = request.getSession().getAttribute("USUARIO") != null
				? (Usuario) request.getSession().getAttribute("USUARIO")
				: null;
		Usuario usuarioVerificar = servicioUsuario.obtenerUsuarioPorId(usuario.getId());

		servicioUsuario.cambiarContrasenia(usuario.getId(), contrasenia);

		if (usuario.getId().equals(usuarioVerificar.getId())) {
			request.getSession().setAttribute("CONTRASENIA", contrasenia);
		}

		return new ModelAndView("redirect:/configuracion?resultado=1");
	}

	@RequestMapping("editarTelefono")
	public ModelAndView modificarTelefono(@RequestParam(value = "tel", required = false) Integer telefono,
			HttpServletRequest request) {
		Usuario usuario = request.getSession().getAttribute("USUARIO") != null
				? (Usuario) request.getSession().getAttribute("USUARIO")
				: null;
		Usuario usuarioVerificar = servicioUsuario.obtenerUsuarioPorId(usuario.getId());
		servicioUsuario.cambiarTelefono(usuario.getId(), telefono);

		if (usuario.getId().equals(usuarioVerificar.getId())) {
			usuario.setTelefono(telefono);
		}

		return new ModelAndView("redirect:/configuracion?resultado=1");
	}
}
