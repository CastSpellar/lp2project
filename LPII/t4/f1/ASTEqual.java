package t4.f1;

public class ASTEqual implements IASTExpression {

	private IASTExpression left ;
	
	private IASTExpression right ;
	
	public ASTEqual(IASTExpression left, IASTExpression right){
		this.left = left ;
		this.right = right ;
	}
	
	public IVal evaluate(IEnv env) {
		// TODO Auto-generated method stub
		return new BoolVal(((IntVal)left.evaluate(env)).getVal() == ((IntVal) right.evaluate(env)).getVal());
	}

	public void gen(CodeSeq code, ICodeEnv env) {
		// TODO Auto-generated method stub

	}

}
