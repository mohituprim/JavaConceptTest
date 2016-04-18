package DynamicProgramming;

public class KnapSack01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int val[] = {60, 100, 120};
	    int wt[] = {10, 20, 30};
	    int  W = 50;
	    int N= val.length;
	    KnapSack01  ks01 = new KnapSack01();
	    int result = ks01.KnapSackDynamic(wt, val, N, W);
	    System.out.println(result);
	}
	
	public int KnapSack(int Weight[], int Value[], int N, int W)
	{
		if(N==0||W==0)
			return 0;
		if(Weight[N-1]>W)
			return KnapSack(Weight, Value, N-1, W);
		else return Integer.max(Value[N-1]+KnapSack(Weight, Value, N-1, W-Weight[N-1]), KnapSack(Weight, Value, N-1, W));
	}

	public int KnapSackDynamic(int Weight[], int Value[], int N, int W)
	{
		int MaxTotalValue[][] = new int[N+1][W+1];
		for(int i=0;i<=N;i++)
		{
			for(int w=0;w<=W;w++)
			{
				if(i==0||w==0)
					MaxTotalValue[i][w]=0;
				else if(Weight[i-1]<=w)
					MaxTotalValue[i][w] = Integer.max(Value[i-1]+MaxTotalValue[i-1][w-Weight[i-1]], MaxTotalValue[i-1][w]);
				else
					MaxTotalValue[i][w] = MaxTotalValue[i-1][w];
					
			}
		}
		
		return MaxTotalValue[N][W];
	}
}
