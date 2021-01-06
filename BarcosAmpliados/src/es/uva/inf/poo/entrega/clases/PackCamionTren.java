package es.uva.inf.poo.entraga.clases;

import java.time.LocalDate;

public class PackCamionTren extends Compuesto {
	
	/**
	 * Constante de Coste variable por kilometro de 12,5 euros
	*/
	private final double COSTE_KILOMETRO_TREN = 10;
	
	/**
	 * Constante de Coste fijo por trayecto de 400 euros
	 */
	private final double COSTE_FIJO_CAMION = 400;
	/**
	 * Constante de Coste variable por kilometro de 4,5 euros
	*/
	private final double COSTE_KILOMETRO_CAMION = 4.5;
	
	
    public PackCamionTren(Puerto puertoOrigen, Muelle muelleOrigen, Puerto puertoDestino,Muelle muelleDestino, LocalDate fechaSalida, LocalDate fechaLlegada ) {
		super(puertoOrigen, muelleOrigen, puertoDestino, muelleDestino, fechaSalida, fechaLlegada);
	}
	/**
	 * Anade un nuevo trayecto a la lista de trayectos
	 * @param trayecto
	 * @throws IllegalArgumentException en caso de que se intente añadir un trayecto en barco
	 */
	public void anadirTrayecto(Simple trayecto) {
		if (trayecto.getClass().getSimpleName().equals("TBarco")) {
			throw new IllegalArgumentException();
		}else {
			listaTrayectos.add(trayecto);
		}
		
	}
	/**
	 * Calcula el precio de todos los trayectos
	 */
	
	
	
	public double calcularPrecio() {
		double suma = 0 ;
		for (Simple trayecto : listaTrayectos) {
			if (trayecto.getClass().getSimpleName().equals("TTren")) {
				suma = suma + ( COSTE_KILOMETRO_TREN*cambiarAKilometros(getMillas()));
			}else {
				suma = suma+ (COSTE_FIJO_CAMION+COSTE_KILOMETRO_CAMION*cambiarAKilometros(getMillas()));
			}
			
		}
		
		
		return suma;
		
	}
	

}
