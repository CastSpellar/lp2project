import java.util.*;

public class ASTDecl implements IASTNode{
	private List <Pair> decls;
	private IASTNode expression;
	
	ASTDecl() {	decls = new ArrayList<Pair>(); }
	
	public void setExpression(IASTNode e) { expression = e;}
	
	public void addDecl(String id, IASTNode e) { decls.add(new Pair(id, e)); }

	public int evaluate(IEnvironment e) throws Exception{
		IEnvironment x = e.BeginScope();
		Iterator it = decls.iterator();
		while(it.hasNext()){
			Pair aux = (Pair)it.next();
			x.Assoc((String) aux.getFirst(), ((IASTNode) aux.getSecond()).evaluate(x));
		}
		int tempreturn = expression.evaluate(x);
		e.EndScope();
		return tempreturn;
	}
	
	public void gen(CodeSeq a, IEnvironment b) { 
		
	}
}
