package tf;

import java.util.HashMap;

public class CodeEnv implements ICodeEnv {

	private ICodeEnv prev;

	private int currVar;

	private int maxVar;

	private HashMap<String, Integer> table;

	public CodeEnv() {
		prev = null;
		currVar = 0;
		maxVar = 0;
		table = new HashMap<String, Integer>();
	}

	protected CodeEnv(ICodeEnv prev, int currVar, int maxVar) {
		this.prev = prev;
		this.currVar = currVar;
		this.maxVar = maxVar;
		table = new HashMap<String, Integer>();
	}

	public ICodeEnv beginScope() {
		// TODO Auto-generated method stub
		return new CodeEnv(this, 0, maxVar);
	}

	public ICodeEnv endScope() {
		// TODO Auto-generated method stub
		prev.setMaxVar(maxVar);
		return prev;
	}

	public int getCurrentLevel() {
		int result = 0;
		CodeEnv current = this;
		while (current != null) {
			current = (CodeEnv) current.prev;
			result++;
		}
		return result;
	}

	public int[] find(String id) {
		// TODO Auto-generated method stub
		int[] result = new int[2];
		result[0] = -1;
		result[1] = -1;
		CodeEnv current = this;
		for (int i = 0; i < getCurrentLevel(); i++) {
			if (current.table.containsKey(id)) {
				result[0] = i;
				result[1] = current.table.get(id);
				return result;
			}
			else
				current = (CodeEnv) current.prev ;
		}
		return result;
		/*
		 * if(table.containsKey(id)) return table.get(id) ; else if (prev !=
		 * null) return prev.find(id) ; else //Gerar Excepção System.exit(0) ;
		 * return 0;
		 */
	}

	public int getCurrVar() {
		// TODO Auto-generated method stub
		return currVar;
	}

	public int getMax() {
		// TODO Auto-generated method stub
		return maxVar;
	}

	public int newVar(String id) {
		// TODO Auto-generated method stub
		table.put(id, currVar);
		if (maxVar <= currVar)
			maxVar++;
		return currVar++ ;//currVar++;
	}

	public void setMaxVar(int var) {
		// TODO Auto-generated method stub
		maxVar = var;
	}

}
