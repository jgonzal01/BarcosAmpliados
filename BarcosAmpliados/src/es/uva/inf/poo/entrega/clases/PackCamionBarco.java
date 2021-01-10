package es.uva.inf.poo.entrega.clases;
import java.time.LocalDate;

public class PackCamionBarco extends Compuesto {
	
	
	public PackCamionBarco(Puerto puertoOrigen, Muelle muelleOrigen,Puerto puertoIntermedio,Muelle muelleIntermedio,  Puerto puertoDestino,Muelle muelleDestino, LocalDate fechaSalida, LocalDate fechaLlegada) {
		super(puertoOrigen,muelleOrigen,puertoIntermedio, muelleIntermedio,  puertoDestino, muelleDestino, fechaSalida, fechaLlegada);
		
		t1 = new TCamion(puertoOrigen, muelleOrigen, puertoIntermedio, muelleIntermedio, fechaSalida, fechaLlegada);
		t2 = new TBarco(puertoIntermedio, muelleIntermedio, puertoDestino, muelleDestino, fechaSalida, fechaLlegada);
	}
	
	public double calcularPrecio() {
		return t1.calcularPrecio() + t2.calcularPrecio() * 0.85; 
	}
}
