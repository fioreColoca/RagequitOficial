package ar.edu.unlam.tallerweb1.modelo;

import java.util.LinkedList;
import java.util.List;

public class Juegos extends Categoria {
	
	private String genero;
	private Integer contJugadores;
	private List <Juegos> juegos = new LinkedList<Juegos>();

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public Integer getContJugadores() {
		return contJugadores;
	}

	public void setContJugadores(Integer contJugadores) {
		this.contJugadores = contJugadores;
	}

	public List<Juegos> getJuegos() {
		return juegos;
	}

	public void setJuegos(List<Juegos> juegos) {
		this.juegos = juegos;
	}
	
	
	
	

}
