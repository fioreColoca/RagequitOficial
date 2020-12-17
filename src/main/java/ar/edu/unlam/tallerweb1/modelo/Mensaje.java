package ar.edu.unlam.tallerweb1.modelo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Mensaje {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	private Usuario usuarioEnviaMensaje;

	@ManyToOne
	private Usuario usuarioRecibeMensaje;

	private String mensaje;
	private Date fecha;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Usuario getUsuarioEnviaMensaje() {
		return usuarioEnviaMensaje;
	}

	public void setUsuarioEnviaMensaje(Usuario usuarioEnviaMensaje) {
		this.usuarioEnviaMensaje = usuarioEnviaMensaje;
	}

	public Usuario getUsuarioRecibeMensaje() {
		return usuarioRecibeMensaje;
	}

	public void setUsuarioRecibeMensaje(Usuario usuarioRecibeMensaje) {
		this.usuarioRecibeMensaje = usuarioRecibeMensaje;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

}
