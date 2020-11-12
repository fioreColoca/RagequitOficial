package ar.edu.unlam.tallerweb1.controladores;

import java.util.List;

import javax.inject.Inject;

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
	
	@RequestMapping(path="/biblioteca")
	public ModelAndView biblioteca(
			@RequestParam(value = "filtro", required = false) CategoriaTipo categoriaTipo
			) {
		
		Biblioteca biblioteca = new Biblioteca();
		ModelMap modelo = new ModelMap();
		
		Long idbiblioteca = servicioBiblioteca.crearBiblioteca(biblioteca);
		
		List<Categoria> categorias = servicioCategoria.mostrarCategorias();
		
		if(!(categoriaTipo == null)) {
			Categoria categoria = servicioCategoria.mostrarCategoriaPorTipo(categoriaTipo);
			categorias =  servicioBiblioteca.obtenerBibliotecaFiltradaPorCategoria(categoria);
		}
		
		modelo.put("categorias", categorias);		
		modelo.put("idBiblioteca", idbiblioteca);
		modelo.put("biblioteca", biblioteca);
		modelo.put("title", "RageQuit | Biblioteca");

		return new ModelAndView("biblioteca", modelo);
	}
	
	@RequestMapping(path="/bibliotecaFiltrada", method = RequestMethod.GET)
	public ModelAndView bibliotecaDesplegada(
			@RequestParam(value = "filtro", required = false) Long categoriaId
			) {		
		
		if(!(categoriaId == -1)) {
			return new ModelAndView("redirect:/biblioteca?categoriaId="+categoriaId);
		}
			
		
		return new ModelAndView("redirect:/biblioteca");
	}
	
	
	
	

}
