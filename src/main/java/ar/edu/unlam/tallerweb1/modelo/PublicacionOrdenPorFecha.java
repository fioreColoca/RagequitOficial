package ar.edu.unlam.tallerweb1.modelo;

import java.util.Comparator;

public class PublicacionOrdenPorFecha implements Comparator<Publicacion>{

	@Override 
	public int compare(Publicacion publicacion1, Publicacion publicacion2) { 

	return publicacion2.getFechaHora().compareTo(publicacion1.getFechaHora()); 

	} 
	
}
