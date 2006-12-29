package tf;

import java.util.Scanner;

public class ASTReadInt implements IASTExpression {
	
	public ASTReadInt(){}

	public IVal evaluate(IEnv env) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in) ;
		return new IntVal(s.nextInt()) ;
	}

	public void gen(CodeSeq code, ICodeEnv env) {
		// TODO Auto-generated method stub

	}

}
