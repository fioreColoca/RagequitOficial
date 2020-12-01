package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;
import java.util.TreeSet;

import ar.edu.unlam.tallerweb1.modelo.Comentario;
import ar.edu.unlam.tallerweb1.modelo.Publicacion;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

public interface ServicioComentario {
	
	 Long guardarComentario(Comentario comentario);

	 Comentario mostrarComentario(Long id);
	 	
	 void borrarComentario(Long id);
	 	 	 
	 void tipoComentario(String boton,Comentario comentario);
	
	 List<Comentario> devolverComentarioPorPublicacion(Publicacion publicacion);
	 
	 List<Comentario> devolverTodosLosComentariosyRespuestas();
	 
	 List<Comentario> respuestaListado(Comentario comentario);
	 
	 Boolean verificarUsuario(Usuario usuarioLogueado, Usuario usuarioIngresado);
	 
	 void aumentarCantidadLikes(Comentario comentario);
	 
	 void disminuirCantidadLikes(Comentario comentario);
	 	 
	 TreeSet<Comentario> ordenarComentarioPorMasLikes(List <Comentario> comentario);

	 TreeSet<Comentario> devolverListaComentarioPorMasLikes();
	 
	 List<Comentario> devolverSoloComentario();
	 
	 

	
	 
	/* Integer devolverAnio(Comentario comentario); */
	 	 
}