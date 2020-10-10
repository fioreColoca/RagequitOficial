package ar.edu.unlam.tallerweb1.servicios;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import ar.edu.unlam.tallerweb1.modelo.Biblioteca;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioBiblioteca;

@Service
@Transactional
public class ServicioBibliotecaImpl implements ServicioBiblioteca {

	@Inject
	private RepositorioBiblioteca repositorioBiblioteca;
	
	@Override
	public Long crearBiblioteca(Biblioteca biblioteca) {
		return repositorioBiblioteca.crearBiblioteca(biblioteca);
	}

}
