package DataStructure;

public class LinkedList {

	//Head of List
	Node head;
	
	class Node
	{
		int data;
		Node next;
		
		//constructor to create a new node
		Node(int d){
			this.data = d;
			next=null;
		}
	}
	
	//insert at front
	public void insert(int new_data)
	{
		Node node = new Node(new_data);
		node.next =head;
		head =node;
		
	}
	
	public void inserAtEnd(int new_data)
	{
		Node newNode = new Node(new_data);
		
		if(head==null)
		{
			head=newNode;
			return;
		}
		Node temp = head;
		while(temp.next!=null)
		{
			temp=temp.next;
		}
		temp.next = newNode;
		newNode.next=null;
	}
	
	public void InsertAfterGivenNode(Node prevNode, int data)
	{
		if(prevNode==null)
		{
			System.out.println("Previous Node can not be Null");
			return;
		}
		Node newNode = new Node(data);
		
		newNode.next=prevNode.next;
		prevNode.next=newNode;
		
		//looping over is required for position insert 
		/*Node temp=head;
		while(temp.next!=prevNode)
			temp=temp.next;
		
		newNode.next=temp.next;
		temp.next=newNode;*/
		
		
	}
	
	public void DeleteGivenNode(Node givenNode)
	{
		if(givenNode==null)
		{
			System.out.println("Given Node to delete can not be Null");
			return;
		}	
		
		if(head==null)
		{
			return;
		}	
			
		Node temp = head;
		while(temp.next!=givenNode)
		{
			temp=temp.next;
		}
		temp.next=givenNode.next;
		
	}
	
	public Node ReverseALinkeListRecursive(Node current, Node prev)
	{
		if(head==null)
			return null;
		//Last Node Make it head
		if(current.next==null)
		{
			head=current;
			current.next=prev;
			return null;
		}
		
		Node next1 = current.next;
		current.next=prev;
		ReverseALinkeListRecursive(next1, current);
		return head;
		
	}
	
	public Node ReverseALinkeListIterative(Node current)
	{
		Node prev = null;
		Node next;
		while(current.next!=null)
		{
			next=current.next;
			current.next=prev;
			prev=current;
			current=next;
		}
		if(current.next==null)
		{
			current.next=prev;
		}
		head=current;
		return head;
	}
	
	public Node ReverseALinkedListInGroupOfGivenSizeIterative(Node start, int size)
	{
		Node prev=null;
		Node current=start;
		Node next=null;
		int count=0;
		while(current!=null&&count<size)
		{
				next=current.next;
				current.next=prev;
				prev=current;
				current=next;
				count++;
		}
		if(next!=null)
			head.next=ReverseALinkedListInGroupOfGivenSizeIterative(next, size);
		head = prev;
		return head;
	}
	
    // This function rotates a linked list counter-clockwise
    // and updates the head. The function assumes that k is
    // smaller than size of linked list. It doesn't modify
    // the list if k is greater than or equal to size
    void rotatebyK(int k)
    {
        if (k == 0) return;
 
        // Let us understand the below code for example k = 4
        // and list = 10->20->30->40->50->60.
        Node current  = head;
 
        // current will either point to kth or NULL after this
        // loop. current will point to node 40 in the above example
        int count = 1;
        while (count < k && current !=  null)
        {
            current = current.next;
            count++;
        }
 
        // If current is NULL, k is greater than or equal to count
        // of nodes in linked list. Don't change the list in this case
        if (current == null)
            return;
 
        // current points to kth node. Store it in a variable.
        // kthNode points to node 40 in the above example
        Node kthNode = current;
 
        // current will point to last node after this loop
        // current will point to node 60 in the above example
        while (current.next != null)
            current = current.next;
 
        // Change next of last node to previous head
        // Next of 60 is now changed to node 10
 
        current.next = head;
 
        // Change head to (k+1)th node
        // head is now changed to node 50
        head = kthNode.next;
 
        // change next of kth node to null
        kthNode.next = null;
 
    }
    
    int detectLoop()
    {
        Node slow_p = head, fast_p = head;
        while (slow_p != null && fast_p != null && fast_p.next != null) {
            slow_p = slow_p.next;
            fast_p = fast_p.next.next;
            if (slow_p == fast_p) {
                System.out.println("Found loop");
                removeloop(slow_p);
                System.out.println("loop Removed");
                return 1;
            }
        }
        return 0;
    }
    
    //http://www.geeksforgeeks.org/detect-and-remove-loop-in-a-linked-list/
    void removeloop(Node loopNode)
    {
    	Node start_p = head;
        while (loopNode != start_p.next) {
        	loopNode = loopNode.next;
        	start_p = start_p.next;
        }

        /* since fast->next is the looping point */
        start_p.next = null; /* remove loop */
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

			LinkedList ll = new LinkedList();
			//Node k= ll.head;
			
			ll.insert(10);
			ll.insert(5);
			ll.inserAtEnd(15);
			ll.InsertAfterGivenNode(ll.head.next, 7);
			ll.ReverseALinkeListIterative(ll.head);
			ll.ReverseALinkeListRecursive(ll.head, null);
//			ll.DeleteGivenNode(ll.head.next);
	}

}
