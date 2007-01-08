package tf;

public class Calc {

	@SuppressWarnings("static-access")
	public static void main(String args[]) throws ParseException {

		Parser parser = new Parser(System.in);
		IASTStatement ast;
		CodeSeq code;
		IEnv env = new Env();
		ICodeEnv codeEnv = new CodeEnv();
		System.out.print("Enter Expression: ");
		System.out.flush();
		try {
			ast = parser.Start();
			ast.evaluate(env);
			code = new CodeSeq(1000);
			ast.gen(code, codeEnv);
			code.generate("Calc.as");
		} catch (ParseException x) {
			System.out.println("Syntax Error.");
		}
	}
}