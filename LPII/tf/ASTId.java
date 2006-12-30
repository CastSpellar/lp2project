package tf;

public class ASTId implements IASTExpression {
	
	private String id ;
	
	public ASTId(String id){
		this.id = id ;
	}

	public IVal evaluate(IEnv env) {
		// TODO Auto-generated method stub
		return env.find(id);
	}

	public void gen(CodeSeq code, ICodeEnv env) {
		// TODO Auto-generated method stub
		int[] location = env.find(id) ;
		code.gen_ldloc("stackframe") ;
		code.gen_ldc_i4(location[0]) ;
		code.gen_ldc_i4(location[1]) ;
		code.gen_stack_get() ;
	}
}
