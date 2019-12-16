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
    	
    	convertToPostfix(input);

    	scanner.close();
    	
    }
    
    private boolean isOperator(char c)
    {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '^' || c == '(' || c == ')';
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
							// Push the operators into the stack
//							operatorStack.push(c); // trial
//							System.out.println("1) operator in the stack: " + operatorStack.peek());
							
							// Pop the operators from the stack when a ')' is found
							if (c == ')')
							{								
								while (!operatorStack.isEmpty() && (char)operatorStack.peek() != '(')
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
								if(!operatorStack.isEmpty() && precedence(c) <= precedence((char)operatorStack.peek()))
								{
									
									result.append((char)operatorStack.pop());
								}
								
								//operatorStack.push(c);

								// Push the operator into the stack except '('
								if(c != '(')
								{
									
									operatorStack.push(c);
									//System.out.println("operator in the stack: " + operatorStack.peek());
//									System.out.println("precedence char: " + precedence(c));
//									System.out.println("precedence peek: " + precedence((char)operatorStack.peek()));
								}
								
//								while(!operatorStack.isEmpty()) 
//								{								
//									result.append((char)operatorStack.pop());
//								}
							}
							while(!operatorStack.isEmpty()) 
							{								
								result.append((char)operatorStack.pop());
							}
						}
	        			
					} 	
	        		
	        		System.out.println("___________________");
	        		System.out.println("output = " + result);
	        	}   
	        	    	
	        	eqScanner.close();
			}
	    	  	
	    }
	 
	 private int precedence(char c)
	 {
        switch (c)
        {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
            case ')':
                return 4;
        }
        return -1;
    }	 
	 
	 // WORKING MODEL
	private String convertToPostfix(String input) 
    {
		 input = input.replaceAll("\\s+","");
		 StringBuilder result = new StringBuilder(input.length());
	     char c;

         for (int i = 0; i < input.length(); i++) 
         {
	            c = input.charAt(i);

	            if (!isOperator(c)) 
	            {
	                result.append(c);
	            } 
	            else if (c == '(') 
	            {
	            	operatorStack.push(c);
	            }
	            // If the scanned character is an ‘)’, pop and output from the stack
	            // until an ‘(‘ is encountered.
	            else if (c == ')') 
	            {

	                while (!operatorStack.isEmpty() && (char)operatorStack.peek() != '(') 
	                {
	                    result.append(operatorStack.pop());
	                }
	                if (!operatorStack.isEmpty() && (char)operatorStack.peek() != '(')
	                {
	                	return null;
	                }
	                    
	                else if(!operatorStack.isEmpty())
	                {
	                	operatorStack.pop();
	                }
	                	
	            }
	            
	            else if (isOperator(c)) // operator encountered
	            {
	                if (!operatorStack.isEmpty() && precedence(c) <= precedence((char)operatorStack.peek())) {
	                    result.append(operatorStack.pop());
	                }
	                operatorStack.push(c);
	            }
	        }

	        while (!operatorStack.isEmpty()) 
	        {
	            result.append(operatorStack.pop());
	        }
	        
	        System.out.println("___________________");
	        System.out.println("result = " + result.toString());
	        return result.toString();
	    }
	    	  		    
}
