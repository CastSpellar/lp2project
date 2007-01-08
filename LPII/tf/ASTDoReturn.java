package tf;

public class ASTDoReturn implements IASTExpression {

	private IASTStatement statement;

	private IASTExpression expression;

	public ASTDoReturn(IASTStatement statement, IASTExpression expression) {
		this.statement = statement;
		this.expression = expression;
	}

	public IVal evaluate(IEnv env) {
		// TODO Auto-generated method stub
		statement.evaluate(env);
		return expression.evaluate(env);
	}

	public void gen(CodeSeq code, ICodeEnv env) {
		// TODO Auto-generated method stub
		statement.gen(code, env);
		expression.gen(code, env);
	}

}
