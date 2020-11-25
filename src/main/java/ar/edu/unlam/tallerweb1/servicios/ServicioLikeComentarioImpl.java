package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.modelo.Comentario;
import ar.edu.unlam.tallerweb1.modelo.LikeComentario;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioLikeComentario;

@Service
@Transactional
public class ServicioLikeComentarioImpl implements ServicioLikeComentario {
	
	@Inject
	private RepositorioLikeComentario repositorioLikeComentario;
	@Inject
	private ServicioUsuario servicioUsuario;
	@Inject
	private ServicioComentar servicioComentario;
	

	@Override
	public Long guardarLike(LikeComentario like) {
		return  repositorioLikeComentario.guardar(like);
	}

	@Override
	public void darLikeAComentario(Comentario comentario, Usuario usuario) {
		Usuario usuarioLike = servicioUsuario.obtenerUsuarioPorId(usuario.getId());
		LikeComentario like = repositorioLikeComentario.obtenerLikePorComentarioYUsuario(comentario, usuarioLike);
		if( like == null) {
			LikeComentario nuevoLike = new LikeComentario();
			nuevoLike.setComentario(comentario);
			nuevoLike.setUsuario(usuarioLike);
			this.guardarLike(nuevoLike);
			
			servicioComentario.aumentarCantidadLikes(comentario);
		}else {
			borrarLike(like);
			servicioComentario.disminuirCantidadLikes(comentario);
		}
		
	}


	@Override
	public void borrarLike(LikeComentario like) {
		 repositorioLikeComentario.borrar(like);
	}

	@Override
	public LikeComentario obtenerLikePorId(Long id) {
		return repositorioLikeComentario.obtenerLikePorId(id);
	}

	@Override
	public List<Usuario> obtenerListaUsuariosLikeComentario() {
		return repositorioLikeComentario.obtenerListaLikes();
	}

	

} 
