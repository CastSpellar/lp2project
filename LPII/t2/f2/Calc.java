package t2.f2;
public class Calc {
    public static void main(String args[]) throws ParseException {

        Parser parser = new Parser(System.in);
        IASTNode ast;
        System.out.print("Enter Expression: ");
        System.out.flush();
        try {
            ast = parser.Start();
            System.out.println(ast.evaluate());
            System.out.println("Ok!");
        } catch (ParseException x) {
            System.out.println("Syntax Error.");
        }
    }
}
