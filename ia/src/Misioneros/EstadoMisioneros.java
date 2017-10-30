package Misioneros;

import aima.core.agent.Action;
import aima.core.agent.impl.DynamicAction;

public class EstadoMisioneros {
	private int numMisioneros; // numMisioneros en orilla izquierda
    private int numCanibales; // numCanibales en orilla izquierda
	private boolean barcaIzq; // true si barca en orilla izquierda
	public static Action M = new DynamicAction("M");
	 public static Action MM = new DynamicAction("MM");
	 public static Action C = new DynamicAction("C");
	 public static Action CC = new DynamicAction("CC");
	 public static Action MC = new DynamicAction("MC");
	 
	 
	 public EstadoMisioneros() {
		 this(3, 3, true);
		 }
		 public EstadoMisioneros(EstadoMisioneros mc) {
		 this(mc.getnMisioneros(), mc.getnCanibales(), mc.isBarcaIzq());
		 }
		 public EstadoMisioneros(int nMisioneros, int nCanibales, boolean
		 barcaIzq) {
		 this.nMisioneros = nMisioneros;
		 this.nCanibales = nCanibales;
		 this.barcaIzq = barcaIzq;
		 }
	 
	 
		 
		/////////////////Rama prueba jose /////////////////////
		 
		 
		 
		 
		 
}
