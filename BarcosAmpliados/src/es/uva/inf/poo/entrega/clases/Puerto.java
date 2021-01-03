package es.uva.inf.poo.entrega.clases;
import java.util.ArrayList;

import es.uva.inf.poo.entraga.clases.Muelle;
import es.uva.inf.poo.maps.GPSCoordinate;
/**
 * Implementaci�n de la clase puerto, que representa a un puerto de una localidad,
 * que es un centro logistico de tranporte maritimo donde entran y salen barcos 
 * para intercambiar contenedores con mercancias. Cada puerto contiene un numero 
 * diferente de muelles que son espacios donde almacenar contenedores en plazas
 * 
 *@author igndomi
 *@author jgonzal
 */

public class Puerto {
	/**
	 * Nombre identificativo del pais
	 */
	private String idPais;
	/**
	 * Nombre identificativo  de la localidad
	 */
	private String idLocalidad ;
	/**
	 * Lista con los muelles que hay en ese puerto
	 */
	private ArrayList<Muelle> listaMuelles= new ArrayList<Muelle>();
	/**
	 * Constructor de la clase puerto
	 * @param nombrePais Referencia de dos caracteres del pais
	 * @param nombreLocalidad Referencia de 3 caracteres de la localidad
	 */
	
	public Puerto(String nombrePais, String nombreLocalidad) {
		
		idPais = comprobarIdPais(nombrePais.toUpperCase());
		idLocalidad = comprobarIdLocalidad(nombreLocalidad.toUpperCase());
		
		
	}private String comprobarIdLocalidad(String id) {
		if (id.length()!=3) {
			throw new IllegalArgumentException();
		}else {
			return id;
		}
	}
	private String comprobarIdPais(String id) {
		if(id.length() != 2) {
			throw new IllegalArgumentException();
		}else {
			return id;
		}
	}
	/**
	 * Getter de la identificacion de pais de un puerto
	 * @return identificacion de pa�s
	 */
	public String getIdPais() {
		return idPais;
	}
	/**
	 * Getter de la identificacion de localidad de un puerto
	 * @return identificacion de una localidad
	 */
	public String getIdLocalidad() {
		return idLocalidad;
	}
	/**
	 * Obtiene el nombre del puerto como consatencaion del id_pais, guion y el id_localidad
	 * @return el nombre completo como consatencaion del id_pais, guion y el id_localidad
	 */
	public String getNombre(){
		
		String nombre = idPais + "-" + idLocalidad;
		return nombre;
	
	}
	/**
	 * Getter de la lista de Muelles
	 * @return la lista de los muelles de un puerto
	 */
	public ArrayList <Muelle> getListaMuelles() {
		return listaMuelles;
	}
	/**
	 * A�ade un muelle al puerte 
	 * @param muelle que se desea a�adir
	 */
	public void anadirMuelle(Muelle muelle) {
		
		listaMuelles.add(muelle);
	}
	
	/**
	 * A partir del nombre de un muelle en ese puerto, lo elimina de la lista
	 * @param nombreMuelle identificador de 2 digitos
	 * @exception IllegalArgumentException si ese muelle no se encuentra en el puerto
	 */
	public void eliminarMuelle(int nombreMuelle){
		boolean flag = false;
		
		for(int i=0; i<listaMuelles.size();i++) {
			int nombreEnLista=listaMuelles.get(i).getNombre();
			if (nombreEnLista == nombreMuelle){
				listaMuelles.remove(i);
				flag = true;
				break;
			}
		}
		if(flag == false) {
			throw new IllegalArgumentException();
		}
		
	}
	/**
	 * Obtiene una lista con los muelles operativos en el puerto
	 * @return lista de muelles operativos
	 */
	public ArrayList<Muelle> listaMuellesOperativos(){
		ArrayList<Muelle> listaOperativos= new ArrayList<Muelle>();
		for(int i=0; i<listaMuelles.size();i++) {
			if (listaMuelles.get(i).getOperativo()) {
				listaOperativos.add(listaMuelles.get(i));
			}
		}
		return listaOperativos;
	}
	/**
	 * Obtiene una lista con los muelles con espacio, previamnete se tiene que haber a�adido una plaza.
	 * @return lista muelles con espacio
	 */
	public ArrayList<Muelle> listaMuellesConEspacio(){
		ArrayList<Muelle> listaEspacio= new ArrayList<Muelle>();
		
		for(int i=0; i<listaMuelles.size();i++) {
			if (listaMuelles.get(i).estaLleno() == false) {
				listaEspacio.add(listaMuelles.get(i));
			}
		}
		return listaEspacio;
	}
	/**
	 * Comprueba si el PUERTO esta lleno entendiendo que si hay espacio para algun contenedor en alguna plaza no esta lleno
	 * 
	 * @return true si esta lleno, false si no
	 */
	public boolean estaLleno() {
		for(int i=0; i<listaMuelles.size();i++) {
			if(!listaMuelles.get(i).estaLleno()) {
				return false;
			}
		}return true;
	}
	/**
	 * Obtiene una lista con los muelles que est� a una distancia menor de un punto GPS
	 * @param punto GPS
	 * @param dist distancia a comparar
	 * @return lista de muelles con distancia menor a un punto GPS
	 */
	public ArrayList<Muelle> listaMuellesDistanciaMenor(GPSCoordinate punto, double dist){
		ArrayList<Muelle> listaMenor= new ArrayList<Muelle>();
		for(int i=0; i<listaMuelles.size();i++) {
			if(listaMuelles.get(i).getGPS().getDistanceTo(punto)<dist) {
				listaMenor.add(listaMuelles.get(i));
			}
		}return listaMenor;
	}
}