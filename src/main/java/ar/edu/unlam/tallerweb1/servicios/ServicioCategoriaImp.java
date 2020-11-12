package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import ar.edu.unlam.tallerweb1.modelo.Categoria;
import ar.edu.unlam.tallerweb1.modelo.CategoriaTipo;
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
	@Override
	public Categoria mostrarCategoriaPorTipo(CategoriaTipo categoriaTipo) {
		return repositorioCategoria.mostrarCategoriaPorTipo(categoriaTipo);
	}
	
}
