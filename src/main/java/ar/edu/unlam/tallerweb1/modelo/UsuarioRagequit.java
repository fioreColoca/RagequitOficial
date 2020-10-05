/*package ar.edu.unlam.tallerweb1.modelo;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class UsuarioRagequit {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nombreUsuario;
	private Date fechaCreacion;
	private Date fechaNacimiento;
	private Integer nivel;
	private String nombre;
	private String apellido;
	private String email;
	private String password;
	private Integer contadorSeguidos;
	private Integer contadorSuscriptores;
	private Integer contadorSeguidores;

	// Array de seguidores
	@ManyToMany
	private List<Usuario> arraySeguidores = new LinkedList<Usuario>();
	
	// Array de Suscriptores
	@ManyToMany
	private List<Usuario> arraySuscriptores = new LinkedList<Usuario>();
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

}*/
