package t3.f1;

public class Calc {

	public static void main(String args[]) throws ParseException {

		Parser parser = new Parser(System.in);
		IASTNode ast;
		CodeSeq code;
		IEnv env = new Env() ;
		ICodeEnv codeEnv = new CodeEnv() ;
		int val;
		System.out.print("Enter Expression: ");
		System.out.flush();
		try {
			ast = parser.Start();
			val = ast.evaluate(env);
			System.out.println(val);
			code = new CodeSeq(1000);
			ast.gen(code, codeEnv);
			code.generate("Calc.as", codeEnv.getMax());
		} catch (ParseException x) {
			System.out.println("Syntax Error.");
		}
	}
}
