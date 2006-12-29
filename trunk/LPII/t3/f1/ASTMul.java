package t3.f1;

public class ASTMul implements IASTNode {
  private IASTNode left;
  private IASTNode right;

  ASTMul(IASTNode l, IASTNode r) { left = l; right = r;}

  public int evaluate(IEnv env) { return left.evaluate(env) * right.evaluate(env); }

  public void gen(CodeSeq code, ICodeEnv env){
        left.gen(code, env);
        right.gen(code, env);
        code.gen_mul();
  }

}
