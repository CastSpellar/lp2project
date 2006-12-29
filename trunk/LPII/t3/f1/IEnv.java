package t3.f1;

public interface IEnv {
	
	IEnv beginScope() ;
	
	IEnv endScope() ;
	
	void assoc(String id, int value) ;
	
	void update(String id, int value) ;
	
	int find(String id) ;

}
