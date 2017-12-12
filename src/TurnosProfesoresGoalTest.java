import aima.core.search.framework.problem.GoalTest;

public class TurnosProfesoresGoalTest implements GoalTest {
	
	public boolean isGoalState(Object state) {
		TurnosExamenBoard board = (TurnosExamenBoard) state;
		return board.getNumberOfProfesoresOnBoard() == board.getSize()
				&& board.getNumeroDeRestriccionesNoCumplidas() == 0;
	}
}
