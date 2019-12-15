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
        		String equation = eqScanner.nextLine().trim();
        		
        		for (Character c : equation.toCharArray()) 
        		{
					// Consider only what's inside the brackets
					if(c != '(' && c != ')')
					{
						// Push the operators into their stack
						if (c == '*' | c == '/' | c == '+') 
						{
							System.out.println("operator:" + c);
						} 
						
						// Push the operands into their stack
						else 
						{
							System.out.println("operand:" + c);
						}
												
					}
        			
				} 			        		    		
        		
        		System.out.println( "output = " + equation);
        	}   
        	    	
        	eqScanner.close();
		}
    	  	
    }
}
