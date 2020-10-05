package ar.edu.unlam.tallerweb1.servicios;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import ar.edu.unlam.tallerweb1.modelo.Lista;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioLista;

@Service
@Transactional
public class ServicioListaImpl implements ServicioLista {

	@Inject
	private RepositorioLista repositorioLista;
	
	@Override
	public Long crearLista(Lista lista) {
		return repositorioLista.crearLista(lista);
	}

}
