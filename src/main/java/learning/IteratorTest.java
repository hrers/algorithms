package learning;

import java.util.Iterator;


public class IteratorTest<E>  implements Iterator<E>{
	public E[] val;
	public int cursor;

	public IteratorTest(E[] val) {
		this.val = val;
	}

	@Override
	public boolean hasNext() {
		if(cursor<val.length)
			return true;
		return false;
	}

	@Override
	public E next() {
		if(hasNext())
			return val[cursor++];
		return null;
	}

}
