package ar.edu.unlam.tallerweb1.modelo;


import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public /*abstrat*/  class Comentario {  /* asbtract para clases que por si solas no existen en la vida real */
	
	/* ES UNARIA  DUDA CON EL IMPORT DE DATE*/
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToMany (fetch=FetchType.EAGER)
	private List<Comentario> respuesta = new LinkedList<Comentario>();
	
	@Column(name="fecha_hora")
	private Date fechaHora;
	
	@Column(name="cantidad_likes")
	private Integer cantidadLikes;
	
	
	private String mensaje; /* no deberia de ir, pero no se hacer herencia foraneas */
	
	/* GETTERS AND SETTERS */
	
	public Long getId() {
		return id;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public void setId(Long id) {
		this.id = id;
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
	
}
