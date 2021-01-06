package es.uva.inf.poo.entrega.clases;
import java.util.ArrayList;
import java.time.LocalDate;
/**
 * Clase que representa objetos de tipo contenedor, que son guardados en plazas de muelles 
 * y que realizan trayectos intercambiando mercancias
 * @author igndomi 	
 * @author jgonzal
 *
 */
public abstract class Contenedor {
	/**
	 * Codigo de tres letra mayusculas que indica el dueno 
	 */
	private String codigoDueno;
	/** 
	 * Letra mayuscula U, J o Z que indica el tipo de equipamiento
	 */
	private char letraEquipamiento;
	/**
	 * Numero de serie de 6 cifras 
	 */
	private int numeroSerie;
	/**
	 * Digito de control obtenido mediante un algoritmo
	 */
	private int digitoControl;
	/**
	 * Peso de la carga que se guarda en kilos
	 */
	private double peso;
	/**
	 * Volumen de la carga que se guarda en metros cubicos
	 */
	private double volumen;
	/**
	 * Estado del contenedor: en transito o en recogida
	 */
	private String estado;
	/**
	 * Numero que indica si tiene techo o no
	 */
	private boolean techo;
	/**
	 * Constante para el cambio de pies cubicos a metros cubicos
	 */
	final double PIES_CUBICOS_A_METROS = 35.3147;
	/**
	 * COnstante para el cambio de Kilos a Libras
	 */
	final double KILOS_A_LIBRAS = 0.4535;
	/**
	 * Lista trayectos
	 */
	private ArrayList<Trayecto> listaTrayectos = new ArrayList<Trayecto>();
	/**Inicializacion de la clase contenedor 
	 * @param codDueno codigo del dueno
	 * @param equip equipamiento del contenedor
	 * @param numSerie numero de serie
	 * @param digitoControl digito que verifica el nombre del contenedor
	 * @param pes peso de la carga 
	 * @param udPeso unidad del peso 'k'o'K' son kilos 'l'o'L' son libras
	 * @param vol volumen de la carga
	 * @param udVol unidad del volumen 'm'o'M' son metros cubicos 'p'o'P' son pies cubicos
	 * @param est estado del contenedor "Transito" o "Recogida"
	 * @param tech numero que si tiene techo o no
	 * 
	 */
	public Contenedor(String codDueno, char equip, int numSerie,int digitoControl, double pes, char udPeso, double vol, char udVol,  String est, boolean tech) {
		
		
		codigoDueno = comprobarCodigoDueno(codDueno);
		letraEquipamiento= comprobarLetraEquipamiento(equip);
		numeroSerie = comprobarNumSerie(numSerie);
		this.digitoControl = comprobarDigitoControl(digitoControl);
		peso = calcularPesoEnKilos(pes,udPeso);
		volumen = calcularVolMetros(vol, udVol);
		techo = comprobarTecho(tech);
		estado = comprobarEstado(est);
	}
	
		

	/**
	 * Se anade a un Arraylist los trayectos que va realizando un contenedor
	 * @param trayecto Trayecto que raliza un contenedor
	 */
	
	public void anadirTrayecto(Trayecto trayecto) {
		listaTrayectos.add(trayecto);
	}
	/**
	 * getter de la lista de tayectos
	 * @return lista de todos los trayectos realizados por un contenedor
	 */
	public ArrayList <Trayecto> getListaTrayectos() {
		return listaTrayectos;
	}
	/**
	 * Getter del codigo de dueno
	 * @return codigo de dueno
	 */
	public String getCodigoDueno() {
		return codigoDueno;
		 
	}
	/**
	 * Getter del tipo de equipamiento
	 * @return equipamiento
	 */
	
	public char getEquipamiento() {
		return letraEquipamiento;
	}
	/**
	 * Getter del numero de serie
	 * @return numero de serie
	 */
	public int getNumSerie() {
		return numeroSerie;
	}
	/**
	 * Getter del digito de control
	 * @return digito de control
	 */
	public int getDigitoControl() {
		return digitoControl;
	}
	/**
	 * Getter del nombre del contenedor como concatenacion del codigo del dueno, letra de quipamiento, numero de serie y digito de control
	 * @return nombre del contenedor
	 */
	public String getNombre() {
		String numSerie = String.valueOf(numeroSerie);
		String letraEquip = String.valueOf(letraEquipamiento);
		
		return codigoDueno + letraEquip + numSerie + digitoControl;
	}
	/**
	 * Getter de estado del contenedor, en transito o recogida
	 * @return estado del contenedor
	 */
	public String getEstado() {
		return estado;
	}
	/**
	 * Getter de si tiene techo
	 * @return true si tiene techo, false si no
	 */
	
