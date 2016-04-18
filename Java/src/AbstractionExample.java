
public class AbstractionExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Factory pattern is more suitable example for abstraction 
		//Abstract
		TestEx abs = new TestEx();
		abs.message();
		//Interface
		InterfaceTest ift = new InterfaceTest();
		ift.print();
		
		
	}

}

///////////////////////////////Abstraction achieved by abstract class////////////////////////////////////////////
//can not create object of abstract class
abstract class absTest{
	
	//can have constructor also
	absTest()
	{
		System.out.println("abstract class constructor");
	}
	//abstract method which do not have body
	abstract void message();
	//abstract class can have the concrete method also
	void display(){System.out.println("Concrete method of abstract class");}
	
	//can have data member also
	int data = 40;
	
	//can not use static with abstract
	//static abstract void stmsg();
	
}

//if extending abstract class means we need to either declare the class as abstract or provide the implementation for all abstract method
class TestEx extends absTest {
	
	void message() 
	{	
		System.out.println("abstract method implemented Test");
	}
	
}

///////////////////////////////Abstraction achieved by interface ////////////////////////////////////////////
//achieves 100 % abstraction through interface
//Interface is just a blue print of a class that have final , static data member and abstract method
//class extend class, class implements interface,  interface extend interface

//interface supports multiple inheritance because there is no ambiguity  
interface printable
{
	void print();
	void commonmethod();
}
interface showable
{
	void show();
	void commonmethod();
}
//can be possible if we do'nt want to implement the method of interface
	//abstract class InterfaceTest implements printable, showable
	//{
		
	//}
class InterfaceTest implements printable, showable
{
	@Override
	public void print() {
		// TODO Auto-generated method stub
		System.out.println("impelementing the print method of printable");
	}
	@Override
	public void show() {
		// TODO Auto-generated method stub
		System.out.println("impelementing the show method of showable");
	}
	
	///providing the implementation of common method in child class only so there will be only one implementation and no ambiguity
	@Override
	public void commonmethod() {
		// TODO Auto-generated method stub
		System.out.println("impelementing the common method to show multiple inheritance example");
	}
}

