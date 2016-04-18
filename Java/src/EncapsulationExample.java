
public class EncapsulationExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EncapsulationExample encap = new EncapsulationExample();
	      encap.setName("James");
	      encap.setAge(20);
	      encap.setIdNum("12343ms");

	      System.out.print("Name : " + encap.getName() + " Age : " + encap.getAge());
	}
	
	//Encapsulation in Java is a mechanism of wrapping the data (variables) and code acting on the data (methods) together as as single unit.
	//In encapsulation the variables of a class will be hidden from other classes, and 
	//can be accessed only through the methods of their current class, therefore it is also known as data hiding.
	   private String name;
	   private String idNum;
	   private int age;

	   public int getAge(){
	      return age;
	   }

	   public String getName(){
	      return name;
	   }

	   public String getIdNum(){
	      return idNum;
	   }

	   public void setAge( int newAge){
	      age = newAge;
	   }

	   public void setName(String newName){
	      name = newName;
	   }

	   public void setIdNum( String newId){
	      idNum = newId;
	   }
}