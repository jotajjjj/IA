package Misioneros;

import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import aima.core.agent.Action;
import aima.core.search.framework.Problem;
import aima.core.search.framework.Search;
import aima.core.search.framework.SearchAgent;
import aima.core.search.uninformed.BreadthFirstSearch;

public class MisionerosDemo {
	static EstadoMisioneros estadoInicial = new EstadoMisioneros();

	public static void main(String[] args) {
		MisionerosBFSDemo();
	}

	private static void MisionerosBFSDemo() {
		System.out.println("\nMisionerosBFSDemo-->");
		try {
			// Crear un objeto Problem con la representación de estados y
			// operadores
			Problem problem = new Problem(estadoInicial, MisionerosFunctionFactory.getActionsFunction(),
					MisionerosFunctionFactory.getResultFunction(), new MisionerosGoalTest()); 
			// si no hay función de coste en el cosntructor usa la función de coste por defecto
			// si hay función de coste hay que añadir el objeto correspondiente:
			// new MisionerosStepCostFunction()
			// indicar el tipo de búsqueda
			Search search = new BreadthFirstSearch(); // búsqueda en anchura
			// crear un agente que realice la búsqueda sobre el problema
			SearchAgent agent = new SearchAgent(problem, search);
			// escribir la solución encontrada (operadores aplicados) e
			// información sobre los recursos utilizados
			printActions(agent.getActions());
			printInstrumentation(agent.getInstrumentation());
			// Hay que implementar estos métodos en la clase Demo (copiar de
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
