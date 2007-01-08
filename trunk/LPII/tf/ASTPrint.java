package tf;

public class ASTPrint implements IASTStatement {

	private IASTExpression exp;

	public ASTPrint(IASTExpression exp) {
		this.exp = exp;
	}

	public void evaluate(IEnv env) {
		// TODO Auto-generated method stub
		System.out.print(exp.evaluate(env).toString());
	}

	public void gen(CodeSeq code, ICodeEnv env) {
		// TODO Auto-generated method stub
		exp.gen(code, env);
		code.gen_print();
	}

}
