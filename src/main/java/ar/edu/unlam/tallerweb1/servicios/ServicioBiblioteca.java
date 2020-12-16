package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Biblioteca;
import ar.edu.unlam.tallerweb1.modelo.Categoria;
import ar.edu.unlam.tallerweb1.modelo.CategoriaTipo;

public interface ServicioBiblioteca {

	Long crearBiblioteca(Biblioteca biblioteca);

	Biblioteca obtenerBiblioteca(Long id);

	List<Categoria> obtenerListaDeCategorias();

	List<Categoria> obtenerBibliotecaFiltradaPorCategoria(Categoria categoria);

}
