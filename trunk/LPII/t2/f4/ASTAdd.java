package t2.f4;

public class ASTAdd implements IASTNode{
	
	private IASTNode left ;
	
	private IASTNode right ;
	
	ASTAdd(IASTNode l, IASTNode r){
		left = l ;
		right = r ;
	}

	public int evaluate() {
		// TODO Auto-generated method stub
		return left.evaluate() + right.evaluate() ;
	}

	public void gen(CodeSeq code) {
		// TODO Auto-generated method stub
		left.gen(code) ;
		right.gen(code) ;
		code.gen_add() ;
	}
}
