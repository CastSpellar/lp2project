package tf;

public class ASTString implements IASTExpression {
	
	private String val ;
	
	public ASTString(String val){
		this.val = val ;
	}

	public IVal evaluate(IEnv env) {
		// TODO Auto-generated method stub
		return new StringVal(val) ;
	}

	public void gen(CodeSeq code, ICodeEnv env) {
		// TODO Auto-generated method stub

	}

}
