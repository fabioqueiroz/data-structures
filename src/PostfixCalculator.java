import java.util.Scanner;

public class PostfixCalculator 
{
	Scanner scanner;
    public PostfixCalculator() 
    {
    	scanner = new Scanner(System.in);
    	   	
	}

    public void calculate() 
    {
    	System.out.print( "Type the equation: " );
    	String input = scanner.nextLine();
    	System.out.println( "input = " + input );
    	
    	postfixConverter(input);
    	
    	scanner.close();
    	
    }
	
    private void postfixConverter(String input)
    {
    	@SuppressWarnings("resource")
		Scanner eqScanner = new Scanner(input);
    	
    	while(eqScanner.hasNextLine())
    	{
    		String lineOfText = eqScanner.nextLine().trim();
    		
    		if (lineOfText.startsWith("(")) 
    		{
				System.out.println("'(' found");
			}
    		
    		else
    		{
    			System.out.println("'(' NOT found");
    		}
    	}
    	
    	eqScanner.close();
    }
}
