package es.uva.inf.poo.entrega.clases;

import java.time.LocalDate;

/**
 * Clase que representa un pack de varios trayectos. Hereda de la clase Trayecto
 * @author nacho
 *
 */
public abstract class Compuesto extends Trayecto {
	public Compuesto(Puerto puertoOrigen, Muelle muelleOrigen, Puerto puertoDestino,Muelle muelleDestino, LocalDate fechaSalida, LocalDate fechaLlegada ) {
		
		super(puertoOrigen, muelleOrigen, puertoDestino, muelleDestino, fechaSalida, fechaLlegada);
	}

}
