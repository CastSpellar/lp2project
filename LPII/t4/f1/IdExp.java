package t4.f1;

public class IdExp {
	
	private String id ;
	
	private IASTExpression exp ;
	
	public IdExp(String id, IASTExpression exp) {
		this.id = id ;
		this.exp = exp ;
	}
	
	public String getId(){
		return id ;
	}
	
	public IASTExpression getExp(){
		return exp ;
	}

}
