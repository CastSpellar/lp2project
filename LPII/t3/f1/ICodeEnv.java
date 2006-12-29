package t3.f1;

public interface ICodeEnv {
	
	/**
	 * M�todo invocado para criar um novo n�vel no ambiente.
	 * */
	ICodeEnv beginScope() ;
	
	
	/**
	 * M�todo invocado para retornar ao n�vel acima do ambiente.
	 * */
	ICodeEnv endScope() ;
	
	/**
	 * M�todo usado para retornar a posi��o do identificador dado
	 * por argumento.
	 * */
	int find(String id) ;
	
	/**
	 * M�todo invocado para carregar uma nova vari�vel no ambiente
	 * retorna a posi��o.
	 * */
	int newVar(String id) ;
	
	/***/
	int getMax() ;
	
	/***/
	void setMaxVar(int var) ;
	
	/***/
	int getCurrVar() ;

}
