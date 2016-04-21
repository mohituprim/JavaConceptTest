package DataStructure;

import java.util.ArrayList;

import java.util.Queue;

public class QueueQuestion {

	class PetrolDistance{
		int petrol;
		int distance;
		PetrolDistance(int petrol, int distance)
		{
			this.petrol=petrol;
			this.distance=distance;
		}
	}
	
	//Find the first circular tour that visits all petrol pumps
	int PrintTour(ArrayList<PetrolDistance> petrolPumps)
	{
		// Consider first petrol pump as a starting point
		int size =petrolPumps.size();
		int start=0;
		int end=0;
		int currentPetrol= petrolPumps.get(start).petrol-petrolPumps.get(start).distance;
	    /* Run a loop while all petrol pumps are not visited.
	      And we have reached first petrol pump again with 0 or more petrol */
		while(start!=end||currentPetrol<0)
		{
	        // If curremt amount of petrol in truck becomes less than 0, then
	        // remove the starting petrol pump from tour
			while(currentPetrol<0&&start!=end)
			{
		          // Remove starting petrol pump. Change start
				currentPetrol-=petrolPumps.get(start).petrol-petrolPumps.get(start).distance;
				start=(start+1)%size;
	            // If 0 is being considered as start again, then there is no
	            // possible solution
				if(start==0)
					return -1;
			}
			// Add a petrol pump to current tour
			currentPetrol+=petrolPumps.get(end).petrol-petrolPumps.get(end).distance;
			
			end=(end+1)%size;
		}
		return start;
	}
	
	//An Interesting Method to Generate Binary Numbers from 1 to n
	void GenerateBinary(int n)
	{
		Queue<String> q = null;
		q.add("1");
		while(n-->0)
		{
			String s1= q.peek();
			q.remove();
			System.out.println(s1+",");
			
			String s2=s1;
			q.add(s1.concat("1"));
			q.add(s2.concat("0"));
			
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
