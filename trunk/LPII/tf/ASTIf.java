package tf;

public class ASTIf implements IASTStatement {

	private IASTExpression exp;

	private IASTStatement thenClause;

	private IASTStatement elseClause = null;

	public ASTIf(IASTExpression exp, IASTStatement thenClause) {
		this.exp = exp;
		this.thenClause = thenClause;
	}

	public void setElse(IASTStatement elseClause) {
		this.elseClause = elseClause;
	}

	public void evaluate(IEnv env) {
		// TODO Auto-generated method stub
		if (((BoolVal) exp.evaluate(env)).getVal())
			thenClause.evaluate(env);
		else
			elseClause.evaluate(env);
	}

	public void gen(CodeSeq code, ICodeEnv env) {
		// TODO Auto-generated method stub
		exp.gen(code, env);
		int label1 = code.pc;
		code.get_bool();
		code.gen_br(false, label1);

		thenClause.gen(code, env);

		if (elseClause != null) {
			int label2 = code.pc;
			code.gen_br(true, label2);
			code.gen_label(label1);
			elseClause.gen(code, env);
			code.gen_label(label2);
		} else
			code.gen_label(label1);
	}

}
