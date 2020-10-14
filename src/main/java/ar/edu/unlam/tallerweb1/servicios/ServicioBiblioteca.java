package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Biblioteca;


public interface ServicioBiblioteca {
	
	Long crearBiblioteca (Biblioteca biblioteca);
	Biblioteca obtenerBiblioteca(Long id);

}
