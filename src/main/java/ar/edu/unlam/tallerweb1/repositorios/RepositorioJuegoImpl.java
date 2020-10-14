package ar.edu.unlam.tallerweb1.repositorios;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Juego;

@Repository
public class RepositorioJuegoImpl implements RepositorioJuego {

	@Inject
	private SessionFactory sessionFactory;
	
	@Override
	public Long guardarJuego(Juego juego) {
		Session session = sessionFactory.getCurrentSession();
		return (Long)session.save(juego);
	}

	@Override
	public Juego obtenerJuego(Long id) {
		
		
		return sessionFactory.getCurrentSession().get(Juego.class, id);
	}

	@Override
	public void borrarJuego(Long id) {
		Juego juego = obtenerJuego(id);
		sessionFactory.getCurrentSession().delete(juego);

	}

}
