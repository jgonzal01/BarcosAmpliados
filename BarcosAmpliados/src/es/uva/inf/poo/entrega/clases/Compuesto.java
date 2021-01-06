package es.uva.inf.poo.entraga.clases;
import java.util.ArrayList;

import java.time.LocalDate;

/**
 * Clase que representa una combinacion de varios trayectos. Hereda de la clase Trayecto
 * @author nacho
 *
 */
public class Compuesto extends Trayecto {
	/**
	 * Lista de trayectos realizados
	 */
	protected ArrayList<Simple> listaTrayectos = new ArrayList<Simple>();
	/**
	 * Constructor de la clase Compuesto
	 * @param puertoOrigen
	 * @param muelleOrigen
	 * @param puertoDestino
	 * @param muelleDestino
	 * @param fechaSalida
	 * @param fechaLlegada
	 */
	public Compuesto(Puerto puertoOrigen, Muelle muelleOrigen, Puerto puertoDestino,Muelle muelleDestino, LocalDate fechaSalida, LocalDate fechaLlegada ) {
		
		super(puertoOrigen, muelleOrigen, puertoDestino, muelleDestino, fechaSalida, fechaLlegada);
	}
	/**
	Calcula el precio de la suma de trayectos
	*/
	public double calcularPrecio() {
		double suma=0;
		for (Simple i : listaTrayectos) {
			suma = suma + i.calcularPrecio();
		}
		return suma;
	
	 
	}
	/**
	 * Añade un trayecto simple a la lista de trayectos
	 * @param trayecto
	 */
	
	
	public void añadirTrayecto(Simple trayecto){
		listaTrayectos.add(trayecto);
	}

}
