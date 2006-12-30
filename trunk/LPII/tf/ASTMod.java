package tf;

public class ASTMod implements IASTExpression {

	IASTExpression left;
	
	IASTExpression right;
	
	public ASTMod(IASTExpression left, IASTExpression right){
		this.left = left ;
		this.right = right ;
	}
	
	public IVal evaluate(IEnv env) {
		// TODO Auto-generated method stub
		return new IntVal(((IntVal)left.evaluate(env)).getVal() % ((IntVal) right.evaluate(env)).getVal());
	}

	public void gen(CodeSeq code, ICodeEnv env) {
		// TODO Auto-generated method stub
		left.gen(code, env) ;
		right.gen(code, env) ;
		code.gen_mod() ;
	}

}
