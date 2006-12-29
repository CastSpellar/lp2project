package tf;

import java.util.LinkedList;
import java.util.List;

public class ASTProc implements IASTExpression {
	
	private List<String> params ;
	
	private IASTStatement statement ;
	
	public ASTProc(){
		params = new LinkedList() ;
	}
	
	public void addParam(String param){
		params.add(param) ;
	}

	public void setStatement(IASTStatement statement){
		this.statement = statement ;
	}
	
	public IVal evaluate(IEnv env) {
		// TODO Auto-generated method stub
		return new ProcVal(params, statement, env) ;
	}

	public void gen(CodeSeq code, ICodeEnv env) {
		// TODO Auto-generated method stub

	}

}
