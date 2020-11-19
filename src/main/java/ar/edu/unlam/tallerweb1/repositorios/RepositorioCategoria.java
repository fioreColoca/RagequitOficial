package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Categoria;
import ar.edu.unlam.tallerweb1.modelo.CategoriaTipo;

public interface RepositorioCategoria {
	
	void guardarCategoria(Categoria categoria);
	
	Categoria mostrarCategoriaPorId(Long id);
	
	List<Categoria> mostrarCategoriaPorTipo(CategoriaTipo tipoCategoria);
	
	List<Categoria> mostrarCategorias();
	
	void borrarCategoria (Long id);
	
//	void editarCategoria(Categoria categoria);

//	void editarNombre(Long id);



}
