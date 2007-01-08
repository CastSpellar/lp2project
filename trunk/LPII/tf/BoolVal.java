package tf;

public class BoolVal implements IVal {

	private boolean val;

	public BoolVal(boolean val) {
		this.val = val;
	}

	public boolean getVal() {
		return val;
	}

	public String toString() {
		return new Boolean(val).toString();
	}

}
