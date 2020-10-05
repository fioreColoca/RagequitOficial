package ar.edu.unlam.tallerweb1.servicios;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import ar.edu.unlam.tallerweb1.modelo.Publicacion;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioPublicacion;

@Service
@Transactional
public class ServicioPublicacionImpl implements ServicioPublicacion {

	@Inject
	private RepositorioPublicacion repositorioPublicacion;

	@Override
	public Long guardarPublicacion(Publicacion publicacion) {
		
		return repositorioPublicacion.guardarPublicacion(publicacion);
	}

}
