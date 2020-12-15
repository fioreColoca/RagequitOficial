package ar.edu.unlam.tallerweb1.modelo;

import java.util.Comparator;

public class ComentarioOrdenadoPorLikes implements Comparator<Comentario> {

	@Override
	public int compare(Comentario comentario, Comentario comentario2) {
		int resultado = comentario2.getCantidadLikes().compareTo(comentario.getCantidadLikes());
		if (resultado == 0) {
			int resultadoComentario = comentario2.getCantidadLikes().compareTo(comentario.getCantidadLikes());

			if (resultadoComentario == 0) {
				return comentario2.getFechaHora().compareTo(comentario.getFechaHora());
			} else {
				return resultadoComentario;
			}
		}
		return resultado;

	}

}
