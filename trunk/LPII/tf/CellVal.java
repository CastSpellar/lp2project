package tf;

public class CellVal implements IVal {
	
	private IVal val ;
	
	public CellVal(IVal val){
		this.val = val ;
	}
	
	public IVal getVal(){
		return val ;
	}
	
	public void setVal(IVal val){
		this.val = val ;
	}
	
	public String toString(){
		return val.toString() ;
	}

}
