
public class MyJavaTest {
	

	//object is not requires to call static method
	//can be used to change the common property of all objects
	//static method belongs to class, not to object of a class
	//static method can access static member and can change the value also
	public static void main( String [] arg)
	{
		
		System.out.println("Hello Main");
		main(12);
	}
	//static variable is used to refer the common property of all objects
	//gets the memory once in class area
	static int staticVar = 10;
	int nonstatictest = 70;
	//Overloading main method
	public static void main( int input)
	{
		//Non static variable or method can not be accessed from static context
		//System.out.println(nonstatictest);
		System.out.println("Hello overloaded main of integer input");
	}
	
	//Static block test
	//static block will execute before main at the time of class loading
	//static block will execute as appeared in program
	static {
		
		System.out.println("Static blocak will execute before main method");
		//Execute a program without main (i.e. exit from static block)
		//System.exit(0);
	}
	
	static {
		
		System.out.println("Static blocak will execute before main method1");
	}
}
