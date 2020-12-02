package ar.edu.unlam.tallerweb1.controladores;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

import ar.edu.unlam.tallerweb1.modelo.Notificacion;
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
		List<Notificacion> notificacionesUsuario= servicioNotificacion.obtenerListaDeNotificacionesDelUsuario(usuarioLogeado);
		
		modelo.put("title", "RageQuit | Notificaciones");
		modelo.put("notificaciones", notificacionesUsuario);
		modelo.put("usuarioLogeado", usuarioLogeado);
		
		return new ModelAndView("notificaciones", modelo);
	}
	
	@RequestMapping(path = "/notificacionVer", produces = "application/json")
	@ResponseBody
	public String notificacionVer(
			@RequestParam(value = "notificacionId", required = false) Long notificacionId,
			HttpServletRequest request) {
		Gson gson = new Gson();
		servicioNotificacion.setearNotificacionVisto(notificacionId);
		
		Usuario usuarioLogeado = request.getSession().getAttribute("USUARIO") != null
				? (Usuario) request.getSession().getAttribute("USUARIO")
				: null;
		Usuario usuario = servicioUsuario.obtenerUsuarioPorId(usuarioLogeado.getId());
		servicioUsuario.disminuirCantidadNotificacionesDeUsuario(usuario);
		return gson.toJson(notificacionId);
	}
	
}
