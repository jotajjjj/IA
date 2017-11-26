package Misioneros;

import aima.core.search.framework.HeuristicFunction;

public class Heuristica2 implements HeuristicFunction {

	@Override
	public double h(Object state) {
		// La heuristica sería ver el número de misioneros y canibales que estan en la orilla derecha
		int num = 0;
		int barca = 1 ;
		EstadoMisioneros board = (EstadoMisioneros) state;
		if(board.isBarcaIzq()){
			barca = 0;
		}
		// num == es lo que devuelbe la heuristica
		//num = 2*((3-board.getnMisioneros()) + (3 - board.getnCanibales())-barca);
		num = ((3-board.getnMisioneros()) + (3 - board.getnCanibales())-barca);
		return num;
	}

}
