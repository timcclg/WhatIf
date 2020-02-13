//What is the rate of the calculation?
//Does shifting (not widening) the range increase calculation time?
//Does number of trials also affect the time?
import java.util.*;
public class simulationv2 {
	
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
		int trials;
		double[] times;
		double averageTime = 0;
		double rate;
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
		
		//input # of trials
		System.out.print("Enter the number trials: ");
		trials = scan.nextInt();
		times = new double[trials];
		
		//start trials (gathering data)
		for(int i = 0; i < trials; i++)
		{
			long startTime = System.nanoTime(); //start timer
			//check numbers
			for(long num = min; num <= max /*9223372036854775807L*/; num++)
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
			times[i] = elapsedTime;
		}
		
		//calculating average time
		for (double i : times)
		{
			averageTime += i;
		}
		averageTime /= times.length;
		
		rate = (max - min + 1)/averageTime; //calculating rate of calculation with average time
		
		//outputs
		System.out.println("Ran " + (max - min + 1) + " numbers between " + min + " and " + max);
		System.out.println("The average time of running this range for " + trials + " trials is: " + averageTime);
		System.out.println("The range/averageTime gives a rate of " + rate + " numbers/second");
	}
}
