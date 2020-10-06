package ar.edu.unlam.tallerweb1.modelo;

public class ComentarioSimple extends Comentario{
		
	/* Duda con la herencia y si va o no Entity */
	
	String mensajeSimple;

	public String getMensajeSimple() {
		return mensajeSimple;
	}

	public void setMensajeSimple(String mensajeSimple) {
		this.mensajeSimple = mensajeSimple;
	}
}