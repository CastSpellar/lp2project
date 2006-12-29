package tf;

public interface IASTStatement {
	
	void evaluate(IEnv env) ;
	
	void gen(CodeSeq code, ICodeEnv env) ;

}
