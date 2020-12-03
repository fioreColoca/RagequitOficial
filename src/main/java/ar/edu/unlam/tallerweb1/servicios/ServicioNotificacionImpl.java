package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.modelo.Notificacion;
import ar.edu.unlam.tallerweb1.modelo.Publicacion;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioNotificacion;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioUsuario;

@Service
@Transactional
public class ServicioNotificacionImpl implements ServicioNotificacion {
	
	@Inject
	private RepositorioNotificacion repositorioNotificacion;
	@Inject
	private RepositorioUsuario repositorioUsuario;
	
	@Override
	public Long guardarNotificacion(Notificacion notificacion) {
		return repositorioNotificacion.guardarNotificacion(notificacion);
	}

	@Override
	public Notificacion obtenerNotificacionPorUsuario1Usuario2YPublicacion
	(Usuario usuario1,Usuario usuario2,Publicacion publicacion) {
		Notificacion notificacion = repositorioNotificacion
		.obtenerNotificacionPorUsuario1Usuario2YPublicacion(usuario1,usuario2,publicacion);
		return notificacion;
	}

	@Override
	public void borrarNotificacionPorId(Long notificacionId) {
		repositorioNotificacion.borrarNotificacionPorId(notificacionId);
	}

	@Override
	public Notificacion obtenerNotificacionPorId(Long id) {
		
		return repositorioNotificacion.obtenerNotificacionPorId(id);
	}

	@Override
	public List<Notificacion> obtenerListaDeNotificacionesDelUsuario(Usuario usuario) {
		
		return repositorioNotificacion.obtenerListaDeNotificacionesDelUsuario(usuario);
	}

	@Override
	public void setearNotificacionVisto(Long notificacionId) {
		Notificacion notificacion = repositorioNotificacion.obtenerNotificacionPorId(notificacionId);
		notificacion.setVisto(true);
	}

	@Override
	public void setearCantidadNotificacionesEnLaSessionDeUnUsuario(Usuario usuario, HttpServletRequest request) {
		Usuario usuarioConNotificacionesActualizadas = repositorioUsuario.obtenerUsuarioPorId(usuario.getId());
		request.getSession().setAttribute("USUARIO", usuarioConNotificacionesActualizadas);
	}

}
