package t2.f2;
public class ASTMul implements IASTNode {
  private IASTNode left;

	private IASTNode right;

	ASTMul(IASTNode l, IASTNode r) {
		left = l;
		right = r;
	}

	public int evaluate() {
		return left.evaluate() * right.evaluate();
	}

}
