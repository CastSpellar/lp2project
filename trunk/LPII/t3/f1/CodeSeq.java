package t3.f1;

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

	public void gen_mul() {
		rep.add(pc++, "mul");
	}
	
	public void gen_div(){
		rep.add(pc++, "div") ;
	}
	
	public void gen_add(){
		rep.add(pc++, "add") ;
	}
	
	public void gen_sub(){
		rep.add(pc++, "sub") ;
	}
	
	public void gen_stloc(int var){
		if(var < 4)
			rep.add(pc++, "stloc." + var) ;
		else
			rep.add(pc++, "stloc " + var) ;
	}
	
	public void gen_ldloc(int var){
		if(var < 4)
			rep.add(pc++, "ldloc." + var) ;
		else
			rep.add(pc++, "ldloc " + var) ;
	}

	public void dump(PrintStream out) {
		for (int i = 0; i < pc; i++)
			out.println(rep.get(i));
	}

	static public void preamble(PrintStream out, int nvars) {
		out.println(".assembly 'Calc' { }");
		out.println(".module Calc.exe");
		out.println(".method public static  hidebysig");
		out.println("default void Main ()  cil managed");
		out.println("{ .entrypoint");
		if(nvars > 0){
			out.print(".locals(") ;
			for(int i = 0; i < nvars; i++)
				if(i == 0)
					out.print("int32") ;
				else
					out.print(", int32") ;
			out.println(")") ;
		}
	}

	static public void epilogue(PrintStream out) {
		out.println("call void class [mscorlib]System.Console::WriteLine(int32)");
		out.println("ret }");

	}

	public void generate(String fileName, int nvars) {

		try {
			FileOutputStream fout = new FileOutputStream(fileName);
			PrintStream pout = new PrintStream(fout);

			preamble(pout, nvars);
			dump(pout);
			epilogue(pout);

			pout.close();
		} catch (Exception e) {
			System.out.println("Error: cannot write to file");
		}

	}

}
