package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

/*import org.springframework.web.multipart.commons.CommonsMultipartFile;*/

@Entity
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	private String urlImagen;
	private String urlIcono;
	private String descripcion;
	private Integer contadorSeguidores;


	/*private CommonsMultipartFile subida;*/


	private Double calificacion;

	private CategoriaTipo tipoCategoria;

	private CategoriaEstado estado;

	@Transient
	private Integer tipoCategoriaNum;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public CategoriaTipo getTipoCategoria() {
		return tipoCategoria;
	}

	public void setTipoCategoria(CategoriaTipo tipo) {
		this.tipoCategoria = tipo;
	}

	public String getUrlImagen() {
		return urlImagen;
	}

	public void setUrlImagen(String urlImagen) {
		this.urlImagen = urlImagen;
	}

	public String getUrlIcono() {
		return urlIcono;
	}

	public void setUrlIcono(String urlIcono) {
		this.urlIcono = urlIcono;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getTipoCategoriaNum() {
		return tipoCategoriaNum;
	}

	public void setTipoCategoriaNum(Integer tipoCategoriaNum) {
		this.tipoCategoriaNum = tipoCategoriaNum;
	}

	public Integer getContadorSeguidores() {
		return contadorSeguidores;
	}

	public void setContadorSeguidores(Integer contadorSeguidores) {
		this.contadorSeguidores = contadorSeguidores;
	}

	/*public CommonsMultipartFile getSubida() {
		return subida;
	}

	public void setSubida(CommonsMultipartFile subida) {
		this.subida = subida;
	}*/

	public CategoriaEstado getEstado() {
		return estado;
	}

	public void setEstado(CategoriaEstado estado) {
		this.estado = estado;
	}

	public Double getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(Double calificacion) {
		this.calificacion = calificacion;
	}

}
