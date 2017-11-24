package rubik;

import Misioneros.EstadoMisioneros;
import aima.core.agent.Action;
import aima.core.agent.impl.DynamicAction;

public class EstadoRubik {

	
	private final int dim=3;
	private final int nCaras=6;
	// representamos la cara, la fila y la columna
	public static Action F = new DynamicAction("F" );
	 public static Action R = new DynamicAction("R");
	 public static Action U = new DynamicAction("U");
	 public static Action B = new DynamicAction("B");
	 public static Action L = new DynamicAction("L");
	 public static Action D = new DynamicAction("D");
	
	 
	 public static Action FR = new DynamicAction("FR" );
	 public static Action RR = new DynamicAction("RR");
	 public static Action UR = new DynamicAction("UR");
	 public static Action BR = new DynamicAction("BR");
	 public static Action LR = new DynamicAction("LR");
	 public static Action DR = new DynamicAction("DR");
	 
	 
	 
	 private int [][][] rubik;
	
	
	public EstadoRubik(){
		
		this.rubik  = new int [this.nCaras][this.dim][this.dim]; 
		
		for (int i = 0; i < this.nCaras; i++) {
			
			if (i==0) {//es la cara cero
				
				for (int j = 0; j < this.dim; j++) {
					for (int j2 = 0; j2 < this.dim; j2++) {
						this.rubik[i][j][j2]=i;
					}
				}
				
			}
			if (i==1) {//es la cara cero
				
				for (int j = 0; j < this.dim; j++) {
					for (int j2 = 0; j2 < this.dim; j2++) {
						this.rubik[i][j][j2]=1;
					}
				}
				
			}
			if (i==2) {//es la cara cero
				
				for (int j = 0; j < this.dim; j++) {
					for (int j2 = 0; j2 < this.dim; j2++) {
						this.rubik[i][j][j2]=2;
					}
				}
				
			}
			if (i==3) {//es la cara cero
				
				for (int j = 0; j < this.dim; j++) {
					for (int j2 = 0; j2 < this.dim; j2++) {
						this.rubik[i][j][j2]=3;
					}
				}
				
			}
			if (i==4) {//es la cara cero
				
				for (int j = 0; j < this.dim; j++) {
					for (int j2 = 0; j2 < this.dim; j2++) {
						this.rubik[i][j][j2]=4;
					}
				}
				
			}
			if (i==5) {//es la cara cero
				
				for (int j = 0; j < this.dim; j++) {
					for (int j2 = 0; j2 < this.dim; j2++) {
						this.rubik[i][j][j2]=5;
					}
				}
				
			}
			
			
		}
		
		
	}
	
	
	public EstadoRubik(EstadoRubik e){
		
		this.rubik  = new int [this.nCaras][this.dim][this.dim];
		
		for (int k = 0; k < this.nCaras; k++) {
			
		
		
		for (int i = 0; i < this.dim; i++) {
			
			
			for (int j= 0; j < this.dim; j++) {
				this.rubik[k][i][j]=e.rubik[k][i][j];
				
			}
			
		}
		
		}
		
	}
	
	
	
	/*
	 * 
	 * REVERSE ESTA PENSADO PARA COPIAR EN UNA FILA , EMPEZANDO POR EL INDICE
	 * FINAL DE LA COLUMNA DE LA QUE SE COPIA
	 */
	
