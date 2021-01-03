package es.uva.inf.poo.entraga.clases;

import java.time.LocalDate;

	
	/**
	 * 
	 * @param puertoOrigen
	 * @param muelleOrigen
	 * @param puertoDestino
	 * @param muelleDestino
	 * @param fechaSalida
	 * @param fechaLlegada
	 */
public class TCamion extends Simple {
	/**
	 * Constante de Coste fijo por trayecto de 400 euros
	 */
	private final double COSTE_FIJO = 400;
	/**
	 * Constante de Coste variable por kilometro de 4,5 euros
	*/
	private final double COSTE_KILOMETRO = 4.5;
	
	public TCamion(Puerto puertoOrigen, Muelle muelleOrigen, Puerto puertoDestino,Muelle muelleDestino, LocalDate fechaSalida, LocalDate fechaLlegada ) {
		super(puertoOrigen, muelleOrigen, puertoDestino, muelleDestino, fechaSalida, fechaLlegada);
	}
	/**
	 * Calcula el precio de un trayecto en camion
	 * @return precio del trayecto
	 */
	public double calcularPrecio(){
		return (COSTE_FIJO+COSTE_KILOMETRO*cambiarAKilometros(getMillas()));
	}
	}


