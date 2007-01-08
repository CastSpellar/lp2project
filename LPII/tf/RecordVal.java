package tf;

import java.util.HashMap;

public class RecordVal implements IVal {

	private HashMap<String, IVal> records;

	public RecordVal() {
		records = new HashMap<String, IVal>();
	}

	public void add(String id, IVal val) {
		records.put(id, val);
	}

	public IVal getRecord(String id) {
		return records.get(id);
	}

}
