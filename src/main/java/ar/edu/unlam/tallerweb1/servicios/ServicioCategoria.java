package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Categoria;
import ar.edu.unlam.tallerweb1.modelo.CategoriaTipo;

public interface ServicioCategoria {
	
	void guardarCategoria(Categoria categoria);
	
	Categoria mostrarCategoriaPorId(Long id);
	
	Categoria mostrarCategoriaPorTipo(CategoriaTipo categoriaTipo);
	
	List<Categoria>mostrarCategorias();
	
	void borrarCategoria(Long id);

}
