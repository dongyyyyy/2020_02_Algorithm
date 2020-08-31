import java.util.Scanner;

public class FibonacciMain {
	public static void main(String args[])
	{
		int i,num;
		Scanner input = new Scanner(System.in);
		
		System.out.print("input : ");
		num = input.nextInt();
		
		System.out.println("Recursion Method!!");
		for(i = 0 ; i <= num ; i++)
		{
			System.out.println("fibo("+i+") : "+Fibonacci_recursion(i));
		}
		
		System.out.println("Loop!!");
		for(i = 0 ; i  <= num ; i++)
		{
			System.out.println("fibo("+i+") : "+Fibonacci_loop(i));
		}
	}
	
	private static int Fibonacci_recursion (int n)
	{
		if(n<=0)
		{
			return 0;
		}
		else if(n ==1)
		{
			return 1;
		}
		else
		{
			return Fibonacci_recursion(n-1) + Fibonacci_recursion(n-2);
		}
	}
	private static int Fibonacci_loop (int n)
	{
		int sum = 0;
		
		int fibo1 = 0;
		int fibo2 = 0;
		for(int i = 0 ; i <= n ; i++)
		{
			if(i == 0)
			{
				fibo2 = 0;
				sum += fibo2;
			}
			else if(i==1)
			{
				fibo1 = 1;
				sum += fibo1;
			}
			else
			{
				sum = fibo1 + fibo2;
				fibo2 = fibo1;
				fibo1 = sum;
			}
		}
		return sum;
	}
	
}

