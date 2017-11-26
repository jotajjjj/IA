package Misioneros;

import aima.core.search.framework.HeuristicFunction;

public class Heuristica1 implements HeuristicFunction {

	@Override
	public double h(Object state) {
		// La heuristica sería ver el número de misioneros y canibales que estan en la orilla derecha
		int num = 0;
		// num == es lo que devuelbe la heuristica
		EstadoMisioneros board = (EstadoMisioneros) state;
		num = 3 - board.getnMisioneros();// Se le resta en numero de misioeros totales al número de misioneros en la orilla izquierda
		return num;
	}

}
