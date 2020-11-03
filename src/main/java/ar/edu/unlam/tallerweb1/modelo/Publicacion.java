package ar.edu.unlam.tallerweb1.modelo;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

@Entity
public class Publicacion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String mensaje;
	private Integer cantidadLikes;
	private Date fechaHora;
	private String urlImagen;
	private String urlVideo;
	private PublicacionTipo tipo;
	@Transient
	private Long categoriaId;
//	private String categoria;
	@ManyToOne
	private Categoria categoria;
//	
//	@OneToMany
//	private List <Comentario> comentarios;
	
//	public String getCategoria() {
//		return categoria;
//	}
//
//	public void setCategoria(String categoria) {
//		this.categoria = categoria;
//	}

	public PublicacionTipo getTipo() {
		return tipo;
	}

	public void setTipo(PublicacionTipo tipo) {
		this.tipo = tipo;
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

	public Integer getCantidadLikes() {
		return cantidadLikes;
	}

	public void setCantidadLikes(Integer cantidadLikes) {
		this.cantidadLikes = cantidadLikes;
	}

	public Date getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(Date fechaHora) {
		this.fechaHora = fechaHora;
	}

	public String getUrlImagen() {
		return urlImagen;
	}

	public void setUrlImagen(String urlImagen) {
		this.urlImagen = urlImagen;
	}

	public String getUrlVideo() {
		return urlVideo;
	}

	public void setUrlVideo(String urlVideo) {
		this.urlVideo = urlVideo;
	}	


	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Long getCategoriaId() {
		return categoriaId;
	}

	public void setCategoriaId(Long categoriaId) {
		this.categoriaId = categoriaId;
	}
	
	

//	public List<Comentario> getComentarios() {
//		return comentarios;
//	}
//
//	public void setComentarios(List<Comentario> comentarios) {
//		this.comentarios = comentarios;
//	}
}
