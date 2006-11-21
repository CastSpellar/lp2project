public class ASTDiv implements IASTNode {
  private IASTNode left;
  private IASTNode right;

  ASTDiv(IASTNode l, IASTNode r) { left = l; right = r;}

  public int evaluate(IEnvironment e) throws Exception{
	if(left.evaluate(e)==0) throw new DivideByZeroException();
	else return (left.evaluate(e) / right.evaluate(e));
  }


  public void gen(CodeSeq code, IEnvironment e){
      left.gen(code,e);
      right.gen(code,e);
      code.gen_div();
  }
}
