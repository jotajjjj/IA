package pruebaMovimientosRubik;

public class mainPrueba {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		RubikPruebaEstado r=new RubikPruebaEstado();
		
		
		
		/*
		 * ahora esta con BUFR //añadimos la L
		 */
		
		
		System.out.println(r);
		System.out.println("Empeiza simulacion: ");
		
		
		System.out.println("Empeiza simulacion movimiento B: ");
		r.movB();
		System.out.println(r);
		
		System.out.println("Empeiza simulacion movimiento U: ");
		r.movU();
		System.out.println(r);
		
		//int t [][][]= new int [1][3][3];
		
		//t.clone(r[0][3][3]);
	
		
		
		System.out.println("Empieza simulacion del movimiento F :  \n");
		r.movF();
		System.out.println(r);
		
		//RubikPruebaEstado n= new RubikPruebaEstado(r);
		
		
		
		
		System.out.println("Empeiza simulacion movimiento BR: ");
		r.movBR();
		System.out.println(r);
		
		
		
		
		System.out.println("Empeiza simulacion movimiento UR: ");
		r.movUR();
		System.out.println(r);
		
		
		
		System.out.println("Empeiza simulacion movimiento RR: ");
		r.movRR();
		System.out.println(r);
		
		
		
		System.out.println("Empeiza simulacion movimiento FR: ");
		r.movFR();
		System.out.println(r);
		
		
		
		
		System.out.println("Empeiza simulacion movimiento D: ");
		r.movD();
		System.out.println(r);
		
		
		System.out.println("Empieza simulacion del movimiento R :  \n");
		r.movR();
		System.out.println(r);
		
		
		System.out.println("Empieza simulacion del movimiento L :  \n");
		r.movL();
		System.out.println(r);
		
		System.out.println("Empeiza simulacion movimiento B: ");
		r.movB();
		System.out.println(r);
		
		System.out.println("Empeiza simulacion movimiento LR: ");
		r.movLR();
		System.out.println(r);
		
		System.out.println("Empeiza simulacion movimiento DR: ");
		r.movDR();
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
