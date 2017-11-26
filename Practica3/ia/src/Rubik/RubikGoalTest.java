package Rubik;

import aima.core.search.framework.GoalTest;

public class RubikGoalTest implements GoalTest{

	EstadoRubik goal = new EstadoRubik();
	
	/*
	 * Es muy problable que no funcione con el equals 
	 * 
	 * (non-Javadoc)
	 * @see aima.core.search.framework.GoalTest#isGoalState(java.lang.Object)
	 */
	
	
	
	
	@Override
	public boolean isGoalState(Object esate) {
		// TODO Auto-generated method stub
		
		
		return goal.equals(esate);
	}

}
