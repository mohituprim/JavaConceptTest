import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test {

	public static void main(String[] args) throws IOException {
		
		String input = "krkrrk";
		int r=0;
		int k=0;
		int maxr=0;
		int maxk=0;
		for(int i=0;i<input.length();i++)
		{
			if(input.charAt(i)=='k'&&r!=0)
			{
				k++;
				maxr=r;
				maxk=k;
			}
			else if(input.charAt(i)=='r')
				r++;
		}
		
		int result=Integer.max(maxr, maxk);
		
		System.out.println(result);
		/*// TODO Auto-generated method stub
		String input = "a02b3c2a1";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//String input = br.readLine();
		String words[] = input.split("(?<=\\d)(?=\\D)|(?<=\\D)(?=\\d)|('_')");
		
		List<Character> output = new ArrayList<Character>();
		for(int i=0;i<words.length;)
		{
			int loop = Integer.parseInt(words[i+1]);
			for(int j=0;j<loop;j++)
			{
				output.add(words[i].toCharArray()[0]);
			}
			i=i+2;
		}
		
		for(int i=0;i<output.size();i++)
		{
			for(int j=0;j<output.size();j++)
			{
				if(output.get(j)>output.get(i))
				{
					char temp1 = output.get(i);
					char temp2 = output.get(j);
					output.remove(i);
					output.add(i, temp2);
					output.remove(j);
					output.add(j, temp1);
				}
			}
		}
		String line = br.readLine();
        int N = Integer.parseInt(line);
        for (int i = 0; i < N; i++) {
            line = br.readLine();
            int k =Integer.parseInt(line);
            if(k>=0&&k<output.size())
            {
            	System.out.println(output.get(k));
            }
        }*/
	}

}
