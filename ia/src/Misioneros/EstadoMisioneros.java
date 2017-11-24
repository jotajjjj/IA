package Misioneros;

import aima.core.agent.Action;
import aima.core.agent.impl.DynamicAction;


public class EstadoMisioneros {
	private int numMisioneros; // numMisioneros en orilla izquierda
    private int numCanibales; // numCanibales en orilla izquierda
	private boolean barcaIzq; // true si barca en orilla izquierda
	
	
	public static Action M = new DynamicAction("M" );
	 public static Action MM = new DynamicAction("MM");
	 public static Action C = new DynamicAction("C");
	 public static Action CC = new DynamicAction("CC");
	 public static Action MC = new DynamicAction("MC");
	 /*
	 (3 3 1)  (0,0,0)  
	 (3 1 0)  (3,2,1)
	 (3 2 1)
	 (3,0,0)
	 (3,1 1)
	 (1,1,0)
	 (2,2,1)
	 (0,2,0)
	 (0,1,1)
	 
	 *
	 */
	 public EstadoMisioneros() {
		 this(3, 3, true);
		 }
	 public EstadoMisioneros(EstadoMisioneros mc) {
		 
		 this(mc.getnMisioneros(), mc.getnCanibales(), mc.isBarcaIzq());
	
	 }
	
	 public EstadoMisioneros(int nMisioneros, int nCanibales, boolean barcaIzq) {
		 
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
		public void movM(){
			if(this.barcaIzq)
				this.numMisioneros--;
			else
				this.numMisioneros++;
			
			cambiarDeOrilla();
			
		}
		public void movMM(){
			if(this.barcaIzq)
				this.numMisioneros=this.numMisioneros-2;
			else
				this.numMisioneros=this.numCanibales+2;
			cambiarDeOrilla();
			
			
		}
		
		
		public void movC(){
			if(this.barcaIzq)
				this.numCanibales--;
			else
				this.numCanibales++;
			cambiarDeOrilla();
			
			
		}
		public void movCC(){
			if(this.barcaIzq)
				this.numCanibales=this.numCanibales-2;
			else
				this.numCanibales=this.numCanibales+2;
			cambiarDeOrilla();
			
		}
		public void movMC(){
			
			if(this.barcaIzq){
				
				this.numCanibales--;
				this.numMisioneros--;
			}
			else{
				this.numCanibales++;
				this.numMisioneros++;
				
			}
			cambiarDeOrilla();
		}
		
		
		
		
		
		
		
		
		public void cambiarDeOrilla(){
			
		//this.barcaIzq=(this.barcaIzq)?false:true;
			if(this.barcaIzq)
				this.barcaIzq=false;
			else
				this.barcaIzq=true;
			
			
		}
		
		
		public boolean movimientoValido(Action where){
			boolean valido=false;
			
			if(where.equals(M)){
				if((barcaIzq&&numMisioneros>0)
						||(!barcaIzq&& this.numMisioneros<3)){
					EstadoMisioneros estadoSiguiente= new EstadoMisioneros(this);
					estadoSiguiente.movM();
					valido=!estadoSiguiente.peligro();
				}
				else valido=false;
				
			}
			if(where.equals(C)){
				if((barcaIzq&&this.numCanibales>0)
						||(!barcaIzq&& this.numCanibales<3)){
					EstadoMisioneros estadoSiguiente= new EstadoMisioneros(this);
					estadoSiguiente.movC();
					valido=!estadoSiguiente.peligro();
				}
				else valido=false;
				
			}
			
			else if(where.equals(MM)){
				
				if((this.barcaIzq&&this.numMisioneros>=2)||(!this.barcaIzq &&(this.numMisioneros<=1))){
					EstadoMisioneros estadoSiguiente= new EstadoMisioneros(this);
					estadoSiguiente.movMM();
					valido=!estadoSiguiente.peligro();
					
				}else
					valido=false;
				
				
			}
			else if(where.equals(CC)){
				if((this.barcaIzq&&this.numCanibales>=2)||(!this.barcaIzq &&(this.numCanibales<=1))){
					EstadoMisioneros estadoSiguiente= new EstadoMisioneros(this);
					estadoSiguiente.movCC();
					valido=!estadoSiguiente.peligro();
					
				}else
					valido=false;
				
				
			}
			else if(where.equals(MC)){				
				
				if( (this.barcaIzq&&this.numCanibales>0&&this.numMisioneros>0)||
						((!this.barcaIzq )&& ( this.numCanibales <3 && this.numMisioneros<3 )) ){
					EstadoMisioneros estadoSiguiente = new EstadoMisioneros(this);
					estadoSiguiente.movMC();
					valido=!estadoSiguiente.peligro();
				
				}else
					valido=false;
				
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
	public String toString(){
		
		return "( "+this.numMisioneros+", "+this.numCanibales+" , "+this.barcaIzq+" )"; 
		
	}
		
		
}