	// cambiasmos la fila columna 3 de 0 por la fila 1 de 5
	public void movF(){
		
		
		/*
		 * fallos , la f3 de la cara 4 pasa a la c0 de cara 2
		 * la columna 0 de cara dos pasa a fila 1 cara 5
		 * columna  3 de cara 0 para a fila 0 cara 4
		 * fila 0 cara 5 pasa a columna 3 cara 0
		 */
		
		
		
		int aux[][] = new int[1][3];
		int aux2[][] = new int[3][1];
		int aux3[][] = new int[1][3];
		int aux4[][] = new int[3][1];
		
		int aux5[][]= new int [1][3];
		int aux6[][]= new int [1][3];
		int aux7[][]= new int [1][3];
		
		//copiamos en un aux la primera fila de zona 5
		aux=cloneF(5,0);
		aux2=cloneC(0,2);
		aux3=cloneF(4,2); //bloque 4 fila 2
		aux4=cloneC(2,0);//bloque 2 col 0
		
		aux5=cloneF(1,0);
		aux6=cloneF(1,1);
		aux7=cloneF(1,2);
		
		
		this.copiaEnColumnaUnaFila(aux, 0, 2);//copiamos en bl0 col2
		this.copiaEnFilaUnaColumnaReverse(aux2, 4, 2);
		
		this.copiaEnColumnaUnaFila(aux3, 2, 0);//copiamos en bl0 la col0
		this.copiaEnFilaUnaColumnaReverse(aux4, 5, 0);
		
		this.copiaEnColumnaUnaFila(aux5, 1, 2);
		this.copiaEnColumnaUnaFila(aux6, 1, 1);
		this.copiaEnColumnaUnaFila(aux7, 1, 0);
		
		
	}
	public void movFR(){

		int aux[][] = new int[1][3];
		int aux2[][] = new int[3][1];
		int aux3[][] = new int[1][3];
		int aux4[][] = new int[3][1];
		
		int aux5[][]= new int [1][3];
		int aux6[][]= new int [1][3];
		int aux7[][]= new int [1][3];
		
		//copiamos en un aux la primera fila de zona 5
		aux=cloneF(5,0);
		aux2=cloneC(0,2);
		aux3=cloneF(4,2); //bloque 4 fila 2
		aux4=cloneC(2,0);//bloque 2 col 0
		
		aux5=cloneF(1,0);
		aux6=cloneF(1,1);
		aux7=cloneF(1,2);
		
		//int[][] v=new int [3][3];
		
		//v=this.rubik[1].clone();
		
		this.copiaEnColumnaUnaFilaReverse(aux, 2, 0);
		
		//quitamos el reverse con respecto  a movF
		//sumamos 1 y el opesto de fila o col
		this.copiaEnFilaUnaColumna(aux2, 5, 0);
		
		
		////esta puede ser reverse
		this.copiaEnColumnaUnaFilaReverse(aux3, 0, 2);//copiamos en bl0 la col0
		
		
		this.copiaEnFilaUnaColumna(aux4, 4, 2);
		
		
		
		this.copiaEnColumnaUnaFilaReverse(aux5, 1, 0);
		this.copiaEnColumnaUnaFilaReverse(aux6, 1, 1);
		this.copiaEnColumnaUnaFilaReverse(aux7, 1, 2);

		
		
		
		
		

	}
	
	
	
	
	public void movR(){
		/*
		 * solo se juega concolumnas
		 */
		
		int aux1[][]= new int [3][1];
		int aux2[][]= new int [3][1];
		int aux3[][]= new int [3][1];
		int aux4[][]= new int [3][1];
		
		int aux5[][]= new int [3][1];
		
		int aux6[][]= new int [3][1];
		
		int aux7[][]= new int [3][1];
		
		aux1=cloneC(5,2);
		aux2=cloneC(1,2);
		aux3=cloneC(4,2);
		aux4=cloneC(3,0);
		
		aux5=cloneF(2,0);
		aux6=cloneF(2,1);
		aux7=cloneF(2,2);
		
		
		this.copiaEnColumnaUnaColumna(aux1, 1, 2);
		this.copiaEnColumnaUnaColumna(aux2, 4, 2);
		this.copiaEnColumnaUnaColumnaReves(aux3, 3, 0);
		this.copiaEnColumnaUnaColumnaReves(aux4, 5, 2);
		
		this.copiaEnColumnaUnaFila(aux5, 2, 2);
		this.copiaEnColumnaUnaFila(aux6, 2, 1);
		this.copiaEnColumnaUnaFila(aux7, 2, 0);
		
	}
	
	
	public void movRR(){
		int aux1[][]= new int [3][1];
		int aux2[][]= new int [3][1];
		int aux3[][]= new int [3][1];
		int aux4[][]= new int [3][1];
		
		int aux5[][]= new int [3][1];
		
		int aux6[][]= new int [3][1];
		
		int aux7[][]= new int [3][1];
		
		aux1=cloneC(5,2);
		aux2=cloneC(1,2);
		aux3=cloneC(4,2);
		aux4=cloneC(3,0);
		
		aux5=cloneF(2,0);
		aux6=cloneF(2,1);
		aux7=cloneF(2,2);
		
		this.copiaEnColumnaUnaFilaReverse(aux5, 2, 0);
		this.copiaEnColumnaUnaFilaReverse(aux6, 2, 1);
		this.copiaEnColumnaUnaFilaReverse(aux7, 2, 2);
		
		
		
		this.copiaEnColumnaUnaColumna(aux3, 1, 2);
		
		this.copiaEnColumnaUnaColumna(aux2, 5, 2);
		
		
		
		this.copiaEnColumnaUnaColumnaReves(aux1, 3, 0);
		this.copiaEnColumnaUnaColumnaReves(aux4, 4, 2);
		
		
		
		
		
		
	}
	
	
	
	
	
	
	/*
	 * movimiento de atras cambiando hacia la derecha la ultima fila y col
	 * 
	 */
	public void movB(){
		int aux1[][]= new int [3][1];
		int aux2[][]= new int [3][1];
		int aux3[][]= new int [3][1];
		int aux4[][]= new int [3][1];
		
		aux1=this.cloneF(5, 2);//copiamos el del bloque 5 la fila 3
		aux2=this.cloneC(2, 2);
		aux3=this.cloneF(4, 0);
		aux4=this.cloneC(0, 0);
		
		this.copiaEnFilaUnaColumna(aux4, 5, 2);
		this.copiaEnColumnaUnaFila(aux1, 2, 2);
		this.copiaEnFilaUnaColumna(aux2, 4, 0);
		this.copiaEnColumnaUnaFila(aux3, 0, 0);
		
		
	}
	