	public boolean getTecho() {
		return techo;
	}
	/**
	 * Cambia el estado a en transito
	 */
	public void cambiarATransito() {
		estado="transito";
		
	}
	/**
	 * Cambia el estado a en recogida
	 */
	public void cambiarARecogida() {
		estado="recogida";
	}
	/**
	 * Realiza el cambio de peso en kilos
	 * @return peso en kilos
	 */
	public double pesoEnKilos() {
		return peso;
	}
	/**
	 * Realiza el cambio de peso en Libras
	 * @return peso en kilos
	 */
	public double pesoEnLibras() {
		double libras= peso/KILOS_A_LIBRAS;
		return libras;
	}
	/**
	 * Realiza el cambio de volumen en metros cubicos
	 * @return volumen en metros cubicos
	 */
	public double volumenEnMetrosCubicos() {
		return volumen;
	}
	/**
	 * Realiza el cambio de volumen en pies cubicos
	 * @return volumen en metros cubicos
	 */
	public double volumenEnPiesCubicos() {
		double pies= volumen*PIES_CUBICOS_A_METROS;
		return pies;
	}
	/**
	 * comprobacion de cubierta de un contenedor
	 * @return true si el contenedor tiene techo, false sino lo tiene
	 */
	public boolean tieneTecho() {
		if (techo) {
			return true;
		}else {
			return false;
		}
	}
	
	private int comprobarDigitoControl(int digito) {
		int valor = obtenerDigitoControl();
		if (digito == valor) {
			return digito;
		}else {
			throw new IllegalArgumentException();
		}
	}
	private String comprobarCodigoDueno(String codigo) {
		
		if(codigo.length() != 3) {
			throw new IllegalArgumentException();
			
		}else {
			if(codigo.equals(codigo.toUpperCase())) {
				return codigo;
			}else {
				throw new IllegalArgumentException();
			}
		}
			
		
	}
	private char comprobarLetraEquipamiento(char letra) {
		char letraMayus = Character.toUpperCase(letra);
		if(letraMayus == 'J' || letraMayus == 'U'|| letraMayus == 'Z') {
			return letraMayus;
			
		}else {
			throw new IllegalArgumentException();
		}
		
	}
	private int comprobarNumSerie(int numserie) {
		if(100000 <= numserie && numserie < 1000000) {
			return numserie;
		}else {
			throw new IllegalArgumentException();
		}
		
	}
	private double calcularPesoEnKilos(double pes, char udPeso) {
		
		if(pes < 0) {
			throw new IllegalArgumentException();
		}
		if (udPeso=='k'||udPeso == 'K') {
			return pes;
		}else if (udPeso=='l'||udPeso == 'L'){
				return pes*KILOS_A_LIBRAS;
		}
		
		throw new IllegalArgumentException();
					 
	}
	
	private double calcularVolMetros(double vol, char udVolum) {
		//Falta comprobar si la entrada esta bien
		if (vol <0) {
			throw new IllegalArgumentException();
		}
		if (udVolum=='m'||udVolum == 'M') {
			return vol;
		}else if (udVolum=='p' || udVolum == 'P'){
				return vol / PIES_CUBICOS_A_METROS;
			}
		else{
			throw new IllegalArgumentException();
		}
		
	}
	private boolean comprobarTecho(boolean techo) {
		if(techo == true || techo == false) {
			return techo;
			
		}else {
			throw new IllegalArgumentException();
		}
	}
	private String comprobarEstado(String estado) {
		String est = estado.toLowerCase(); 
		if(est.equals("transito") || est.equals("recogida")) {
			return est;
		}else {
			throw new IllegalArgumentException();
		}
		
	}
	private int obtenerDigitoControl() {
		int [] listaDigitos = new int [10];
		int digito = 0;
		int copiaNumSerie = numeroSerie;
		listaDigitos[0] = transformarLetras(codigoDueno.charAt(0));
		listaDigitos[1] = transformarLetras(codigoDueno.charAt(1));
		listaDigitos[2] = transformarLetras(codigoDueno.charAt(2));
		listaDigitos[3] = transformarLetras(letraEquipamiento);
		for (int i = 9; i>3; i--) {
			listaDigitos[i]=copiaNumSerie%10;
			copiaNumSerie = copiaNumSerie/10;
		}for (int i = 0; i<listaDigitos.length; i++) {
			listaDigitos[i] = (int) Math.pow(2 , i) * listaDigitos[i];
			digito = digito + listaDigitos[i];
		}double aux = digito;
		aux = aux /11;
	
		aux = Math.floor(aux);
		aux = aux * 11;
		digito = digito- (int) aux;
		
		return digito;
		
	}
	private int transformarLetras(char letra) {
		int valor = 0;
		int [] listaNum = new int [] {10,	12,	13,	14,	15,	16,	17,	18,	19,	20,	21,	23,	24,25,26,	27,	28,	29,	30,	31,	32,	34,	35,	36,	37,	38};
		char [] listaCaracteres = new char []{'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
		for (int i = 0 ; i < listaNum.length; i++ ) {
			if (letra==listaCaracteres[i]) {
				valor = listaNum[i];
			}
		}
			
		return valor;
	}
	
}
