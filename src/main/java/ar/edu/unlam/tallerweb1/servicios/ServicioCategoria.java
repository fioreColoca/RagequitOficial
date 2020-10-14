package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Categoria;

public interface ServicioCategoria {
	
	void crearCategoria(Categoria categoria);
	
	Categoria mostrarCategoriaPorId(Long id);
	

}
