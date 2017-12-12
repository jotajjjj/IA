import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class cargarFichero {
	private final int MAXTURNOS = 16;
	private int turnos;
	private String[] profes;
	private int [][] restric;
	private int [][] prefer;

	public void muestraContenido(String archivo) throws FileNotFoundException, IOException {
		int numero;
		String turnosStr;
		String cadena;
		String[] aux;
		String[] auxRest;
		String[] auxPref;
		
		FileReader f = new FileReader(archivo);
		BufferedReader b = new BufferedReader(f);

		turnosStr = b.readLine(); // lee el número de profesores

		 this.turnos = Integer.parseInt(turnosStr); // lo introduce en el atributo 

		cadena = b.readLine();
		this.profes = cadena.split(",");// mete el nombre de los profesores en el atributo profes

		// --------------------------RESTRICCIONES-------------------------------------
		int numeroProf = this.profes.length;
		this.restric = new int [numeroProf][this.MAXTURNOS];
		for (int i = 0; i < numeroProf; i++) {
			cadena = b.readLine(); // lEO TODA LA LINEA de profesor con sus restricciones

			aux = cadena.split(": "); // LA SEPARO EN DOS STRING

			if (aux.length > 1) { // si tine restricciones dicho profesor
				
				auxRest = aux[1].split(",");// ME QUEDO SOLO CON LA PARTE DE LOS NÚMEROS y la meto en auxRest
				
				for (int j = 0; j < auxRest.length; j++) {
					numero = Integer.parseInt(auxRest[j]);
					this.restric[i][j] = numero;
				}
			} 
		}
		// si en la Matriz de restricciones aparece en las casillas el valor 0,es que no tiene restricciones
		
		//--------------------------PREFERENCIAS---------------------------------------------------
		this.prefer = new int [numeroProf][this.MAXTURNOS];
		for (int i = 0; i < numeroProf; i++) {
			cadena = b.readLine(); // lEO TODA LA LINEA de profesor con sus preferencias

			aux = cadena.split(": "); // LA SEPARO EN DOS STRING

			if (aux.length > 1) { // si tine preferencias dicho profesor
				
				auxPref = aux[1].split(",");// ME QUEDO SOLO CON LA PARTE DE LOS NÚMEROS y la meto en auxPref
				
				for (int j = 0; j < auxPref.length; j++) {
					numero = Integer.parseInt(auxPref[j]);
					this.prefer[i][j] = numero;
				}
			} 
		}
		// si en la Matriz de preferencias aparece en las casillas el valor 0,es que no tiene restricciones
		b.close();
	}
}
