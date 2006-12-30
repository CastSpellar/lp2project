package tf;

public class ASTIfExpression implements IASTExpression {

	private IASTExpression exp ;
	
	private IASTExpression thenClause ;
	
	private IASTExpression elseClause = null ;
	
	public ASTIfExpression(IASTExpression exp, IASTExpression thenClause){
		this.exp = exp ;
		this.thenClause = thenClause ;
	}

	public void setElse(IASTExpression elseClause){
		this.elseClause = elseClause ;
	}
	
	
	public IVal evaluate(IEnv env) {
		// TODO Auto-generated method stub
		if(((BoolVal) exp.evaluate(env)).getVal())
			return thenClause.evaluate(env) ;
		else
			return elseClause.evaluate(env) ;
	}

	public void gen(CodeSeq code, ICodeEnv env) {
		// TODO Auto-generated method stub
		exp.gen(code, env) ;
		int label1 = code.pc ;
		code.get_bool() ;
		code.gen_br(false, label1) ;
		thenClause.gen(code, env) ;
		int label2 = code.pc ;
		code.gen_br(true, label2) ;
		elseClause.gen(code, env) ;
		code.gen_label(label2) ;
	}
}
