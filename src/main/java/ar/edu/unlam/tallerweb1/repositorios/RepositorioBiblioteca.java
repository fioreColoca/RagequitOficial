package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Biblioteca;
import ar.edu.unlam.tallerweb1.modelo.Categoria;
import ar.edu.unlam.tallerweb1.modelo.CategoriaTipo;

public interface RepositorioBiblioteca {

	Long crearBiblioteca(Biblioteca biblioteca);

	Biblioteca obtenerBiblioteca(Long id);

	List<Categoria> obtenerBibliotecaFiltradaPorCategoria(Categoria categoria);

}