	public void movBR(){
		
		int aux1[][]= new int [3][1];
		int aux2[][]= new int [3][1];
		int aux3[][]= new int [3][1];
		int aux4[][]= new int [3][1];
		
		int aux5[][] = new int [1][3];
		int aux6[][] = new int [1][3];
		int aux7[][] = new int [1][3];
		
		
		aux1=this.cloneF(5, 2);//copiamos el del bloque 5 la fila 3
		
		
		aux2=this.cloneC(2, 2);
		aux3=this.cloneF(4, 0);
		aux4=this.cloneC(0, 0);
		
		aux5=this.cloneF(3, 0);
		aux6=this.cloneF(3, 1);
		aux7=this.cloneF(3, 2);
		
		
		
		this.copiaEnColumnaUnaFila(aux1, 0, 0);
		this.copiaEnFilaUnaColumnaReverse(aux2, 5, 2);
		this.copiaEnColumnaUnaFila(aux3, 2, 2);
		this.copiaEnFilaUnaColumnaReverse(aux4, 4, 0);
		
		
		this.copiaEnColumnaUnaFilaReverse(aux5, 3, 0);
		this.copiaEnColumnaUnaFilaReverse(aux6, 3, 1);
		this.copiaEnColumnaUnaFilaReverse(aux7, 3, 2);
		
		
		
		
		
		
	}
/*	
public void movBR(){
		
		int aux1[][]= new int [3][1];
		int aux2[][]= new int [3][1];
		int aux3[][]= new int [3][1];
		int aux4[][]= new int [3][1];
		
		int aux5[][] = new int [1][3];
		int aux6[][] = new int [1][3];
		int aux7[][] = new int [1][3];
		
		
		aux1=this.cloneF(5, 2);//copiamos el del bloque 5 la fila 3
		this.copiaEnColumnaUnaFila(aux1, 0, 0);
		aux1=this.cloneC(2, 2);
		
		
		this.copiaEnColumnaUnaFilaReverse(aux5, 3, 0);
		
		
		
		
		
		
		
		
		aux3=this.cloneF(4, 0);
		aux4=this.cloneC(0, 0);
		
		aux5=this.cloneF(3, 0);
		aux6=this.cloneF(3, 1);
		aux7=this.cloneF(3, 2);
		
		
		
		
		this.copiaEnFilaUnaColumnaReverse(aux2, 5, 2);
		this.copiaEnColumnaUnaFila(aux3, 2, 2);
		this.copiaEnFilaUnaColumnaReverse(aux4, 4, 0);
		
		
		
		this.copiaEnColumnaUnaFilaReverse(aux6, 3, 1);
		this.copiaEnColumnaUnaFilaReverse(aux7, 3, 2);
		
		
		
		
		
		
	}
	
	*/
	
