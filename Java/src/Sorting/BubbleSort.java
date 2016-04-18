package Sorting;

public class BubbleSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer array[]  = {5,3,21,3,2,1};
		int N= 6;
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<N;j++)
			{
				if(array[j]>array[i])
				{
					int temp = array[j];
					array[j]= array[i];
					array[i] =temp;
				}
			}
		}
		
		System.out.println(array[0]);
	}

}
