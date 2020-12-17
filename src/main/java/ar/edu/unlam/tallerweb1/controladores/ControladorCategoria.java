package ar.edu.unlam.tallerweb1.controladores;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ar.edu.unlam.tallerweb1.modelo.Categoria;
import ar.edu.unlam.tallerweb1.modelo.CategoriaEstado;
import ar.edu.unlam.tallerweb1.modelo.CategoriaTipo;
import ar.edu.unlam.tallerweb1.modelo.Publicacion;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioCategoria;

@Controller
public class ControladorCategoria {

	@Inject
	private ServicioCategoria servicioCategoria;

	@RequestMapping("/categoria")
	public ModelAndView categoria(@RequestParam(value = "errorNombre", required = false) String errorNombre,
			@RequestParam(value = "errorTipo", required = false) String errorTipo,
			/* @RequestParam(value = "errorImagen", required = false) String errorImagen, */
			HttpServletRequest request) {

		ModelMap modelo = new ModelMap();
		Categoria categoria = new Categoria();

		Usuario usuarioLogeado = request.getSession().getAttribute("USUARIO") != null
				? (Usuario) request.getSession().getAttribute("USUARIO")
				: null;

		modelo.put("categoria", categoria);
		modelo.put("errorNombre", errorNombre);
		modelo.put("errorTipo", errorTipo);
		/* modelo.put("errorImagen", errorImagen); */
		modelo.put("title", "RageQuit | Categoria");
		modelo.put("usuarioLogeado", usuarioLogeado);

		return new ModelAndView("categoria", modelo);
	}

	@RequestMapping(path = "/agregarCategoria", method = RequestMethod.POST)
	public ModelAndView agregarCategoria(@ModelAttribute("categoria") Categoria categoria,
			/*
			 * @RequestParam("subida") MultipartFile subida, RedirectAttributes attributes,
			 */
			HttpServletRequest request) /* throws IOException */ {

		String errorNombre = null;
		String errorTipo = null;
		/* String errorImagen = null; */

		List<String> nombres = servicioCategoria.traerNombreCategoriasExistentes();
		if (categoria.getNombre().isEmpty()) {
			errorNombre = "Falta elegir el nombre a la categoria";
		} else {
			Boolean existe = false;
			for (String string : nombres) {
				if (string.equals(categoria.getNombre())) {
					existe = true;
					errorNombre = "Ya existe una categoria con ese nombre";
				}
			}
			if (!existe) {
				categoria.setNombre(categoria.getNombre());
			}
		}

		if (categoria.getTipoCategoriaNum() == null) {
			errorTipo = "Falta elegir el tipo de categoria (JUEGOS o VARIOS)";
		} else {
			if (categoria.getTipoCategoriaNum().equals(0)) {
				categoria.setTipoCategoria(CategoriaTipo.JUEGOS);
			} else {
				categoria.setTipoCategoria(CategoriaTipo.VARIOS);
			}
		}

		/*
		 * if (categoria.getSubida().isEmpty()) { errorImagen =
		 * "Falta elegir la imagen a la categoria"; } else { StringBuilder builder = new
		 * StringBuilder(); builder.append(System.getProperty("user.home"));
		 * builder.append(File.separator); builder.append("/categoriaImg");
		 * builder.append(File.separator); builder.append(subida.getOriginalFilename());
		 * 
		 * byte[] subidaBytes = subida.getBytes(); Path path =
		 * Paths.get(builder.toString()); Files.write(path, subidaBytes); }
		 */

		categoria.setContadorSeguidores(0);

		if (errorNombre == null && errorTipo == null) {
			servicioCategoria.guardarCategoria(categoria);
			return new ModelAndView("redirect:/irACategorias");
		}

		return new ModelAndView("redirect:/categoria?errorNombre=" + errorNombre + "&errorTipo=" + errorTipo);

	}

	@RequestMapping("/irACategorias")
	public ModelAndView irACategorias(@RequestParam(value = "errorNombre", required = false) String errorNombre,
			@RequestParam(value = "errorTipo", required = false) String errorTipo,
			@RequestParam(value = "errorImagen", required = false) String errorImagen, HttpServletRequest request) {

		ModelMap modelo = new ModelMap();

		List<Categoria> categorias = servicioCategoria.mostrarCategorias();

		Usuario usuarioLogeado = request.getSession().getAttribute("USUARIO") != null
				? (Usuario) request.getSession().getAttribute("USUARIO")
				: null;

		modelo.put("errorNombre", errorNombre);
		modelo.put("errorTipo", errorTipo);
		modelo.put("errorImagen", errorImagen);
		modelo.put("categorias", categorias);
		modelo.put("title", "RageQuit | Categoria Creadas");
		modelo.put("usuarioLogeado", usuarioLogeado);

		return new ModelAndView("irACategorias", modelo);
	}

	@RequestMapping(path = "/borrarCategoria", method = RequestMethod.GET)
	public ModelAndView borrarCategoria(@RequestParam(value = "botonBorrar", required = false) Long id) {
		Categoria categoriaABorrar = servicioCategoria.mostrarCategoriaPorId(id);
		servicioCategoria.borrarCategoria(id);

		return new ModelAndView("redirect:/irACategorias");
	}

	@RequestMapping(path = "/editarCategoria", method = RequestMethod.GET)
	public ModelAndView editarCategoria(@RequestParam(value = "categoria", required = false) Integer tipoCategoria,
			@RequestParam(value = "nombre", required = false) String nombreCategoria,
			@RequestParam(value = "botonGuardar", required = false) Long id) {

		String errorNombre = null;
		String errorTipo = null;
		Categoria categoria = servicioCategoria.mostrarCategoriaPorId(id);

		if (nombreCategoria.isEmpty()) {
			errorNombre = "Falta elegir nombre a la categoria";
		} else {
			servicioCategoria.editarNombre(nombreCategoria, id);
		}

		if (tipoCategoria == null) {
			errorTipo = "Falta elegir categoria";
		} else {
			servicioCategoria.editarTipo(tipoCategoria, id);
		}

		if (errorNombre == null && errorTipo == null) {
			return new ModelAndView("redirect:/biblioteca");
		}

		return new ModelAndView("redirect:/irACategorias?errorNombre=" + errorNombre + "&errorTipo=" + errorTipo);

	}

	public ServicioCategoria getServicioCategoria() {
		return servicioCategoria;
	}

	public void setServicioCategoria(ServicioCategoria servicioCategoria) {
		this.servicioCategoria = servicioCategoria;
	}

}
