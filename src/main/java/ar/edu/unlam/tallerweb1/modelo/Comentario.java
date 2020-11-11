package ar.edu.unlam.tallerweb1.modelo;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Comentario { 
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	private Publicacion publicacion;
	
	@ManyToOne
	private Comentario respuesta;
	
	/*@Transient
	private Long respuestaId;*/

	private String mensaje;
	
	private Date fechaHora;
	
	private Integer cantidadLikes;
	
	private ComentarioEstado estado;

	private ComentarioTipo tipo;
	
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

	/*public Long getRespuestaId() {
		return respuestaId;
	}

	public void setRespuestaId(Long respuestaId) {
		this.respuestaId = respuestaId;
	}*/

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

	public ComentarioTipo getTipo() {
		return tipo;
	}

	public void setTipo(ComentarioTipo tipo) {
		this.tipo = tipo;
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
	

}
