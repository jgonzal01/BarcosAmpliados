package es.uva.inf.poo.entraga.clases;

import java.time.LocalDate;

public class TTren extends Simple {
	/**
	 * Coste de cada kilometro de viaje
	 */
	private double costeKilometro = 12.5;
	/**
	 * COste fijo por trayecto
	 */
	private double costeFijo = 20;
	/**
	 * Construcotor clase TTren
	 * @param puertoOrigen
	 * @param muelleOrigen
	 * @param puertoDestino
	 * @param muelleDestino
	 * @param fechaSalida
	 * @param fechaLlegada
	 */
	public TTren(Puerto puertoOrigen, Muelle muelleOrigen, Puerto puertoDestino,Muelle muelleDestino, LocalDate fechaSalida, LocalDate fechaLlegada ) {
		super(puertoOrigen, muelleOrigen, puertoDestino, muelleDestino, fechaSalida, fechaLlegada);
	}
	public double calcularPrecio() {
		return (costeFijo+costeKilometro*cambiarAKilometros(getMillas()));
	}
}
