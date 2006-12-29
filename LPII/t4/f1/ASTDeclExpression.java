package t4.f1;

import java.util.LinkedList;
import java.util.List;

public class ASTDeclExpression implements IASTExpression {
	
	private List<IdExp> decls ;
	
	private IASTExpression exp ;
	
	public ASTDeclExpression(){
		decls = new LinkedList<IdExp>() ;
	}
	
	public void setExpression(IASTExpression exp){
		this.exp = exp ;
	}
	
	public void addDecl(String id, IASTExpression exp){
		decls.add(new IdExp(id, exp)) ;
	}

	public IVal evaluate(IEnv env) {
		// TODO Auto-generated method stub
		env = env.beginScope() ;
		for(IdExp var: decls){
			env.assoc(var.getId(), var.getExp().evaluate(env)) ;
		}
		IVal returnVal = exp.evaluate(env) ;
		env.endScope() ;
		return returnVal ;
	}

	public void gen(CodeSeq code, ICodeEnv env) {
		// TODO Auto-generated method stub

	}

}
