package rubik;

//package Misioneros;

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


public class RubikFunctionFactory {

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
				EstadoRubik estado = (EstadoRubik) state;
				// lista de acciones posibles
			Set<Action> actions = new LinkedHashSet<Action>();
			// si se cumplen las precondiciones y no se va a un estado de peligro entonces
			// se añade la acción a la lista de acciones posibles
			
			//if (estado.movimientoValido(EstadoRubik.F))
				actions.add(EstadoRubik.F);
			
				actions.add(EstadoRubik.R);
		
				actions.add(EstadoRubik.U);
		
				actions.add(EstadoRubik.B);
			
				actions.add(EstadoRubik.L);
				
				actions.add(EstadoRubik.D);
				
				
				
				actions.add(EstadoRubik.FR);
				
				actions.add(EstadoRubik.RR);
		
				actions.add(EstadoRubik.UR);
		
				actions.add(EstadoRubik.BR);
			
				actions.add(EstadoRubik.LR);
				
				actions.add(EstadoRubik.DR);
				
				
				
				
				
				
			//System.out.println(estado);
			
			return actions;
		}

		}
	
	
	
	private static class MisionerosResultFunction implements ResultFunction{
		
		
		
		public Object result(Object s, Action a){
			
			EstadoRubik estado = (EstadoRubik) s;
			
			if (EstadoRubik.F.equals(a)) {
				EstadoRubik nuevoEstado = new EstadoRubik(estado);
				nuevoEstado.movF();
				return nuevoEstado;
			}
			else if(EstadoRubik.R.equals(a)){
				EstadoRubik nuevoEstado = new EstadoRubik(estado);
				nuevoEstado.movR();
				return nuevoEstado;
			
			}
			else if(EstadoRubik.U.equals(a)){
				EstadoRubik nuevoEstado = new EstadoRubik(estado);
				nuevoEstado.movU();
				return nuevoEstado;
			
			}
			else if(EstadoRubik.B.equals(a)){
				EstadoRubik nuevoEstado = new EstadoRubik(estado);
				nuevoEstado.movB();
				return nuevoEstado;
			
			}
			else if(EstadoRubik.L.equals(a)){
				EstadoRubik nuevoEstado = new EstadoRubik(estado);
				nuevoEstado.movL();
				return nuevoEstado;
			
			}
			else if(EstadoRubik.D.equals(a)){
				EstadoRubik nuevoEstado = new EstadoRubik(estado);
				nuevoEstado.movD();
				return nuevoEstado;
			
			}
			else if(EstadoRubik.FR.equals(a)){
				EstadoRubik nuevoEstado = new EstadoRubik(estado);
				nuevoEstado.movFR();
				return nuevoEstado;
			
			}
			else if(EstadoRubik.RR.equals(a)){
				EstadoRubik nuevoEstado = new EstadoRubik(estado);
				nuevoEstado.movRR();
				return nuevoEstado;
			
			}
			else if(EstadoRubik.UR.equals(a)){
				EstadoRubik nuevoEstado = new EstadoRubik(estado);
				nuevoEstado.movUR();
				return nuevoEstado;
			
			}
			else if(EstadoRubik.BR.equals(a)){
				EstadoRubik nuevoEstado = new EstadoRubik(estado);
				nuevoEstado.movBR();
				return nuevoEstado;
			
			}
			else if(EstadoRubik.LR.equals(a)){
				EstadoRubik nuevoEstado = new EstadoRubik(estado);
				nuevoEstado.movLR();
				return nuevoEstado;
			
			}
			else if(EstadoRubik.DR.equals(a)){
				EstadoRubik nuevoEstado = new EstadoRubik(estado);
				nuevoEstado.movDR();
				return nuevoEstado;
			
			}


			
			
			
			
			
			//…
				// The Action is not understood or is a NoOp
				// the result will be the current state.
				return s;

	
			}
		
	
	}
	
	
		
	
	
	
	
	
}
