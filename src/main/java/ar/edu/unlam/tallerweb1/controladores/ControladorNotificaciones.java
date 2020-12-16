package ar.edu.unlam.tallerweb1.controladores;

import java.util.List;
import java.util.TreeSet;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import ar.edu.unlam.tallerweb1.modelo.Notificacion;
import ar.edu.unlam.tallerweb1.modelo.Publicacion;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioNotificacion;
import ar.edu.unlam.tallerweb1.servicios.ServicioUsuario;

@Controller
public class ControladorNotificaciones {
	@Inject
	ServicioNotificacion servicioNotificacion;
	@Inject
	ServicioUsuario servicioUsuario;

	@RequestMapping(path = "/notificaciones")
	public ModelAndView irAlHome(HttpServletRequest request) {
		ModelMap modelo = new ModelMap();

		Usuario usuarioLogeado = request.getSession().getAttribute("USUARIO") != null
				? (Usuario) request.getSession().getAttribute("USUARIO")
				: null;
		if (usuarioLogeado != null) {
			Usuario usuario = servicioUsuario.obtenerUsuarioPorId(usuarioLogeado.getId());
			List<Notificacion> notificacionesUsuario = servicioNotificacion
					.obtenerListaDeNotificacionesDelUsuario(usuarioLogeado);
			TreeSet<Notificacion> notificacionesOrdenadas = servicioNotificacion
					.ordenarUnaListaDeNotificacionesPorFechaDesendencete(notificacionesUsuario);

			modelo.put("notificaciones", notificacionesOrdenadas);
			modelo.put("usuarioLogeado", usuarioLogeado);
		}
		modelo.put("title", "RageQuit | Notificaciones");
		return new ModelAndView("notificaciones", modelo);
	}

	@RequestMapping(path = "/notificacionVer", produces = "application/json")
	@ResponseBody
	public String notificacionVer(@RequestParam(value = "notificacionId", required = false) Long notificacionId,
			HttpServletRequest request) {
		Gson gson = new Gson();
		JsonObject json = new JsonObject();
		servicioNotificacion.setearNotificacionVisto(notificacionId);

		Usuario usuarioLogeado = request.getSession().getAttribute("USUARIO") != null
				? (Usuario) request.getSession().getAttribute("USUARIO")
				: null;

		servicioUsuario.disminuirCantidadNotificacionesDeUsuario(usuarioLogeado);
		servicioNotificacion.setearCantidadNotificacionesEnLaSessionDeUnUsuario(usuarioLogeado, request);

		Usuario usuario = servicioUsuario.obtenerUsuarioPorId(usuarioLogeado.getId());
		Integer cantidadNotificaciones = usuario.getContadorNotificaciones();

		json.addProperty("notificacionId", notificacionId);
		json.addProperty("cantidadNotificaciones", cantidadNotificaciones);
		return gson.toJson(json);
	}

}
