package tf;

import java.util.List;

public class FunVal implements IVal {
	
	private List<String> params;
	
	private IASTExpression expression;
	
	private IEnv env;
	
	public FunVal(List<String> params,IASTExpression expression,IEnv env){
	  this.params = params;
	  this.expression = expression;
	  this.env = env;
	}
	
	public List<String> getParams(){
		return params;
	}
	
	public IASTExpression getExpression(){
		return expression;
	}
	
	public IEnv getEnv(){
		return env;
	}
	
}
