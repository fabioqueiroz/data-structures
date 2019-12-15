
public class MainCalculator {

	public static void main(String[] args) 
	{
		//System.out.println("working");
		
		ArrayLinearList numbers = new ArrayLinearList(5);
		
//		numbers.add(0, 1);
//		numbers.add(1, 2);
		
		for (int i = 0; i < 5; i++) 
		{
			numbers.add(i, i + 1);			
		}
		
		System.out.println(numbers.size());
		System.out.println(numbers.outputList());

	}

}
