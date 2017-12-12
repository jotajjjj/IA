
public class TurnosExamenBoard {
	int[] squares; // Horario

	final int size = 16;// tama�o-->

	public TurnosExamenBoard() {
		this.squares = new int[this.size];
		for (int i = 0; i < size; i++) {
			this.squares[i] = 0; // Metemos 0s en todas las posici�n de la
									// soluci�n
		}
	}

	public int getSize() {
		return this.size;
	}

	private boolean ProfesoresExisteAt(int x) { // No se si est� bien
		return (squares[x] != 0);
	}

	public int getNumberOfProfesoresOnBoard() {
		int count = 0;
		for (int i = 0; i < size; i++) {
			if (squares[i] != 0)
				count++;
		}
		return count;
	}

	public String getBoardPic() {
		StringBuffer buf = new StringBuffer();
		for (int col = 0; col < size; col++) { // columns
			if (ProfesoresExisteAt(col))
				buf.append('Q');
			else
				buf.append('-');
		}
		buf.append("\n");
		return buf.toString();
	}

	public void print() {
		System.out.println(getBoardPic());
	}

	@Override
	public String toString() {
		StringBuffer buf = new StringBuffer();
		for (int col = 0; col < size; col++) { // columns
			if (ProfesoresExisteAt(col))
				buf.append('Q');
			else
				buf.append('-');
		}
		buf.append("\n");
		return buf.toString();
	}

	public int getNumeroDeRestriccionesNoCumplidas() {
		return 0;// Faltar�a hacer el m�todo
	}

	public int getNumeroDePreferenciasCumplidas() {
		return 0;// Faltar�a haceer el m�todo
	}
}
