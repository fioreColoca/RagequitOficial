package ar.edu.unlam.tallerweb1.modelo;

public class ComentarioSuscripto extends Comentario{
	
	String mensajePremium;

	/* Duda con herencia */
	public String getMensajePremium() {
		return mensajePremium;
	}

	public void setMensajePremium(String mensajePremium) {
		this.mensajePremium = mensajePremium;
	}
}
