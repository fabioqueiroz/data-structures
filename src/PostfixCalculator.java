import java.util.Scanner;

public class PostfixCalculator 
{
	Scanner scanner;
	ArrayStack operatorStack;
	
    public PostfixCalculator() 
    {
    	scanner = new Scanner(System.in);
    	operatorStack = new ArrayStack(10);  	   	
	}

    public void calculate() 
    {
    	System.out.print( "Type the equation: " );
    	String input = scanner.nextLine();
    	
    	postfixConverter(input);
    	
    	postfixConverter2(input);

    	scanner.close();
    	
    }
    
    private boolean isOperator(char c)
    {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '^' || c == '(' || c == ')';
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
	        			
	        			else if (c == '(') 
				        {
							operatorStack.push(c);
				        }
	        			
	        			// Pop the operators from the stack when a ')' is found
						else if (c == ')')
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
	        			
						else if (isOperator(c)) // operator encountered
				          {
				               if (!operatorStack.isEmpty() && precedence(c) <= precedence((char)operatorStack.peek())) 
				               {
				                   result.append(operatorStack.pop());
					           }
					               operatorStack.push(c);
					           
					      }
	        			
//						else
//						{
//							if(!operatorStack.isEmpty() && precedence(c) <= precedence((char)operatorStack.peek()))
//							{
//								
//								result.append((char)operatorStack.pop());
//							}
//							
//							
//							
//						}
	        				        			
	        			while (!operatorStack.isEmpty()) 
						{								
							result.append((char)operatorStack.pop());
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
	 
	
	 // NEW MODEL
	private void postfixConverter2(String input) 
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
		    Scanner eqScanner = new Scanner(input); // (x*y)+p/k // (P*Q) +(R/(S*(T^U)))
		     
			while (eqScanner.hasNextLine())
			{
			 	 String equation = eqScanner.nextLine().trim();
			    	 
			   	 for (char c : equation.toCharArray()) 
			     {
			   		 // Append to the string builder if not an operator
			         if (!isOperator(c)) 
			         {
			             result.append(c);
			         } 
			         
			         else if (c == '(') 
			         {
			           	operatorStack.push(c);
			         }
			         
			         // When a ')' is found pop it from the stack and scan until a '(' is found
			         else if (c == ')') 
			         {

			             while (!operatorStack.isEmpty() && (char)operatorStack.peek() != '(') 
			             {
			                 result.append(operatorStack.pop());
			             }
			             
			             if(!operatorStack.isEmpty())
			             {
			               	operatorStack.pop();
			             }
				                	
			          }
				            
			          // Process the other operators
			          else if (isOperator(c)) 
			          {
			               if (!operatorStack.isEmpty() && precedence(c) <= precedence((char)operatorStack.peek())) 
			               {
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
				      System.out.println("postfix = " + result.toString());
			     	}
			
				eqScanner.close();
			}
		}
			    	  		    
}
