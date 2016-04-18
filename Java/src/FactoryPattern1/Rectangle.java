package FactoryPattern1;
//Create concrete classes implementing the same interface.
public class Rectangle implements Shape {


	   @Override
	   public void draw() {
	      System.out.println("Inside Square::draw() method.");
	   }
}
