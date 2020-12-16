package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import ar.edu.unlam.tallerweb1.modelo.Categoria;
import ar.edu.unlam.tallerweb1.modelo.CategoriaTipo;

public interface RepositorioCategoria {

	
	Long guardarCategoria(Categoria categoria);
	
	Categoria mostrarCategoriaPorId(Long id);
	
	Categoria mostrarCategoriaPorNombre(String nombre);
	
	List<Categoria> mostrarCategoriaPorTipo(CategoriaTipo tipoCategoria);

	List<Categoria> mostrarCategorias();

	void borrarCategoria(Long id);


}
