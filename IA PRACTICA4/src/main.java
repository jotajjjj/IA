import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;


public class main {

	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
	cargarFichero carga = 	new cargarFichero();
	System.out.println("Escriba el fichero que quiere cargar");
	//String archivo = sc.nextLine();
	carga.muestraContenido(/*archivo*/"configuracionConvocatoria1.txt");  
	}

}
