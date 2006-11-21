public class ASTId implements IASTNode {
  private String Id;

  ASTId(String id) { this.Id = id; }

  public int evaluate(IEnvironment e) throws Exception{ return e.Find(Id); }
  
  public void gen(CodeSeq a, IEnvironment b) {
	  
  }


}
