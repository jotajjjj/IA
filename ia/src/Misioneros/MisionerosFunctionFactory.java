package Misioneros;

//import java.util.LinkedHashSet;
//import java.util.Set;

//import aima.core.agent.Action;
//import aima.core.probability.mdp.ActionsFunction;
//import aima.core.search.framework.ResultFunction;



import java.util.LinkedHashSet;
import java.util.Set;

import aima.core.agent.Action;
//import aima.core.search.framework.problem.ActionsFunction;
//import aima.core.search.framework.problem.ResultFunction;
import aima.core.search.framework.ActionsFunction;
import aima.core.search.framework.ResultFunction;


public class MisionerosFunctionFactory {

	private static ActionsFunction _actionsFunction = null;
	private static ResultFunction _resultFunction = null;
	
	
		public static ActionsFunction getActionsFunction() {
		
		
			if (null == _actionsFunction) {
				_actionsFunction = new MisionerosActionsFunction();
			
			}
			
				return _actionsFunction;
		
		
		}
		public static ResultFunction getResultFunction() {
		
			if (null == _resultFunction) {
				_resultFunction = new MisionerosResultFunction();
			
			}
		
		
		
		return _resultFunction;
	
		
		
		}
	
	
	
		@SuppressWarnings("rawtypes")
		private static class MisionerosActionsFunction implements ActionsFunction{
			
			public Set<Action> actions(Object state){
				EstadoMisioneros estado = (EstadoMisioneros) state;
				// lista de acciones posibles
			Set<Action> actions = new LinkedHashSet<Action>();
			// si se cumplen las precondiciones y no se va a un estado de peligro entonces
			// se añade la acción a la lista de acciones posibles
			
			if (estado.movimientoValido(EstadoMisioneros.M))
				actions.add(EstadoMisioneros.M);
			if(estado.movimientoValido(EstadoMisioneros.C))
				actions.add(EstadoMisioneros.C);
			if(estado.movimientoValido(EstadoMisioneros.CC))
				actions.add(EstadoMisioneros.CC);
			if(estado.movimientoValido(EstadoMisioneros.MC))
				actions.add(EstadoMisioneros.MC);
			if(estado.movimientoValido(EstadoMisioneros.MM))
				actions.add(EstadoMisioneros.MM);
			
			
			//System.out.println(estado);
			
			return actions;
		}

		}
	
	
	
	private static class MisionerosResultFunction implements ResultFunction{
		
		
		
		public Object result(Object s, Action a){
			
			EstadoMisioneros estado = (EstadoMisioneros) s;
			
			if (EstadoMisioneros.M.equals(a)) {
				EstadoMisioneros nuevoEstado = new EstadoMisioneros(estado);
				nuevoEstado.movM();
				return nuevoEstado;
			}
			else if(EstadoMisioneros.C.equals(a)){
				EstadoMisioneros nuevoEstado = new EstadoMisioneros(estado);
				nuevoEstado.movC();
				return nuevoEstado;
			
			}
			else if(EstadoMisioneros.CC.equals(a)){
				EstadoMisioneros nuevoEstado = new EstadoMisioneros(estado);
				nuevoEstado.movCC();
				return nuevoEstado;
			
			}
			else if(EstadoMisioneros.MM.equals(a)){
				EstadoMisioneros nuevoEstado = new EstadoMisioneros(estado);
				nuevoEstado.movMM();
				return nuevoEstado;
			
			}
			else if(EstadoMisioneros.MC.equals(a)){
				EstadoMisioneros nuevoEstado = new EstadoMisioneros(estado);
				nuevoEstado.movMC();
				return nuevoEstado;
			
			}
			
			//…
				// The Action is not understood or is a NoOp
				// the result will be the current state.
				return s;

	
			}
		
	
	}
	
	
		
	
	
	
	
	
}
