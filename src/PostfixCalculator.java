import java.util.Scanner;

public class PostfixCalculator 
{
	Scanner scanner;
	ArrayStack operandStack;
	ArrayStack operatorStack;
	
    public PostfixCalculator() 
    {
    	scanner = new Scanner(System.in);
    	operandStack = new ArrayStack(20);
    	operatorStack = new ArrayStack(10);  	   	
	}

    public void calculate() 
    {
    	System.out.print( "Type the equation: " );
    	String input = scanner.nextLine();
    	
    	postfixConverter(input);
    	
    	scanner.close();
    	
    }
	
    private void postfixConverter(String input)
    {
    	input = input.replaceAll("\\s+","");
    	
    	if (input.length() > 20) 
    	{
    		System.out.println("Max 20 characters");
		} 
    	
    	else 
    	{
    		@SuppressWarnings("resource")
    		Scanner eqScanner = new Scanner(input);
        	
        	while(eqScanner.hasNextLine())
        	{       		
        		Object valueTop;
				Object operator;
				Object valueBottom;
				String equation = eqScanner.nextLine().trim();
				ArrayLinearList numbers = new ArrayLinearList(10);
				ArrayLinearList operators = new ArrayLinearList(10);
        		
        		for (Character c : equation.toCharArray()) 
        		{
					// Consider only what's inside the brackets
					if(c != '(' && c != ')')
					{										
						// Push the operators into their stack
						if (c == '*' | c == '/' | c == '+') 
						{
							operatorStack.push(c);
						} 
						
						// Push the operands into their stack
						else 
						{
							operandStack.push(c);
						}																
					}
					
					// If a right bracket it found pop the last two values in the stack
					if(c == ')')
					{
						valueTop = operandStack.pop();
						operator = operatorStack.pop();
						valueBottom = operandStack.pop();
						
						// **** Concatenate and push the operands into an array/stack ****
						numbers.add(0, valueBottom.toString() + valueTop.toString());
						operandStack.push(valueBottom.toString() + valueTop.toString());
//						numbers.add(1, valueTop.toString());
						
						// Add the operator to an array
						operators.add(0, operator.toString());

						equation = valueBottom.toString() + valueTop.toString() + operator.toString();
						
					}
					
					else
					{
		
						//  Add the operator to an array
						if (c == '*' | c == '/' | c == '+') 
						{
//							operator = operatorStack.pop();
//							operators.add(1, operator.toString());
//							System.out.println(operator.toString());
						}
						
						else
						{
//							valueTop = operandStack.pop();
//							numbers.add(2, valueTop.toString());
						}
					}
        			
				} 			        		    		
        		
        		System.out.println( "output = " + equation);
        		System.out.println(numbers.outputList());
        		System.out.println(operators.outputList());
        		System.out.println("top operand: " + operandStack.peek());
        		System.out.println("top operator: " + operatorStack.peek());
        	}   
        	    	
        	eqScanner.close();
		}
    	  	
    }
}
