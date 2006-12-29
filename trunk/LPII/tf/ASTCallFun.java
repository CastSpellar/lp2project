package tf;

import java.util.Iterator;
import java.util.List;
import java.util.LinkedList;

public class ASTCallFun implements IASTExpression {

	private IASTExpression id;
	
	private List<IASTExpression> params;
	
	public ASTCallFun(IASTExpression id){
		this.id = id;
		params = new LinkedList<IASTExpression>();
	}
	
	public void addArg(IASTExpression arg){
		params.add(arg);
	}
	
	public IVal evaluate(IEnv env) {
		// TODO Auto-generated method stub
		FunVal closure = (FunVal)id.evaluate(env);
		Iterator<String> varList = closure.getVars().iterator();
		Iterator<IASTExpression> paramList = params.iterator();
		IEnv environment = closure.getEnv();
		
		environment = environment.beginScope();
		while(paramList.hasNext()){
			environment.assoc(varList.next(),paramList.next().evaluate(env));
		}
		IVal returnval = closure.getExpression().evaluate(environment);
		environment.endScope();
		
		return returnval;
	}

	public void gen(CodeSeq code, ICodeEnv env) {
		// TODO Auto-generated method stub

	}

}
