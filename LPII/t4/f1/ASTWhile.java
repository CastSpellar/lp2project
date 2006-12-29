package t4.f1;

public class ASTWhile implements IASTStatement{
	
	private IASTExpression exp ;
	
	private IASTStatement command ;
	
	public ASTWhile(IASTExpression exp, IASTStatement command){
		this.exp = exp ;
		this.command = command ;
	}

	public void evaluate(IEnv env) {
		// TODO Auto-generated method stub
		while(((BoolVal) exp.evaluate(env)).getVal())
			command.evaluate(env) ;
	}

	public void gen(CodeSeq code, ICodeEnv env) {
		// TODO Auto-generated method stub
		
	}

}
