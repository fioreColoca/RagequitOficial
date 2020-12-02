package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.NotificacionLikePublicacion;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

public interface RepositorioNotificacionLikePublicacion {

	Long guardarNotificacionLikePublicacion(NotificacionLikePublicacion notificacion);

	NotificacionLikePublicacion obtenerNotificacionLikePublicacionPorUsuario1YUsuario2(Usuario usuario1, Usuario usuario2);

	void borrarNotificacionLikePublicacionPorId(Long notificacionId);
	
	NotificacionLikePublicacion obtenerNotificacionLikePublicacionPorId(Long id);
}
