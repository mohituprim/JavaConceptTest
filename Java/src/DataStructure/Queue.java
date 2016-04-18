package DataStructure;

public class Queue {

	int front;;
	int rear;;
	int capacity;
	int array[];
	int size;
	
	Queue(int capacity)
	{
		this.front=-1;
		this.rear=-1;
		this.capacity=capacity;
		this.array = new int[capacity];
		this.size=0;
		
	}
	
	boolean isFull()
	{
		if(this.size==this.capacity)
			return true;
		return false;
		
	}
	
	boolean isEmpty()
	{
		if(this.size==0)
			return true;
		return false;
	}
	
	void Enqeue(int data)
	{
		if(isFull())
			return;

			this.rear = (this.rear + 1)%this.capacity;
			this.array[this.rear]=data;
			this.size++;
	}
	
	int Dequue()
	{
		if(isEmpty())
			return Integer.MIN_VALUE;
		int item = this.array[this.front];
		this.front= (this.front+1)%this.capacity;
		this.size--;
		return item;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
