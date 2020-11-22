package ar.edu.unlam.tallerweb1.servicios;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.modelo.Likee;
import ar.edu.unlam.tallerweb1.modelo.Publicacion;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioLike;

@Service
@Transactional
public class ServicioLikeImpl implements ServicioLike{
	
	@Inject
	private RepositorioLike repositorioLike;
	@Inject
	private ServicioUsuario servicioUsuario;
	@Inject
	private ServicioPublicacion servicioPublicacion;
	
	@Override
	public Long guardarLike(Likee like) {
		
		return repositorioLike.guardarLike(like);
	}

	@Override
	public void darLikeAPublicacion(Publicacion publicacion, Usuario usuario) {
		
		Usuario usuarioQueLikeo = servicioUsuario.obtenerUsuarioPorId(usuario.getId());
		Likee like = repositorioLike.obtenerLikePorPublicacionYUsuario(publicacion, usuarioQueLikeo);
		if( like == null) {
			Likee nuevoLike = new Likee();
			nuevoLike.setPublicacion(publicacion);
			nuevoLike.setUsuario(usuarioQueLikeo);
			this.guardarLike(nuevoLike);
			
			servicioPublicacion.aumentarCantidadLikesDePublicacion(publicacion);
		}else {
			borrarLike(like);
			servicioPublicacion.disminuirCantidadLikesDePublicacion(publicacion);
		}
		
	}

	@Override
	public void borrarLikePorId(Long id) {
		repositorioLike.borrarLikePorId(id);
		
	}

	@Override
	public void borrarLike(Likee like) {
		repositorioLike.borrarLike(like);
		
	}

	@Override
	public Likee obtenerLikePorId(Long id) {
		return repositorioLike.obtenerLikePorId(id);
	}
	
}
