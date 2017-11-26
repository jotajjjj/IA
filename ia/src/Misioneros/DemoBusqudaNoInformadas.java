package Misioneros;

import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import aima.core.agent.Action;
import aima.core.search.framework.GraphSearch;
import aima.core.search.framework.Problem;
import aima.core.search.framework.Search;
import aima.core.search.framework.SearchAgent;
import aima.core.search.uninformed.BreadthFirstSearch;
import aima.core.search.uninformed.DepthFirstSearch;
import aima.core.search.uninformed.UniformCostSearch;

public class DemoBusqudaNoInformadas {
	static EstadoMisioneros estadoInicial = new EstadoMisioneros();

	public static void main(String[] args) {
		MisionerosPrimeroEnAchuraDemo();
		MisionerosPrimeroEnProfundidad();
		MisionerosCosteUniforme();
	}

	private static void MisionerosPrimeroEnAchuraDemo() {
		System.out.println("\nMisioneros Busquda Primero en anchura ");
		try {
			// Crear un objeto Problem con la representaci�n de estados y
			// operadores
			Problem problem = new Problem(estadoInicial, MisionerosFunctionFactory.getActionsFunction(),
					MisionerosFunctionFactory.getResultFunction(), new MisionerosGoalTest()); 
			// si no hay funci�n de coste en el cosntructor usa la funci�n de coste por defecto
			// si hay funci�n de coste hay que a�adir el objeto correspondiente:
			// new MisionerosStepCostFunction()
			// indicar el tipo de b�squeda
			Search search = new BreadthFirstSearch(); // b�squeda en anchura
			// crear un agente que realice la b�squeda sobre el problema
			SearchAgent agent = new SearchAgent(problem, search);
			// escribir la soluci�n encontrada (operadores aplicados) e
			// informaci�n sobre los recursos utilizados
			printActions(agent.getActions());
			printInstrumentation(agent.getInstrumentation());
			// Hay que implementar estos m�todos en la clase Demo (copiar de
			// aima.gui.demo.search.EightPuzzleDemo)
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private static void MisionerosPrimeroEnProfundidad() {
		System.out.println("\nMisioneros Busquda Primero en Profundidad ");
		try {
			// Crear un objeto Problem con la representaci�n de estados y
			// operadores
			Problem problem = new Problem(estadoInicial, MisionerosFunctionFactory.getActionsFunction(),
					MisionerosFunctionFactory.getResultFunction(), new MisionerosGoalTest()); 
			// si no hay funci�n de coste en el cosntructor usa la funci�n de coste por defecto
			// si hay funci�n de coste hay que a�adir el objeto correspondiente:
			// new MisionerosStepCostFunction()
			// indicar el tipo de b�squeda
			Search search = new DepthFirstSearch(new GraphSearch()); // b�squeda en profundidad
			// crear un agente que realice la b�squeda sobre el problema
			SearchAgent agent = new SearchAgent(problem, search);
			// escribir la soluci�n encontrada (operadores aplicados) e
			// informaci�n sobre los recursos utilizados
			printActions(agent.getActions());
			printInstrumentation(agent.getInstrumentation());
			// Hay que implementar estos m�todos en la clase Demo (copiar de
			// aima.gui.demo.search.EightPuzzleDemo)
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private static void MisionerosCosteUniforme() {
		System.out.println("\nMisioneros Busqueda Coste Uniforme ");
		try {
			// Crear un objeto Problem con la representaci�n de estados y
			// operadores
			Problem problem = new Problem(estadoInicial, MisionerosFunctionFactory.getActionsFunction(),
					MisionerosFunctionFactory.getResultFunction(), new MisionerosGoalTest()); 
			// si no hay funci�n de coste en el cosntructor usa la funci�n de coste por defecto
			// si hay funci�n de coste hay que a�adir el objeto correspondiente:
			// new MisionerosStepCostFunction()
			// indicar el tipo de b�squeda
			Search search = new UniformCostSearch(new GraphSearch()); // b�squeda coste uniforme
			// crear un agente que realice la b�squeda sobre el problema
			SearchAgent agent = new SearchAgent(problem, search);
			// escribir la soluci�n encontrada (operadores aplicados) e
			// informaci�n sobre los recursos utilizados
			printActions(agent.getActions());
			printInstrumentation(agent.getInstrumentation());
			// Hay que implementar estos m�todos en la clase Demo (copiar de
			// aima.gui.demo.search.EightPuzzleDemo)
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
	private static void printInstrumentation(Properties instrumentation) {
		// TODO Auto-generated method stub
		Iterator<Object> keys = instrumentation.keySet().iterator();
		while (keys.hasNext()) {
			String key = (String) keys.next();
			String property = instrumentation.getProperty(key);
			System.out.println(key + " : " + property);
		}
	}

	private static void printActions(List<Action> actions) {
		// TODO Auto-generated method stub
		for (Action item : actions){
			System.out.println(item.toString());
		}
	}

}
