package es.uva.inf.poo.entraga.clases;
/**
 * Clase que representa un contenedor flatRack que se caracteriza por no tener techo, por requerir dos plazas para su almacenamiento y por no poder transportarse en camion. 
 * Hereda de la clase contenedor.
 * @author igndomi
 * @author jgonzal
 *
 */
public class FlatRack extends Contenedor{
	/**
	 * Constructor de la clase FlatRack
	 * @param codDueno
	 * @param equip
	 * @param numSerie
	 * @param digitoControl
	 * @param pes
	 * @param udPeso
	 * @param vol
	 * @param udVol
	 * @param est
	 */
	public FlatRack(String codDueno, char equip, int numSerie,int digitoControl, double pes, char udPeso, double vol, char udVol,  String est) {
			super(codDueno,equip,numSerie,digitoControl,pes,udPeso,vol,udVol,est,false);
	
	}
	
	@Override
	/**
	 * Sobrecarga del metodo anadir trayecto de la clase Contenedor para que no se pueda anadir un trayecto por Camion
	 * @throws IllegalArgumentException si se intenta anadir un trayecto por camion
	 */
	public void anadirTrayecto(Trayecto tray) {
		if (tray.getClass().getSimpleName().equals("TCamion")||tray.getClass().getSimpleName().equals("PackCamionTren")||tray.getClass().getSimpleName().equals("PackCamionBarco")) {
			throw new IllegalArgumentException("No se admiten trayectos en camion");
			
		}else {
			getListaTrayectos().add(tray);
		}
	}
	

	}
