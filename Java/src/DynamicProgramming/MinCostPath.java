package DynamicProgramming;

//Given a cost matrix cost[][] and a position (m, n) in cost[][], write a function that returns cost of minimum cost path to reach (m, n) from (0, 0). 
//Each cell of the matrix represents a cost to traverse through that cell. Total cost of a path to reach (m, n) is sum of all the costs on that path (including both source and destination). 
//You can only traverse down, right and diagonally lower cells from a given cell, i.e., from a given cell (i, j), cells (i+1, j), (i, j+1) and (i+1, j+1) can be traversed. 
//You may assume that all costs are positive integers.
public class MinCostPath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		   int cost[][] = new int[][]{ {1, 2, 3},{4, 8, 2},{1, 5, 3} };
		   
		   MinCostPath mcp =  new MinCostPath();
		   int x = mcp.DynamicMCP(cost, 2, 2);
		   System.out.println(x);
  	}
	
	public int MinCostPathNaive(int cost[][], int m, int n, int i, int j)
	{
		if(i>m||j>n)
			return Integer.MAX_VALUE;
		if(i==m&&j==n)
			return cost[i][j];
		else
			return cost[i][j] + Integer.min(MinCostPathNaive(cost, m , n, i+1, j+1), Integer.min(MinCostPathNaive(cost, m , n, i, j+1), MinCostPathNaive(cost, m , n, i+1, j)));
		
	}
	
	public int MinCostPathNaiveAnotherWay(int cost[][], int m, int n)
	{
		if(n<0||m<0)
			return Integer.MAX_VALUE;
		if(m==0&&n==0)
			return cost[m][n];
		else
			return cost[m][n] + Integer.min(MinCostPathNaiveAnotherWay(cost, m-1 , n-1), Integer.min(MinCostPathNaiveAnotherWay(cost, m-1 , n), MinCostPathNaiveAnotherWay(cost, m , n-1)));
		
	}

	public int DynamicMCP(int cost[][], int m, int n)
	{
		int TotalCost[][] = new int[m+1][n+1];
		TotalCost[0][0] = cost[0][0];
		
		for(int i=1;i<=m;i++)
			TotalCost[i][0] = TotalCost[i-1][0]+cost[i][0];
		for(int j=1;j<=n;j++)
			TotalCost[0][j] = TotalCost[0][j-1]+cost[0][j];
		for(int i=1;i<=m;i++)
			for(int j=1;j<=m;j++)
				TotalCost[i][j] = cost[i][j]+Integer.min(TotalCost[i-1][j-1], Integer.min(TotalCost[i-1][j], TotalCost[i][j-1]));
		
		return TotalCost[m][n];
	}
}
