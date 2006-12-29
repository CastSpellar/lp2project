package tf;

import java.util.List;

public class FunVal implements IVal {
	
	private List<String> vars;
	
	private IASTExpression expression;
	
	private IEnv env;
	
	public FunVal(List<String> vars,IASTExpression expression,IEnv env){
	  this.vars = vars;
	  this.expression = expression;
	  this.env = env;
	}
	
	public List<String> getVars(){
		return vars;
	}
	
	public IASTExpression getExpression(){
		return expression;
	}
	
	public IEnv getEnv(){
		return env;
	}
	
}
