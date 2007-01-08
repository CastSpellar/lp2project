package tf;

public class ASTNum implements IASTExpression {

	private int val;

	public ASTNum(int val) {
		this.val = val;
	}

	public IVal evaluate(IEnv env) {
		// TODO Auto-generated method stub
		return new IntVal(val);
	}

	public void gen(CodeSeq code, ICodeEnv env) {
		// TODO Auto-generated method stub
		code.gen_ldc_i4(val);
	}

}