	/*
	 * 
	 * movimeinto frotal primera fila lo hace a la izquierda
	 */
	public void movU(){
		
		int aux1[][]= new int [3][1];
		int aux2[][]= new int [3][1];
		int aux3[][]= new int [3][1];
		int aux4[][]= new int [3][1];
		
		
		int aux5[][]= new int [3][1];
		int aux6[][]= new int [3][1];
		int aux7[][]= new int [3][1];
		
		
		
		aux1=this.cloneF(0, 0);
		aux2=this.cloneF(1, 0);
		aux3=this.cloneF(2, 0);
		aux4=this.cloneF(3, 0);
		
		
		aux5=this.cloneF(4, 0);
		aux6=this.cloneF(4, 1);
		aux7=this.cloneF(4, 2);
		
		this.copiaEnFilaUnaFila(aux1, 3, 0);
		this.copiaEnFilaUnaFila(aux2, 0, 0);
		this.copiaEnFilaUnaFila(aux3, 1, 0);
		this.copiaEnFilaUnaFila(aux4, 2, 0);
		
		
		this.copiaEnColumnaUnaFila(aux5, 4, 2);
		this.copiaEnColumnaUnaFila(aux6, 4, 1);
		this.copiaEnColumnaUnaFila(aux7, 4, 0);
		
		
	}
	
public void movUR(){
		
		int aux1[][]= new int [3][1];
		int aux2[][]= new int [3][1];
		int aux3[][]= new int [3][1];
		int aux4[][]= new int [3][1];
		
		
		int aux5[][]= new int [3][1];
		int aux6[][]= new int [3][1];
		int aux7[][]= new int [3][1];
		
		
		
		aux1=this.cloneF(0, 0);
		aux2=this.cloneF(1, 0);
		aux3=this.cloneF(2, 0);
		aux4=this.cloneF(3, 0);
		
		
		aux5=this.cloneF(4, 0);
		aux6=this.cloneF(4, 1);
		aux7=this.cloneF(4, 2);
		
		
		
		this.copiaEnFilaUnaFila(aux1, 1, 0);
		this.copiaEnFilaUnaFila(aux2, 2, 0);
		this.copiaEnFilaUnaFila(aux3, 3, 0);
		this.copiaEnFilaUnaFila(aux4, 0, 0);
		
		
		
		this.copiaEnColumnaUnaFilaReverse(aux5, 4, 0);
		this.copiaEnColumnaUnaFilaReverse(aux6, 4, 1);
		this.copiaEnColumnaUnaFilaReverse(aux7, 4, 2);
		
		
		
	}
	
	
	
	
	
	public void movL(){
		
		
		
		int aux1[][]= new int [1][3];
		int aux2[][]= new int [1][3];
		int aux3[][]= new int [1][3];
		int aux4[][]= new int [3][1];
		int aux5[][]= new int [3][1];
		int aux6[][]= new int [3][1];
		int aux7[][]=new int [3][1];
		// la cara que rota completa es la 0  
		// la columna 0 del bloque 5 va a la columna 2 bloque 3 reves
		// la col 2 del bloque 3 va a la col 0 del bloque 4 (reves)
		// la col 0 bloque 1 va a la col 0 del bl 5
		
		aux1=this.cloneF(0, 0);
		aux2=this.cloneF(0, 1);
		aux3=this.cloneF(0, 2);
		
		
		aux4=this.cloneC(5, 0);
		aux5=this.cloneC(3, 2);
		aux6=this.cloneC(4, 0);
		aux7=this.cloneC(1, 0);
		
		
		this.copiaEnColumnaUnaColumnaReves(aux4, 3, 2);
		this.copiaEnColumnaUnaColumnaReves(aux5, 4, 0);
		this.copiaEnColumnaUnaColumna(aux6, 1, 0);
		this.copiaEnColumnaUnaColumna(aux7, 5, 0);
		
		
		
		
		this.copiaEnColumnaUnaFila(aux1, 0, 2);
		this.copiaEnColumnaUnaFila(aux2, 0, 1);
		this.copiaEnColumnaUnaFila(aux3, 0, 0);
		
		
		
		
		
		
	}
	
