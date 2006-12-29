
public class Cell{
	private int value ;
	
	public Cell(int value){
		this.value = value ;
	}
	
	public object getVal(){
		return new Integer(value) ;
	}
	
	public void setVal(object val){
		value = ((Integer) val).getInt() ;
	}
}