package tf;

public class ASTAssign implements IASTStatement {

	private IASTExpression left;

	private IASTExpression right;

	public ASTAssign(IASTExpression left, IASTExpression right) {
		this.left = left;
		this.right = right;
	}

	public void evaluate(IEnv env) {
		// TODO Auto-generated method stub
		((CellVal) left.evaluate(env)).setVal(right.evaluate(env));
	}

	public void gen(CodeSeq code, ICodeEnv env) {
		// TODO Auto-generated method stub
		left.gen(code, env);
		right.gen(code, env);
		code.gen_assign();
	}

}
