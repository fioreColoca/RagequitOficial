package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Categoria;

public interface RepositorioCategoria {
	
	void crearCategoria(Categoria categoria);
	
	Categoria mostrarCategoriaPorId(Long id);
	
	List<Categoria> mostrarCategorias();

}
