package tf;

public class IntVal implements IVal {

	private int val;

	public IntVal(int val) {
		this.val = val;
	}

	public int getVal() {
		return val;
	}

	public String toString() {
		return new Integer(val).toString();
	}

}
