package tf;

public class ASTCallRec implements IASTExpression {

	private IASTExpression exp;

	private String id;

	public ASTCallRec(IASTExpression exp, String id) {
		this.exp = exp;
		this.id = id;
	}

	public IVal evaluate(IEnv env) {
		// TODO Auto-generated method stub
		return ((RecordVal) exp.evaluate(env)).getRecord(id);
	}

	public void gen(CodeSeq code, ICodeEnv env) {
		// TODO Auto-generated method stub

	}

}
