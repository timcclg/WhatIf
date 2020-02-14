import java.util.*;
import java.math.*;

public class multiplicativePersistence {
	public static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args)
	{
		System.out.println("The multiplicative persistence of a number is the amount of times all the digits of that number can be multiplied together without resulting in a single digit number");
		while(true)
		{
			BigInteger num = new BigInteger("-1");
			int count = 0;
			while(num.compareTo(new BigInteger("0")) == -1)
			{
				System.out.print("Enter a number: ");
				num = scan.nextBigInteger();
				if(num.compareTo(new BigInteger("0")) == -1)
				{
					System.out.println("Please enter a positive number.");
				}
			}
			
			while(num.compareTo(new BigInteger("10")) >= 0)
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
	
	public static BigInteger multiplyDigits(BigInteger num)
	{
		BigInteger product = num.mod(new BigInteger("10"));
		while (num.compareTo(new BigInteger("10")) >= 0)
		{
			num = num.divide(new BigInteger("10"));
			product = product.multiply(num.mod(new BigInteger("10")));
		}
		return product;
	}
}
