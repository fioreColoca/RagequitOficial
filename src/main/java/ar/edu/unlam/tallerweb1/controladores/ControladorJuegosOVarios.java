package ar.edu.unlam.tallerweb1.controladores;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Biblioteca;
import ar.edu.unlam.tallerweb1.modelo.Categoria;
import ar.edu.unlam.tallerweb1.modelo.SeguirCategoria;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioCategoria;
import ar.edu.unlam.tallerweb1.servicios.ServicioSeguirCategoria;

@Controller
public class ControladorJuegosOVarios {

	@Inject
	private ServicioCategoria servicioCategoria;

	@Inject
	private ServicioSeguirCategoria servicioSeguirCategoria;

	@RequestMapping(path = "/juegosOVarios")
	public ModelAndView juegosOvarios(@RequestParam(value = "categoriaId", required = false) Long categoriaId,
			HttpServletRequest request) {
		ModelMap modelo = new ModelMap();

		Categoria juegosOVarios = servicioCategoria.mostrarCategoriaPorId(categoriaId);

		Usuario usuarioLogeado = request.getSession().getAttribute("USUARIO") != null
				? (Usuario) request.getSession().getAttribute("USUARIO")
				: null;

		SeguirCategoria verificarSeguimientoCategoria = null;
		if (usuarioLogeado != null && juegosOVarios != null) {
			verificarSeguimientoCategoria = servicioSeguirCategoria
					.buscarSeguirCategoriaPorUsuarioYCategoria(usuarioLogeado, juegosOVarios);
		}

		List<Usuario> listaSeguidores = servicioSeguirCategoria.devolverListaDeSeguidores(juegosOVarios);

		modelo.put("listaSeguidores", listaSeguidores);
		modelo.put("verificarSeguimientoCategoria", verificarSeguimientoCategoria);
		modelo.put("juegosOVarios", juegosOVarios);
		modelo.put("usuarioLogeado", usuarioLogeado);

		return new ModelAndView("juegosOVarios", modelo);
	}

	@RequestMapping(path = "/seguirCategoria")
	public ModelAndView seguirCategoria(HttpServletRequest request,
			@RequestParam(value = "categoriaId", required = false) Long categoriaId) {

		Usuario usuarioLogeado = request.getSession().getAttribute("USUARIO") != null
				? (Usuario) request.getSession().getAttribute("USUARIO")
				: null;
		Categoria categoriaSeguida = servicioCategoria.mostrarCategoriaPorId(categoriaId);

		servicioSeguirCategoria.seguirCategoria(usuarioLogeado, categoriaSeguida);

		return new ModelAndView("redirect:/juegosOVarios?categoriaId=" + categoriaId);
	}

	@RequestMapping(path = "/dejarSeguirCategoria")
	public ModelAndView dejarSeguirCategoria(HttpServletRequest request,
			@RequestParam(value = "categoriaId", required = false) Long categoriaId) {

		Usuario usuarioLogeado = request.getSession().getAttribute("USUARIO") != null
				? (Usuario) request.getSession().getAttribute("USUARIO")
				: null;

		Categoria categoriaADejarDeSeguir = servicioCategoria.mostrarCategoriaPorId(categoriaId);

		servicioSeguirCategoria.dejarDeSeguirCategoria(usuarioLogeado, categoriaADejarDeSeguir);

		return new ModelAndView("redirect:/juegosOVarios?categoriaId=" + categoriaId);
	}

	public ServicioCategoria getServicioCategoria() {
		return servicioCategoria;
	}

	public void setServicioCategoria(ServicioCategoria servicioCategoria) {
		this.servicioCategoria = servicioCategoria;
	}

}
