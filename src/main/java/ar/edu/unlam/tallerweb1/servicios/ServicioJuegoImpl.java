package ar.edu.unlam.tallerweb1.servicios;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.modelo.Juego;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioJuego;

@Service
@Transactional
public class ServicioJuegoImpl implements ServicioJuego {

	@Inject
	private RepositorioJuego repositorioJuego;
	
	@Override
	public Long guardarJuego(Juego juego) {
		
		return repositorioJuego.guardarJuego(juego);
	}

	
	@Override
	public Juego obtenerJuego(Long id) {
		
		return repositorioJuego.obtenerJuego(id);
	}

	@Override
	public void borrarJuego(Long id) {
		
		repositorioJuego.borrarJuego(id);

	}

}
