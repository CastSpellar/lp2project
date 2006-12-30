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
		env = env.beginScope() ;
		code.gen_ldloc("stackframe") ;
		code.gen_ldc_i4(decls.size()) ;
		code.gen_new_stack_frame() ;
		code.gen_stloc("stackframe") ;
		for(IdExp id: decls){
			code.gen_ldloc("stackframe") ;
			env.newVar(id.getId()) ;
			int pos = env.find(id.getId())[1] ;
			id.getExp().gen(code, env) ;
			code.gen_ldc_i4(pos) ;
			code.gen_frameset() ;
		}
		statement.gen(code, env) ;
		code.gen_ldloc("stackframe") ;
		code.gen_closeframe() ;
		code.gen_stloc("stackframe") ;
		env = env.endScope() ;
	}

}
