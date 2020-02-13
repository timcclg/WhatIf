//What is the smallest number with the greatest persistent between 0 and an upper limit
//What is the smallest number with the greatest persistence in a certain lower and upper limit? 
import java.util.*;
public class simulation {
	
	public static long multiplyDigits(long num)
	{
		long product = num % 10;
		while (num >= 10)
		{
			num /= 10;
			product *= num % 10;
		}
		return product;
	}
	
	public static void main(String[] args) throws InterruptedException
	{
		//variables
		long number = 0;
		int persistence = 0;
		long max = 9223372036854775807L;
		long min = 0;
		String input;
		Scanner scan = new Scanner(System.in);
		
		//upper and lower limit inputs
		System.out.print("Enter the upper limit (\"max\" if max value): ");
		input = scan.next();
		if (input.equals("max")) {}
		else
		{
			max = Long.parseLong(input);
		}
		System.out.print("Enter the lower limit: ");
		min = scan.nextLong();
		
		long startTime = System.nanoTime(); //start timer
		
		//check numbers
		for(long num = min; num <= max /*9223372036854775807L*/; num++) //29247 centuries - 100,000 digits per second
		{
			System.out.println(num);
			int count = 0;
			long temp = num;
			while(temp >= 10)
			{
				temp = multiplyDigits(temp);
				count++;
			}
			
			if(count > persistence)
			{
				number = num;
				persistence = count;
			}
		}
		
		long endTime = System.nanoTime(); //stop timer
		
		//calculate time elapsed
		double elapsedTime = (endTime-startTime)/1000000000.0;
		
		//outputs
		System.out.println("The number with the greatest persistence is: " + number);
		System.out.println("The multiplicative persistence is: " + persistence);
		System.out.println("The time elapsed in seconds is: " + elapsedTime);
	}
}
