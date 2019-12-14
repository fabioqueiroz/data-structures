
public class ArrayLinearList implements ILinearList
{
	protected Object[] elementArray;
	protected int size;
	
	public ArrayLinearList(int initialCapacity) 
	{
		if(initialCapacity < 1) {
			throw new IllegalArgumentException("The value must be at least 1");
		}

		this.elementArray = new Object[initialCapacity];
	}
		
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object get(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int indexOf(Object object) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void add(int index, Object object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object remove(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String outputlist() {
		// TODO Auto-generated method stub
		return null;
	}

}
