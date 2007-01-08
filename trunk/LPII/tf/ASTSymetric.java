package tf;

public class ASTSymetric implements IASTExpression {

	private IASTExpression exp;

	public ASTSymetric(IASTExpression exp) {
		this.exp = exp;
	}

	public IVal evaluate(IEnv env) {
		// TODO Auto-generated method stub
		return new IntVal(-((IntVal) exp.evaluate(env)).getVal());
	}

	public void gen(CodeSeq code, ICodeEnv env) {
		// TODO Auto-generated method stub

	}

}
