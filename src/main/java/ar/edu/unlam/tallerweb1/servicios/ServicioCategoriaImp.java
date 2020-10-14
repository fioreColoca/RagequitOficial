package ar.edu.unlam.tallerweb1.servicios;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import ar.edu.unlam.tallerweb1.modelo.Categoria;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioCategoria;

@Service
@Transactional
public class ServicioCategoriaImp implements ServicioCategoria {
	
	@Inject
	private RepositorioCategoria repositorioCategoria;

	@Override
	public void crearCategoria(Categoria categoria) {
		repositorioCategoria.crearCategoria(categoria);
	}

	@Override
	public Categoria mostrarCategoriaPorId(Long id) {
		return repositorioCategoria.mostrarCategoriaPorId(id);
	}

	
}
