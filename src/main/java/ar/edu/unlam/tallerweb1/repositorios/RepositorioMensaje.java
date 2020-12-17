package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Mensaje;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

public interface RepositorioMensaje {

	Long crearMensaje(Mensaje mensaje);

	Mensaje obtenerMensajePorId(Long id);

	List<Mensaje> obtenerListaMensajesPorUsuario(Usuario usuario);

}
