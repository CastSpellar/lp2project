package tf;

public interface IASTExpression {

	IVal evaluate(IEnv env);

	void gen(CodeSeq code, ICodeEnv env);

}