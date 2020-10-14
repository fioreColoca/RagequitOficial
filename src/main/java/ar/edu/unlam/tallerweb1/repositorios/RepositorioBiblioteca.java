package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Biblioteca;

public interface RepositorioBiblioteca {
	
	Long crearBiblioteca (Biblioteca biblioteca);
	
	Biblioteca obtenerBiblioteca(Long id);

}
