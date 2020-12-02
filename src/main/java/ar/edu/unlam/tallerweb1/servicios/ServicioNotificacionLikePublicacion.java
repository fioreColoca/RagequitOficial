package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.NotificacionLikePublicacion;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

public interface ServicioNotificacionLikePublicacion {
	Long guardarNotificacionLikePublicacion(NotificacionLikePublicacion notificacion);

	NotificacionLikePublicacion obtenerNotificacionLikePublicacionPorUsuario1YUsuario2(Usuario usuario1,Usuario usuario2);

	void borrarNotificacionLikePublicacionPorId(Long notificacionId);
	
	NotificacionLikePublicacion obtenerNotificacionLikePublicacionPorId(Long id);
}
