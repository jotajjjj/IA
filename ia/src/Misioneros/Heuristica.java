package Misioneros;

import aima.core.search.framework.HeuristicFunction;

public class Heuristica implements HeuristicFunction{

	@Override
	public double h(Object state) {
		// TODO Auto-generated method stub
		int num=0;
		
		EstadoMisioneros board=(EstadoMisioneros) state;
		num = board.getnCanibales()+board.getnMisioneros();
		
		
		return num;
	}

	
	
	
}
