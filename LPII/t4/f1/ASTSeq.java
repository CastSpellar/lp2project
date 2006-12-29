package t4.f1;

public class ASTSeq implements IASTStatement {
	
	private IASTStatement preStatement ;
	
	private IASTStatement posStatement ;
	
	public ASTSeq(IASTStatement preStatement, IASTStatement poStatement){
		this.preStatement = preStatement ;
		this.posStatement = poStatement ;
	}

	public void evaluate(IEnv env) {
		// TODO Auto-generated method stub
		preStatement.evaluate(env) ;
		posStatement.evaluate(env) ;
	}

	public void gen(CodeSeq code, ICodeEnv env) {
		// TODO Auto-generated method stub

	}

}
