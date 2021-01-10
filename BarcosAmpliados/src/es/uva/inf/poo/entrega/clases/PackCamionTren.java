package es.uva.inf.poo.entrega.clases;

import java.time.LocalDate;

public class PackCamionTren extends Compuesto {

	public PackCamionTren(Puerto puertoOrigen, Muelle muelleOrigen,Puerto puertoIntermedio,Muelle muelleIntermedio,  Puerto puertoDestino,Muelle muelleDestino, LocalDate fechaSalida, LocalDate fechaLlegada) {
		super(puertoOrigen,muelleOrigen,puertoIntermedio, muelleIntermedio,  puertoDestino, muelleDestino, fechaSalida, fechaLlegada);
		
		t1 = new TCamion(puertoOrigen, muelleOrigen, puertoIntermedio, muelleIntermedio, fechaSalida, fechaLlegada);
		t2 = new TTren(puertoIntermedio, muelleIntermedio, puertoDestino, muelleDestino, fechaSalida, fechaLlegada);
		
	}
	
	public double calcularPrecio() {
		Double distT1 = super.cambiarAKilometros(t1.calculaMillas());
		Double distT2 = super.cambiarAKilometros(t2.calculaMillas());
		
		return 10 * (distT1 + distT2);
	}

}
