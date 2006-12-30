package tf;

import java.util.List;
import java.util.LinkedList;
import java.util.Vector;

public class ASTFun implements IASTExpression {

	private List<String> params;
	
	private IASTExpression expressions; 
	
	public ASTFun(){
		params = new LinkedList<String>() ;
	}
	
	public void addParam(String param){
		params.add(param) ;
	}
	
	public void setExpression(IASTExpression expression) {
		this.expressions = expression;
	}
	
	public IVal evaluate(IEnv env) {
		// TODO Auto-generated method stub
		return new FunVal(params, expressions, env);
	}

	public void gen(CodeSeq code, ICodeEnv env) {
		// TODO Auto-generated method stub
		int pos = code.code.size() ;
		code.gen_ldloc("stackframe") ;
		code.gen_ldfnt(pos) ;
		code.gen_new_closure() ;
		Vector<String> newFun = new Vector<String>(code.size) ;
		Vector<String> currRep = code.rep ;
		int pc = code.pc ;
		code.pc = 0 ;
		code.code.add(newFun) ;
		code.rep = newFun ;
		code.gen_new_fun(pos) ;
		env = env.beginScope() ;
		for(String id: params)
			env.newVar(id) ;
		expressions.gen(code, env) ;
		code.rep = currRep ;
		code.pc = pc ;
	}
}
