package DataStructure;
import java.util.Stack;

public class StackQuestion {

	void ReverseStackUsingRecursion(Stack st)
	{
		int item;
		if(!st.empty())
		{
			item=(int) st.pop();
			ReverseStackUsingRecursion(st);
			InsertAtBottom(st, item);
		}
	}
	
	void InsertAtBottom(Stack st, int element)
	{
		if(st.empty())
			st.push(element);
	    else
	    {
	 
	        /* Hold all items in Function Call Stack until we
	           reach end of the stack. When the stack becomes
	           empty, the isEmpty(*top_ref)becomes true, the
	           above if part is executed and the item is inserted
	           at the bottom */
	        int temp = (int) st.pop();
	        InsertAtBottom(st, element);
	 
	        /* Once the item is inserted at the bottom, push all
	           the items held in Function Call Stack */
	        st.push(temp);
	    }
	}
	
	// Recursive function to insert an item x in sorted way
	void sortedInsert(Stack s, int x)
	{
	    // Base case: Either stack is empty or newly inserted
	    // item is greater than top (more than all existing)
	    if (s.isEmpty() || x > (int)s.peek())
	    {
	        s.push(x);
	        return;
	    }
	 
	    // If top is greater, remove the top item and recur
	    int temp = (int)s.pop();
	    sortedInsert(s, x);
	 
	    // Put back the top item removed earlier
	   s.push(temp);
	}
	 
	// Function to sort stack
	void sortStack(Stack s)
	{
	    // If stack is not empty
	    if (!s.isEmpty())
	    {
	        // Remove the top item
	        int x = (int)s.pop();
	 
	        // Sort remaining stack
	        sortStack(s);
	 
	        // Push the top item back in sorted stack
	        sortedInsert(s, x);
	 
	    }
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<Integer> st = new Stack<Integer>();
		st.push(10);
		st.push(15);
		st.push(20);
		StackQuestion  sq = new StackQuestion();
		sq.ReverseStackUsingRecursion(st);
	}

}
