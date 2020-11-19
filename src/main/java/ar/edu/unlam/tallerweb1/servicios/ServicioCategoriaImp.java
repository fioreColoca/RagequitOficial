package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import ar.edu.unlam.tallerweb1.modelo.Categoria;
import ar.edu.unlam.tallerweb1.modelo.CategoriaTipo;
import ar.edu.unlam.tallerweb1.modelo.ComentarioTipo;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioCategoria;

@Service
@Transactional
public class ServicioCategoriaImp implements ServicioCategoria {
	
	@Inject
	private RepositorioCategoria repositorioCategoria;

	@Override
	public void guardarCategoria(Categoria categoria) {
		repositorioCategoria.guardarCategoria(categoria);
	}
	
	@Override
	public Categoria mostrarCategoriaPorId(Long id) {
		return repositorioCategoria.mostrarCategoriaPorId(id);
	}

	@Override
	public List<Categoria> mostrarCategorias() {
		return repositorioCategoria.mostrarCategorias();
	}
	
	@Override
	public void borrarCategoria(Long id) {
		repositorioCategoria.borrarCategoria(id);
		
	}
//	@Override
//
//	public void editarCategoria(Categoria categoria) {
//		repositorioCategoria.editarCategoria(categoria);
//	}

	public List<Categoria> mostrarCategoriaPorTipo(CategoriaTipo categoriaTipo) {
		return repositorioCategoria.mostrarCategoriaPorTipo(categoriaTipo);

	}

//	@Override
//	public void editarCategoria(Long id) {
//		repositorioCategoria.editarCategoria(id);
//		
//	}

	@Override
	public void editarNombre(String nombre, Long id) {
		Categoria categoria = repositorioCategoria.mostrarCategoriaPorId(id);
		categoria.setNombre(nombre);
		
	}

	@Override
	public void editarTipo(Integer tipoCategoria, Long id) {
		Categoria categoria = repositorioCategoria.mostrarCategoriaPorId(id);
		if (tipoCategoria.equals(0)) {
			categoria.setTipoCategoria(CategoriaTipo.JUEGOS);
		} else {
			categoria.setTipoCategoria(CategoriaTipo.VARIOS);
		}
		
	}
	
	
	
}
