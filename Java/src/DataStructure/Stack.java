package DataStructure;

public class Stack {

	int top;
	int capacity;
	int array[];
	
	Stack(int capacity)
	{
		this.top=-1;
		this.capacity=capacity;
		this.array = new int[capacity];
	}
	
	boolean isFull(Stack stack)
	{
		if(stack.top==stack.capacity-1)
			return true;
		return false;
	}
	
	boolean isEmapty(Stack stack)
	{
		if(stack.top==-1)
			return true;
		return false;
	}
	
	void push(Stack stack, int data)
	{
		if(isFull(stack))
			return;
			
		stack.array[++stack.top]=data;
	}
	
	void pop(Stack stack)
	{
		if(isEmapty(stack))
			return;
		--stack.top;
	}
	
	int peek(Stack stack)
	{
		if(isEmapty(stack))
			return Integer.MIN_VALUE;
		return stack.array[stack.top];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack stack = new Stack(10);
		
		stack.push(stack, 2);
		stack.push(stack, 5);
		stack.peek(stack);
		stack.pop(stack);
	}

}
