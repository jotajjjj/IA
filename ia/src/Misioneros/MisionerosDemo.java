package Misioneros;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import aima.core.agent.Action;
import aima.core.search.framework.ActionsFunction;
import aima.core.search.framework.GraphSearch;
import aima.core.search.framework.Problem;
import aima.core.search.framework.Search;
import aima.core.search.framework.SearchAgent;
import aima.core.search.informed.AStarSearch;
//import aima.core.search.framework.SearchForActions;
import aima.core.search.uninformed.BreadthFirstSearch;
import aima.core.search.uninformed.DepthLimitedSearch;

public class MisionerosDemo {

	
	static EstadoMisioneros estadoInicial = new EstadoMisioneros();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			//MisionerosBFSDemo();
			MisionerosAStartDemo();
	}

	private static void MisionerosBFSDemo(){
	System.out.println("\nMisionerosBFSDemo-->");
	try{
		// Crear un objeto Problem con la representación de estados y operadores
		Problem problem = new Problem(estadoInicial, (ActionsFunction) MisionerosFunctionFactory.getActionsFunction(), MisionerosFunctionFactory.getResultFunction(),
		new MisionerosGoalTest()); // si no hay función de coste en el constructor se usa el coste por defecto
		// si hay función de coste hay que añadir el objeto correspondiente: new MisionerosStepCostFunction()
		// indicar el tipo de búsqueda
		Search search = new BreadthFirstSearch(); // búsqueda en anchura
		
		//Search search = new DepthLimitedSearch(9);
		
		
		// crear un agente que realice la búsqueda sobre el problema
		
		
		SearchAgent agent = new SearchAgent(problem, search);
		// escribir la solución encontrada (operadores aplicados) e información sobre los recursos utilizados
	printActions(agent.getActions());
	muestraMov(agent.getActions());
	
	
	printInstrumentation(agent.getInstrumentation());
	// Hay que implementar estos métodos en la clase Demo (copiar de aima.gui.demo.search.EightPuzzleDemo)
	
	
	}
			
	catch (Exception e){
	e.printStackTrace();
	
	}
	
	}
	
	public static void muestraMov(List<Action> l){
		EstadoMisioneros e= new EstadoMisioneros();
		for (int i = 0; i < l.size(); i++) {
			
			
			if(l.get(i).toString().equals("Action[name==CC]"))
				e.movCC();
			if(l.get(i).toString().equals("Action[name==C]"))
				e.movC();
			if(l.get(i).toString().equals("Action[name==MM]"))
				e.movMM();
			if(l.get(i).toString().equals("Action[name==MC]"))
				e.movMC();
			if(l.get(i).toString().equals("Action[name==M]"))
				e.movM();
			
			
			//System.out.println(l.get(i).toString());
			System.out.println(e);
		}
	}
	
	
	
	private static void MisionerosAStartDemo(){
		
		System.out.println("Misioneros as star");
		try {
			
			Problem problem= new Problem(estadoInicial, MisionerosFunctionFactory.getActionsFunction(),
					MisionerosFunctionFactory.getResultFunction(),new MisionerosGoalTest());
			
			AStarSearch search= new AStarSearch(new GraphSearch(),new Heuristica());
			
			SearchAgent agent= new SearchAgent(problem,search);
			
			printActions(agent.getActions());
			printInstrumentation(agent.getInstrumentation());
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
	}
	
	
	private static void printInstrumentation(Properties properties) {
		Iterator<Object> keys = properties.keySet().iterator();
		while (keys.hasNext()) {
			String key = (String) keys.next();
			String property = properties.getProperty(key);
			System.out.println(key + " : " + property);
		}

	}

	private static void printActions(List<Action> actions) {
		for (int i = 0; i < actions.size(); i++) {
			String action = actions.get(i).toString();
			System.out.println(action);
		}
	}
	
	
}
