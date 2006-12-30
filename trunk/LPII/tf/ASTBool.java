package tf;

public class ASTBool implements IASTExpression {
	
	private boolean val ;
	
	public ASTBool(boolean val){
		this.val = val ;
	}

	public IVal evaluate(IEnv env) {
		// TODO Auto-generated method stub
		return new BoolVal(val) ;
	}

	public void gen(CodeSeq code, ICodeEnv env) {
		// TODO Auto-generated method stub
		code.gen_newBool(val) ;
	}

}
