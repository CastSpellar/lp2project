public interface IASTNode {
   int evaluate(IEnvironment e) throws Exception;
   void gen(CodeSeq code, IEnvironment e);
}
