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

    	scanner.close();
    	
    }
    
    private boolean isOperator(char c)
    {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '^' || c == '(' || c == ')';
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
	 
	
	private void postfixConverter(String input) 
	{
		// Ensure there are no spaces in the equation
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
			               if (!operatorStack.isEmpty() && precedence((char)operatorStack.peek()) >= precedence(c)) 
			               {
			                   result.append(operatorStack.pop());
				           }
				               operatorStack.push(c);
				      }
				   }

			   	  // Remove the remaining operators from the stack
				  while (!operatorStack.isEmpty()) 
				  {
				       result.append(operatorStack.pop());
				  }
				        
				  System.out.println("___________________");
				  System.out.println("infix = " + input);
				  System.out.println("postfix = " + result.toString());
			    }
			
				eqScanner.close();
			}
		}			    	  		    
}
