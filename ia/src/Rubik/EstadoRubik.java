package Rubik;

import aima.core.agent.Action;
import aima.core.agent.impl.DynamicAction;

public class EstadoRubik {
	final int DIM = 3;
	private int[][] cara0;//cara verde
	private int[][] cara1;//cara naranja
	private int[][] cara2;//cara azul
	private int[][] cara3;//cara rojo
	private int[][] cara4;//cara amarillo
	private int[][] cara5;//cara blanca
	
	
	//private int  cubo [][][];
	
	public EstadoRubik(){ // Estado perfecto del cubo de rubik
		for (int i = 0; i < DIM ; i++){
			for(int j = 0; j < DIM;j++){
				this.cara0[i][j]=0;
				this.cara1[i][j]=1;
				this.cara2[i][j]=2;
				this.cara3[i][j]=3;
				this.cara4[i][j]=4;
				this.cara5[i][j]=5;
			
			}		
		}
	}
	
	
	
	public void movU(EstadoRubik e){
		
		int aux2[] = null;
		int aux1[] = null;
		int aux0[] = null;
		
		int auxArriba0[] = null;// el valor no existe
		int auxArriba1[] = null;
		int auxArriba2[] = null;
		
		for (int i = 0; i < DIM; i++) {
			aux2[i]=this.cara2[0][i];
			aux1[i]=this.cara1[0][i];
			aux0[i]=this.cara0[0][i];
		}
		for(int i = 0; i < DIM; i++){ // cambia los valores entre caras
			this.cara2[0][i]=this.cara3[0][1];
			this.cara1[0][i] = aux2[i];
			this.cara0[0][i] = aux1[i];
			this.cara3[0][i] = aux0[i];
		}
		
	
	}
	
	
	
	
}



//cubo[0][1][2]


