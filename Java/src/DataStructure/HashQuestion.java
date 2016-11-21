package DataStructure;
import java.util.ArrayList;
import java.util.HashSet;

public class HashQuestion {

	boolean CheckDuplicatesWithInKDistance(ArrayList<Integer> input, int k)
	{
		HashSet<Integer> hashSet = new HashSet<>(k);
		for(int i=0;i<input.size();i++)
		{
			if(hashSet.contains(input.get(i)))
				return true;
			if(i>=k)
			{
				hashSet.remove(input.get(i-k));
			}
		}
		return false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
