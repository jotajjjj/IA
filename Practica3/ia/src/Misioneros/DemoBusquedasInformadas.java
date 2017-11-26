package Misioneros;

import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import aima.core.agent.Action;
import aima.core.search.framework.GraphSearch;
import aima.core.search.framework.Problem;
import aima.core.search.framework.SearchAgent;
import aima.core.search.informed.AStarSearch;
//import aima.core.search.framework.SearchForActions;


public class DemoBusquedasInformadas {
	static EstadoMisioneros estadoInicial = new EstadoMisioneros();

	public static void main(String[] args) {
		MisionerosAStartH1();
		MisionerosAStartH2();
		}

private static void MisionerosAStartH1(){
		
		System.out.println("\nMisioneros A* con H1");
		try {
			
			Problem problem= new Problem(estadoInicial, MisionerosFunctionFactory.getActionsFunction(),
					MisionerosFunctionFactory.getResultFunction(),new MisionerosGoalTest());
			
			AStarSearch search= new AStarSearch(new GraphSearch(),new Heuristica1());
			
			SearchAgent agent= new SearchAgent(problem,search);
			
			printActions(agent.getActions());
			printInstrumentation(agent.getInstrumentation());
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
private static void MisionerosAStartH2(){
	
	System.out.println("\nMisioneros A* con H2");
	try {
		
		Problem problem= new Problem(estadoInicial, MisionerosFunctionFactory.getActionsFunction(),
				MisionerosFunctionFactory.getResultFunction(),new MisionerosGoalTest());
		
		AStarSearch search= new AStarSearch(new GraphSearch(),new Heuristica2());
		
		SearchAgent agent= new SearchAgent(problem,search);
		
		printActions(agent.getActions());
		printInstrumentation(agent.getInstrumentation());
		
		
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
