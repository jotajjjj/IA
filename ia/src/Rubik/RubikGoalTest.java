package Rubik;

public class RubikGoalTest {
EstadoRubik goal = new EstadoRubik();
	
	
	
	
	public boolean isGoalState(Object state) {
	
	
	EstadoRubik estado = (EstadoRubik) state;
	
	return estado.equals(goal);
	}
}
