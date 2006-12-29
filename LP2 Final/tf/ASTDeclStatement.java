package tf;

import java.util.LinkedList;
import java.util.List;

public class ASTDeclStatement implements IASTStatement {
	
	private List<IdExp> decls ;
	
	private IASTStatement statement ;
	
	public ASTDeclStatement(){
		decls = new LinkedList<IdExp>() ;
	}
	
	public void setStatement(IASTStatement statement){
		this.statement = statement ;
	}
	
	public void addDecl(String id, IASTExpression exp){
		decls.add(new IdExp(id, exp)) ;
	}

	public void evaluate(IEnv env) {
		// TODO Auto-generated method stub
		IEnv e = env.beginScope() ;
		for(IdExp decl: decls)
			e.assoc(decl.getId(), decl.getExp().evaluate(e)) ;
		statement.evaluate(e) ;
		e.endScope() ;
	}

	public void gen(CodeSeq code, ICodeEnv env) {
		// TODO Auto-generated method stub

	}

}
