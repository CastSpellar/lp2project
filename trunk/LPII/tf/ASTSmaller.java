package tf;

public class ASTSmaller implements IASTExpression {
	
	private IASTExpression left ;
	
	private IASTExpression right ;
	
	public ASTSmaller(IASTExpression left, IASTExpression right){
		this.left = left ;
		this.right = right ;
	}

	public IVal evaluate(IEnv env) {
		// TODO Auto-generated method stub
		return new BoolVal(((IntVal)left.evaluate(env)).getVal() < ((IntVal) right.evaluate(env)).getVal());
	}

	public void gen(CodeSeq code, ICodeEnv env) {
		// TODO Auto-generated method stub
		left.gen(code, env) ;
		right.gen(code, env) ;
		code.gen_smaller() ;
	}

}
