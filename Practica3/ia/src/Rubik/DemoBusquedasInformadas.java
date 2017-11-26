package Rubik;

import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import aima.core.agent.Action;
import aima.core.search.framework.GraphSearch;
import aima.core.search.framework.Problem;
import aima.core.search.framework.SearchAgent;
import aima.core.search.informed.AStarSearch;

public class DemoBusquedasInformadas {
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
		
		RubikAStartH1();
		}

	private static void RubikAStartH1() {
		System.out.println("\n A* con H1");
		try {
			
			Problem problem= new Problem(estadoInicial, RubikFunctionFactory.getActionsFunction(),
					RubikFunctionFactory.getResultFunction(),new RubikGoalTest());
			
			AStarSearch search= new AStarSearch(new GraphSearch(),new Heuristica1());
			
			SearchAgent agent= new SearchAgent(problem,search);
			
			printActions(agent.getActions());
			muestraMov(agent.getActions());
			printInstrumentation(agent.getInstrumentation());
			
			
		} catch (Exception e) {
			// TODO: handle exception
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
