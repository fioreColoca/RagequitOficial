package ar.edu.unlam.tallerweb1.servicios;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import ar.edu.unlam.tallerweb1.modelo.Categoria;
import ar.edu.unlam.tallerweb1.modelo.CategoriaEstado;
import ar.edu.unlam.tallerweb1.modelo.CategoriaTipo;
import ar.edu.unlam.tallerweb1.modelo.CriticaCategoria;
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
	@Inject
	private ServicioCriticaCategoria servicioCriticaCategoria;

	@Override
	public void guardarCategoria(Categoria categoria) {
		categoria.setEstado(CategoriaEstado.ACTIVO);
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
		Categoria categoriaABorrar = repositorioCategoria.mostrarCategoriaPorId(id);

		List<Publicacion> publicacionesConCategoriaABorrar = repositorioPublicacion
				.buscarPublicacionesPorCategoria(categoriaABorrar);

		if (publicacionesConCategoriaABorrar != null) {
			categoriaABorrar.setEstado(CategoriaEstado.INACTIVO);
		} else {
			repositorioCategoria.borrarCategoria(id);
		}

	}

	public List<Categoria> mostrarCategoriaPorTipo(CategoriaTipo categoriaTipo) {
		return repositorioCategoria.mostrarCategoriaPorTipo(categoriaTipo);

	}

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
	public List<String> traerNombreCategoriasExistentes() {
		List<Categoria> categorias = repositorioCategoria.mostrarCategorias();
		List<String> nombres = new ArrayList<String>();
		for (Categoria categoria : categorias) {
			nombres.add(categoria.getNombre());
		}
		return nombres;

	}

	@Override
	public void calcularCalificacionDeCategoria(Categoria categoria) {
		List<CriticaCategoria> criticas = servicioCriticaCategoria.obtenerListaCriticasPorMismaCategoria(categoria);
		Categoria categoria1 = repositorioCategoria.mostrarCategoriaPorId(categoria.getId());
		Double calificacion = 0.0;
		for (CriticaCategoria criticaCategoria : criticas) {
			calificacion += criticaCategoria.getCalificacion();
		}
		calificacion = calificacion / (double) criticas.size();

		categoria1.setCalificacion(calificacion);
	}

}
