package DynamicProgramming;

public class Fibonacci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printFibonacciRecursively();
	}
	
	static void printFibonacciRecursively()
	{
		Fibonacci f = new Fibonacci();
		f.FibonacciUsingDp(5);

	}
	
	int FibonacciRecursively(int number)
	{
		if(number<=1)
			return 1;
		
		return FibonacciRecursively(number-1) + FibonacciRecursively(number-2);
	}
	
	void FibonacciUsingDp(int number)
	{		
		int[] array = new int[number+1];
		array[0]=1;
		array[1]=1;
		
		for(int i=2; i<number; i++)
		{
			array[i] = array[i-1]+array[i-2];
		}
		
		for(int i=0; i<number; i++)
		{
			System.out.println(array[i]);
		}
		
	}

}
