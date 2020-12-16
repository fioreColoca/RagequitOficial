package ar.edu.unlam.tallerweb1.controladores;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Categoria;
import ar.edu.unlam.tallerweb1.modelo.CriticaCategoria;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioCategoria;
import ar.edu.unlam.tallerweb1.servicios.ServicioCriticaCategoria;
import ar.edu.unlam.tallerweb1.servicios.ServicioUsuario;

@Controller
public class ControladorCriticaCategoria {

	@Inject
	private ServicioCriticaCategoria servicioCriticaCategoria;
	@Inject
	private ServicioUsuario servicioUsuario;
	@Inject
	private ServicioCategoria servicioCategoria;

	@RequestMapping(path = "/crearCriticaCategoria", method = RequestMethod.POST)
	public ModelAndView crearCriticaCategoria(@RequestParam(value = "usuarioCritico") Long idUsuario,
			@RequestParam(value = "categoria") Long idCategoria,
			@RequestParam(value = "calificacion") Integer calificacion,
			@RequestParam(value = "mensaje") String mensaje) {
		CriticaCategoria criticaCategoria = new CriticaCategoria();
		Usuario usuarioCritico = servicioUsuario.obtenerUsuarioPorId(idUsuario);
		Categoria categoria = servicioCategoria.mostrarCategoriaPorId(idCategoria);
		criticaCategoria.setUsuarioCritico(usuarioCritico);
		criticaCategoria.setCategoria(categoria);
		criticaCategoria.setCalificacion(calificacion);
		criticaCategoria.setMensaje(mensaje);
		servicioCriticaCategoria.crearUnaCriticaCategoria(criticaCategoria);

		return new ModelAndView("redirect:/juegosOVarios?categoriaId=" + idCategoria);
	}

}
