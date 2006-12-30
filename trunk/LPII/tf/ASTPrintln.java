package tf;

public class ASTPrintln implements IASTStatement {
	
	public ASTPrintln() {
	}

	public void evaluate(IEnv env) {
		// TODO Auto-generated method stub
		System.out.println();
	}

	public void gen(CodeSeq code, ICodeEnv env) {
		// TODO Auto-generated method stub
		code.gen_println() ;
	}

}
