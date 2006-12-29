package t2.f2;

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
}
