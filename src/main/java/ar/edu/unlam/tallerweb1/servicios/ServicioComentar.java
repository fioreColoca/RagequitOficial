package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Comentario;

public interface ServicioComentar {
	
	 Long enviarComentario(Comentario comentario);

	Comentario mostrarComentario(Long id);

}
