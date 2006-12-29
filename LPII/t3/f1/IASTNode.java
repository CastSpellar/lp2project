package t3.f1;

public interface IASTNode {
   int evaluate(IEnv env);
   void gen(CodeSeq code, ICodeEnv env);
}
