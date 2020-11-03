package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Categoria;

public interface RepositorioCategoria {
	
	void guardarCategoria(Categoria categoria);
	
	Categoria mostrarCategoriaPorId(Long id);
	
	List<Categoria> mostrarCategorias();
	
	void borrarCategoria (Long id);

}
