package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Comentario;
import ar.edu.unlam.tallerweb1.modelo.Publicacion;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

public interface ServicioComentar {
	
	 Long enviarComentario(Comentario comentario);

	 Comentario mostrarComentario(Long id);
	 	
	 void borrarComentario(Long id);
	 	 	 
	 void tipoComentario(String boton,Comentario comentario);
	
	 List<Comentario> mostrarComentarioPorPublicacion(Publicacion publicacion);
	 
	 List<Comentario> mostrarTodosLosComentarios();
	 
	 List<Comentario> respuestaListado(Comentario comentario);
	 
	 Boolean verificarUsuario(Usuario usuarioLogueado, Usuario usuarioIngresado);
	 
	 void aumentarCantidadLikes(Comentario comentario);
	 
	 void disminuirCantidadLikes(Comentario comentario);

	
	 
	/* Integer devolverAnio(Comentario comentario); */
	 	 
}
