public class Integer{
	
	private int value ;
	
	public Integer(int value){
		this.value = value ;
	}
	
	public int getInt(){
		return value ;
	}
	
	public static Integer add(object int1, object int2){
		int n1 = ((Integer) int1).getInt() ;
		int n2 = ((Integer) int2).getInt() ;
		return new Integer(n1 + n2) ;
	}
	
	public static Integer sub(object int1, object int2){
		int n1 = ((Integer) int1).getInt() ;
		int n2 = ((Integer) int2).getInt() ;
		return new Integer(n1 - n2) ;
	}
	
	public static Integer div(object int1, object int2){
		int n1 = ((Integer) int1).getInt() ;
		int n2 = ((Integer) int2).getInt() ;
		return new Integer(n1 / n2) ;
	}
	
	public static Integer mul(object int1, object int2){
		int n1 = ((Integer) int1).getInt() ;
		int n2 = ((Integer) int2).getInt() ;
		return new Integer(n1 * n2) ;
	}
	
	public static bool equals(object int1, object int2){
		return ((Integer) int1).getInt() == ((Integer) int2).getInt() ;
	}
	
	public static bool greater(object int1, object int2){
		return ((Integer) int1).getInt() > ((Integer) int2).getInt() ;
	}
}