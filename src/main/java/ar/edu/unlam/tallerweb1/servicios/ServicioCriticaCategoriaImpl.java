package ar.edu.unlam.tallerweb1.servicios;

import javax.inject.Inject;

import ar.edu.unlam.tallerweb1.modelo.CriticaCategoria;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioCriticaCategoria;

public class ServicioCriticaCategoriaImpl implements ServicioCriticaCategoria {

	@Inject
	private RepositorioCriticaCategoria repoCriticaCategoria;

	@Override
	public void crearUnaCriticaCategoria(CriticaCategoria criticaCategoria) {
		repoCriticaCategoria.crearUnaCriticaCategoria(criticaCategoria);
	}

}
