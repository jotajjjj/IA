package pruebaMovimientosRubik;

public class mainPrueba {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		RubikPruebaEstado r=new RubikPruebaEstado();
		
		
		
		/*
		 * ahora esta con BUFR
		 */
		
		
		System.out.println(r);
		System.out.println("Empeiza simulacion: ");
		
		
		System.out.println("Empeiza simulacion movimiento B: ");
		r.movB();
		System.out.println(r);
		
		System.out.println("Empeiza simulacion movimiento U: ");
		r.movU();
		System.out.println(r);
		
		
		/*
		 * 
		 * cuando se  hace el movieminto F se producen fallos en la cara 1 y 4
		 * 
		 */
		System.out.println("Movimiento F :  \n");
		r.movF();
		System.out.println(r);
		
		
		System.out.println("Movimiento R :  \n");
		r.movR();
		System.out.println(r);
		
		
		
		
		/*
		//funcionan estos dos movimeitnos
		
		
		BULFRU
		
		
		System.out.println("Movimiento F :  \n");
		r.movF();
		System.out.println(r);
		
		
		System.out.println("Movimiento R :  \n");
		r.movR();
		System.out.println(r);
	*/
	}

}
