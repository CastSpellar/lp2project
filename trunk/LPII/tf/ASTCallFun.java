package tf;

import java.util.List;
import java.util.LinkedList;

public class ASTCallFun implements IASTExpression {

	private IASTExpression expression;
	
	private List<IASTExpression> params;
	
	public ASTCallFun(IASTExpression expression){
		this.expression = expression;
		params = new LinkedList<IASTExpression>();
	}
	
	
	public IVal evaluate(IEnv env) {
		// TODO Auto-generated method stub
		return null;
	}

	public void gen(CodeSeq code, ICodeEnv env) {
		// TODO Auto-generated method stub

	}

}
