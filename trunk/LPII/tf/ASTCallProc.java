package tf;

import java.util.LinkedList;
import java.util.List;

public class ASTCallProc implements IASTStatement {
	
	private IASTExpression exp ;
	
	private List<IASTExpression> params ;
	
	public ASTCallProc(IASTExpression exp) {
		this.exp = exp ;
		params = new LinkedList<IASTExpression>() ;
	}

	public void addParam(IASTExpression param){
		params.add(param) ;
	}
	
	public void evaluate(IEnv env) {
		// TODO Auto-generated method stub
		ProcVal closure = (ProcVal)exp.evaluate(env);
		IASTStatement closExp = closure.getStatement() ;
		IEnv closEnv = closure.getEnv() ;
		IEnv nEnv = closEnv.beginScope() ;
		for(String par: closure.getParams())
			for(IASTExpression exp: params)
				nEnv.assoc(par, exp.evaluate(env)) ;
		closExp.evaluate(nEnv) ;
	}

	public void gen(CodeSeq code, ICodeEnv env) {
		// TODO Auto-generated method stub

	}

}
