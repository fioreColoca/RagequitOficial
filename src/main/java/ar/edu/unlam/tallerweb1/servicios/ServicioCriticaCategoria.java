package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Categoria;
import ar.edu.unlam.tallerweb1.modelo.CriticaCategoria;

public interface ServicioCriticaCategoria {
	void crearUnaCriticaCategoria(CriticaCategoria criticaCategoria);

	List<CriticaCategoria> obtenerListaCriticasPorMismaCategoria(Categoria categoria);

}
