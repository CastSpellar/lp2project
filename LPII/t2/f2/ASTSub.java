package t2.f2;

public class ASTSub implements IASTNode{
	
	private IASTNode left ;
	
	private IASTNode right ;
	
	ASTSub(IASTNode l, IASTNode r){
		left = l ;
		right = r ;
	}

	public int evaluate() {
		// TODO Auto-generated method stub
		return left.evaluate() - right.evaluate() ;
	}

}
