package ar.edu.unlam.tallerweb1.modelo;

import java.util.Comparator;

public class PublicacionOrdenPorLikeYComentario implements Comparator<Publicacion> {

	@Override
	public int compare(Publicacion publicacion1, Publicacion publicacion2) {

		int comparacionCantidadLikes = publicacion2.getCantidadLikes().compareTo(publicacion1.getCantidadLikes());

		if (comparacionCantidadLikes == 0) {
			int comparacionCantidadComentarios = publicacion2.getCantidadComentarios()
					.compareTo(publicacion1.getCantidadComentarios());

			if (comparacionCantidadComentarios == 0) {
				return publicacion2.getFechaHora().compareTo(publicacion1.getFechaHora());
			} else {
				return comparacionCantidadComentarios;
			}
		}
		return comparacionCantidadLikes;
	}
}
