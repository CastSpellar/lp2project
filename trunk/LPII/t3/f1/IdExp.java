package t3.f1;

public class IdExp {
	
	private String id ;
	
	private IASTNode exp ;
	
	public IdExp(String id, IASTNode exp) {
		this.id = id ;
		this.exp = exp ;
	}
	
	public String getId(){
		return id ;
	}
	
	public IASTNode getExp(){
		return exp ;
	}

}
