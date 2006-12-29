package t3.f1;

public class ASTAdd implements IASTNode{
	
	private IASTNode left ;
	
	private IASTNode right ;
	
	ASTAdd(IASTNode l, IASTNode r){
		left = l ;
		right = r ;
	}

	public int evaluate(IEnv env) {
		// TODO Auto-generated method stub
		return left.evaluate(env) + right.evaluate(env) ;
	}

	public void gen(CodeSeq code, ICodeEnv env) {
		// TODO Auto-generated method stub
		left.gen(code, env) ;
		right.gen(code, env) ;
		code.gen_add() ;
	}
}
