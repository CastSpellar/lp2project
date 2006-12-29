package tf;

import java.util.List;
import java.util.LinkedList;

public class ASTFun implements IASTExpression {

	private List<String> params;
	
	private IASTExpression expressions; 
	
	public ASTFun(){
		params = new LinkedList() ;
	}
	
	public void addParam(String param){
		params.add(param) ;
	}
	
	public void setExpression(IASTExpression expression) {
		this.expressions = expression;
	}
	
	public IVal evaluate(IEnv env) {
		// TODO Auto-generated method stub
		return new FunVal(params, expressions, env);
	}

	public void gen(CodeSeq code, ICodeEnv env) {
		// TODO Auto-generated method stub

	}

}
