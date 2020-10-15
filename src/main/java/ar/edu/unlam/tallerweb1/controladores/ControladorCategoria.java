package ar.edu.unlam.tallerweb1.controladores;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
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
	public ModelAndView irACategoria(){
		return new ModelAndView("categoria");
	}
	
	
	@RequestMapping("/confirmacionCategoria")
	public ModelAndView categoriaExitosa(
			@RequestParam(value = "categoria", required = false) String tipoCategoria,
			@RequestParam(value = "crearCategoria", required = false) String nombreCategoria) throws Exception {
		ModelMap modelo = new ModelMap();
		Categoria categoria = new Categoria();
		

		if(tipoCategoria.equals("Juegos")) {
			categoria.setTipoCategoria(CategoriaTipo.JUEGOS);
		} else {
			categoria.setTipoCategoria(CategoriaTipo.VARIOS);
		}
		
		categoria.setNombre(nombreCategoria);
		
		servicioCategoria.crearCategoria(categoria);
		
		List<Categoria> categorias = servicioCategoria.mostrarCategorias();
		
		modelo.put("categoriaCreada", categoria);
		modelo.put("categorias", categorias);
		return new ModelAndView("confirmacionCategoria",modelo);
	}

}
