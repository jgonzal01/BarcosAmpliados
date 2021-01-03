package es.uva.inf.poo.entraga.clases;



public class Refrigerado extends Contenedor {
	public Refrigerado(String codDueno, char equip, int numSerie,int digitoControl, double pes, char udPeso, double vol, char udVol,  String est) {
		super(codDueno,equip,numSerie,digitoControl,pes,udPeso,vol,udVol,est,true);
	}

}
