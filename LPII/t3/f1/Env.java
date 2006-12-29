package t3.f1;

import java.util.HashMap;

/**
 * Classe que implementa a Interface IEnv que representa um Ambiente.
 * Disponibiliza os m�todos necess�rios para criar um novo ambiente,
 * associar um identificador a um valor num ambiente, terminar um ambiente, etc...
 * */

public class Env implements IEnv {
	
	/**
	 * Usado para guardar os identificadores e os respectivos valores.
	 * */
	private HashMap<String, Integer> env ;
	
	/**
	 * Apontador para o ambiente imediatamente acima do corrente.
	 * */
	private IEnv prevEnv ;
	
	
	/**
	 * Construtor da classe, cria uma nova estrutura para guardar os identificadores
	 * e define o anterior como inexistente (null).
	 * */
	public Env(){
		this.prevEnv = null ;
		env = new HashMap<String, Integer>() ;
	}
	
	/**
	 * Construtor privado da classe, recebe em argumento o ambiente acima.
	 * Chamado unicamente dentro da classe no m�todo beginScope().
	 * */
	private Env(IEnv prevEnv){
		this.prevEnv = prevEnv ;
		this.env = new HashMap<String, Integer>() ;
	}

	/**
	 * M�todo que associa um identificador a um valor.
	 * */
	public void assoc(String id, int value) throws IdentifierAlreadyDefinedException{
		// TODO Auto-generated method stub
		if(env.containsKey(id))
			throw new IdentifierAlreadyDefinedException("Variable allready defined in this Enviroment...") ;
		env.put(id, value) ;
	}

	/**
	 * M�todo usado para criar um novo n�vel dentro do ambiente.
	 * */
	public IEnv beginScope() {
		// TODO Auto-generated method stub
		return new Env(this) ;
	}

	/**
	 * M�todo usado para retornar ao ambiente no n�vel acima do corrente.
	 * */
	public IEnv endScope() {
		// TODO Auto-generated method stub
		return prevEnv ;
	}

	/**
	 * M�todo usado para encontrar um identificador no ambiente. Procura primeio
	 * no ambiente corrente, se n�o encontrar procura no(s) n�vel acima.
	 * */
	public int find(String id) throws IdentifierNotFoundException{
		// TODO Auto-generated method stub
		if(env.containsKey(id))
			return env.get(id) ;
		else
			if(prevEnv != null)
				return prevEnv.find(id) ;
			else
				throw new IdentifierNotFoundException("Identifier not defined in the Enviroment.") ;
			
	}

	/**
	 * M�todo que actualiza o valor do identificador id. Gera uma excep��o se o identificador n�o
	 * estiver definido.
	 * */
	public void update(String id, int value) throws IdentifierNotFoundException{
		// TODO Auto-generated method stub
		if(env.containsKey(id))
			env.put(id, value) ;
		else
			if(prevEnv != null)
				prevEnv.update(id, value) ;
			else
				throw new IdentifierNotFoundException("Identifier not defined in the Enviroment") ;
	}
}
