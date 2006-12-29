package t4.f1;

public interface IASTExpression {
	
	IVal evaluate(IEnv env) ;
	
	void gen(CodeSeq code, ICodeEnv env) ;

}