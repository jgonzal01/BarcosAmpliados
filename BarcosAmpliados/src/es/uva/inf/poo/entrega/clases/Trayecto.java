package es.uva.inf.poo.entrega.clases;
import java.time.LocalDate;
import java.time.Period;

import es.uva.inf.poo.entraga.clases.*;
/**
 * Implementacion de la clase trayecto, que representa los viajes que hace un barco entre dos muelles transportando contenedores.
 * @author igndomi 
 * @author jgonzal
 *
 */

public abstract class Trayecto {
	/**
	 * Muelle origen
	 */
	private Muelle muelleOrigen;
	/**
	 * Muelle destino
	 */
	private Muelle muelleDestino;
	/**
	 * Puerto de destino
	 */
	private Puerto puertoDestino;
	/**
	 * Puerto de origen
	 */
	private Puerto puertoOrigen;
	/**
	 * Fecha salida
	 */
	private LocalDate fechaSalida;
	/**
	 * Fecha llegada
	 */
	private LocalDate fechaLlegada;
	
	/**
	 * Dias trayecto
	 */
	private int dias;
	/**
	 * Millas trayecto
	 */
	private double millas;
	/**
	 * Constructor de la clase trayecto 
	 * @param puertoOrigen puerto de salida
	 * @param muelleOrigen muelle de salida
	 * @param puertoDestino puerto de destino
	 * @param muelleDestino muelle de destino
	 * @param fechaSalida fecha de salida
	 * @param fechaLlegada fecha de llegada
	 */
	public Trayecto(Puerto puertoOrigen, Muelle muelleOrigen, Puerto puertoDestino,Muelle muelleDestino, LocalDate fechaSalida, LocalDate fechaLlegada ) {
		this.muelleOrigen = muelleOrigen;
		this.puertoOrigen = puertoOrigen;
		this.muelleDestino = muelleDestino;
		this.puertoDestino = puertoDestino;
		this.fechaSalida = fechaSalida;
		this.fechaLlegada = fechaLlegada;
		//Modifico para crear un metodo 
		dias = calcularDias();
		millas = calculaMillas();
		
	}
	/**
	 * Devuelve el numero de dias que dura el trayecto
	 * @return el numero de dias que dura el trayecto
	 */
	public int calcularDias() {
		return Period.between(fechaSalida,fechaLlegada).getDays();
	}
	/**
	 * Devuelve en kilometros unas millas dadas
	 * @param millas
	 * @return
	 */
	public double cambiarAKilometros(double millas) {
		return millas*1.852;
	}
	/**
	 * Devuelve una lista completa con el pais,localidad y fecha de salida y de destino
	 * @return lista de Strings con esos campos
	 */
	
	public String[] infoCompleta() {
		String[] listaInfo = new String[6]; 
		listaInfo[0] = puertoOrigen.getIdPais();
		listaInfo[1] = puertoOrigen.getIdLocalidad();
		listaInfo[2] = fechaSalida.toString();
		listaInfo[3] = puertoDestino.getIdPais();
		listaInfo[4] = puertoDestino.getIdLocalidad();
		listaInfo[5] = fechaLlegada.toString();
		return listaInfo;
	}
	/**
	 * Obtener informaci�n completa trayecto
	 * @return lista con localidad puerto origen, pais, fecha de inicio. localida puerto destino, pais y feccha fin trayecto
	 */
	/**
	 * Getter de millas
	 * @return numero de millas
	 */
	public double getMillas() {
		return millas;
	}
	/**
	 * Numero de dias entre fecha de salida y llegada
	 * @return la diferencia de dias entre la fecha de salida y llegada
	 */
	public int getDias() {
		return dias;
	}
	/**
	 * Getter puerto de origen
	 * @return puerto de origen
	 */
	public Puerto getPuertoOrigen(){
		return puertoOrigen;
	}
	/**
	 * Getter muelle origen
	 * @return muelle origen
	 */
	public Muelle getMuelleOrigen(){
		return muelleOrigen;
	}
	/**
	 * Getter puerto llegada
	 * @return puerto de llegada
	 */
	public Puerto getPuertoLlegada(){
		return puertoDestino;
	}
	/**
	 * Getter muelle llegada
	 * @return muelle llegada
	 */
	public Muelle getMuelleLlegada(){
		return muelleDestino;
	}
	
	
	/**
	 * Comprueba si una fecha introducida es posterior a la fecha de fin de trayecto
	 * @param fecha fecha a comprobar
	 * @return Devuelve true si es posterior o igual y false si es anterior
	 * 
	 */
	public boolean fechaValida(LocalDate fecha){
		return fecha.isAfter(fechaSalida);
		
	}
	/**
	 * Obtiene la distancia en millas de un trayecto
	 * @return distancia en millas
	 */
	public double calculaMillas() {
		double dist = muelleOrigen.getGPS().getDistanceTo(muelleDestino.getGPS());
		return dist;
		
	}
	/**
	 * 
	 * 
	 * @return precio calculado como producto de coste por dia por numero de dias mas producto de millas por numero de millas
	 */
	//Cambio este metodo para hacerlo generico
	public abstract double calcularPrecio( );
	
}
