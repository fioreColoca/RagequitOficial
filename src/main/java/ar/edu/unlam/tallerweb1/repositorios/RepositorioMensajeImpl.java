package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Categoria;
import ar.edu.unlam.tallerweb1.modelo.Mensaje;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

@Repository
public class RepositorioMensajeImpl implements RepositorioMensaje {

	@Inject
	private SessionFactory sessionFactory;

	@Override
	public Long crearMensaje(Mensaje mensaje) {
		Session session = sessionFactory.getCurrentSession();
		return (Long) session.save(mensaje);
	}

	@Override
	public Mensaje obtenerMensajePorId(Long id) {
		return sessionFactory.getCurrentSession().get(Mensaje.class, id);
	}

	@Override
	public List<Mensaje> obtenerListaMensajesPorUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		return null;
	}

}
