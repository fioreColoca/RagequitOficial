package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Categoria;
import ar.edu.unlam.tallerweb1.modelo.CriticaCategoria;

public interface RepositorioCriticaCategoria {
	void crearUnaCriticaCategoria(CriticaCategoria criticaCategoria);

	CriticaCategoria obtenerCriticaCategoriaPorId(Long id);

	List<CriticaCategoria> obtenerListaCriticasPorMismaCategoria(Categoria categoria);

}
