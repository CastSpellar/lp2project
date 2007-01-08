package tf;

public class ASTCallArray implements IASTExpression {

	private IASTExpression id;

	private IASTExpression position;

	public ASTCallArray(IASTExpression id) {
		this.id = id;
	}

	public void setPos(IASTExpression position) {
		this.position = position;
	}

	public IVal evaluate(IEnv env) {
		// TODO Auto-generated method stub
		return ((ArrayVal) id.evaluate(env)).getVal(((IntVal) position
				.evaluate(env)).getVal());
	}

	public void gen(CodeSeq code, ICodeEnv env) {
		// TODO Auto-generated method stub

	}

}
