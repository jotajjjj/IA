package pruebaMovimientosRubik;

public class RubikPruebaEstado {

	
	private final int dim=3;
	private final int nCaras=6;
	// representamos la cara, la fila y la columna
	private int [][][] rubik;
	
	public RubikPruebaEstado(){
		
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
	
	
	// cambiasmos la fila columna 3 de 0 por la fila 1 de 5
	public void movF(){
		
		int aux[][] = new int[1][3];
		int aux2[][] = new int[3][1];
		int aux3[][] = new int[1][3];
		int aux4[][] = new int[3][1];
		
		//copiamos en un aux la primera fila de zona 5
		aux=cloneF(5,0);
		aux2=cloneC(0,2);
		aux3=cloneF(4,2); //bloque 4 fila 2
		aux4=cloneC(2,0);//bloque 2 col 0
		
		
		this.copiaEnColumnaUnaFila(aux, 0, 2);//copiamos en bl0 col2
		this.copiaEnFilaUnaColumna(aux2, 4, 2);
		
		this.copiaEnColumnaUnaFila(aux3, 2, 0);//copiamos en bl0 la col0
		this.copiaEnFilaUnaColumna(aux4, 5, 0);
		
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
		
		aux5=cloneC(2,0);
		
		
		aux6=cloneC(2,1);
		aux7=cloneC(2,2);
		
		
		this.copiaEnColumnaUnaColumna(aux1, 1, 2);
		this.copiaEnColumnaUnaColumna(aux2, 4, 2);
		this.copiaEnColumnaUnaColumnaReves(aux3, 3, 0);
		this.copiaEnColumnaUnaColumna(aux4, 5, 2);
		
		this.copiaEnFilaUnaColumna(aux5, 2, 0);
		
		this.copiaEnFilaUnaColumna(aux6, 2, 1);
		this.copiaEnFilaUnaColumna(aux7, 2, 2);
		
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
		
		for (int i = 0; i < this.dim; i++) {
			//copiamos la primera fila del bloque 5
			ret[i][0]=this.rubik[bloque][i][nCol];
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
	
	
	
	
	
}
