package DynamicProgramming;

public class LongestPalindromeSubSequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int LongestPalindromeSubSequenceRecursive(String input, int i, int j)
	{
		 // Base Case 1: If there is only 1 character
		if(i==j)
			return 1;
		 // Base Case 2: If there are only 2 characters and both are same
		if((i+1==j)&&(input.charAt(i)==input.charAt(j)))
			return 2;
		 // If the first and last characters match
		if(input.charAt(i)==input.charAt(j))
		{
			return LongestPalindromeSubSequenceRecursive(input, i+1, j+1)+2;
		}		
		
		// If the first and last characters do not match
		return Integer.max(LongestPalindromeSubSequenceRecursive(input, i, j-1), LongestPalindromeSubSequenceRecursive(input, i+1, j));
	}
	
	public int LongestPalindromeSubSequenceDynamic(String input)
	{
		int length = input.length();
		int Dp[][] = new int[length][length];
		for(int i=0;i<length;i++)
			Dp[i][i]=1;
		
		// Build the table. Note that the lower diagonal values of table are
	    // useless and not filled in the process. The values are filled in a
	    // manner similar to Matrix Chain Multiplication DP solution (See
		// cl is length of substring
		for(int cl=2;cl<length;cl++)
		{
			for(int i=0; i<length-cl+2;cl++)
			{
				int j=i+cl-1;
				if(input.charAt(i)==input.charAt(j)&&cl==2)
					Dp[i][j]=2;
				else if(input.charAt(i)==input.charAt(j))
					Dp[i][j]= Dp[i+1][j-1]+2;
				else
					Dp[i][j] =Integer.max(Dp[i][j-1], Dp[i+1][j]);
			}
		}
		
		return Dp[0][length-1];
	}
}

