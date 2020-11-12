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
import ar.edu.unlam.tallerweb1.servicios.ServicioCategoria;

@Controller
public class ControladorCategoria {

	@Inject
	private ServicioCategoria servicioCategoria;

	@RequestMapping("/categoria")
	public ModelAndView irACategoria( 
		HttpServletRequest request
			/*@RequestParam(value = "errorCategoria", required = false) String errorCategoria*/) {
		ModelMap modelo = new ModelMap();
		
		String rol = request.getSession().getAttribute("ROL") != null

				 ? (String) request.getSession().getAttribute("ROL")

				 : "";
				 
		modelo.put("title", "RageQuit | Categoria");
		modelo.put("usuarioRol", rol);
		/*modelo.put("errorCategoria", errorCategoria);*/

		return new ModelAndView("categoria", modelo);
	}

	@RequestMapping(path = "/agregarCategoria", method = RequestMethod.GET)
	public ModelAndView agregarCategoria(@RequestParam(value = "categoria", required = false) String tipoCategoria,
			@RequestParam(value = "crearCategoria", required = false) String nombreCategoria) {
	
		ModelMap modelo = new ModelMap();
		Categoria categoria = new Categoria();
		
		String errorCategoria = null;

		if (tipoCategoria.equals("Juegos")) {
			categoria.setTipoCategoria(CategoriaTipo.JUEGOS);
		} else {
			categoria.setTipoCategoria(CategoriaTipo.VARIOS);
		}
		
		/*if (categoria.getNombre().equals(nombreCategoria)) {
			errorCategoria = "La categoría ya fue creada";
		}*/
		categoria.setNombre(nombreCategoria);

		servicioCategoria.guardarCategoria(categoria);

		modelo.put("categoriaCreada", categoria);
		/*return new ModelAndView("redirect:/home?errorMensaje=" + errorCategoria);*/
		return new ModelAndView("redirect:/irACategorias", modelo);
	}

	@RequestMapping("/irACategorias")
	public ModelAndView irACategorias(
			HttpServletRequest request) {
		ModelMap modelo = new ModelMap();

		List<Categoria> categorias = servicioCategoria.mostrarCategorias();
		
		String rol = request.getSession().getAttribute("ROL") != null

				 ? (String) request.getSession().getAttribute("ROL")

				 : "";

		modelo.put("categorias", categorias);
		modelo.put("usuarioRol", rol);
		modelo.put("title", "RageQuit | Categoria Creadas");

		return new ModelAndView("irACategorias", modelo);
	}

	@RequestMapping(path = "/borrarCategoria", method = RequestMethod.GET)
	public ModelAndView borrarCategoria(@RequestParam(value = "botonBorrar", required = false) Long id) {
		servicioCategoria.borrarCategoria(id);

		return new ModelAndView("redirect:/irACategorias");
	}
	
	@RequestMapping(path = "/editarCategoria", method = RequestMethod.GET)
	public ModelAndView editarCategoria(@RequestParam(value = "botonGuardar", required = false) Long id) {
		servicioCategoria.editarCategoria(id);

		return new ModelAndView("redirect:/irACategorias");
	}

	/*
	 * @RequestMapping("/confirmacionCategoria") public ModelAndView
	 * categoriaExitosa(
	 * 
	 * @RequestParam(value = "categoria", required = false) String tipoCategoria,
	 * 
	 * @RequestParam(value = "crearCategoria", required = false) String
	 * nombreCategoria) throws Exception { ModelMap modelo = new ModelMap();
	 * Categoria categoria = new Categoria();
	 * 
	 * 
	 * if(tipoCategoria.equals("Juegos")) {
	 * categoria.setTipoCategoria(CategoriaTipo.JUEGOS); } else {
	 * categoria.setTipoCategoria(CategoriaTipo.VARIOS); }
	 * 
	 * categoria.setNombre(nombreCategoria);
	 * 
	 * servicioCategoria.crearCategoria(categoria);
	 * 
	 * List<Categoria> categorias = servicioCategoria.mostrarCategorias();
	 * 
	 * modelo.put("categoriaCreada", categoria); modelo.put("categorias",
	 * categorias); return new ModelAndView("confirmacionCategoria",modelo); }
	 */

}
