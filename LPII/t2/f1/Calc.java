package t2.f1;

public class Calc {
    public static void main(String args[]) throws ParseException {
        Parser parser = new Parser(System.in);

	System.out.print("Enter Expression: ");
        System.out.flush();
        try {
          parser.Start();
          System.out.println("Ok!");
        } catch (ParseException x) {
          System.out.println("Syntax Error.");
        }
    }
}
