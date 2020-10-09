package ar.edu.unlam.tallerweb1.controladores;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.UsuarioRagequit;
import ar.edu.unlam.tallerweb1.servicios.ServicioUsuarioRagequit;

@Controller
public class ControladorLoginUsuarioRagequit {

	@Inject
	private ServicioUsuarioRagequit servicioUsuarioRagequit;

	@RequestMapping(path = "/loginUsuarioRagequit")
	public ModelAndView crearUsuario() {
		ModelMap modelo = new ModelMap();
		modelo.put("title","Login");
		return new ModelAndView("crearUsuario",modelo);
	}
	//esto verifica que se cree el usuario 
	@RequestMapping(path = "mostrarUsuario")
	public ModelAndView mostrarUsuarioCreado(@RequestParam(value = "nombre", required = false) String name,
			@RequestParam(value = "apellido", required = false) String surname,
			@RequestParam(value = "email", required = false) String email,
			@RequestParam(value = "id", required = false) Long id) {
		ModelMap modelo = new ModelMap();
		UsuarioRagequit usuario = new UsuarioRagequit();

		usuario.setApellido(surname);
		usuario.setNombre(name);
		usuario.setEmail(email);

		servicioUsuarioRagequit.crearUsuario(usuario);
		servicioUsuarioRagequit.mostrarUsuario(id);
		modelo.put("usuario", usuario);

		return new ModelAndView("mostrarUsuario", modelo);
	}
}
