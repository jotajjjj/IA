package rubik;

import aima.core.environment.eightpuzzle.EightPuzzleBoard;
import aima.core.search.framework.HeuristicFunction;

public class NumeroDePiezasIgualAlaCentralHeuristic implements HeuristicFunction {

	@Override
	public double h(Object arg0) {
		
		int ret=0;
		EstadoRubik board = (EstadoRubik) arg0;
		int[][][] val= board.getEstado();
		
		for (int k = 0; k < 6; k++) {
			
			//val=board.getEstado()[k][1][1];
			for (int i = 0; i < 3; i++) {
				
				for (int j = 0; j < 3; j++) {
					if(val[k][i][j]==k)
						ret++;
					
				}
				
			}
			
		}
		
		
		int r=54-ret-6;
		ret=r;
		return ret;
	}
	
	
	

}
