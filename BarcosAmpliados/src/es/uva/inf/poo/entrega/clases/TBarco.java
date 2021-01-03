package es.uva.inf.poo.entrega.clases;

import java.time.LocalDate;
/**
 * Clase que representa la clas trayecto en Barco. Hereda de la clase simple
 * @author nacho
 *
 */
public class TBarco extends Simple {
	/**
	 * Constante del coste por dia de un trayecto en barco
	 */
	
	private final double COSTE_DIA_BARCO = 4000;
	/**
	 * Constructor de la clase TBarco
	 * @param puertoOrigen
	 * @param muelleOrigen
	 * @param puertoDestino
	 * @param muelleDestino
	 * @param fechaSalida
	 * @param fechaLlegada
	 */
	public TBarco(Puerto puertoOrigen, Muelle muelleOrigen, Puerto puertoDestino,Muelle muelleDestino, LocalDate fechaSalida, LocalDate fechaLlegada ) {
		super(puertoOrigen, muelleOrigen, puertoDestino, muelleDestino, fechaSalida, fechaLlegada);
	}
	/**
	 * Calcula el precio de un trayecto en barco
	 * @return precio del trayecto
	 */
	public double calcularPrecio() {
		return COSTE_DIA_BARCO*calcularDias();
	}
}
