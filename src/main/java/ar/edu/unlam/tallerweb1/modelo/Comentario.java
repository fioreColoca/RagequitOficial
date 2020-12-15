package ar.edu.unlam.tallerweb1.modelo;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

@Entity
public class Comentario implements Comparable<Comentario> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	private Publicacion publicacion;
	@Transient
	private Long publicacionId;

	@ManyToOne
	private Comentario respuesta;
	@Transient
	private Long comentarioAResponderId;

	@ManyToOne
	private Usuario usuario;

	@ManyToMany
	private List<Usuario> litadoLikes;

	private String mensaje;

	@Column(name = "fecha")
	private Date fechaHora;

	private Integer cantidadLikes;

	private ComentarioEstado estado;

	private Integer cantidadRespuesta;

	/* ---------- GETERS AND SETERS ---------- */

	public Comentario getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(Comentario respuesta) {
		this.respuesta = respuesta;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public Date getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(Date fechaHora) {
		this.fechaHora = fechaHora;
	}

	public Integer getCantidadLikes() {
		return cantidadLikes;
	}

	public void setCantidadLikes(Integer cantidadLikes) {
		this.cantidadLikes = cantidadLikes;
	}

	public Publicacion getPublicacion() {
		return publicacion;
	}

	public void setPublicacion(Publicacion publicacion) {
		this.publicacion = publicacion;
	}

	public ComentarioEstado getEstado() {
		return estado;
	}

	public void setEstado(ComentarioEstado estado) {
		this.estado = estado;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Usuario> getLitadoLikes() {
		return litadoLikes;
	}

	public void setLitadoLikes(List<Usuario> litadoLikes) {
		this.litadoLikes = litadoLikes;
	}

	public Long getPublicacionId() {
		return publicacionId;
	}

	public void setPublicacionId(Long publicacionId) {
		this.publicacionId = publicacionId;
	}

	public Long getComentarioAResponderId() {
		return comentarioAResponderId;
	}

	public void setComentarioAResponderId(Long comentarioAResponderId) {
		this.comentarioAResponderId = comentarioAResponderId;
	}

	@Override
	public int compareTo(Comentario comentario) {
		return this.id.compareTo(comentario.getId());
	}

	public Integer getCantidadRespuesta() {
		return cantidadRespuesta;
	}

	public void setCantidadRespuesta(Integer cantidadRespuesta) {
		this.cantidadRespuesta = cantidadRespuesta;
	}

}
