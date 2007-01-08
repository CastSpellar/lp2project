package tf;

import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class ASTProc implements IASTExpression {

	private List<String> params;

	private IASTStatement statement;

	public ASTProc() {
		params = new LinkedList();
	}

	public void addParam(String param) {
		params.add(param);
	}

	public void setStatement(IASTStatement statement) {
		this.statement = statement;
	}

	public IVal evaluate(IEnv env) {
		// TODO Auto-generated method stub
		return new ProcVal(params, statement, env);
	}

	public void gen(CodeSeq code, ICodeEnv env) {
		// TODO Auto-generated method stub
		int pos = code.code.size();
		code.gen_ldloc("stackframe");
		code.gen_ldfnt_proc(pos);
		code.gen_new_closure();
//		code.gen_dup() ;
		Vector<String> newProc = new Vector<String>(code.size);
		Vector<String> currRep = code.rep;
		int pc = code.pc;
		code.pc = 0;
		code.code.add(newProc);
		code.rep = newProc;
		code.gen_new_proc(pos);
		env = env.beginScope();
		for (String id : params)
			env.newVar(id);
		statement.gen(code, env);
		code.rep = currRep;
		code.pc = pc;
		env = env.endScope() ;
	}

}
