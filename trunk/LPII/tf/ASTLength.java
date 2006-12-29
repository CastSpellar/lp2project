package tf;

public class ASTLength implements IASTExpression {

	private IASTExpression array;
	
	public ASTLength(IASTExpression array){
		this.array = array;
	}
	
	public IVal evaluate(IEnv env) {
		// TODO Auto-generated method stub
		return( (ArrayVal)array.evaluate(env)).length();
	}

	public void gen(CodeSeq code, ICodeEnv env) {
		// TODO Auto-generated method stub

	}

}
