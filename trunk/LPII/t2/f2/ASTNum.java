package t2.f2;
public class ASTNum implements IASTNode {
   
	private int val;
   
   ASTNum(int it) { val = it; }

   public int evaluate() { return val; }
}
