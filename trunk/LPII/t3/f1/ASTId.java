package t3.f1;

public class ASTId implements IASTNode {
	
	private String id ;
	
	public ASTId(String id){
		this.id = id ;
	}

	public int evaluate(IEnv env) {
		// TODO Auto-generated method stub
		return env.find(id);
	}

	public void gen(CodeSeq code, ICodeEnv env) {
		// TODO Auto-generated method stub
		int location = env.find(id) ;
		code.gen_ldloc(location) ;
	}

}
