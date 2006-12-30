package tf;

import java.util.List;
import java.util.LinkedList;

public class ASTFun implements IASTExpression {

	private List<String> params;
	
	private IASTExpression expressions; 
	
	public ASTFun(){
		params = new LinkedList() ;
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
		
	}
	
	/*int pos = code.getCodesSize();
		code.gen_ldloc("stackframe");
		code.gen_ldftn("object" , new String("f"+pos) );
		code.gen_closure();
				
		code.switchNext();
		code.gen_func( pos );
		cenv=cenv.beginScope();
		Iterator<String> it = args.iterator();
		while( it.hasNext() )
			cenv.AssocC(it.next());
		exp.gen(code, cenv);
		code.switchPrevious();
		cenv.endScope();*/

}
