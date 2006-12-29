package tf;

import java.util.List;

public class ProcVal implements IVal {
	
	private List<String> params;
	
	private IASTStatement statement;
	
	private IEnv env;
	
	public ProcVal(List<String> params,IASTStatement statement,IEnv env){
	  this.params = params;
	  this.statement = statement ;
	  this.env = env;
	}
	
	public List<String> getParams(){
		return params;
	}
	
	public IASTStatement getStatement(){
		return statement;
	}
	
	public IEnv getEnv(){
		return env;
	}
	

}
