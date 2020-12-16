package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.CriticaCategoria;

public interface RepositorioCriticaCategoria {
	void crearUnaCriticaCategoria(CriticaCategoria criticaCategoria);
	
	CriticaCategoria obtenerCriticaCategoriaPorId(Long id);
	
}
