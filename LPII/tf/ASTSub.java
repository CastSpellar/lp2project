package tf;

public class ASTSub implements IASTExpression {

	private IASTExpression left;

	private IASTExpression right;

	public ASTSub(IASTExpression left, IASTExpression right) {
		this.left = left;
		this.right = right;
	}

	public IVal evaluate(IEnv env) {
		// TODO Auto-generated method stub
		return new IntVal(((IntVal) left.evaluate(env)).getVal()
				- ((IntVal) right.evaluate(env)).getVal());
	}

	public void gen(CodeSeq code, ICodeEnv env) {
		// TODO Auto-generated method stub
		left.gen(code, env);
		right.gen(code, env);
		code.gen_sub();
	}

}
