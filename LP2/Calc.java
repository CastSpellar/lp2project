public class Calc {

    public static void main(String args[]) throws ParseException {
        Parser parser = new Parser(System.in);
		IASTNode ast;
		CodeSeq code = new CodeSeq(1000);
		Environment e = new Environment();
		
		System.out.print("\n\tWelcome!\n\n\tEnter Expression: "); System.out.flush();
        try { 
			ast = parser.Start(); 
			int result = ast.evaluate(e);
			System.out.println("\n\tSintax Accepted. Result = " + result + "\n");
			ast.gen(code, e);
			code.generate("Calc.as");
			System.out.println("File 'Calc.as' successfully generated.");
		} 
		catch (Exception x) { 
			System.out.println("\nERROR! Returned message:\n" + x.getMessage() + "\nExiting...\n"); 
		}
    }
}