	public void movLR(){
		
		int aux1[][]= new int [1][3];
		int aux2[][]= new int [1][3];
		int aux3[][]= new int [1][3];
		int aux4[][]= new int [3][1];
		int aux5[][]= new int [3][1];
		int aux6[][]= new int [3][1];
		int aux7[][]=new int [3][1];
		// la cara que rota completa es la 0  
		// la columna 0 del bloque 5 va a la columna 2 bloque 3 reves
		// la col 2 del bloque 3 va a la col 0 del bloque 4 (reves)
		// la col 0 bloque 1 va a la col 0 del bl 5
		
		aux1=this.cloneF(0, 0);
		aux2=this.cloneF(0, 1);
		aux3=this.cloneF(0, 2);
		
		
		aux4=this.cloneC(5, 0);
		aux5=this.cloneC(3, 2);
		aux6=this.cloneC(4, 0);
		aux7=this.cloneC(1, 0);
		
		
		this.copiaEnColumnaUnaFilaReverse(aux1, 0, 0);
		this.copiaEnColumnaUnaFilaReverse(aux2, 0, 1);
		this.copiaEnColumnaUnaFilaReverse(aux3, 0, 2);
		
		this.copiaEnColumnaUnaColumna(aux4, 1, 0);
		this.copiaEnColumnaUnaColumna(aux7, 4, 0);
		this.copiaEnColumnaUnaColumnaReves(aux6, 3, 2);
		
		this.copiaEnColumnaUnaColumnaReves(aux5, 5, 0);
		
		
		
	}
	
public void movD(){
		
		int aux1[][]= new int [1][3];
		int aux2[][]= new int [1][3];
		int aux3[][]= new int [1][3];
		int aux4[][]= new int [1][3];
		
		int aux5[][]= new int [1][3];
		int aux6[][]= new int [1][3];
		int aux7[][]= new int [1][3];
		
		/*
		 * la cara que cambia completa es la 5
		 * 
		 * lo que se mueven son las filas 2 de los bl 0 1 2 y 3 
		 * hacia la derecha.
		 * 
		 * 
		 */
		
		aux1=this.cloneF(0, 2);
		aux2=this.cloneF(1, 2);
		aux3=this.cloneF(2, 2);
		aux4=this.cloneF(3, 2);
		
		this.copiaEnFilaUnaFila(aux1, 1, 2);
		this.copiaEnFilaUnaFila(aux2, 2, 2);
		this.copiaEnFilaUnaFila(aux3, 3, 2);
		this.copiaEnFilaUnaFila(aux4, 0, 2);
		
		
		aux5=this.cloneF(5, 0);
		aux6=this.cloneF(5, 1);
		aux7=this.cloneF(5, 2);
		
		this.copiaEnColumnaUnaFila(aux5, 5, 2);
		this.copiaEnColumnaUnaFila(aux6, 5, 1);
		this.copiaEnColumnaUnaFila(aux7, 5, 0);
		
		
	}

public void movDR(){
	
	
	int aux1[][]= new int [1][3];
	int aux2[][]= new int [1][3];
	int aux3[][]= new int [1][3];
	int aux4[][]= new int [1][3];
	
	int aux5[][]= new int [1][3];
	int aux6[][]= new int [1][3];
	int aux7[][]= new int [1][3];
	
	/*
	 * la cara que cambia completa es la 5
	 * 
	 * lo que se mueven son las filas 2 de los bl 0 1 2 y 3 
	 * hacia la derecha.
	 * 
	 * 
	 */
	
	aux1=this.cloneF(0, 2);
	aux2=this.cloneF(1, 2);
	aux3=this.cloneF(2, 2);
	aux4=this.cloneF(3, 2);
	
	aux5=this.cloneF(5, 0);
	aux6=this.cloneF(5, 1);
	aux7=this.cloneF(5, 2);
	//aux7=this.rubik.clone();
	this.copiaEnColumnaUnaFilaReverse(aux5, 5, 0);
	this.copiaEnColumnaUnaFilaReverse(aux6, 5, 1);
	this.copiaEnColumnaUnaFilaReverse(aux7, 5, 2);
	
	this.copiaEnFilaUnaFila(aux1, 3, 2);
	this.copiaEnFilaUnaFila(aux2, 0, 2);
	this.copiaEnFilaUnaFila(aux3, 1, 2);
	this.copiaEnFilaUnaFila(aux4, 2, 2);
	
	
	
	
	
	
}



public void copiaEnColumnaUnaFilaReverse(int v[][],int bl,int nc){
	
	for (int i = 0; i < this.dim; i++) {
		//System.out.println(v[i][0]);
		//System.out.println(this.rubik[bl][i][nc]);
		this.rubik[bl][i][nc]=v[0][this.dim-i-1];
	}
	
}
	
	
	public void copiaEnFilaUnaFila(int v[][],int bl,int nf){
		
		for (int i = 0; i < this.dim; i++) {
			//System.out.println(v[i][0]);
			//System.out.println(this.rubik[bl][i][nc]);
			this.rubik[bl][nf][i]=v[0][i];
		}
		
	}
	
	
	public void copiaEnColumnaUnaColumna(int v[][],int bl,int nc){
		
		
		
		for (int i = 0; i < this.dim; i++) {
			//System.out.println(v[i][0]);
			//System.out.println(this.rubik[bl][i][nc]);
			this.rubik[bl][i][nc]=v[i][0];
		}
		
		
		
	}
public void copiaEnColumnaUnaColumnaReves(int v[][],int bl,int nc){
		
		
		
		for (int i = 0; i < this.dim; i++) {
			//System.out.println(v[i][0]);
			//System.out.println(this.rubik[bl][i][nc]);
			this.rubik[bl][i][nc]=v[this.dim-i-1][0];
		}
		
		
		
	}
	
	
	
