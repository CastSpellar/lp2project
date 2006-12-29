package t4.f1;

public interface IASTStatement {
	
	void evaluate(IEnv env) ;
	
	void gen(CodeSeq code, ICodeEnv env) ;

}
