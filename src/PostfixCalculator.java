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
    	
    	// call postfixConverter()
    }
	
    private void postfixConverter(String input)
    {
    	
    }
}
