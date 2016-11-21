package DynamicProgramming;

public class Fibonacci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printFibonacciRecursively();
	}
	
	static void printFibonacciRecursively()
	{
		Fibonacci f = new Fibonacci();
		f.FibonacciUsingDpBootomUp(5);

	}
	
	int FibonacciRecursively(int number)
	{
		if(number<=1)
			return 1;
		
		return FibonacciRecursively(number-1) + FibonacciRecursively(number-2);
	}
	
	void FibonacciUsingDpBootomUp(int number)
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
	
	private static final int NIL=-1;
	private static final int MAX=100;
	Integer lookUp[] = new Integer[MAX];
	
	void _initialize()
	{
	  int i;
	  for (i = 0; i < MAX; i++)
		  lookUp[i] = NIL;
	}
	
	int FibonacciUsingDpTopDown(int N)
	{
		
		if(lookUp[N]==NIL)
		{
			if(N<=1)
				lookUp[N]=N;
			else
				lookUp[N]=lookUp[N-1]+lookUp[N-1];
		}
		
		return lookUp[N];
	}

}
