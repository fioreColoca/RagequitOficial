package ar.edu.unlam.tallerweb1.modelo;


import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Publicacion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String mensaje;
	private Integer contadorLikes;
	private Date fechaHora;
	
//	@ManyToOne
//	private Categoria categoria;
	
//	@OneToMany
//	private List <Comentario> comentarios = new LinkedList<Comentario>();

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

	public Integer getContadorLikes() {
		return contadorLikes;
	}

	public void setContadorLikes(Integer contadorLikes) {
		this.contadorLikes = contadorLikes;
	}

	public Date getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(Date fechaHora) {
		this.fechaHora = fechaHora;
	}


//	public Categoria getCategoria() {
//		return categoria;
//	}
//
//	public void setCategoria(Categoria categoria) {
//		this.categoria = categoria;
//	}

//	public List<Comentario> getComentarios() {
//		return comentarios;
//	}
//
//	public void setComentarios(List<Comentario> comentarios) {
//		this.comentarios = comentarios;
//	}
}
