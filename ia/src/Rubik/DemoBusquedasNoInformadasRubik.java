package Rubik;

import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import aima.core.agent.Action;
import aima.core.search.framework.ActionsFunction;
import aima.core.search.framework.GraphSearch;
import aima.core.search.framework.Problem;
import aima.core.search.framework.Search;
import aima.core.search.framework.SearchAgent;
//import aima.core.search.framework.SearchForActions;
//import aima.core.search.framework.SearchForActions;
import aima.core.search.uninformed.BreadthFirstSearch;
import aima.core.search.uninformed.DepthFirstSearch;
import aima.core.search.uninformed.UniformCostSearch;



/*
 * 
 * ¿DIFERECNIA EN SEARCH Y SEARCHAGENT
 * 
 */


public class DemoBusquedasNoInformadasRubik {

	
	static EstadoRubik estadoInicial = new EstadoRubik();
	
	static EstadoRubik estadoPrueba;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			//MisionerosBFSDemo();
			
		estadoInicial.movB();
		//estadoInicial.movU();
		//estadoInicial.movL();
		//estadoInicial.movF();
		//estadoInicial.movR();
		//estadoInicial.movU(); 
		
		estadoPrueba = new EstadoRubik(estadoInicial);
		
		
		RubikPrimeroEnAchuraDemo();
		RubikPrimeroEnProfundidad();
		RubikCosteUniforme();
			
		
		
	}

	private static void RubikPrimeroEnAchuraDemo(){
	System.out.println("\nBusqueda primero en anchura-->");
	try{
		// Crear un objeto Problem con la representación de estados y operadores
		Problem problem = new Problem(estadoInicial, (ActionsFunction) RubikFunctionFactory.getActionsFunction(), RubikFunctionFactory.getResultFunction(),
		
		new RubikGoalTest()); // si no hay función de coste en el constructor se usa el coste por defecto
		// si hay función de coste hay que añadir el objeto correspondiente
		Search search = new BreadthFirstSearch(); // búsqueda en anchura
		
		// crear un agente que realice la búsqueda sobre el problema
		SearchAgent agent = new SearchAgent(problem, search);
		// escribir la solución encontrada (operadores aplicados) e información sobre los recursos utilizados
		printActions(agent.getActions());
	
		muestraMov(agent.getActions());
	
		printInstrumentation(agent.getInstrumentation());
		
		}	
		catch (Exception e){
			e.printStackTrace();
	
	}
	
	}
	private static void RubikPrimeroEnProfundidad() {
		System.out.println("\nBusquda Primero en Profundidad ");
		try {
			// Crear un objeto Problem con la representaci�n de estados y
			// operadores
			Problem problem = new Problem(estadoInicial, (ActionsFunction) RubikFunctionFactory.getActionsFunction(),
					RubikFunctionFactory.getResultFunction(),new RubikGoalTest()); 
			// si no hay funci�n de coste en el cosntructor usa la funci�n de coste por defecto
			// si hay funci�n de coste hay que a�adir el objeto correspondiente
			// indicar el tipo de b�squeda
			Search search = new DepthFirstSearch(new GraphSearch()); // b�squeda en profundidad
			// crear un agente que realice la b�squeda sobre el problema
			SearchAgent agent = new SearchAgent(problem, search);
			// escribir la soluci�n encontrada (operadores aplicados) e
			// informaci�n sobre los recursos utilizados
			printActions(agent.getActions());
			muestraMov(agent.getActions());
			printInstrumentation(agent.getInstrumentation());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private static void RubikCosteUniforme() {
		System.out.println("\nBusqueda Coste Uniforme ");
		try {
			// Crear un objeto Problem con la representaci�n de estados y
			// operadores
			Problem problem = new Problem(estadoInicial, (ActionsFunction) RubikFunctionFactory.getActionsFunction(),
					RubikFunctionFactory.getResultFunction(),new RubikGoalTest());
			// si no hay funci�n de coste en el cosntructor usa la funci�n de coste por defecto
			// si hay funci�n de coste hay que a�adir el objeto correspondiente)
			// indicar el tipo de b�squeda
			Search search = new UniformCostSearch(new GraphSearch()); // b�squeda coste uniforme
			// crear un agente que realice la b�squeda sobre el problema
			SearchAgent agent = new SearchAgent(problem, search);
			// escribir la soluci�n encontrada (operadores aplicados) e
			// informaci�n sobre los recursos utilizados
			printActions(agent.getActions());
			muestraMov(agent.getActions());
			printInstrumentation(agent.getInstrumentation());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	

		public static void muestraMov(List<Action> l){
		EstadoRubik e= estadoPrueba;
		for (int i = 0; i < l.size(); i++) {
			
			
			if(l.get(i).toString().equals("Action[name==F]")){
				e.movF();
				System.out.println("MovF :---------------");
			}
			if(l.get(i).toString().equals("Action[name==R]")){
				e.movR();
				System.out.println("MovR :---------------");
			}
			if(l.get(i).toString().equals("Action[name==U]")){
				e.movU();
				System.out.println("MovU :--------------");
			}
			if(l.get(i).toString().equals("Action[name==B]")){
				
				e.movB();
				System.out.println("MovB :--------------");
			}
			if(l.get(i).toString().equals("Action[name==L]")){
				e.movL();
				System.out.println("MovL :--------------");
			}
			if(l.get(i).toString().equals("Action[name==FR]")){
				e.movFR();
				System.out.println("MovFR :---------------");
			}
			if(l.get(i).toString().equals("Action[name==RR]")){
				e.movRR();
				System.out.println("MovRR :---------------");
			}
			if(l.get(i).toString().equals("Action[name==UR]")){
				e.movUR();
				System.out.println("MovUR :--------------");
			}
			if(l.get(i).toString().equals("Action[name==BR]")){
				
				e.movBR();
				System.out.println("MovBR :--------------");
			}
			if(l.get(i).toString().equals("Action[name==LR]")){
				e.movLR();
				System.out.println("MovLR :--------------");
			}
			
			
			//System.out.println(l.get(i).toString());
			System.out.println(e);
		}
		//System.out.println(e);
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
