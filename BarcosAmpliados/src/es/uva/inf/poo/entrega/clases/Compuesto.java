package es.uva.inf.poo.entrega.clases;
import java.time.LocalDate;

/**
 * Clase que representa un pack de varios trayectos. Hereda de la clase Trayecto
 * @author nacho
 *
 */
public abstract class Compuesto extends Trayecto {
	private Muelle muelleIntermedio;
	private Puerto puertoIntermedio;
	
	protected Simple t1;
	protected Simple t2;
	
	public Compuesto(Puerto puertoOrigen, Muelle muelleOrigen,Puerto puertoIntermedio,Muelle muelleIntermedio,  Puerto puertoDestino,Muelle muelleDestino, LocalDate fechaSalida, LocalDate fechaLlegada) {
		super(puertoOrigen, muelleOrigen, puertoDestino, muelleDestino, fechaSalida, fechaLlegada);
		this.muelleIntermedio = muelleIntermedio;
		this.puertoIntermedio = puertoIntermedio;
		
	}
	public double calcularMillasAMuelleIntermedio() {
		double dist = super.getMuelleOrigen().getGPS().getDistanceTo(muelleIntermedio.getGPS());
		return dist;
	}
	public Muelle getMuelleIntermedio() {
		return muelleIntermedio;
	}
	public Puerto getPuertoIntermedio() {
		return puertoIntermedio;
	}
	
}
