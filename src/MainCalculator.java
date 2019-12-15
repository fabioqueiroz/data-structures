
public class MainCalculator {

	public static void main(String[] args) 
	{
		// Array
		System.out.println("ArrayList tests:");		
		ArrayLinearList numbers = new ArrayLinearList(5);
		
		for (int i = 0; i < 5; i++) 
		{
			numbers.add(i, i + 1);			
		}
		
		System.out.println(numbers.size());
		System.out.println(numbers.outputList());
		
		System.out.println(numbers.get(2));
		
		numbers.remove(2);
		
		System.out.println(numbers.outputList());
		System.out.println(numbers.get(2));
		System.out.println("_________________");
		
		System.out.println("");
		
		// ArrayStack
		System.out.println("Array Stack tests:");
				
		ArrayStack stack = new ArrayStack(5);
				
		for (int i = 0; i < 6; i++) 
		{
			stack.push(i);			
		}
		
		System.out.println(stack.peek());

		stack.pop();
		
		System.out.println(stack.peek());

	}
}
