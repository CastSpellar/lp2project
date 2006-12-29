package tf;

public class ASTMod implements IASTExpression {

	IASTExpression left;
	
	IASTExpression right;
	
	public IVal evaluate(IEnv env) {
		// TODO Auto-generated method stub
		return new IntVal(((IntVal)left.evaluate(env)).getVal() % ((IntVal) right.evaluate(env)).getVal());
	}

	public void gen(CodeSeq code, ICodeEnv env) {
		// TODO Auto-generated method stub

	}

}
