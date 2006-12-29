package t4.f1;

public class ASTIf implements IASTStatement {
	
	private IASTExpression exp ;
	
	private IASTStatement thenClause ;
	
	private IASTStatement elseClause ;
	
	public ASTIf(IASTExpression exp, IASTStatement thenClause, IASTStatement elseClause){
		this.exp = exp ;
		this.thenClause = thenClause ;
		this.elseClause = elseClause ;
	}

	public void evaluate(IEnv env) {
		// TODO Auto-generated method stub
		if(((BoolVal) exp.evaluate(env)).getVal())
			thenClause.evaluate(env) ;
		else
			elseClause.evaluate(env) ;
	}

	public void gen(CodeSeq code, ICodeEnv env) {
		// TODO Auto-generated method stub

	}

}
