package tf;

public class ASTArray implements IASTExpression {
	
	private IASTExpression size ;
	
	private IASTExpression initVal ;
	
	public ASTArray(IASTExpression size, IASTExpression initVal){
		this.size = size ;
		this.initVal = initVal ;
	}

	public IVal evaluate(IEnv env) {
		return new ArrayVal(((IntVal)size.evaluate(env)).getVal(), initVal.evaluate(env));
	}

	public void gen(CodeSeq code, ICodeEnv env) {
		// TODO Auto-generated method stub

	}

}
