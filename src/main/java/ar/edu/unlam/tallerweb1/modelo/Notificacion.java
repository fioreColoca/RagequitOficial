package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Notificacion implements Comparable<Notificacion> {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	private Usuario usuarioOtorgadorNotifi;

	@ManyToOne
	private Usuario usuarioRecibidorNotifi;

	@ManyToOne
	private Publicacion publicacion;

	@ManyToOne
	private Comentario comentario;

	@ManyToOne
	private Publicacion comentarioDePublicacion;

	@ManyToOne
	private Comentario comentarioLike;

	@ManyToOne
	private Comentario respuestaDeComentario;

	private NotificacionTipo tipo;

	private Boolean visto;

	public Boolean getVisto() {
		return visto;
	}

	public void setVisto(Boolean visto) {
		this.visto = visto;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Usuario getUsuarioOtorgadorNotifi() {
		return usuarioOtorgadorNotifi;
	}

	public void setUsuarioOtorgadorNotifi(Usuario usuarioOtorgadorNotifi) {
		this.usuarioOtorgadorNotifi = usuarioOtorgadorNotifi;
	}

	public Usuario getUsuarioRecibidorNotifi() {
		return usuarioRecibidorNotifi;
	}

	public void setUsuarioRecibidorNotifi(Usuario usuarioRecibidorNotifi) {
		this.usuarioRecibidorNotifi = usuarioRecibidorNotifi;
	}

	public Publicacion getPublicacion() {
		return publicacion;
	}

	public void setPublicacion(Publicacion publicacion) {
		this.publicacion = publicacion;
	}

	public NotificacionTipo getTipo() {
		return tipo;
	}

	public void setTipo(NotificacionTipo tipo) {
		this.tipo = tipo;
	}

	@Override
	public int compareTo(Notificacion notificacion) {
		return this.id.compareTo(notificacion.getId());
	}

	public Comentario getComentarioLike() {
		return comentarioLike;
	}

	public void setComentarioLike(Comentario comentarioLike) {
		this.comentarioLike = comentarioLike;
	}

	public Publicacion getComentarioDePublicacion() {
		return comentarioDePublicacion;
	}

	public void setComentarioDePublicacion(Publicacion comentarioDePublicacion) {
		this.comentarioDePublicacion = comentarioDePublicacion;
	}

	public Comentario getRespuestaDeComentario() {
		return respuestaDeComentario;
	}

	public void setRespuestaDeComentario(Comentario respuestaDeComentario) {
		this.respuestaDeComentario = respuestaDeComentario;
	}

	public Comentario getComentario() {
		return comentario;
	}

	public void setComentario(Comentario comentario) {
		this.comentario = comentario;
	}

}
