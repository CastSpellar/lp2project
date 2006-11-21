public class ASTMul implements IASTNode {
  private IASTNode left;
  private IASTNode right;

  ASTMul(IASTNode l, IASTNode r) { left = l; right = r;}

  public int evaluate(IEnvironment e) throws Exception{ return left.evaluate(e) * right.evaluate(e); }

  public void gen(CodeSeq code,IEnvironment e){
        left.gen(code,e);
        right.gen(code,e);
        code.gen_mul();
  }

}
