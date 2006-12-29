package tf;

import java.util.Vector;

public class ArrayVal implements IVal {
	
	private Vector<CellVal> array;

	public ArrayVal(int size, IVal initVal){
		array = new Vector<CellVal>();
		for(int i = 0; i < size; i++)
			array.add(i, new CellVal(initVal));
	}
	
	public Vector<CellVal> getArray(){
		return array;
	}
	
	public IVal getVal(int pos){
		return array.get(pos);
	}
	
	public IVal length(){
		return new IntVal(array.size());
	}

}
