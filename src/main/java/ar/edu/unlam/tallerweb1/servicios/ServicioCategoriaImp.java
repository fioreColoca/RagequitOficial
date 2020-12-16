package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import ar.edu.unlam.tallerweb1.modelo.Categoria;
import ar.edu.unlam.tallerweb1.modelo.CategoriaEstado;
import ar.edu.unlam.tallerweb1.modelo.CategoriaTipo;
import ar.edu.unlam.tallerweb1.modelo.ComentarioTipo;
import ar.edu.unlam.tallerweb1.modelo.Publicacion;
import ar.edu.unlam.tallerweb1.modelo.PublicacionEstado;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioCategoria;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioPublicacion;

@Service
@Transactional
public class ServicioCategoriaImp implements ServicioCategoria {
	
	@Inject
	private RepositorioCategoria repositorioCategoria;
	
	@Inject
	private RepositorioPublicacion repositorioPublicacion;

	@Override
	public Long guardarCategoria(Categoria categoria) {
		return repositorioCategoria.guardarCategoria(categoria);
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
		Categoria categoriaABorrar = repositorioCategoria.mostrarCategoriaPorId(id);
		
		List<Publicacion> publicacionesConCategoriaABorrar= repositorioPublicacion.buscarPublicacionesPorCategoria(categoriaABorrar);
		
		if (publicacionesConCategoriaABorrar != null) {
			categoriaABorrar.setEstado(CategoriaEstado.INACTIVO);
		} else {
			repositorioCategoria.borrarCategoria(id);
		}
			
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

	@Override
	public void aumentarSeguidores(Categoria categoria) {
		Categoria categoriaAumentar = repositorioCategoria.mostrarCategoriaPorId(categoria.getId());
		Integer seguidores = categoriaAumentar.getContadorSeguidores() + 1;
		categoriaAumentar.setContadorSeguidores(seguidores);
		
	}

	@Override
	public void disminuirSeguidores(Categoria categoriaSeguida) {
		Categoria categoriaDisminuir = repositorioCategoria.mostrarCategoriaPorId(categoriaSeguida.getId());
		Integer seguidores = categoriaDisminuir.getContadorSeguidores() - 1;
		categoriaDisminuir.setContadorSeguidores(seguidores);		
	}

	@Override
	public Categoria mostrarCategoriaPorNombre(String nombre) {
		return repositorioCategoria.mostrarCategoriaPorNombre(nombre);
	}
	
	
	
}
