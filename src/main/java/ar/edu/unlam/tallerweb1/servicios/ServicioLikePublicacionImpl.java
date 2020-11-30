package ar.edu.unlam.tallerweb1.servicios;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.modelo.LikePublicacion;
import ar.edu.unlam.tallerweb1.modelo.Publicacion;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioLikePublicacion;

@Service
@Transactional
public class ServicioLikePublicacionImpl implements ServicioLikePublicacion{
	
	@Inject
	private RepositorioLikePublicacion repositorioLike;
	@Inject
	private ServicioUsuario servicioUsuario;
	@Inject
	private ServicioPublicacion servicioPublicacion;
	
	@Override
	public Long guardarLike(LikePublicacion like) {
		
		return repositorioLike.guardarLike(like);
	}

	@Override
	public void darLikeAPublicacion(Publicacion publicacion, Usuario usuario) {
		
		Usuario usuarioQueLikeo = servicioUsuario.obtenerUsuarioPorId(usuario.getId());
		LikePublicacion like = repositorioLike.obtenerLikePorPublicacionYUsuario(publicacion, usuarioQueLikeo);
		if( like == null) {
			LikePublicacion nuevoLike = new LikePublicacion();
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
	public void borrarLike(LikePublicacion like) {
		repositorioLike.borrarLike(like);
		
	}

	@Override
	public LikePublicacion obtenerLikePorId(Long id) {
		return repositorioLike.obtenerLikePorId(id);
	}
	
}
