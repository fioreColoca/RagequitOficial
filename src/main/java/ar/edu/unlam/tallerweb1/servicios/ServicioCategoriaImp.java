package ar.edu.unlam.tallerweb1.servicios;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import ar.edu.unlam.tallerweb1.modelo.Categoria;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioCategoria;

@Service
@Transactional
public class ServicioCategoriaImp implements ServicioCategoria {
	
	private RepositorioCategoria servicioCategoria;

	@Override
	public void crearCategoria(Categoria categoria) {
		servicioCategoria.crearCategoria(categoria);
	}

	@Override
	public Categoria mostrarCategoriaPorId(Long id) {
		return servicioCategoria.mostrarCategoriaPorId(id);
	}

	
}
