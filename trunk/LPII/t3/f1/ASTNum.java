package t3.f1;

public class ASTNum implements IASTNode {
   private int val;
   
   ASTNum(int it) { val = it; }

   public int evaluate(IEnv env) { return val; }
   public void gen(CodeSeq code, ICodeEnv end) {
	code.gen_ldc_i4(val);
   }	
}
