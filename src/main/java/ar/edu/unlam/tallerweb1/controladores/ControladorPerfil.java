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

import ar.edu.unlam.tallerweb1.modelo.Categoria;
import ar.edu.unlam.tallerweb1.modelo.Seguir;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioCategoria;
import ar.edu.unlam.tallerweb1.servicios.ServicioSeguir;
import ar.edu.unlam.tallerweb1.servicios.ServicioUsuario;

@Controller
public class ControladorPerfil {

	@Inject
	private ServicioCategoria servicioCategoria;

	@Inject
	private ServicioUsuario servicioUsuario;

	@Inject
	private ServicioSeguir servicioSeguir;

	@RequestMapping("/perfil")
	public ModelAndView verPerfil(HttpServletRequest request,
			@RequestParam(value = "usuarioNombre", required = false) String nombreUsuarioPerfil) {
		ModelMap modelo = new ModelMap();

		Usuario usuarioLogeado = request.getSession().getAttribute("USUARIO") != null
				? (Usuario) request.getSession().getAttribute("USUARIO")
				: null;

		List<Categoria> categorias = servicioCategoria.mostrarCategorias();
		Usuario usuarioPerfil = servicioUsuario.obtenerUsuarioPorNombreUsuario(nombreUsuarioPerfil);
		Seguir verificarSeguimiento = servicioSeguir.buscarSeguirPorUsuarioSeguidorYUsuarioSeguido(usuarioLogeado,
				usuarioPerfil);

		modelo.put("verificacionSeguir", verificarSeguimiento);
		modelo.put("usuarioPerfil", usuarioPerfil);
		modelo.put("categorias", categorias);
		modelo.put("usuarioLogeado", usuarioLogeado);
		modelo.put("title", "RageQuit | Perfil");
		return new ModelAndView("perfil", modelo);
	}

	@RequestMapping(path = "/seguir", method = RequestMethod.POST)
	public ModelAndView seguirUsuario(HttpServletRequest request,
			@RequestParam(value = "usuarioSeguido", required = false) String usuarioSeguido) {

		Usuario usuarioLogeado = request.getSession().getAttribute("USUARIO") != null
				? (Usuario) request.getSession().getAttribute("USUARIO")
				: null;
		Usuario usuarioSeguido1 = servicioUsuario.obtenerUsuarioPorNombreUsuario(usuarioSeguido);

		servicioSeguir.seguirUsuario(usuarioLogeado, usuarioSeguido1);

		return new ModelAndView("redirect:/perfil?usuarioNombre=" + usuarioSeguido1.getNombreUsuario());

	}

	@RequestMapping(path = "/dejarSeguir", method = RequestMethod.POST)
	public ModelAndView dejarDeSeguirUsuario(HttpServletRequest request,
			@RequestParam(value = "usuarioSeguido", required = false) String usuarioSeguido) {

		Usuario usuarioLogeado = request.getSession().getAttribute("USUARIO") != null
				? (Usuario) request.getSession().getAttribute("USUARIO")
				: null;
		Usuario usuarioSeguido1 = servicioUsuario.obtenerUsuarioPorNombreUsuario(usuarioSeguido);
		System.out.println("estoy apunto de hacer el metodo dejar de seguir usuario *************************************************************");
		servicioSeguir.dejarDeSeguirUsuario(usuarioLogeado, usuarioSeguido1);

		return new ModelAndView("redirect:/perfil?usuarioNombre=" + usuarioSeguido1.getNombreUsuario());

	}

}
