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
		 this.numMisioneros = nMisioneros;
		 this.numCanibales = nCanibales;
		 this.barcaIzq = barcaIzq;
		 }
		 
		public int getnMisioneros(){
			
			return this.numMisioneros;
		}
		public int getnCanibales(){
			
			return this.numCanibales;
		}
		public boolean isBarcaIzq(){
			return this.barcaIzq;
		}
	 
	 /*
	  * tenemos que definir lo estador y operadores pres y post
	  */
		public void moveM(){
			if(this.barcaIzq)
				this.numMisioneros--;
			else
				this.numMisioneros++;
			
			cambiarDeOrilla();
			
		}
		public void cambiarDeOrilla(){
			
		this.barcaIzq=(this.barcaIzq)?false:true;
			
		}
		
		
		public boolean movimientoValido(Action where){
			boolean valido=false;
			
			if(where.equals(M)){
				if((barcaIzq&&numMisioneros>0)
						||(!barcaIzq&& this.numMisioneros<3)){
					EstadoMisioneros estadoSiguiente= new EstadoMisioneros(this);
					
					
				}
				else valido=false;
				
			}
			else if(where.equals(MM)){
				
				
			}
			
			return valido;
		}
		
		private boolean peligro(){
			
			if(((this.numMisioneros<this.numCanibales)&&(
					this.numMisioneros!=0))||((this.numMisioneros>this.numCanibales)&&
							(this.numMisioneros!=3)))
				return true;
			else
				return false;
			
			
			
		}
		public boolean equals(Object o){
			
			if(this==o){
				return true;
			}
			if ((o == null) || (this.getClass() != o.getClass())) {
				return false;
			}
			
			EstadoMisioneros otroEstado=(EstadoMisioneros)o;
			
			if((this.numMisioneros==otroEstado.getnMisioneros())&&
					(this.numCanibales==otroEstado.getnCanibales())&&
					(this.barcaIzq==otroEstado.barcaIzq))
				return true;
			else
				return false;
				
				
			
			
		}
		
		
		
}
