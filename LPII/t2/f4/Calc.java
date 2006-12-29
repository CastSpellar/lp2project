package t2.f4;

public class Calc {

	public static void main(String args[]) throws ParseException {

		Parser parser = new Parser(System.in);
		IASTNode ast;
		CodeSeq code;
		int val;
		System.out.print("Enter Expression: ");
		System.out.flush();
		try {
			ast = parser.Start();
			val = ast.evaluate();
			System.out.println(val);
			code = new CodeSeq(1000);
			ast.gen(code);
			code.generate("Calc.as");
		} catch (ParseException x) {
			System.out.println("Syntax Error.");
		}
	}
}
