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
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioCategoria;

@Controller
public class ControladorJuegosOVarios {
	
	@Inject
	private ServicioCategoria servicioCategoria;
	
	@RequestMapping(path = "/juegosOVarios")
	public ModelAndView juegosOvarios(@RequestParam(value = "categoriaId", required = false) Long categoriaId,
			HttpServletRequest request) {
		ModelMap modelo = new ModelMap();

		Categoria juegosOVarios = servicioCategoria.mostrarCategoriaPorId(categoriaId);		

		Usuario usuarioLogeado = request.getSession().getAttribute("USUARIO") != null
				? (Usuario) request.getSession().getAttribute("USUARIO")
				: null;
				
		modelo.put("juegosOVarios", juegosOVarios);
		modelo.put("usuarioLogeado", usuarioLogeado);

		return new ModelAndView("juegosOVarios", modelo);
	}
	
	public ServicioCategoria getServicioCategoria() {
		return servicioCategoria;
	}

	public void setServicioCategoria(ServicioCategoria servicioCategoria) {
		this.servicioCategoria = servicioCategoria;
	}

}
