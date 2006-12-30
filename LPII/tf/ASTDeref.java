package tf;

public class ASTDeref implements IASTExpression {
	
	private IASTExpression exp ;
	
	public ASTDeref(IASTExpression exp){
		this.exp = exp ;
	}

	public IVal evaluate(IEnv env) {
		// TODO Auto-generated method stub
		return ((CellVal)exp.evaluate(env)).getVal();
	}

	public void gen(CodeSeq code, ICodeEnv env) {
		// TODO Auto-generated method stub
		exp.gen(code, env) ;
		code.gen_get_cell() ;
	}

}
