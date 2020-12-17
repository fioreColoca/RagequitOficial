package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.modelo.Mensaje;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioBiblioteca;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioMensaje;

@Service
@Transactional
public class ServicioMensajeImpl implements ServicioMensaje {

	@Inject
	private RepositorioMensaje repositorioMensaje;

	@Override
	public Long crearMensaje(Mensaje mensaje) {
		return repositorioMensaje.crearMensaje(mensaje);
	}

	@Override
	public Mensaje obtenerMensajePorId(Long id) {
		return repositorioMensaje.obtenerMensajePorId(id);
	}

	@Override
	public List<Mensaje> obtenerListaMensajesPorUsuario(Usuario usuario) {
		return repositorioMensaje.obtenerListaMensajesPorUsuario(usuario);
	}

}
