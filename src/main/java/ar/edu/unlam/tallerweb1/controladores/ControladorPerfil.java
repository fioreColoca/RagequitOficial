package ar.edu.unlam.tallerweb1.controladores;

import java.util.List;
import java.util.TreeSet;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.jvnet.staxex.util.XMLStreamReaderToXMLStreamWriter.Breakpoint;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import ar.edu.unlam.tallerweb1.modelo.Categoria;
import ar.edu.unlam.tallerweb1.modelo.Comentario;
import ar.edu.unlam.tallerweb1.modelo.Publicacion;
import ar.edu.unlam.tallerweb1.modelo.Seguir;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioCategoria;
import ar.edu.unlam.tallerweb1.servicios.ServicioComentario;
import ar.edu.unlam.tallerweb1.servicios.ServicioPublicacion;
import ar.edu.unlam.tallerweb1.servicios.ServicioSeguir;
import ar.edu.unlam.tallerweb1.servicios.ServicioUsuario;
import net.bytebuddy.asm.Advice.Exit;

@Controller
public class ControladorPerfil {

	@Inject
	private ServicioCategoria servicioCategoria;

	@Inject
	private ServicioUsuario servicioUsuario;

	@Inject
	private ServicioSeguir servicioSeguir;

	@Inject
	private ServicioPublicacion servicioPublicacion;

	@Inject
	private ServicioComentario servicioComentario;

	@RequestMapping("/perfil")
	public ModelAndView verPerfil(HttpServletRequest request,
			@RequestParam(value = "usuarioNombre", required = false) String nombreUsuarioPerfil) {
		ModelMap modelo = new ModelMap();

		Usuario usuarioLogeado = request.getSession().getAttribute("USUARIO") != null
				? (Usuario) request.getSession().getAttribute("USUARIO")
				: null;
		Usuario usuarioPerfil = nombreUsuarioPerfil != null
				? servicioUsuario.obtenerUsuarioPorNombreUsuario(nombreUsuarioPerfil)
				: null;

		TreeSet<Publicacion> publicacioneHechasPorUnUsuario = servicioPublicacion
				.devolverPublicacionesOrdenadasPor("hechasPorUsuario", usuarioPerfil);
		List<Categoria> categorias = servicioUsuario.devolverListaDeCategoriasSeguidasPorUsuario(usuarioPerfil);
		List<Usuario> listaSeguidores = servicioSeguir.devolverListaDeSeguidores(usuarioPerfil);
		List<Usuario> listaSeguidos = servicioSeguir.devolverListaDeSeguidos(usuarioPerfil);
		TreeSet<Comentario> comentarios = servicioComentario.devolverListaComentarioPorMasLikes();
		List<Seguir> seguimientos = servicioSeguir.devolverListaDeSeguimientos();
		TreeSet<Comentario> respuestas = servicioComentario.devolverListaRespuestaPorMasLikes();

		Seguir verificarSeguimiento = null;
		if (usuarioLogeado != null && usuarioPerfil != null) {
			verificarSeguimiento = servicioSeguir.buscarSeguirPorUsuarioSeguidorYUsuarioSeguido(usuarioLogeado,
					usuarioPerfil);
		}
		modelo.put("seguimientos", seguimientos);
		modelo.put("publicaciones", publicacioneHechasPorUnUsuario);
		modelo.put("verificacionSeguir", verificarSeguimiento);
		modelo.put("usuarioPerfil", usuarioPerfil);
		modelo.put("categorias", categorias);
		modelo.put("comentario", new Comentario());
		modelo.put("comentarios", comentarios);
		modelo.put("respuestas", respuestas);
		modelo.put("usuarioLogeado", usuarioLogeado);
		modelo.put("listaSeguidores", listaSeguidores);
		modelo.put("listaSeguidos", listaSeguidos);
		modelo.put("title", "RageQuit | Perfil");
		return new ModelAndView("perfil", modelo);
	}

	@RequestMapping(path = "/seguir", method = RequestMethod.POST)
	public ModelAndView seguirUsuario(HttpServletRequest request,
			@RequestParam(value = "usuarioSeguido", required = false) String usuarioSeguido,
			@RequestParam(value = "usuarioSeguidoHome", required = false) Integer usuarioSeguidoHome) {

		Usuario usuarioLogeado = request.getSession().getAttribute("USUARIO") != null
				? (Usuario) request.getSession().getAttribute("USUARIO")
				: null;
		Usuario usuarioSeguido1 = servicioUsuario.obtenerUsuarioPorNombreUsuario(usuarioSeguido);

		servicioSeguir.seguirUsuario(usuarioLogeado, usuarioSeguido1);

		if (usuarioSeguidoHome != null) {
			return new ModelAndView("redirect:/home");
		}
		return new ModelAndView("redirect:/perfil?usuarioNombre=" + usuarioSeguido1.getNombreUsuario());

	}

	@RequestMapping(path = "/dejarSeguir", method = RequestMethod.POST)
	public ModelAndView dejarDeSeguirUsuario(HttpServletRequest request,
			@RequestParam(value = "usuarioSeguido", required = false) String usuarioSeguido,
			@RequestParam(value = "usuarioSeguidoHome", required = false) Integer usuarioSeguidoHome) {

		Usuario usuarioLogeado = request.getSession().getAttribute("USUARIO") != null
				? (Usuario) request.getSession().getAttribute("USUARIO")
				: null;
		Usuario usuarioSeguido1 = servicioUsuario.obtenerUsuarioPorNombreUsuario(usuarioSeguido);
		servicioSeguir.dejarDeSeguirUsuario(usuarioLogeado, usuarioSeguido1);
		if (usuarioSeguidoHome != null) {
			return new ModelAndView("redirect:/home");

		}
		return new ModelAndView("redirect:/perfil?usuarioNombre=" + usuarioSeguido1.getNombreUsuario());

	}

}
