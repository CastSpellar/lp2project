package tf;

import java.util.Scanner;

public class ASTReadStr implements IASTExpression {
	
	public ASTReadStr() {}

	public IVal evaluate(IEnv env) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in) ;
		return new StringVal(s.nextLine()) ;
	}

	public void gen(CodeSeq code, ICodeEnv env) {
		// TODO Auto-generated method stub
		
	}

}
