package ar.edu.unlam.tallerweb1.modelo;

import java.util.Comparator;

public class NotificacionOrdenPorIDDescendente implements Comparator<Notificacion> {

	@Override
	public int compare(Notificacion notificacion1, Notificacion notificacion2) {
		return notificacion2.getId().compareTo(notificacion1.getId());
	}

}
