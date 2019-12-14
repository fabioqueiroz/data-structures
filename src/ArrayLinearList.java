
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
		this.size = 1; // review
	}
	
	public void checkIndex(int index)
	{
		if (index < 0 || index >= size) 
		{
			throw new IndexOutOfBoundsException("index="+ index +", size=" + size);
		}
	}
		
	@Override
	public boolean isEmpty() 
	{
		return size == 0;
	}

	@Override
	public int size() 
	{
		return size - 1; // review
	}

	@Override
	public Object get(int index) 
	{
		checkIndex(index);
		return elementArray[index];
	}

	@Override
	public int indexOf(Object object) 
	{
		for (int i= 0; i < size; i++)
		{
			if (elementArray[i].equals(object))
			{
				return i;
			}
		}
		
		return -1;	
	}

	@Override
	public void add(int index, Object object) 
	{
		checkIndex(index);
		
		if (size == elementArray.length)
		{
			Object[] newArray = new Object[elementArray.length*2];
			System.arraycopy(elementArray,0,newArray,0,elementArray.length);     
			elementArray = newArray;
		}
		
		for (int i = size - 1; i >= index; i--) 
		{
			elementArray[i + 1] = elementArray[i];
			elementArray[index] = object;
			size++;
		}		
	}

	@Override
	public Object remove(int index) 
	{
		checkIndex(index);
		
		Object removedElement = elementArray[index];
		
		for (int i = index + 1; i < size; i++) 
		{
			elementArray[i-1] = elementArray[i];
		}

		elementArray[--size] = null; 
		
		return removedElement;
	}

	@Override
	public String outputList() 
	{
		StringBuffer s = new StringBuffer("["); 
		
		for (int i = 0; i < size; i++)
		{
			if (elementArray[i] == null) 
			{
				s.append("null, ");
			}
			else
			{
				s.append(elementArray[i].toString() + ",");
			}
		}
		
		if (size > 0)        
		{
			s.delete(s.length() - 2, s.length()); 			
		}
		
		s.append("]");
		
		return new String(s);		
	}
}
