package tf;

public class ASTOr implements IASTExpression {

private IASTExpression left ;
	
	private IASTExpression right ;
	
	public ASTOr(IASTExpression left, IASTExpression right){
		this.left = left ;
		this.right = right ;
	}

	public IVal evaluate(IEnv env) {
		// TODO Auto-generated method stub
		return new BoolVal(((BoolVal)left.evaluate(env)).getVal() || ((BoolVal) right.evaluate(env)).getVal());
	}

	public void gen(CodeSeq code, ICodeEnv env) {
		// TODO Auto-generated method stub
		left.gen(code, env) ;
		right.gen(code, env) ;
		code.gen_or() ;
	}

}
