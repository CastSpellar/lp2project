package t4.f1;

public interface IEnv {
	
	IEnv beginScope() ;
	
	IEnv endScope() ;
	
	void assoc(String id, IVal value) ;
	
	void update(String id, IVal value) ;
	
	IVal find(String id) ;

}
