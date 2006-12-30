package tf;

import java.util.Vector;
import java.io.*;

public class CodeSeq {
	
	Vector<Vector<String>> code ;

	Vector<String> rep;

	int pc;

	CodeSeq(int size) {
		code = new Vector<Vector<String>>() ;
		rep = new Vector<String>(size);
		code.add(rep) ;
		pc = 0;
	}

	public void gen_ldc_i4(int k) {
		rep.add(pc++, "ldc.i4 " + k);
		rep.add(pc++, "newobj instance void [Runtime]Integer::.ctor(int32)") ;
	}

	public void gen_mul() {
		rep.add(pc++,"call class [Runtime]Integer class [Runtime]Integer::'mul'(object,object)");
	}

	public void gen_add() {
		rep.add(pc++,"call class [Runtime]Integer class [Runtime]Integer::'add'(object,object)");
	}

	public void gen_div() {
		rep.add(pc++,"call class [Runtime]Integer class [Runtime]Integer::'div'(object,object)");
	}

	public void gen_sub() {
		rep.add(pc++,"call class [Runtime]Integer class [Runtime]Integer::'sub'(object,object)");
	}
	
	public void gen_mod() {
		rep.add(pc++,"call class [Runtime]Integer class [Runtime]Integer::'mod'(object,object)");
	}
	
	public void gen_newBool(boolean val){
		if(val)
			rep.add(pc++, "ldc.i4 " + 1);
		else
			rep.add(pc++, "ldc.i4 " + 0);
		rep.add(pc++, "newobj instance void [Runtime]Boolean::.ctor(int32)") ;
	}
	
	public void gen_stloc(String varName){
		rep.add(pc++, "stloc " + varName) ;
	}
	
	public void gen_ldloc(String varName){
		rep.add(pc++, "ldloc " + varName) ;
	}
	
	public void gen_and(){
		rep.add(pc++,"call class [Runtime]Boolean class [Runtime]Boolean::'and'(object,object)");
	}
	
	public void gen_or(){
		rep.add(pc++,"call class [Runtime]Boolean class [Runtime]Boolean::'or'(object,object)");
	}
	
	public void gen_not(){
		rep.add(pc++,"callvirt instance object [Runtime]Boolean::'not'()");
	}
	
	public void gen_diff(){
		rep.add(pc++, "call class [Runtime] Boolean [Runtime]Integer::'diff'(object,object)") ;
	}
	
	public void gen_equal(){
		rep.add(pc++, "call class [Runtime]Boolean class [Runtime]Integer::'equal'(object,object)") ;
	}
	
	public void gen_greater(){
		rep.add(pc++, "call class [Runtime]Boolean class [Runtime]Integer::'greater'(object,object)") ;
	}
	
	public void get_bool() {
		rep.add(pc++, "callvirt instance bool [Runtime]BoolValue::getBool()");
	}
	
	public void gen_br(boolean type, int val){
		if(type)
			rep.add(pc++, "br L_" + val);
		else
			rep.add(pc++, "brfalse L_" + val);
	}
	
	public void gen_label(int label) { 
		rep.add(pc++, "L_" + label + ":"); 
	}
	
	public void gen_greaterorequal(){
		rep.add(pc++, "call class [Runtime]Boolean class [Runtime]Integer::'greaterorequal'(object,object)") ;
	}
	
	public void gen_assign(){
		rep.add(pc++, "callvirt instance object [Runtime]Cell::'setVal'(object)") ;
	}
	
	public void gen_print(){
		rep.add(pc++, "call void class [mscorlib]System.Console::Write(object)");
	}
	
	public void gen_println(){
		rep.add(pc++,"call void class [mscorlib]System.Console::WriteLine()");
	}
	
	public void gen_newStackFrame(){
		rep.add(pc++, "newobj instance void [Runtime]StackFrame::.ctor" + "(class [Runtime]StackFrame, int32)");
	}
	
	public void gen_frameset(){
		rep.add(pc++, "callvirt instance void [Runtime]StackFrame::'set'(object, object)") ;
	}
	
	public void gen_closeframe(){
		rep.add(pc++, "callvirt instance object [Runtime]StackFrame::getprevFrame()") ;
	}
	
	public void gen_stack_get(){
		rep.add(pc++, "callvirt instance object [Runtime]StackFrame::get(object, object)") ;
	}
	
	public void gen_ldfnt(){
		rep.add(pc++, "ldftn "+ret+" "+id+"(object)");
	}

	public void dump(PrintStream out) {
		for (int i = 0; i < pc; i++)
			out.println(rep.get(i));
	}

	static public void preamble(PrintStream out) {
		out.println(".assembly 'Calc' { }");
		out.println(".assembly extern Runtime {}") ;
		out.println(".module Calc.exe");		
		out.println(".method public static  hidebysig");
		out.println("default void Main ()  cil managed");
		out.println("{ .entrypoint");
		out.println(".maxstack 1000") ;
		out.println(".locals init (object stackframe)") ;
		out.println("newobj instance void [Runtime]StackFrame::.ctor()");
		out.println("stloc stackframe");
		/*if(nvars > 0){
			out.print(".locals(") ;
			for(int i = 0; i < nvars; i++)
				if(i == 0)
					out.print("object") ;
				else
					out.print(", object") ;
			out.println(")") ;
		}*/
	}

	static public void epilogue(PrintStream out) {
		//out.println("call void class [mscorlib]System.Console::WriteLine(int32)");
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
