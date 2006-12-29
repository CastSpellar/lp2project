public class Boolean{
	
	private bool value ;
	
	public Boolean(bool value){
		this.value = value ;
	}
	
	public bool getBool(){
		return value ;
	}
	
	public static Boolean and(object bool1, object bool2){
		bool b1 = ((Boolean) bool1).getBool() ;
		bool b2 = ((Boolean) bool2).getBool() ;
		return new Boolean(b1 && b2) ;
	}
}