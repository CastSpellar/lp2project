package tf;

public class ASTWhile implements IASTStatement {

	private IASTExpression exp;

	private IASTStatement command;

	public ASTWhile(IASTExpression exp, IASTStatement command) {
		this.exp = exp;
		this.command = command;
	}

	public void evaluate(IEnv env) {
		// TODO Auto-generated method stub
		while (((BoolVal) exp.evaluate(env)).getVal())
			command.evaluate(env);
	}

	public void gen(CodeSeq code, ICodeEnv env) {
		// TODO Auto-generated method stub
		int label1 = code.pc;
		code.gen_label(label1);
		exp.gen(code, env);
		code.get_bool();
		int label2 = code.pc;
		code.gen_br(false, label2);
		command.gen(code, env);
		code.gen_br(true, label1);
		code.gen_label(label2);
	}

}
