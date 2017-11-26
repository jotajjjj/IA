package Misioneros;

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
}
