package t3.f1;

import java.util.HashMap;

/**
 * Classe que implementa a Interface IEnv que representa um Ambiente.
 * Disponibiliza os métodos necessários para criar um novo ambiente,
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
	 * Chamado unicamente dentro da classe no método beginScope().
	 * */
	private Env(IEnv prevEnv){
		this.prevEnv = prevEnv ;
		this.env = new HashMap<String, Integer>() ;
	}

	/**
	 * Método que associa um identificador a um valor.
	 * */
	public void assoc(String id, int value) throws IdentifierAlreadyDefinedException{
		// TODO Auto-generated method stub
		if(env.containsKey(id))
			throw new IdentifierAlreadyDefinedException("Variable allready defined in this Enviroment...") ;
		env.put(id, value) ;
	}

	/**
	 * Método usado para criar um novo nível dentro do ambiente.
	 * */
	public IEnv beginScope() {
		// TODO Auto-generated method stub
		return new Env(this) ;
	}

	/**
	 * Método usado para retornar ao ambiente no nível acima do corrente.
	 * */
	public IEnv endScope() {
		// TODO Auto-generated method stub
		return prevEnv ;
	}

	/**
	 * Método usado para encontrar um identificador no ambiente. Procura primeio
	 * no ambiente corrente, se não encontrar procura no(s) nível acima.
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
	 * Método que actualiza o valor do identificador id. Gera uma excepção se o identificador não
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
