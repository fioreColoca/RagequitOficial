package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Notificacion;
import ar.edu.unlam.tallerweb1.modelo.NotificacionTipo;
import ar.edu.unlam.tallerweb1.modelo.Publicacion;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

public interface RepositorioNotificacion {

	Long guardarNotificacion(Notificacion notificacion);

	Notificacion obtenerNotificacionPorUsuario1Usuario2YPublicacion(Usuario usuario1, Usuario usuario2,
			Publicacion publicacion);

	Notificacion obtenerNotificacionPorUsuario1Usuario2YTipoPublicacion(Usuario usuario1, Usuario usuario2,
			NotificacionTipo tipoPublicacion);

	void borrarNotificacionPorId(Long notificacionId);

	Notificacion obtenerNotificacionPorId(Long id);

	List<Notificacion> obtenerListaDeNotificacionesDelUsuario(Usuario usuario);

	List<Notificacion> obtenerListaDeNotificacionPorTipo(NotificacionTipo tipo);

}
