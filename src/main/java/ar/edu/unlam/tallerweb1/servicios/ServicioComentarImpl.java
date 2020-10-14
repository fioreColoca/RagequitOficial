package ar.edu.unlam.tallerweb1.servicios;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import ar.edu.unlam.tallerweb1.modelo.Comentario;
import ar.edu.unlam.tallerweb1.modelo.ComentarioTipo;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioComentario;

@Service
@Transactional
public class ServicioComentarImpl implements ServicioComentar {
	
	@Inject
	private RepositorioComentario repositorioComentar;


	@Override
	public Long enviarComentario(Comentario comentario) {
		return  repositorioComentar.enviarComentario(comentario);
	}

	@Override
	public Comentario mostrarComentario(Long id) {
		return repositorioComentar.mostrarComentario(id);
	}

	@Override
	public void borrarComentario(Long id) {
		repositorioComentar.borrarComentario(id);
	}

	@Override
	public void darLikeComentario(Long id) {
		Comentario comentario = mostrarComentario(id);
		comentario.setCantidadLikes(comentario.getCantidadLikes() + 1);
	}

	@Override
	public List<Comentario> listaDeComentarios() {
		return repositorioComentar.verListaComentarios();
	}

	@Override
	public void tipoComentario(String boton,Comentario comentario) {
		switch (boton) {
		case "comun":
			comentario.setTipo(ComentarioTipo.COMUN);
			break;
		case "premium":
			comentario.setTipo(ComentarioTipo.SUSCRIPTOR);		
			break;
		default:
			break;
		}

	}


}


