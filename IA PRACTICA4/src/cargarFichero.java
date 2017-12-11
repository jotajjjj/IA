import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class cargarFichero {
	private int turnos;
	private String [] profes;
	private int [][] restric;
	private int [] recom;
	
	public void muestraContenido(String archivo) throws FileNotFoundException, IOException {
	      int numProf = 0;
		  String turnosStr;
		  String cadena;
	      String[] aux;
	      String auxRest [];
		  FileReader f = new FileReader(archivo);
	      BufferedReader b = new BufferedReader(f);
	      turnosStr = b.readLine(); // lee los turnos de los profesores
	      this.turnos = Integer.parseInt(turnosStr);
	      cadena = b.readLine();
	       this.profes = cadena.split(",");
	       int numeroProf = this.profes.length;
	       for (int i = 0; i < numeroProf;i++){
	    	   int num=0;
	    	   turnosStr= b.readLine();
	    	   
	    	   aux =   turnosStr.split(":");
	    	 if (aux.length > 1){
	    	   auxRest = aux[1].split(",");
	    	 }
	    	  /// this.restric[i][num]= Integer.parseInt(cadena.split(","));
	    	   
	    	   num++;
	       }
	       
	       while((cadena = b.readLine())!=null) {
	    	 

	    	  System.out.println(cadena);
	      }
	      b.close();
	}
}
