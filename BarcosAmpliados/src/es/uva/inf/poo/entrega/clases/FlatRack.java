package es.uva.inf.poo.entraga.clases;

public class FlatRack extends Contenedor{
	
	public FlatRack(String codDueno, char equip, int numSerie,int digitoControl, double pes, char udPeso, double vol, char udVol,  String est) {
			super(codDueno,equip,numSerie,digitoControl,pes,udPeso,vol,udVol,est,false);
	
	}
	@Override
	public void anadirTrayecto(Trayecto tray) {
		if (tray.getClass().getSimpleName().equals("TCamion")||tray.getClass().getSimpleName().equals("PackCamionTren")||tray.getClass().getSimpleName().equals("PackCamionBarco")) {
			throw new IllegalArgumentException("No se admiten trayectos en camion");
			
		}else {
			getListaTrayectos().add(tray);
		}
	}
	

	}
