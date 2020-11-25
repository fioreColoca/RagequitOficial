package ar.edu.unlam.tallerweb1.modelo;

import java.util.Comparator;

public class ComentarioOrdenadoPorLikes implements Comparator<Comentario> {
	

	@Override 
	public int compare(Comentario comentario, Comentario comentario2) { 
	return comentario2.getCantidadLikes().compareTo(comentario.getCantidadLikes()); 

	} 

}
