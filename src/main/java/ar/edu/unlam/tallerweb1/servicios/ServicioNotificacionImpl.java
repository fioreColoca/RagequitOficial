package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.modelo.Notificacion;
import ar.edu.unlam.tallerweb1.modelo.Publicacion;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioNotificacion;

@Service
@Transactional
public class ServicioNotificacionImpl implements ServicioNotificacion {
	
	@Inject
	private RepositorioNotificacion repositorioNotificacion;
	
	@Override
	public Long guardarNotificacionLikePublicacion(Notificacion notificacion) {
		return repositorioNotificacion.guardarNotificacionLikePublicacion(notificacion);
	}

	@Override
	public Notificacion obtenerNotificacionLikePublicacionPorUsuario1Usuario2YPublicacion
	(Usuario usuario1,Usuario usuario2,Publicacion publicacion) {
		Notificacion notificacion = repositorioNotificacion
		.obtenerNotificacionLikePublicacionPorUsuario1Usuario2YPublicacion(usuario1,usuario2,publicacion);
		return notificacion;
	}

	@Override
	public void borrarNotificacionLikePublicacionPorId(Long notificacionId) {
		repositorioNotificacion.borrarNotificacionLikePublicacionPorId(notificacionId);
	}

	@Override
	public Notificacion obtenerNotificacionLikePublicacionPorId(Long id) {
		
		return repositorioNotificacion.obtenerNotificacionLikePublicacionPorId(id);
	}

	@Override
	public List<Notificacion> obtenerListaDeNotificacionesDelUsuario(Usuario usuario) {
		
		return repositorioNotificacion.obtenerListaDeNotificacionesDelUsuario(usuario);
	}

}
