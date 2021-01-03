package es.uva.inf.poo.entraga.clases;
import es.uva.inf.poo.entraga.clases.Contenedor;
/**
 * Imlementacion de la clase plaza, que representa las plazas que tiene un muelle.
 * Las plazas son un el lugar de tama�o el de un contenedor de ancho y de profundo
 * y donde se pueden apilar hasta cuatro contenedores
 * 
 * @author igndomi 
 * @author jgonzal
 *
 */

public class Plaza {
	/**
	 * Numero de contenedores en la plaza
	 */
	private int numCont;
	/**
	 * Numero m�ximo de contenedores que puede almacenar esa plaza
	 */
	private int numMaxCont;
	/**
	 * Array con la lista de contenedores en la plaza
	 */
	private Contenedor[] listaCont = new Contenedor[4];
	/**
	 * Constructor de la clase plaza sin argumentos
	 */
	public Plaza() {
		numCont=0;
		numMaxCont=4;
		
	}
	/**
	 * Comprueba si esta plaza tiene espacio
	 * @return Devuelve true si tiene espacio para apilar contenedores, si no false
	 */
	public boolean tieneEspacio(){
		if (numCont<numMaxCont) {
			return true;
		
		}else{
			return false;
		}
		
	}
	/**
	 * Getter de la posicion de los contenedores en una plaza
	 * @param pos posicion donde se encuentra el vector
	 * @return El contenedor ubicado en la poscion pos
	 */
	public Contenedor getListaContPos(int pos) {
		return listaCont[pos];
	}
	/**
	 * Getter numero de contenedores
	 * @return numero de contenedores en esa plaza
	 */
	public int getnumCont() {
		return numCont;
		
	}
	/**
	 * Getter numero maximo de contenedores
	 * @return numero maximo de contenedores en esa plaza
	 */
	public int getnumMaxCont() {
		return numMaxCont;	
	}
	
	/**
	 * Comprueba si esta un contenedor dado en esta plaza
	 * @param contenedor nombre del contenedor
	 * @return Devuelve true si el contenedor esta en esta plaza, si no  false
	 */
	public boolean estaContenedor(String contenedor) {
	
		int i = 0;
		while(i < listaCont.length && listaCont[i] != null) {
			if (listaCont[i].getNombre().equals(contenedor)) {
				return true;
			}
			i++;
		}
		return false;
		
	}
	
	/**
	 * Devuelve el nivel en el que esta el contenedor dado del 0 al 3, 
	 * @param contenedor nombre contenedor
	 * @return devuelve el nivel en el que esta el contenedor
	 * @throws IllegalArgumentException() cuando no se encuntra el contenedor
	 */

	public int getNivelContenedor(String contenedor) {
		int i = 0;
		while(i < listaCont.length && listaCont[i] != null) {
			String nombre = listaCont[i].getNombre();
			if (nombre.equals(contenedor)) {
				return i;
			}
			i ++;
		}
		throw new IllegalArgumentException();
		
	}
	/**
	 * A�ade un contenedor a una plaza, mientras los contenedores tengan techo 
	 * @param contenedor contenedor completo
	 * @throws ArrayIndexOutOfBoundsException() cuando el contenedor esta lleno
	 */
	public void anadirContenedor(Contenedor contenedor) {
		if (numCont<numMaxCont){
			listaCont[numCont]=contenedor;
			numCont++;
			if (!contenedor.tieneTecho()){
				numMaxCont=numCont;		
			}
			
		} else {
			throw new ArrayIndexOutOfBoundsException();
		} 
	}
	/**
	 * Despaila un contenedor de una plaza es decir quita un ocntenedor de la lista y baja el nivel de los contenedores superiores
	 * @param contenedor contenedor completo
	 */
	
	public void desapilarContenedor(Contenedor contenedor) {
		String nomCont=contenedor.getNombre();
		if(numCont == 0) {
			throw new ArrayIndexOutOfBoundsException();
		}
		int i = 0;
		while(i < listaCont.length -1  && listaCont[i] != null) {
			
			if (listaCont[i].getNombre().equals(nomCont)) {
				for(int j = i; j < listaCont.length - 1; j++ ) {
					listaCont[i]=listaCont[i+1];
				}
				
			}
			i++;
		} 
		listaCont[listaCont.length-1]=null;
		numCont--;
		
	}boolean estaVacia(){
		if (numMaxCont==4) {
			return true;
		}else return false;
		
	}

}
