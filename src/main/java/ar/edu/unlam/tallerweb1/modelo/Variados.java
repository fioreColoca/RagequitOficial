package ar.edu.unlam.tallerweb1.modelo;

import java.util.LinkedList;
import java.util.List;

public class Variados extends Categoria {

	private String genero;
	private List<Variados> variados = new LinkedList<Variados>();

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public List<Variados> getVariados() {
		return variados;
	}

	public void setVariados(List<Variados> variados) {
		this.variados = variados;
	}

}
