package DataStructure;
import java.util.ArrayList;
public class HeapQuestion {
	
	public class BinaryMinHeap
	{
		int heapSize;
		ArrayList<Integer> heapArray;
		
		BinaryMinHeap()
		{
			this.heapSize=0;
			this.heapArray=null;
		}
		
		int parent(int index)
		{
			return (index-1)/2;
		}
		
		int left(int index)
		{
			return (2*index+1);
		}
		
		int right(int index)
		{
			return (2*index-1);
		}
		
		public void insertKey(int key)
		{
			heapArray.add(key);
			heapSize++;
			int i=heapSize-1;
			// Fix the min heap property if it is violated
			while(i!=0&&(heapArray.get(parent(i))>heapArray.get(i)))
			{
				//swap the element
				int temp=heapArray.get(parent(i));
				heapArray.set(parent(i), heapArray.get(i));
				heapArray.set(i, temp);
				i=parent(i);
				
			}
		}
		
		public void decreaseKey(int index, int newKey)
		{
			heapArray.set(index, newKey);
			// Fix the min heap property if it is violated
			while(index!=0&&(heapArray.get(parent(index))>heapArray.get(index)))
			{
				//swap the element
				int temp=heapArray.get(parent(index));
				heapArray.set(parent(index), heapArray.get(index));
				heapArray.set(index, temp);
				index=parent(index);
				
			}
		}
	
		public int extractMin()
		{
			if(heapSize<=0)
				return Integer.MAX_VALUE;
			if(heapSize==1)
			{
				heapSize--;
				return heapArray.remove(0);
			}
			
			// Store the minimum vakue, and remove it from heap
			int root = heapArray.get(0);
			heapArray.set(0, heapArray.get(heapSize-1));
			heapSize--;
			MinHeapify(0);
			
			return root;
		}

		// A recursive method to heapify a subtree with root at given index
		// This method assumes that the subtrees are already heapified
		public void MinHeapify(int i) {
			int l=left(i);
			int r=right(i);
			int smallest=i;
			if(l<heapSize&&heapArray.get(l)<heapArray.get(i))
			{
				smallest=l;
			}
			if(r<heapSize&&heapArray.get(r)<heapArray.get(i))
			{
				smallest=r;
			}
			if(smallest!=i)
			{
				//swap the element
				int temp=heapArray.get(i);
				heapArray.set(i, heapArray.get(smallest));
				heapArray.set(smallest, temp);
				
				MinHeapify(smallest);
			}
		}
		
		// This function deletes key at index i. It first reduced value to minus
		// infinite, then calls extractMin()
		public  void deleteKey(int index)
		{
			decreaseKey(index, Integer.MIN_VALUE);
			extractMin();
		}
		
		//using minheap so it will sort in descending order
		public void heapSort()
		{
			// Build heap (rearrange array)
			for(int i=heapSize/2-1;i>=0;i--)
			{
				MinHeapify(i);
			}
			
			// One by one extract an element from heap
	        for (int i=heapSize-1; i>=0; i--)
	        {
	            // Move current root to end
	            int temp = heapArray.get(0);
	            heapArray.set(0, heapArray.get(i));
	            heapArray.set(i, temp);
	 
	            heapSize--;
	            // call max heapify on the reduced heap
	            MinHeapify(0);
	        }
			
		}
		
	}
	
	public BinaryMinHeap  UseBinaryMinHeap()
	{
		return new BinaryMinHeap();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HeapQuestion hq = new HeapQuestion();
		BinaryMinHeap bmh = hq.UseBinaryMinHeap();
	}

}
