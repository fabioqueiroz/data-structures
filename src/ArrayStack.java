import java.util.EmptyStackException;

public class ArrayStack implements IStackList
{
	Object[] stack;
	int top;
	
	public ArrayStack(int initialCapacity) 
	{
		if(initialCapacity < 1) {
			throw new IllegalArgumentException("The value must be at least 1");
		}
		
		this.stack = new Object[initialCapacity];
		this.top = -1;
	}


	@Override
	public boolean isEmpty() 
	{
		return top == -1;
	}

	@Override
	public Object peek() 
	{
		if (isEmpty())
		{
			throw new EmptyStackException();
		}
		
		return stack[top];
	}

	@Override
	public void push(Object object) 
	{
		if (top == stack.length-1)
		{
			Object [] newArray= new Object[stack.length*2];
			System.arraycopy(stack, 0,newArray,0,stack.length);
			stack = newArray;
		}
		
		stack[++top] = object;
	}

	@Override
	public Object pop() 
	{
		if (isEmpty())
		{
			throw new EmptyStackException();
		}
		
		Object topObject = stack[top];
		stack[top--] = null;
		return topObject;
	}

}
