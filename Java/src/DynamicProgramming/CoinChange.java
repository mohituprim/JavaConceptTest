package DynamicProgramming;

public class CoinChange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CoinChange cc= new CoinChange();
		int S[] = {2,5,3,6};
		int result = cc.CoinChangeDynamic(S, 10, 4);
		System.out.println(result);
	}

	//Given a value N, if we want to make change for N cents, and we have infinite supply of each of S = { S1, S2, .. , Sm} valued coins,
	//how many ways can we make the change? The order of coins doesn’t matter.
	//For example, for N = 4 and S = {1,2,3}, there are four solutions: {1,1,1,1},{1,1,2},{2,2},{1,3}. 
	//So output should be 4. For N = 10 and S = {2, 5, 3, 6}, there are five solutions: {2,2,2,2,2}, {2,2,3,3}, {2,2,6}, {2,3,5} and {5,5}. 
	//So the output should be 5.
	public int CoinChangeRecursive(int S[], int N, int M)
	{
		if(N==0)
			return 1;
		if(N<0)
			return 0;
		if(M<=0&&N>=1)
			return 0;
		
		return CoinChangeRecursive(S, N, M-1) + CoinChangeRecursive(S, N-S[M-1], M);
	}
	
	//N=Value
	//M=No of coin
	public int CoinChangeDynamic(int S[], int n , int m)
	{
		int Totalways[][] = new int[n+1][m];
		for(int i=0;i<m;i++)
		{
			Totalways[0][i] = 1;
		}
		
		for(int i=1;i<n+1;i++)
		{
			for(int j=0;j<m;j++)
			{
	            // Count of solutions including S[j]
	           int x = (i-S[j] >= 0)? Totalways[i - S[j]][j]: 0;
	 
	            // Count of solutions excluding S[j]
	           int  y = (j >= 1)? Totalways[i][j-1]: 0;
	 
	            // total count
	            Totalways[i][j] = x + y;
			}
		}
		return Totalways[n][m-1];
	}
}
