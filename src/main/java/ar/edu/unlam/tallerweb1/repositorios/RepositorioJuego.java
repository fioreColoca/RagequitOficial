package ar.edu.unlam.tallerweb1.repositorios;


import ar.edu.unlam.tallerweb1.modelo.Juego;


public interface RepositorioJuego {
	
	Long guardarJuego(Juego juego);

	
	Juego obtenerJuego(Long id);

	void borrarJuego(Long id);

}
