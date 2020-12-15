package ar.edu.unlam.tallerweb1.modelo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

@Entity
public class Publicacion implements Comparable<Publicacion> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String mensaje;
	private Integer cantidadLikes;
	private Integer cantidadComentarios;
	private Date fechaHora;
	private String urlImagen;
	private String urlVideo;
	private PublicacionTipo tipo;
	private PublicacionEstado estado;
	@Transient
	private Long categoriaId;
	@ManyToOne
	private Categoria categoria;

	@OneToOne
	private Usuario usuario;

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

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public PublicacionEstado getEstado() {
		return estado;
	}

	public void setEstado(PublicacionEstado estado) {
		this.estado = estado;
	}

	public Integer getCantidadComentarios() {
		return cantidadComentarios;
	}

	public void setCantidadComentarios(Integer cantidadComentarios) {
		this.cantidadComentarios = cantidadComentarios;
	}

	@Override
	public int compareTo(Publicacion publicacion) {
		return this.id.compareTo(publicacion.getId());
	}

}
