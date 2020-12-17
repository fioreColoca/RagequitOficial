package ar.edu.unlam.tallerweb1.controladores;

import java.util.Date;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import ar.edu.unlam.tallerweb1.modelo.Mensaje;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioMensaje;
import ar.edu.unlam.tallerweb1.servicios.ServicioUsuario;

@Controller
public class ControladorMensajes {
	@Inject
	private ServicioUsuario servicioUsuario;
	@Inject
	private ServicioMensaje servicioMensaje;

	@RequestMapping(path = "/verMensaje")
	public ModelAndView verMensaje(HttpServletRequest request) {
		Usuario usuarioLogeado = request.getSession().getAttribute("USUARIO") != null
				? (Usuario) request.getSession().getAttribute("USUARIO")
				: null;
		ModelMap modelo = new ModelMap();
		modelo.put("title", "RageQuit | Mensajes");

		return new ModelAndView("mensaje", modelo);
	}

	@RequestMapping(path = "/crearMensaje", produces = "application/json", method = RequestMethod.POST)
	@ResponseBody
	public String crearMensaje(@RequestParam(value = "mensajeAMandarAUsuario") String mensaje,
			@RequestParam(value = "idUsuarioEnviaMensaje") Long idUsuarioEnviaMensaje,
			@RequestParam(value = "idUsuarioRecibeMensaje") Long idUsuarioRecibeMensaje, HttpServletRequest request) {
		Usuario usuarioLogeado = request.getSession().getAttribute("USUARIO") != null
				? (Usuario) request.getSession().getAttribute("USUARIO")
				: null;

		Gson gson = new Gson();
		JsonObject json = new JsonObject();
		json.addProperty("errorEnviarMensaje", false);
		if (usuarioLogeado != null) {
			Date fecha = new Date();
			Usuario usuarioEnviaMensaje = servicioUsuario.obtenerUsuarioPorId(idUsuarioEnviaMensaje);
			Usuario usuarioRecibeMensaje = servicioUsuario.obtenerUsuarioPorId(idUsuarioRecibeMensaje);

			Mensaje nuevoMensaje = new Mensaje();

			nuevoMensaje.setMensaje(mensaje);
			nuevoMensaje.setFecha(fecha);
			nuevoMensaje.setUsuarioEnviaMensaje(usuarioEnviaMensaje);
			nuevoMensaje.setUsuarioRecibeMensaje(usuarioRecibeMensaje);

			servicioMensaje.crearMensaje(nuevoMensaje);
			return gson.toJson(json);
		}
		json.addProperty("errorEnviarMensaje", true);
		return gson.toJson(json);
	}
}
