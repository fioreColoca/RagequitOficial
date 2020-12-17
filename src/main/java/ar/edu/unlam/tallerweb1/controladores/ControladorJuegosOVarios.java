package ar.edu.unlam.tallerweb1.controladores;

import java.util.List;
import java.util.TreeSet;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Biblioteca;
import ar.edu.unlam.tallerweb1.modelo.Categoria;
import ar.edu.unlam.tallerweb1.modelo.Comentario;
import ar.edu.unlam.tallerweb1.modelo.CriticaCategoria;
import ar.edu.unlam.tallerweb1.modelo.Publicacion;
import ar.edu.unlam.tallerweb1.modelo.SeguirCategoria;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioCategoria;
import ar.edu.unlam.tallerweb1.servicios.ServicioComentario;
import ar.edu.unlam.tallerweb1.servicios.ServicioCriticaCategoria;
import ar.edu.unlam.tallerweb1.servicios.ServicioPublicacion;
import ar.edu.unlam.tallerweb1.servicios.ServicioSeguirCategoria;

@Controller
public class ControladorJuegosOVarios {

	@Inject
	private ServicioCategoria servicioCategoria;

	@Inject
	private ServicioSeguirCategoria servicioSeguirCategoria;

	@Inject
	private ServicioCriticaCategoria servicioCriticaCategoria;

	@Inject
	private ServicioPublicacion servicioPublicacion;

	@Inject
	private ServicioComentario servicioComentario;

	@RequestMapping(path = "/juegosOVarios")
	public ModelAndView juegosOvarios(@RequestParam(value = "categoriaId", required = false) Long categoriaId,
			HttpServletRequest request) {
		ModelMap modelo = new ModelMap();
		CriticaCategoria critica = new CriticaCategoria();
		Categoria juegosOVarios = servicioCategoria.mostrarCategoriaPorId(categoriaId);
		TreeSet<Publicacion> publicaciones = new TreeSet<>();

		String ordenPublicaciones = "ordenFechaRecienteAAntigua";

		Usuario usuarioLogeado = request.getSession().getAttribute("USUARIO") != null
				? (Usuario) request.getSession().getAttribute("USUARIO")
				: null;

		if (categoriaId == null) {
			publicaciones = servicioPublicacion.devolverPublicacionesOrdenadasPor(ordenPublicaciones, usuarioLogeado);
		} else if (!(categoriaId == null)) {
			Categoria categoria = servicioCategoria.mostrarCategoriaPorId(categoriaId);
			List publicacionesList = servicioPublicacion.buscarPublicacionesPorCategoria(categoria);

			publicaciones = servicioPublicacion.ordenarUnaListaDePublicacionesPor(ordenPublicaciones, publicacionesList,
					usuarioLogeado);
		}

		SeguirCategoria verificarSeguimientoCategoria = null;
		if (usuarioLogeado != null && juegosOVarios != null) {
			verificarSeguimientoCategoria = servicioSeguirCategoria
					.buscarSeguirCategoriaPorUsuarioYCategoria(usuarioLogeado, juegosOVarios);
		}

		TreeSet<Comentario> comentarios = servicioComentario.devolverListaComentarioPorMasLikes();
		TreeSet<Comentario> respuestas = servicioComentario.devolverListaRespuestaPorMasLikes();
		List<Usuario> listaSeguidores = servicioSeguirCategoria.devolverListaDeSeguidores(juegosOVarios);

		modelo.put("criticaCategoria", critica);
		modelo.put("listaSeguidores", listaSeguidores);
		modelo.put("verificarSeguimientoCategoria", verificarSeguimientoCategoria);
		modelo.put("juegosOVarios", juegosOVarios);
		modelo.put("publicaciones", publicaciones);
		modelo.put("comentario", new Comentario());
		modelo.put("comentarios", comentarios);
		modelo.put("respuestas", respuestas);
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
