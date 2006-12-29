package t3.f1;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ASTDecl implements IASTNode {
	
	private List<IdExp> decls ;
	
	private IASTNode exp ;

	public ASTDecl(){
		decls = new LinkedList<IdExp>() ;
	}
	
	public void setExpression(IASTNode exp){
		this.exp = exp ;
	}
	
	public void addDecl(String id, IASTNode exp){
		decls.add(new IdExp(id, exp)) ;
	}
	
	public int evaluate(IEnv env) {
		// TODO Auto-generated method stub
		IEnv e = env.beginScope() ;
		Iterator it = decls.iterator() ;
		while(it.hasNext()){
			IdExp pair = (IdExp) it.next() ;
			e.assoc(pair.getId(), pair.getExp().evaluate(e)) ;
		}
		int value = exp.evaluate(e) ;
		e.endScope() ;
		return value ;
	}

	public void gen(CodeSeq code, ICodeEnv env) {
		// TODO Auto-generated method stub
		env = env.beginScope() ;
		for(IdExp i: decls){
			i.getExp().gen(code, env) ;
			int loc = env.newVar(i.getId()) ;
			code.gen_stloc(loc) ;
		}
		exp.gen(code, env) ;
		env = env.endScope() ;
	}

}
