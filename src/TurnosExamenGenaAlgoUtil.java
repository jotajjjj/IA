
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

import aima.core.search.framework.problem.GoalTest;
import aima.core.search.local.FitnessFunction;
import aima.core.search.local.Individual;
import aima.core.util.datastructure.XYLocation;

/**
 * A class whose purpose is to provide static utility methods for solving the
 * n-queens problem with genetic algorithms. This includes fitness function,
 * goal test, random creation of individuals and convenience methods for
 * translating between between an NQueensBoard representation and the Integer list
 * representation used by the GeneticAlgorithm.
 * 
 * @author Ciaran O'Reilly
 * @author Ruediger Lunde
 * 
 */
public class TurnosExamenGenaAlgoUtil {

	public static FitnessFunction<Integer> getFitnessFunction() {
		return new TurnosExamenFitnessFunction();
	}
	
	public static GoalTest getGoalTest() {
		return new TurnosExamenGenaAlgoGoalTest();
	}
	

	public static Individual<Integer> generateRandomIndividual(int boardSize) {
		List<Integer> individualRepresentation = new ArrayList<Integer>();
		for (int i = 0; i < boardSize; i++) {
			individualRepresentation.add(new Random().nextInt(boardSize));
		}
		Individual<Integer> individual = new Individual<Integer>(individualRepresentation);
		return individual;
	}

	public static Collection<Integer> getFiniteAlphabetForBoardOfSize(int size) {
		Collection<Integer> fab = new ArrayList<Integer>();

		for (int i = 0; i < size; i++) {
			fab.add(i);
		}

		return fab;
	}
	
	public static class TurnosExamenFitnessFunction implements FitnessFunction<Integer> {

		public double apply(Individual<Integer> individual) { // aquí es donde se difine la función de fitness
			

			TurnosExamenBoard board = getBoardForIndividual(individual);
			int boardSize = board.getSize();
			double fitness = boardSize; // Número de turnos
			
			fitness = fitness - board.getNumeroDeRestriccionesNoCumplidas();// quita el número de restricciones que no se cumplen
			
			if (fitness == 16){
				fitness = fitness + board.getNumeroDePreferenciasCumplidas();
				}
			
		return fitness;
	}
}

	public static class TurnosExamenGenaAlgoGoalTest implements GoalTest {
		private final TurnosProfesoresGoalTest goalTest = new TurnosProfesoresGoalTest();

		@SuppressWarnings("unchecked")
		public boolean isGoalState(Object state) {
			return goalTest.isGoalState(getBoardForIndividual((Individual<Integer>) state));
		}
	}

	public static TurnosExamenBoard getBoardForIndividual(Individual<Integer> individual) {
		int boardSize = individual.length();
		TurnosExamenBoard board = new TurnosProfesoresGoalTest(boardSize);
		for (int i = 0; i < boardSize; i++) {
			int pos = individual.getRepresentation().get(i);
			board.addQueenAt(new XYLocation(i, pos));
		}

		return board;
	}
}