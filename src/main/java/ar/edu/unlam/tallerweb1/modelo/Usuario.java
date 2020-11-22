package ar.edu.unlam.tallerweb1.modelo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

// Clase que modela el concepto de Usuario, la anotacion @Entity le avisa a hibernate que esta clase es persistible
// el paquete ar.edu.unlam.tallerweb1.modelo esta indicado en el archivo hibernateCOntext.xml para que hibernate
// busque entities en él
@Entity
public class Usuario {

	// La anotacion id indica que este atributo es el utilizado como clave primaria
	// de la entity, se indica que el valor es autogenerado.
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	// para el resto de los atributo no se usan anotaciones entonces se usa el
	// default de hibernate: la columna se llama igual que
	// el atributo, la misma admite nulos, y el tipo de dato se deduce del tipo de
	// dato de java.
	private String email;
	private String password;
	private String rol;
	private String nombreUsuario;
	private Date fechaCreacion;
	private Date fechaNacimiento;
	private Integer nivel;
	private String nombre;
	private String apellido;
	private Integer contadorSeguidos;
	private Integer contadorSuscriptores;
	private Integer contadorSeguidores;
	private String url_imagen;

	// Array de seguidores
	// @ManyToMany
	// private List<Usuario> arraySeguidores = new LinkedList<Usuario>();

	// Array de Suscriptores
	// @ManyToMany
	// private List<Usuario> arraySuscriptores = new LinkedList<Usuario>();

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Integer getNivel() {
		return nivel;
	}

	public void setNivel(Integer nivel) {
		this.nivel = nivel;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Integer getContadorSeguidos() {
		return contadorSeguidos;
	}

	public void setContadorSeguidos(Integer contadorSeguidos) {
		this.contadorSeguidos = contadorSeguidos;
	}

	public Integer getContadorSuscriptores() {
		return contadorSuscriptores;
	}

	public void setContadorSuscriptores(Integer contadorSuscriptores) {
		this.contadorSuscriptores = contadorSuscriptores;
	}

	public Integer getContadorSeguidores() {
		return contadorSeguidores;
	}

	public void setContadorSeguidores(Integer contadorSeguidores) {
		this.contadorSeguidores = contadorSeguidores;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public String getUrl_imagen() {
		return url_imagen;
	}

	public void setUrl_imagen(String url_imagen) {
		this.url_imagen = url_imagen;
	}
}
