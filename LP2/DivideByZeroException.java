public class DivideByZeroException extends Exception {
	static final long serialVersionUID=3L; 
    public DivideByZeroException() { super("Divide By Zero Exception"); }
    public DivideByZeroException(String message) { super(message); }
}
