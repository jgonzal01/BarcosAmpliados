package es.uva.inf.poo.entraga.clases;

import java.time.LocalDate;
/**
 * Clase abstracta que representa un trayecto que puede ser por tren por barco o por camion. Hereda de la clase Trayecto
 * @author igndomi 
 * @author jgonzal
 *
 */
public abstract class Simple extends Trayecto{
	
	/**
	 * Constructor de la clase Simple
	 * @param puertoOrigen
	 * @param muelleOrigen
	 * @param puertoDestino
	 * @param muelleDestino
	 * @param fechaSalida
	 * @param fechaLlegada
	 */
	public Simple(Puerto puertoOrigen, Muelle muelleOrigen, Puerto puertoDestino,Muelle muelleDestino, LocalDate fechaSalida, LocalDate fechaLlegada ) {
	
		super(puertoOrigen, muelleOrigen, puertoDestino, muelleDestino, fechaSalida, fechaLlegada);
		
	}

}
