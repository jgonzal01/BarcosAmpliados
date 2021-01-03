package es.uva.inf.poo.entraga.clases;
import java.util.ArrayList;

import es.uva.inf.poo.entraga.clases.*;
import es.uva.inf.poo.maps.*;

/**
 * Implementacion de la clase Muelle, que representa a un muelle de un puerto, 
 * que es un lugar que hay en los puertos donde se almacenan contenedores en plazas
 * @author igndomi 	
 * @author jgonzal
 *
 */
public class Muelle {

	/**
	 * Numero de dos digitos
	 */
	private int identificador;
	
	/**
	 * Estado del muelle, puede estar operativo, o fuera de servicio
	 */
	private Boolean operativo;
	/**
	 * Lista de almacenamiento de plazas en el muelle
	 */
	private ArrayList <Plaza> listaPlazas = new ArrayList <Plaza>();
	/**
	 * Latitud 
	 */
	private GPSCoordinate GPS;
	/**
	 * Admite por barco
	 */
	private boolean admiteBarco;
	/**
	 * Admite por tren
	 */
	private boolean admiteTren;
	/**
	 * Admite por camion
	 */
	private boolean admiteCamion;
	/**
	 * Inicializacion del identificador del Muelle y el Puerto en el que esta el Muelle
	 * @param id numero de dos digitos
	 * 
	 * @param estado del muelle true operativo false no operativo
	 * @param latitudeGD latitud 
	 * @param longitudeGD longitud
	 */
	//Registro de cambios. Añado tres parametros al constructor
	public Muelle(int id,boolean estado,double latitudeGD, double longitudeGD, boolean aceptaBarco, boolean aceptaTren, boolean aceptaCamion){
		identificador = comprobarIdentificador(id);
		operativo = estado;
		GPS = new GPSCoordinate(latitudeGD, longitudeGD);
		admiteBarco = aceptaBarco;
		admiteCamion = aceptaCamion;
		admiteTren = aceptaTren;
		
		
	}
	/**
	 * Comprueba que la entrada introducida al crear el muelle son correctas
	 * @except Si alguna no es correcta lanza IllegalArgumetnException
	 */
	private int comprobarIdentificador(int id) {
		if (id<0 || id>100)
			throw new IllegalArgumentException();
		else {
			return id;
			
		}
	}
	/**
	 * Getter GPS
	 * @return GPS
	 */
	public GPSCoordinate getGPS() {
		return GPS;
	}
	/**
	 * Getter de identificador de muelle
	 * @return identificador del muelle
	 */
	public int getNombre(){
		return identificador;
	} 
	/**
	 * Getter del estado del Muelle
	 * @return Estado del Muelle 
	 */
	public boolean getOperativo() {
		return operativo;
	
	}
	/**
	 * Cambiar el estado a operativo
	 */
	public void cambiarAOperativo() {
		operativo = true;
	/**
	 * Cambiar el estado a no operativo
	 */
	}public void cambiarANoOperativo() {
		operativo = false;
	}
	/**
	 * Comprobacion de capacidad de espacio de un muelle
	 * @return Devuelve true si el muelle tiene espacio espacio para recibir contenedores. Devuelve false cuando no puede recibir contenedores 
	 * 
	 */
	public boolean tieneEspacio() {
		for (int i=0;i<listaPlazas.size();i++) {
			if (listaPlazas.get(i).tieneEspacio()) {
				return true;
			}
		}return false;
	}
	/**
	 * Numero de plazas totales del muelle
	 * @return devuelve el numero total de plazas en el muelle
	 */
	public int numeroPlazas() {
		return listaPlazas.size();
	}
	/**
	 * Calcula el numero de plazas vacias semi-llenas y llenas
	 *@return Devuelve un vector con tres posiciones, numero de plazas vacias, semi-llenas y llenas
	 */
	public int[] numeroPlazasPorEstado() {
		int [] estados = new int[3];
		for (int i=0;i<listaPlazas.size();i++) {
			if (listaPlazas.get(i).tieneEspacio()) {
				if (listaPlazas.get(i).getnumCont()==0) {
					estados[0]++;
				}else estados[1]++;
			}else estados[2]++;
		}
		return estados;
	}
	/**
	 * Busqueda de un contenedor
	 * @param contenedor nombre del contenedor 
	 * @return La plaza donde se encuentra el contenedor si existe, null si el contenedor no exite
	 */
	public Plaza encontrarContenedor(String contenedor) {
		for (int i=0;i<listaPlazas.size();i++) {
			if (listaPlazas.get(i).estaContenedor(contenedor)) {
				Plaza plaza =  listaPlazas.get(i);
				return plaza;
			}
		}return null;
		
	}
	/**
	 * Comprobacion de la situaciï¿½n del Muelle
	 * @return False si el Muelle no esta lleno, True si el Muelle no tiene espacio
	 */
	public boolean estaLleno() {
		for (int i=0;i<listaPlazas.size();i++) {
			if (listaPlazas.get(i).tieneEspacio()) {
				return false;
			}
		}return true;
	}
	/**
	 * Busca el nivel de la plaza donde se encuentra un contenedor a partir de su nombre
	 * @param contenedor nombre del contenedor
	 * @return Nivel de plaza donde se encuentra el contenedor, si el contenedor existe, sino devulve la plaza -1
	 */
	public int nivelPlaza(String contenedor) {
		
		for (int i=0;i<listaPlazas.size();i++) {
			if(listaPlazas.get(i).estaContenedor(contenedor)) {
				return listaPlazas.get(i).getNivelContenedor(contenedor);
			}
		}return -1; 
		
		
	}
	/**
	 * Anade una plaza a la lista de plazas
	 * @param p plaza a insertar
	 */
	public void anadirPlaza(Plaza p) {
		listaPlazas.add(p);
	}
	
