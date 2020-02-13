import java.util.*;

public class multiplicativePersistence {
	public static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args)
	{
		System.out.println("The multiplicative persistence of a number is the amount of times all the digits of that number can be multiplied together without resulting in a single digit number");
		while(true)
		{
			long num = -1;
			int count = 0;
			while(num < 0)
			{
				System.out.print("Enter a number: ");
				num = scan.nextLong();
				if(num < 0)
				{
					System.out.println("Please enter a positive number.");
				}
			}
			
			while(num >= 10)
			{
				num = multiplyDigits(num);
				System.out.println(num);
				count++;
			}
			System.out.println("The multiplicative digital root is: " + num);
			System.out.println("The multiplicative persistence is: " + count + "\n");
			System.out.print("Would you like to continue? (y/n): ");
			String response = scan.next();
			if (response == "n")
			{
				break;
			}
		}
	}
	
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
}
