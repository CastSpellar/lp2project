package t2.f4;

public class ASTNum implements IASTNode {
   private int val;
   
   ASTNum(int it) { val = it; }

   public int evaluate() { return val; }
   public void gen(CodeSeq code) {
	code.gen_ldc_i4(val);
   }	
}
