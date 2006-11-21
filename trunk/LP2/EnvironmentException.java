public class EnvironmentException extends Exception {
	static final long serialVersionUID=1L; //Compatibility with JDK 1.1.x
    public EnvironmentException() { super("Environment Exception!"); }    
    public EnvironmentException(String message) { super(message); }
}
