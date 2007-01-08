package tf;

import java.util.LinkedList;
import java.util.List;

public class ASTRecord implements IASTExpression {

	private List<IdExp> records;

	public ASTRecord() {
		records = new LinkedList<IdExp>();
	}

	public void addRec(String id, IASTExpression exp) {
		records.add(new IdExp(id, exp));
	}

	public IVal evaluate(IEnv env) {
		// TODO Auto-generated method stub
		RecordVal r = new RecordVal();
		for (IdExp i : records)
			r.add(i.getId(), i.getExp().evaluate(env));
		return r;
	}

	public void gen(CodeSeq code, ICodeEnv env) {
		// TODO Auto-generated method stub

	}

}
