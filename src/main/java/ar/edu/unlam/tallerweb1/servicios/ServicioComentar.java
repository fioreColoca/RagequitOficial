package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Comentario;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

public interface ServicioComentar {
	
	 Long enviarComentario(Comentario comentario);

	 Comentario mostrarComentario(Long id);
	 	
	 void borrarComentario(Long id);
	 
	 void darLikeComentario(Long id);
	 	 
	 void tipoComentario(String boton,Comentario comentario);
	
	 List<Comentario> mostrarComentarioPorPublicacion(Long idPublicacion);
	 
	 List<Comentario> mostrarTodosLosComentarios();
	 
	 List<Comentario> respuestaListado(Comentario comentario);
	 
	 Boolean veridifcarUsuario(Usuario usuarioLogueado, Usuario usuarioIngresado);
	 
	/* Integer devolverAnio(Comentario comentario); */
	 	 
}
