package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.excepciones.publicacionVaciaException;
import ar.edu.unlam.tallerweb1.modelo.Publicacion;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioPublicacion;

@Service
@Transactional
public class ServicioPublicacionImpl implements ServicioPublicacion {

	@Inject
	private RepositorioPublicacion repositorioPublicacion;

	@Override
	public Long guardarPublicacion(Publicacion publicacion) throws publicacionVaciaException {
		String categoriaPublicacion = publicacion.getCategoria();
		String mensajePublicacion = publicacion.getMensaje();
		
		if(categoriaPublicacion.isEmpty() & mensajePublicacion.isEmpty()) { 
			throw new publicacionVaciaException("Mensaje y categoria son obligatorios.");
		}else if(mensajePublicacion.isEmpty()){
			throw new publicacionVaciaException("Mensaje esta vacio.");
		}else if(categoriaPublicacion.isEmpty()) {
			throw new publicacionVaciaException("Categoria esta vacia.");
		}
		
		return repositorioPublicacion.guardarPublicacion(publicacion);
	}

	@Override
	public List<Publicacion> buscarPublicacionesPorCategoria(String categoria) {
		return repositorioPublicacion.buscarPublicacionesPorCategoria(categoria);
	}

	@Override
	public List<Publicacion> buscarPublicaciones() {
		return repositorioPublicacion.buscarPublicaciones();
	}
	
	@Override
	public Publicacion obtenerPublicacion(Long id) {
		
		return repositorioPublicacion.obtenerPublicacion(id);
	}

	@Override
	public void borrarPublicacion(Long id) {
		repositorioPublicacion.borrarPublicacion(id);
		
	}

	@Override
	public Integer devolverAnio(Publicacion publicacion) {
		Integer anio =((Integer)publicacion.getFechaHora().getYear()) + 1900;
		
		return anio;
	}
	


}
