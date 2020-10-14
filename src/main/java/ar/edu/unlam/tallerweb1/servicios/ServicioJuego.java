package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Juego;

public interface ServicioJuego {
	
	Long guardarJuego(Juego juego);
	Juego obtenerJuego(Long id);
	void borrarJuego(Long id);
	
}
