package DynamicProgramming;

public class LongestCommonSubSequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String x= "AGGTAB";
		String y= "GXTXAYB";
		LongestCommonSubSequence lcs = new LongestCommonSubSequence();
		int result = lcs.dynamicproLCS(x, y, x.length(), y.length());
		System.out.println(result);
	}
	
	//Naive approach
	
	public int recursiveLCS(String x, String y, int m, int n)
	{
		if(m==0||n==0)
			return 0;
		if(x.charAt(m-1)==y.charAt(n-1))
			return 1+recursiveLCS(x, y, m-1, n-1);
		else
			return Integer.max(recursiveLCS(x, y, m-1, n), recursiveLCS(x, y, m, n-1));
	}
	
	//Dynamic programming approach
	
	public int dynamicproLCS(String x, String y, int m , int n)
	{
		Integer lcs[][] = new Integer[m+1][n+1];
		
		for(int i=0; i<m+1; i++)
		{
			for(int j=0; j<n+1; j++)
			{
				if(i==0||j==0)
					lcs[i][j]=0;
				else if(x.charAt(i-1)==y.charAt(j-1))
				{
					lcs[i][j] = lcs[i-1][j-1]+1;
				}
				else
				{
					lcs[i][j] = Integer.max(lcs[i-1][j], lcs[i][j-1]);
				}
				
			}
		}
		
		return lcs[m][n];
	}

}
