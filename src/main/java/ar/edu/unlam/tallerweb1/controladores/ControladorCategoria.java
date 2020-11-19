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
import ar.edu.unlam.tallerweb1.modelo.CategoriaTipo;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioCategoria;

@Controller
public class ControladorCategoria {

	@Inject
	private ServicioCategoria servicioCategoria;

	@RequestMapping("/categoria")
	public ModelAndView categoria(@RequestParam(value = "errorNombre", required = false) String errorNombre,
			@RequestParam(value = "errorTipo", required = false) String errorTipo,
			HttpServletRequest request) {
		ModelMap modelo = new ModelMap();
				
		Usuario usuarioLogeado = request.getSession().getAttribute("USUARIO") != null
					? (Usuario) request.getSession().getAttribute("USUARIO")
					: null;
				
		modelo.put("errorNombre", errorNombre);
		modelo.put("errorTipo", errorTipo);
		modelo.put("title", "RageQuit | Categoria");
		modelo.put("usuarioLogeado", usuarioLogeado);

		return new ModelAndView("categoria", modelo);
	}

	@RequestMapping(path = "/agregarCategoria", method = RequestMethod.GET)
	public ModelAndView agregarCategoria(@RequestParam(value = "categoria", required = false) String tipoCategoria,
			@RequestParam(value = "crearCategoria", required = false) String nombreCategoria) {

		ModelMap modelo = new ModelMap();
		Categoria categoria = new Categoria();
		
		String errorNombre = null;
		String errorTipo = null;
		
		if (nombreCategoria.isEmpty()) {
			errorNombre = "Falta elegir nombre a la categoria";
		} else {
			categoria.setNombre(nombreCategoria);
		}

		if (tipoCategoria == null) {
			errorTipo = "Falta elegir categoria";
		} else {
			if (tipoCategoria.equals("Juegos")) {
				categoria.setTipoCategoria(CategoriaTipo.JUEGOS);
			} else {
				categoria.setTipoCategoria(CategoriaTipo.VARIOS);
			}
		}
		
		if (errorNombre == null && errorTipo == null) {
			servicioCategoria.guardarCategoria(categoria);
			return new ModelAndView("redirect:/biblioteca");
		}

		//modelo.put("categoriaCreada", categoria);
		return new ModelAndView("redirect:/categoria?errorNombre=" + errorNombre + "&errorTipo=" + errorTipo);
	}

	@RequestMapping("/irACategorias")
	public ModelAndView irACategorias(HttpServletRequest request) {
		ModelMap modelo = new ModelMap();

		List<Categoria> categorias = servicioCategoria.mostrarCategorias();

		Usuario usuarioLogeado = request.getSession().getAttribute("USUARIO") != null
				? (Usuario) request.getSession().getAttribute("USUARIO")
				: null;

		modelo.put("categorias", categorias);
		modelo.put("title", "RageQuit | Categoria Creadas");
		modelo.put("usuarioLogeado", usuarioLogeado);

		return new ModelAndView("irACategorias", modelo);
	}

	@RequestMapping(path = "/borrarCategoria", method = RequestMethod.GET)
	public ModelAndView borrarCategoria(@RequestParam(value = "botonBorrar", required = false) Long id) {
		servicioCategoria.borrarCategoria(id);

		return new ModelAndView("redirect:/irACategorias");
	}

	@RequestMapping(path = "/editarCategoria", method = RequestMethod.GET)
	public ModelAndView editarCategoria(@RequestParam(value = "categoria", required = false) String tipoCategoria,
			@RequestParam(value = "editarCategoria", required = false) String nombreCategoria,
			@RequestParam(value = "botonGuardar", required = false) Long id) 
			{
		
		//ModelMap modelo = new ModelMap();
		//Categoria categoria = new Categoria();
		
		Categoria categoria = servicioCategoria.mostrarCategoriaPorId(id);
		if (tipoCategoria.equals("Juegos")) {
			categoria.setTipoCategoria(CategoriaTipo.JUEGOS);
		} else {
			categoria.setTipoCategoria(CategoriaTipo.VARIOS);
		}

		categoria.setNombre(nombreCategoria);
		
		servicioCategoria.editarCategoria(id);
		
//		if (tipoCategoria.equals("Juegos")) {
//			categoria.setTipoCategoria(CategoriaTipo.JUEGOS);
//		} else {
//			categoria.setTipoCategoria(CategoriaTipo.VARIOS);
//		}
//
//		categoria.setNombre(nombreCategoria);
//		
//		servicioCategoria.editarCategoria(categoria);
		
//		modelo.put("categoriaEditada", categoria);
		return new ModelAndView("redirect:/irACategorias");
	}

}
