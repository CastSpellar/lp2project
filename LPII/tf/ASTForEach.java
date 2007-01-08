package tf;

import java.util.Vector;

public class ASTForEach implements IASTStatement {

	private IASTExpression exp;

	private String id;

	private IASTStatement statement;

	public ASTForEach(IASTExpression exp, String id, IASTStatement statement) {
		this.exp = exp;
		this.id = id;
		this.statement = statement;
	}

	public void evaluate(IEnv env) {
		// TODO Auto-generated method stub
		ArrayVal a = (ArrayVal) exp.evaluate(env);
		Vector<CellVal> array = a.getArray();
		for (CellVal c : array) {
			env.update(id, c);
			statement.evaluate(env);
		}
	}

	public void gen(CodeSeq code, ICodeEnv env) {
		// TODO Auto-generated method stub

	}

}
