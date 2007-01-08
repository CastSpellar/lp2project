package tf;

public class StringVal implements IVal {

	private String val;

	public StringVal(String val) {
		this.val = val;
	}

	public String toString() {
		return val;
	}

}
