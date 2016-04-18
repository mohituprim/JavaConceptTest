package DynamicProgramming;

public class EditDistance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    String str1 = "sunday";
	    String str2 = "saturday";
	    EditDistance ed = new EditDistance();
	    int result = ed.EditDistanceRecursive(str1, str2, str1.length(), str2.length());
	    System.out.println(result);
	}

	//Given two strings str1 and str2 and operations (i.e. remove, replace, insert)that can performed on str1. 
	//Find minimum number of edits (operations) required to convert ‘str1′ into ‘str2′
	public int EditDistanceRecursive(String x, String y, int m, int n)
	{
		if(m==0)
			return n;
		else if(n==0)
			return m;
		
		else if(x.charAt(m-1)==y.charAt(n-1))
			return EditDistanceRecursive(x, y, m-1, n-1);
		
		//Replace m-1, n-1
		//insert m , n-1
		//Remove m-1 n
		return 1 +Integer.min(Integer.min(EditDistanceRecursive(x, y, m, n-1), EditDistanceRecursive(x, y, m-1, n)), EditDistanceRecursive(x, y, m-1, n-1));
	}
	
	public int EditDistanceDynamicProgramming(String x, String y, int m, int n)
	{
		Integer dpArray[][] = new Integer[m+1][n+1];
		
		for(int i=0; i<=m; i++)
		{
			for(int j=0; j<=n; j++)
			{
				if(i==0)
					dpArray[i][j]=j;
				else if(j==0)
					dpArray[i][j]=i;
				else if(x.charAt(i-1)==y.charAt(j-1))
					dpArray[i][j] = dpArray[i-1][j-1];
				else
					dpArray[i][j] = 1+Integer.min(Integer.min(dpArray[i][j-1],dpArray[i-1][j]), dpArray[i-1][j-1]);
				
			}
		}
		return dpArray[m][n];
	}
}

