package DynamicProgramming;

public class LngstIncrsngSqns {

	// length of LIS for { 10, 22, 9, 33, 21, 50, 41, 60, 80 } is 6 and LIS is {10, 22, 33, 50, 60, 80}.
	Integer array[] = {10, 22, 9, 33, 21, 50, 41, 60, 80};
	int N = 9;

	public static void main(String[] args)
	{
		LngstIncrsngSqns lis = new LngstIncrsngSqns();
		int result = lis.bruteForceLIS();
		System.out.println(result);
		
	}
	
	public int dpLIS()
	{
		Integer lis[] = new Integer[N];
		int max=0;
		/* Initialize LIS values for all indexes */
		for(int i=0;i<N;i++)
		{
			lis[i]=1;
		}
	
	   /* Compute optimized LIS values in bottom up manner */
	   for (int i = 1; i < N; i++ )
	      for (int j = 0; j < i; j++ )
	         if ( array[i] > array[j] && lis[i] < lis[j] + 1)
	            lis[i] = lis[j] + 1;
	   
	   /* Pick maximum of all LIS values */
	   for (int i = 0; i < N; i++ )
	      if ( max < lis[i] )
	         max = lis[i];
		   
		return max;
	}
	public int bruteForceLIS()
	{
		int maxlis=0;
		
		for(int i=0;i<N;i++)
		{
			int count=1;
			int last = array[i];
			for(int j=i+1;j<N;j++)
			{
				if(array[j]>last)
				{
					last=array[j];
					count++;
				}
			}
			if(count>maxlis)
				maxlis=count;
		}
		return maxlis;
	}
}

