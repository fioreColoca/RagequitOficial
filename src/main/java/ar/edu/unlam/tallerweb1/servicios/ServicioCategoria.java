package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Categoria;
import ar.edu.unlam.tallerweb1.modelo.CategoriaTipo;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

public interface ServicioCategoria {

	void guardarCategoria(Categoria categoria);

	Categoria mostrarCategoriaPorId(Long id);

	List<Categoria> mostrarCategoriaPorTipo(CategoriaTipo categoriaTipo);

	List<Categoria> mostrarCategorias();

	void borrarCategoria(Long id);

//	void editarCategoria(Categoria categoria);

	void editarNombre(String nombre, Long id);

	void editarTipo(Integer tipoCategoria, Long id);

	void aumentarSeguidores(Categoria categoriaSeguida);

	void disminuirSeguidores(Categoria categoriaSeguida);

}
