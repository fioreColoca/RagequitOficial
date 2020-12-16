package ar.edu.unlam.tallerweb1.servicios;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.modelo.CriticaCategoria;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioCriticaCategoria;

@Service
@Transactional
public class ServicioCriticaCategoriaImpl implements ServicioCriticaCategoria {

	@Inject
	private RepositorioCriticaCategoria repoCriticaCategoria;

	@Override
	public void crearUnaCriticaCategoria(CriticaCategoria criticaCategoria) {
		repoCriticaCategoria.crearUnaCriticaCategoria(criticaCategoria);
	}

}
