package es.uva.inf.poo.entrega.clases;

import java.time.LocalDate;
/**
 * Clase abstracta que representa un trayecto que puede ser por tren por barco o por camion. Hereda de la clase Trayecto
 * @author nacho
 *
 */
public abstract class Simple extends Trayecto{
	
	public Simple(Puerto puertoOrigen, Muelle muelleOrigen, Puerto puertoDestino,Muelle muelleDestino, LocalDate fechaSalida, LocalDate fechaLlegada ) {
	
		super(puertoOrigen, muelleOrigen, puertoDestino, muelleDestino, fechaSalida, fechaLlegada);
	}

}
