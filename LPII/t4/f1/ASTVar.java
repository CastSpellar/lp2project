package t4.f1;

public class ASTVar implements IASTExpression {
	
	private IASTExpression exp ;
	
	public ASTVar(IASTExpression exp){
		this.exp = exp ;
	}

	public IVal evaluate(IEnv env) {
		// TODO Auto-generated method stub
		return new CellVal(exp.evaluate(env));
	}

	public void gen(CodeSeq code, ICodeEnv env) {
		// TODO Auto-generated method stub

	}

}
