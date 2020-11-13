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

import ar.edu.unlam.tallerweb1.modelo.Biblioteca;
import ar.edu.unlam.tallerweb1.modelo.Categoria;
import ar.edu.unlam.tallerweb1.modelo.CategoriaTipo;
import ar.edu.unlam.tallerweb1.servicios.ServicioBiblioteca;
import ar.edu.unlam.tallerweb1.servicios.ServicioCategoria;

@Controller
public class ControladorBiblioteca {

	@Inject
	private ServicioBiblioteca servicioBiblioteca;
	@Inject
	private ServicioCategoria servicioCategoria;

	@RequestMapping(path = "/biblioteca")
	public ModelAndView biblioteca(@RequestParam(value = "categoriaId", required = false) Long categoriaTipo,
			HttpServletRequest request) {
		Biblioteca biblioteca = new Biblioteca();
		ModelMap modelo = new ModelMap();

		Long idbiblioteca = servicioBiblioteca.crearBiblioteca(biblioteca);

		List<Categoria> categorias = servicioCategoria.mostrarCategorias();

		if (!(categoriaTipo == null)) {
			Categoria categoria = servicioCategoria.mostrarCategoriaPorId(categoriaTipo);
			categorias = servicioCategoria.mostrarCategoriaPorTipo(categoria.getTipoCategoria());
		}

		String rol = request.getSession().getAttribute("ROL") != null

				? (String) request.getSession().getAttribute("ROL")

				: "";
		String nombreUsuario = request.getSession().getAttribute("NOMBREUSUARIO") != null

				? (String) request.getSession().getAttribute("NOMBREUSUARIO")

				: "";
		String url_imagen = request.getSession().getAttribute("URLIMAGEN") != null

				? (String) request.getSession().getAttribute("URLIMAGEN")

				: "";
		modelo.put("url_imagen", url_imagen);
		modelo.put("categorias", categorias);
		modelo.put("idBiblioteca", idbiblioteca);
		modelo.put("biblioteca", biblioteca);
		modelo.put("title", "RageQuit | Biblioteca");
		modelo.put("usuarioRol", rol);
		modelo.put("nombreUsuario", nombreUsuario);

		return new ModelAndView("biblioteca", modelo);
	}

	@RequestMapping(path = "/bibliotecaFiltrada", method = RequestMethod.GET)
	public ModelAndView bibliotecaDesplegada(@RequestParam(value = "categoriaId", required = false) Long categoriaId) {

		if (!(categoriaId == -1)) {
			return new ModelAndView("redirect:/biblioteca?categoriaId=" + categoriaId);
		}

		return new ModelAndView("redirect:/biblioteca");
	}

}
