package t2.f2;
public class ASTDiv implements IASTNode {
	private IASTNode left;

	private IASTNode right;

	ASTDiv(IASTNode l, IASTNode r) {
		left = l;
		right = r;
	}

	public int evaluate() {
		return left.evaluate() / right.evaluate();
	}

}
