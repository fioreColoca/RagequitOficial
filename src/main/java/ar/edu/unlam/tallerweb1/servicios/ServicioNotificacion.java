package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Notificacion;
import ar.edu.unlam.tallerweb1.modelo.Publicacion;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

public interface ServicioNotificacion {
	Long guardarNotificacionLikePublicacion(Notificacion notificacion);

	Notificacion obtenerNotificacionLikePublicacionPorUsuario1Usuario2YPublicacion(Usuario usuario1,Usuario usuario2,Publicacion publicacion);

	void borrarNotificacionLikePublicacionPorId(Long notificacionId);
	
	Notificacion obtenerNotificacionLikePublicacionPorId(Long id);

	List<Notificacion> obtenerListaDeNotificacionesDelUsuario(Usuario usuario);
}
