package t4.f1;

public class ASTNot implements IASTExpression {
	
	private IASTExpression exp ;
	
	public ASTNot(IASTExpression exp){
		this.exp = exp ;
	}

	public IVal evaluate(IEnv env) {
		// TODO Auto-generated method stub
		return new BoolVal(!((BoolVal) exp.evaluate(env)).getVal()) ;
	}

	public void gen(CodeSeq code, ICodeEnv env) {
		// TODO Auto-generated method stub

	}

}
