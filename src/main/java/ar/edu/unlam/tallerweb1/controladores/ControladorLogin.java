package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioLogin;
import ar.edu.unlam.tallerweb1.servicios.ServicioUsuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

@Controller
public class ControladorLogin {

	// La anotacion @Autowired indica a Spring que se debe utilizar el contructor
	// como mecanismo de inyección de dependencias,
	// es decir, qeue lo parametros del mismo deben ser un bean de spring y el
	// framewrok automaticamente pasa como parametro
	// el bean correspondiente, en este caso, un objeto de una clase que implemente
	// la interface ServicioLogin,
	// dicha clase debe estar anotada como @Service o @Repository y debe estar en un
	// paquete de los indicados en
	// applicationContext.xml
	// La anotacion @Autowired indica a Spring que se debe utilizar el contructor
	// como mecanismo de inyección de dependencias,
	// es decir, qeue lo parametros del mismo deben ser un bean de spring y el
	// framewrok automaticamente pasa como parametro
	// el bean correspondiente, en este caso, un objeto de una clase que implemente
	// la interface ServicioLogin,
	// dicha clase debe estar anotada como @Service o @Repository y debe estar en un
	// paquete de los indicados en
	// applicationContext.xml
	@Inject
	private ServicioLogin servicioLogin;

	@Inject
	private ServicioUsuario servicioUsuario;

	@Autowired
	public ControladorLogin(ServicioLogin servicioLogin) {
		this.servicioLogin = servicioLogin;
	}

	// Este metodo escucha la URL localhost:8080/NOMBRE_APP/login si la misma es
	// invocada por metodo http GET
	@RequestMapping("/login")
	public ModelAndView irALogin(@RequestParam(value = "errorSeguir", required = false) String errorSeguir,
			@RequestParam(value = "errorLogin", required = false) String errorLogin,
			@RequestParam(value = "errorLike", required = false) String errorLike) {

		ModelMap modelo = new ModelMap();
		// Se agrega al modelo un objeto del tipo Usuario con key 'usuario' para que el
		// mismo sea asociado
		// al model attribute del form que esta definido en la vista 'login'
		Usuario usuario = new Usuario();
		String errorAlSeguir = errorSeguir != null ? errorSeguir : null;
		modelo.put("usuario", usuario);
		modelo.put("errorAlSeguir", errorAlSeguir);
		modelo.put("errorLogin", errorLogin);
		modelo.put("errorLike", errorLike);
		// Se va a la vista login (el nombre completo de la lista se resuelve utilizando
		// el view resolver definido en el archivo spring-servlet.xml)
		// y se envian los datos a la misma dentro del modelo
		modelo.put("title", "RageQuit | Iniciar Sesion");
		return new ModelAndView("login", modelo);
	}

	// Este metodo escucha la URL validar-login siempre y cuando se invoque con
	// metodo http POST
	// El método recibe un objeto Usuario el que tiene los datos ingresados en el
	// form correspondiente y se corresponde con el modelAttribute definido en el
	// tag form:form
	@RequestMapping(path = "/validar-login", method = RequestMethod.POST)
	public ModelAndView validarLogin(@ModelAttribute("usuario") Usuario usuario, HttpServletRequest request) {
		ModelMap model = new ModelMap();

		// invoca el metodo consultarUsuario del servicio y hace un redirect a la URL
		// /home, esto es, en lugar de enviar a una vista
		// hace una llamada a otro action a través de la URL correspondiente a ésta
		String contrasenia = usuario.getPassword();
		usuario.setPassword(servicioUsuario.encriptarPassword(usuario.getPassword()));
		Usuario usuarioBuscado = servicioLogin.consultarUsuario(usuario);
		if (usuarioBuscado != null) {
			request.getSession().setAttribute("USUARIO", usuarioBuscado);
			request.getSession().setAttribute("CONTRASENIA", contrasenia);

			return new ModelAndView("redirect:/home");
		} else {
			// si el usuario no existe agrega un mensaje de error en el modelo.

			return new ModelAndView("redirect:/login?errorLogin=true", model);
		}

	}

	// Escucha la URL /home por GET, y redirige a una vista.
	/*
	 * @RequestMapping(path = "/home", method = RequestMethod.GET) public
	 * ModelAndView irAHome() { ModelMap modelo = new ModelMap();
	 * modelo.put("Titulo","Home"); return new ModelAndView("home",modelo); }
	 */

	// Escucha la url /, y redirige a la URL /login, es lo mismo que si se invoca la
	// url /login directamente.
	@RequestMapping(path = "/", method = RequestMethod.GET)
	public ModelAndView inicio() {
		return new ModelAndView("redirect:/login");
	}

	@RequestMapping(path = "registrar")
	public ModelAndView registrar() {
		ModelMap modelo = new ModelMap();
		Usuario usuario1 = new Usuario();
		modelo.put("usuario", usuario1);
		modelo.put("title", "RageQuit | Registrar Usuario");
		return new ModelAndView("crearUsuario", modelo);
	}

	@RequestMapping(path = "cerrarSesion")
	public ModelAndView cerrarSesion(HttpServletRequest request) {
		ModelMap modelo = new ModelMap();
		request.getSession().invalidate();
		return new ModelAndView("redirect:/home", modelo);
	}

	@RequestMapping(path = "/registrando", method = RequestMethod.POST)
	public ModelAndView registrarUsuario(@ModelAttribute("usuario") Usuario usuario1,
			@RequestParam(value = "fechaNacimiento", required = false) String date) {
		ModelMap modelo = new ModelMap();
		Date fecha = new Date();
		usuario1.setContadorSuscriptores(0);
		usuario1.setContadorSeguidores(0);
		usuario1.setContadorNotificaciones(0);
		usuario1.setContadorSeguidos(0);
		usuario1.setContadorCategoriasSeguidas(0);
		usuario1.setFechaCreacion(fecha);
		usuario1.setNivel(1);
		usuario1.setRol("usuario");
		servicioLogin.registrarUsuario(usuario1);
		return new ModelAndView("redirect:/login", modelo);
	}
}
