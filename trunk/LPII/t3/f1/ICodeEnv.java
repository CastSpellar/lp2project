package t3.f1;

public interface ICodeEnv {
	
	/**
	 * Método invocado para criar um novo nível no ambiente.
	 * */
	ICodeEnv beginScope() ;
	
	
	/**
	 * Método invocado para retornar ao nível acima do ambiente.
	 * */
	ICodeEnv endScope() ;
	
	/**
	 * Método usado para retornar a posição do identificador dado
	 * por argumento.
	 * */
	int find(String id) ;
	
	/**
	 * Método invocado para carregar uma nova variável no ambiente
	 * retorna a posição.
	 * */
	int newVar(String id) ;
	
	/***/
	int getMax() ;
	
	/***/
	void setMaxVar(int var) ;
	
	/***/
	int getCurrVar() ;

}