	public void copiaEnFilaUnaColumna(int v[][],int bloqa,int nf){
		
		for (int i = 0; i < this.dim; i++) {
			
			this.rubik[bloqa][nf][i]=v[i][0];
		}
		
		
		
	}
	public void copiaEnFilaUnaColumnaReverse(int v[][],int bl, int nf){
		
		for (int i = 0; i < this.dim; i++) {
			
			this.rubik[bl][nf][i]=v[this.dim-i-1][0];
		}
		
		
		
	}
	
	public void copiaEnColumnaUnaFila(int v[][],int bloqa,int nc){
		
		for (int i = 0; i < this.dim; i++) {
			
			this.rubik[bloqa][i][nc]=v[0][i];
		}
		
		
		
	}
	/*
	 * devulve una array de una fila de bloque y nFila dadas
	 */
	public int [][] cloneF(int bloque,int nFila){
		
		int ret[][]=new int [1][3];
		
		for (int i = 0; i < this.dim; i++) {
			//copiamos la primera fila del bloque 5
			ret[0][i]=this.rubik[bloque][nFila][i];
		}
		return ret;
		
	}
	public int [][] cloneC(int bloque,int nCol){
		
		int ret[][]=new int [3][1];
		//int ret[][][]=new int [1][3][1];
		for (int i = 0; i < this.dim; i++) {
			//copiamos la primera fila del bloque 5
			ret[i][0]=this.rubik[bloque][i][nCol];
			//this.rubik[bloque][nCol][0].clone();	
		
		}
		return ret;
		
	}
	
	
	
	public String toString(){
		
		String ret="";
		ret+="       ";
		for (int c4 = 0; c4 <this.dim ; c4++) {
			
			for (int c4c = 0; c4c < this.dim; c4c++) {
				ret+=" "+this.rubik[4][c4][c4c];
				
			}
			
			ret+=System.lineSeparator();
			ret+="       ";
		}
		
		
		ret+=System.lineSeparator();
		
		boolean salir=false;
		int k=0;
		for (int i = 0; i <this.nCaras-3; i++) {
			
			
			for (int j2 = 0; j2 <=3; j2++) {
				//int k=0;
			
			
			for (int j = 0; j < this.dim; j++) {
					
				if(j2==3&&j==3){
					j=0;
				salir=true;
				}
			
				ret+=" "+this.rubik[j2][k][j];
				
			}
			ret+=" ";
			
			
			
		
			}
			k++;
			ret+=System.lineSeparator();
		
		}
	
		ret+=System.lineSeparator();
		ret+="       ";
		for (int c4 = 0; c4 <this.dim ; c4++) {
			
			for (int c4c = 0; c4c < this.dim; c4c++) {
				ret+=" "+this.rubik[5][c4][c4c];
				
			}
			
			ret+=System.lineSeparator();
			ret+="       ";
		}
		
		
		//ret+=System.lineSeparator();
		
		
		
		
		
		
		
		
		
		return ret;
	}
	
	
	public boolean equals(Object o){
		
		int cont=0;
		
		if(this==o){
			return true;
		}
		if ((o == null) || (this.getClass() != o.getClass())) {
			return false;
		}
		
		EstadoRubik otroEstado=(EstadoRubik)o;
		
		boolean seguimos=true;
	
		for (int k = 0; k < this.nCaras&&seguimos; k++) {
			
			
			
			for (int i = 0; i < this.dim&&seguimos; i++) {
				
				
				for (int j= 0; j < this.dim&&seguimos; j++) {
					
					if(this.rubik[k][i][j]==otroEstado.rubik[k][i][j])
						cont++;
					else
						seguimos=false;
					
				}
				
			}
			
			}

			
		return cont==54;
		
	}
	
	public int  [][][] getEstado(){
		
		
		return this.rubik;
	}
	
	
}
