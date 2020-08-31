import java.util.Scanner;


public class FactorialMain {
	public static void main(String args[])
	{
		int num;
		
		Scanner input = new Scanner(System.in);

		System.out.print("input : ");
		num = input.nextInt();
		
		System.out.println("loop Factorial("+num+") : "+Factorial_loop(num));
		System.out.println("Recursion Factorial("+num+") : "+Factorial_recursion(num));
		
	}
	
	private static int Factorial_loop(int n)
	{
		int sum = 1;
		for(int i = 1 ; i <=n; i++)
		{
			sum *= i;
		}
		
		return sum;
	}
	
	private static int Factorial_recursion (int n)
	{
		if(n<=1)
		{
			return 1;
		}
		else
		{
			return n*Factorial_recursion(n-1);
		}
		
	}
	
}



