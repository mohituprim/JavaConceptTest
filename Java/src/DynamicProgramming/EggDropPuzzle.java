package DynamicProgramming;

public class EggDropPuzzle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
	//Case 1
	//If the egg breaks after dropping from xth floor, then we only need to check for floors lower than x with remaining eggs; 
	//so the problem reduces to x-1 floors and n-1 eggs
	//case 2
	//If the egg doesn’t break after dropping from the xth floor, then we only need to check for floors higher than x; 
	//so the problem reduces to k-x floors and n eggs.
	
	int EggDrop(int eggs, int floor)
	{
		if(floor==0||floor==1)
			return floor;
		if(eggs==1)
			return floor;		
		int min = Integer.MAX_VALUE;
		for(int i=1;i<=floor;i++)
		{
			int result = Integer.max(EggDrop(eggs-1, floor-1) , EggDrop(eggs, floor-i) );
			if(result<min)
				min=result;
		}
		return min+1;
	}
	
	int EggDropByDp(int eggs, int floor)
	{
		int eggFloor[][] = new int[eggs+1][floor+1];
		
		 // We need one trial for one floor and 0 trials for 0 floors
	    for (int i = 1; i <= eggs; i++)
	    {
	        eggFloor[i][1] = 1;
	        eggFloor[i][0] = 0;
	    }
	    
	 // We always need j trials for one egg and j floors.
	    for (int j = 1; j <= floor; j++)
	        eggFloor[1][j] = j;

	    for (int i = 2; i <= eggs; i++)
	    {
	        for (int j = 2; j <= floor; j++)
	        {
	            eggFloor[i][j] = Integer.MAX_VALUE;
	            for (int x = 1; x <= j; x++)
	            {
	               int  res = 1 + Integer.max(eggFloor[i-1][x-1], eggFloor[i][j-x]);
	                if (res < eggFloor[i][j])
	                    eggFloor[i][j] = res;
	            }
	        }
	    }
	    // eggFloor[n][k] holds the result
	    return eggFloor[eggs][floor];
	}

}
