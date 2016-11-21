package StringTest;

public class StringPermutations {

	public String swap(String str, int l, int r)
	{
		char[] input = str.toCharArray();
		char x= input[l];
		input[l]= input[r];
		input[r]= x;
		return input.toString();
	}
	public void printAllPermutations(String str, int start, int end)
	{
		if(start==end)
			System.out.println(str);
		else
		{
			for(int i=start;i<=end;i++)
			{
				str = swap(str, start, i);
				printAllPermutations(str, start+1, end);
				str = swap(str, start, i); //backtrack
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
