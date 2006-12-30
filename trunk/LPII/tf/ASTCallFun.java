package tf;

import java.util.Iterator;
import java.util.List;
import java.util.LinkedList;

public class ASTCallFun implements IASTExpression {

	private IASTExpression id;
	
	private List<IASTExpression> params;
	
	public ASTCallFun(IASTExpression id){
		this.id = id;
		params = new LinkedList<IASTExpression>();
	}
	
	public void addArg(IASTExpression arg){
		params.add(arg);
	}
	
	public IVal evaluate(IEnv env) {
		// TODO Auto-generated method stub
		FunVal closure = (FunVal)id.evaluate(env);
		Iterator<String> varList = closure.getVars().iterator();
		Iterator<IASTExpression> paramList = params.iterator();
		IEnv environment = closure.getEnv();
		
		environment = environment.beginScope();
		while(paramList.hasNext()){
			environment.assoc(varList.next(),paramList.next().evaluate(env));
		}
		IVal returnval = closure.getExpression().evaluate(environment);
		environment.endScope();
		
		return returnval;
	}

	public void gen(CodeSeq code, ICodeEnv env) {
		// TODO Auto-generated method stub
		id.gen(code, env) ;
		code.gen_dup() ;
		code.gen_get_env() ;
		code.gen_ldc_i4(params.size()) ;
		code.gen_new_stack_frame() ;
		int i = 0 ;
		for(IASTExpression param: params){
			code.gen_dup() ;
			param.gen(code, env) ;
			code.gen_ldc_i4(i++) ;
			code.gen_frameset() ;
		}
		code.gen_stloc("tmp");
		code.gen_stloc("tmp2");
		code.gen_ldloc("tmp");
		code.gen_ldloc("tmp2");
		code.gen_fun_get() ;
		code.gen_call() ;
	}
}
