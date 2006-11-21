import java.util.Vector;
import java.io.*;

public class CodeSeq {

	Vector<String> rep;

	int pc;

	CodeSeq(int size) {
		rep = new Vector<String>(size);
		pc = 0;
	}

	public void gen_ldc_i4(int k) {
		rep.add(pc++, "ldc.i4 " + k);
	}

	public void gen_add() {
		rep.add(pc++, "add");
	}
	
	public void gen_sub() {
		rep.add(pc++, "sub");
	}
	
	public void gen_mul() {
		rep.add(pc++, "mul");
	}
	
	public void gen_div() {
		rep.add(pc++, "div");
	}

	public void dump(PrintStream out) {
		for (int i = 0; i < pc; i++)
			out.println(rep.get(i));
	}

	static public void preamble(PrintStream out) {
		out.println(".assembly 'Calc' { }");
		out.println(".module Calc.exe");
		out.println(".method public static  hidebysig");
		out.println("default void Main ()  cil managed");
		out.println("{ .entrypoint");
	}

	static public void epilogue(PrintStream out) {
		out.println("call void class [mscorlib]System.Console::WriteLine(int32)");
		out.println("ret }");

	}

	public void generate(String fileName) {

		try {
			FileOutputStream fout = new FileOutputStream(fileName);
			PrintStream pout = new PrintStream(fout);

			preamble(pout);
			dump(pout);
			epilogue(pout);

			pout.close();
		} catch (Exception e) {
			System.out.println("Error: cannot write to file");
		}

	}

}
