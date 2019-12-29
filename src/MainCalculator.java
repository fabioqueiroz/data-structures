
public class MainCalculator {

	public static void main(String[] args) 
	{	
//		// ArrayStack
//		System.out.println("Array Stack tests:");
//				
//		ArrayStack stack = new ArrayStack(5);
//				
//		for (int i = 0; i < 6; i++) 
//		{
//			stack.push(i);			
//		}
//		
//		System.out.println(stack.peek());
//
//		stack.pop();
//		
//		System.out.println(stack.peek()); 
//		
//		System.out.println("_________________");		
//		System.out.println("");
		
		// Postfix
//		System.out.println("Postfix tests:");
		
		PostfixCalculator pc = new PostfixCalculator();
		
		pc.calculate();
		
		
			

	}
}
