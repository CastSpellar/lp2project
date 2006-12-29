package tf;

public interface IEnv {
	
	IEnv beginScope() ;
	
	IEnv endScope() ;
	
	void assoc(String id, IVal value) ;
	
	void update(String id, IVal value) ;
	
	IVal find(String id) ;
	
	int getNDecls() ;

}