	//Registro de cambios. Sobrecarga 
	private void insertarContenedor(Contenedor contenedor) {
		boolean flag = false;
		for (int i=0;i<listaPlazas.size();i++) {
			if (listaPlazas.get(i).tieneEspacio()){
				listaPlazas.get(i).anadirContenedor(contenedor);
				flag = true;
				break;
			}		 
		}
		if(!flag) {
			throw new ArrayIndexOutOfBoundsException();	
		}
	}
	/**
	 * Anade un contenedor al Muelle siempre que sea posible
	 * @param contenedor Estandar 
	 * @throws ArrayIndexOutOfBoundsException() cuando no se puede anadir otro contenedor
	 */
	
	public void anadirContenedor(Estandar contenedor) {
		this.insertarContenedor(contenedor);
		
	}
	
	/**
	 * Anade un contenedor al Muelle siempre que sea posible
	 * @param contenedor Refrigerado 
	 * @throws ArrayIndexOutOfBoundsException() cuando no se puede anadir otro contenedor o cuando el muelle no puede realizar trayectos por barco ni por camion
	 */

	public void anadirContenedor(Refrigerado contenedor) {
		if (!(admiteBarco || admiteCamion)) {
			throw new IllegalArgumentException();
		}else {
			this.insertarContenedor(contenedor);
		}
	}
	
	/**
	 * Anade un contenedor al Muelle siempre que sea posible
	 * @param FlatRack contenedor
	 * @throws ArrayIndexOutOfBoundsException() cuando no hay dos plazas enteras vacias o cuando el muelle no puede realizar trayectos por barco ni por tren
	 */

	public void anadirContenedor(FlatRack contenedor) {
		if (!(admiteBarco||admiteTren)) {
			throw new IllegalArgumentException();
		}else {
			int c = 0;
			for (int i=0;i<listaPlazas.size();i++) {
				if (listaPlazas.get(i).estaVacia()){
					c++;
				}
			}if (c<2) {
				throw new ArrayIndexOutOfBoundsException();
			}else insertarContenedor(contenedor);
	}		
	}
	/**
	 * Desapila un contenedor del muelle simpre que exista y se encuentre en una plaza.
	 * @param contenedor contenedor completo
	 */
	public void desapilarContenedor(Contenedor contenedor) {
		for (int i=0;i<listaPlazas.size();i++) {
			if (listaPlazas.get(i).estaContenedor(contenedor.getNombre())) {
				listaPlazas.get(i).desapilarContenedor(contenedor);
			}
		}
	}
	
	

}