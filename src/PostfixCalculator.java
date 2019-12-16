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
    
    private boolean isOperator(char c)
    {
        return c == '+' || c == '-' || c == '*' || c == '/'|| c == '^' || c == '(' || c == ')';
    }
    

	private static boolean isLowerPrecedence(char op1, char op2)
	{
	    switch (op1)
	    {
	        case '+':
	        case '-':
	            return !(op2 == '+' || op2 == '-');
	
	        case '*':
	        case '/':
	            return op2 == '^' || op2 == '(';
	
	        case '^':
	            return op2 == '(';
	
	        case '(':
	            return true;
	
	        default:
	            return false;
	    }
	}
	 

//	 private void postfixConverter(String input)
//	    {
//	    	input = input.replaceAll("\\s+","");
//	    	
//	    	if (input.length() > 20) 
//	    	{
//	    		System.out.println("Max 20 characters");
//			} 
//	    	
//	    	else 
//	    	{
//	    		StringBuilder result = new StringBuilder(input.length()); 
//	    	
//	    		@SuppressWarnings("resource")
//	    		Scanner eqScanner = new Scanner(input); // (x*y)+p/k
//	        	
//	        	while(eqScanner.hasNextLine())
//	        	{       		
//	        		Object valueTop;
//					Object operator;
//					Object valueBottom;
//					String equation = eqScanner.nextLine().trim();
//	        		
//	        		for (Character c : equation.toCharArray()) 
//	        		{
//						// Consider only what's inside the brackets
//						if(c != '(' && c != ')')
//						{										
//							// Push the operators into their stack
//							if (c == '*' | c == '/' | c == '+') 
//							{
//								operatorStack.push(c);
//							} 
//							
//							// Push the operands into their stack
//							else 
//							{
//								operandStack.push(c);
//							}																
//						}
//						
//						// If a right bracket it found pop the last two values in the stack
//						if(c == ')')
//						{
//							valueTop = operandStack.pop();
//							operator = operatorStack.pop();
//							valueBottom = operandStack.pop();
//
//							// Add the operator to an array
//							result.append(valueBottom.toString());
//							result.append(valueTop.toString());
//							result.append(operator.toString());
//
//						}
//						
//						else
//						{
//							System.out.println("else statement");
//						}
//	        			
//					} 			        		    		
//	        		
//	        		System.out.println("output = " + result);
//	        		System.out.println("top operand: " + operandStack.peek());
//	        		System.out.println("top operator: " + operatorStack.peek());
//	        	}   
//	        	    	
//	        	eqScanner.close();
//			}
//	    	  	
//	    }
	 
	// only using the operator stack
	 private void postfixConverter(String input)
	    {
	    	input = input.replaceAll("\\s+","");
	    	
	    	if (input.length() > 20) 
	    	{
	    		System.out.println("Max 20 characters");
			} 
	    	
	    	else 
	    	{
	    		StringBuilder result = new StringBuilder(input.length()); 
	    	
	    		@SuppressWarnings("resource")
	    		Scanner eqScanner = new Scanner(input); // (x*y)+p/k
	        	
	        	while(eqScanner.hasNextLine())
	        	{       		

					String equation = eqScanner.nextLine().trim();
	        		
	        		for (char c : equation.toCharArray()) 
	        		{
	        			// Append to the string builder if not an operator
	        			if(!isOperator(c))
	        			{
	        				result.append(c);
	        			}
	        			
						else
						{
							// Pop the operators from the stack when a ')' is found
							if (c == ')')
							{								
								while (!operatorStack.isEmpty() && (char) operatorStack.peek() != '(')
			                    {
									result.append((char)operatorStack.pop());
			                    }
								
								if (!operatorStack.isEmpty())
				                {
									operatorStack.pop();
				                }
							}

							else
							{
								// Push the operator into the stack
								if(c!= '(')
								{
									operatorStack.push(c);
									System.out.println("operator in the stack: " + operatorStack.peek());
								}
								
								while(!operatorStack.isEmpty()) 
								{
									result.append((char)operatorStack.pop());
								}
								
							}
							
						}
	        			
					} 	
	        		
	        		System.out.println("___________________");
	        		System.out.println("output = " + result);
//	        		System.out.println("top operator: " + operatorStack.peek());

	        	}   
	        	    	
	        	eqScanner.close();
			}
	    	  	
	    }
	 
	 private int precedence(Object object){
        switch ((char)object){
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }	 
}
