package tf;

import java.util.LinkedList;
import java.util.List;

public class ASTCallProc implements IASTStatement {

	private IASTExpression exp;

	private List<IASTExpression> params;

	public ASTCallProc(IASTExpression exp) {
		this.exp = exp;
		params = new LinkedList<IASTExpression>();
	}

	public void addParam(IASTExpression param) {
		params.add(param);
	}

	public void evaluate(IEnv env) {
		// TODO Auto-generated method stub
		ProcVal closure = (ProcVal) exp.evaluate(env);
		IASTStatement closExp = closure.getStatement();
		IEnv closEnv = closure.getEnv();
		IEnv nEnv = closEnv.beginScope();
		int i = 0;
		for (String par : closure.getParams()) {
			IASTExpression expr = params.get(i++);
			nEnv.assoc(par, expr.evaluate(env));
		}
		closExp.evaluate(nEnv);
	}

	public void gen(CodeSeq code, ICodeEnv env) {
		// TODO Auto-generated method stub
		exp.gen(code, env);
		code.gen_dup();
		code.gen_get_env();
		code.gen_ldc_i4(params.size());
		code.gen_new_stack_frame();
		env = env.beginScope() ;
		int i = 0;
		for (IASTExpression param : params) {
			code.gen_dup();
			param.gen(code, env);
			code.gen_ldc_i4(i++);
			code.gen_frameset();
		}
		code.gen_stloc("tmp");
		code.gen_stloc("tmp2");
		code.gen_ldloc("tmp");
		code.gen_ldloc("tmp2");
		code.gen_proc_get();
		code.gen_call_proc();
		env = env.endScope() ;
	}

}
