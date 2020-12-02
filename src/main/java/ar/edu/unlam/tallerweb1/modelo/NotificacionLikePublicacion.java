package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class NotificacionLikePublicacion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	private Usuario usuarioOtorgadorNotifi;
	
	@ManyToOne
	private Usuario usuarioRecibidorNotifi;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Usuario getUsuarioOtorgadorNotifi() {
		return usuarioOtorgadorNotifi;
	}

	public void setUsuarioOtorgadorNotifi(Usuario usuarioOtorgadorNotifi) {
		this.usuarioOtorgadorNotifi = usuarioOtorgadorNotifi;
	}

	public Usuario getUsuarioRecibidorNotifi() {
		return usuarioRecibidorNotifi;
	}

	public void setUsuarioRecibidorNotifi(Usuario usuarioRecibidorNotifi) {
		this.usuarioRecibidorNotifi = usuarioRecibidorNotifi;
	}
	
}
