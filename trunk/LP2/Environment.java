import java.util.*;

public class Environment implements IEnvironment{
	private Hashtable<String,Integer> dict;
	private IEnvironment prevIE = null; 
	
	Environment() { dict = new Hashtable<String,Integer>(); }
	Environment(IEnvironment e) { dict = new Hashtable<String,Integer>(); prevIE = e; }
	
	public void Assoc (String id,int val) throws Exception{
		dict.put(id, new Integer(val));
	};
	
	public int Find ( String id ) throws Exception{
		if (dict.containsKey(id)) return dict.get(id);
		else 
			if (prevIE != null) return prevIE.Find(id);
		else 
			throw new EnvironmentException();
	};
	
	public IEnvironment BeginScope() throws Exception{
		return this;
	};
	
	public IEnvironment EndScope() throws Exception{
		return this;
	};
}
