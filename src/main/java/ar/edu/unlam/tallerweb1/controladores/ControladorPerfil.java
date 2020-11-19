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
public class ControladorPerfil {

	@Inject
	private ServicioUsuario servicioUsuario;

	@RequestMapping(path = "/perfil", method = RequestMethod.GET)
	public ModelAndView mostrarPerfil(@RequestParam(value = "resultado", required = false) String resultado,
			HttpServletRequest request) {
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

		String apellido = (String) usuario.getApellido() != null ? (String) usuario.getApellido() : null;
		String nombre = (String) usuario.getNombre() != null ? (String) usuario.getNombre() : null;
		String email = (String) usuario.getEmail() != null ? (String) usuario.getEmail() : null;
		String nombreUsuarioo = (String) usuario.getNombreUsuario() != null ? (String) usuario.getNombreUsuario()
				: null;
		String contrasenia = (String) usuario.getPassword() != null ? (String) usuario.getPassword() : null;

		modelo.put("cambioExitoso", resultado);
		modelo.put("usuarioRol", rol);
		modelo.put("nombreUsuario", nombreUsuario);
		modelo.put("url_imagen", url_imagen);
		modelo.put("apellido", apellido);
		modelo.put("email", email);
		modelo.put("nombre", nombre);
		modelo.put("nombreUsuarioo", nombreUsuarioo);

		modelo.put("contrasenia", contrasenia);

		modelo.put("title", "RageQuit | Perfil");
		return new ModelAndView("perfil", modelo);
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

		return new ModelAndView("redirect:/perfil?resultado=1");
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

		return new ModelAndView("redirect:/perfil?resultado=1");
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

		return new ModelAndView("redirect:/perfil?resultado=1");
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

		return new ModelAndView("redirect:/perfil?resultado=1");
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

		return new ModelAndView("redirect:/perfil?resultado=1");
	}
}
