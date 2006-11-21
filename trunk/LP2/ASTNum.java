public class ASTNum implements IASTNode {
   private int val;
   
   ASTNum(int it) { val = it; }

   public int evaluate(IEnvironment e) throws Exception{ return val; }
   public void gen(CodeSeq code,IEnvironment e) {
	code.gen_ldc_i4(val);
   }	
}
