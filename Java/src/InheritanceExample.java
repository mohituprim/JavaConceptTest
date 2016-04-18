
public class InheritanceExample {

	public InheritanceExample() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String [] args)
	{
			//Runtime polymorphism that is why it will call Dog's printAnimalCharacter
			// also called dynamic binding
			//Animal animal = new Dog();
			//animal.printAnimalCharacter();
		
			//This is fine
			//Animal animal = new Animal();
			//animal.onlyAnimalClassMethod();
			//but following is not correct because type is Animal although object is of Dog class
			//Animal animal = new Dog();
			//animal.onlyDogClassMethod();
			//using casting we call child class method that is not present in parent class
			//((Dog) animal).onlyDogClassMethod();
		
			//RunTime polymorphism can not be achieved by data member
			//Animal a = new Dog();
			//System.out.println(a.data);
		
			//static method can not be overidden
		
			//if there is any private , final or static method in class, it is static binding
	}
}

								/*Use of super Example*/
//public class can be defined only in own file
 class Animal
{
	String color = "red";
	
	String data = "animal"; 
	
	Animal()
	{
		System.out.println("Animal constructor");
	}
	void printAnimalCharacter()
	{
		System.out.println("Animal character");
	}
	
}

class Dog extends Animal
{
	String color = "white";
	
	String data = "Dog";
	Dog()
	{
		//using to refer parent class constructor
		//if you append super than compiler will not provide default one
		//this and super can not be used in static context
		//argument of super should match with parent class constructor in both case that is implictly or explictly invoking super 
		super();
		
		System.out.println("Dog Constructor");
	}
	public void  printColor()
	{
		System.out.println(color);
		//super is used to refer immediate parent class instance variable
		System.out.println(super.color);
		//super can be used to invoke parent class method
		super.printAnimalCharacter();
	}
	void printAnimalCharacter()
	{
		System.out.println("Dog character");
	}
	
	void onlyDogClassMethod()
	{
		
	}

}
								/*Use of final Example*/
//if a class is final we can not inherit it
final class  Fclass
{

	// final variable means it is constant
	final int finalVar= 5;
	
	//variable declared as final but not assigned any value called blank final variable
	final int blankFinalVar;

	Fclass()
	{
		//already assigned,  can not be changed
		//fvar =9;
		
		//value can be only assigned in constructor
		blankFinalVar = 9;
	}
	
	//if a method is final we can not override it
	
	
}

