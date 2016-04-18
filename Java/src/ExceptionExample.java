import java.io.IOException;

public class ExceptionExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExceptionExample ee = new ExceptionExample();
		ee.runTimeException();
	}
	
	public int runTimeException()
	{
		//At a time only one exception can occur, only one catch block can be executed.
		try
		{
			//AirthMetic Exception
			int a = 70/0;
			//Null pointer Exception
			String s = null;
			System.out.println(s.length());
			//Array Index Out Of bound exception
			int array[] = new int[3];
			array[3]=90;
		}
		catch(ArithmeticException e)
		{
			//specific to arithmetic exception
			System.out.println(e);
		}
		catch(NullPointerException e)
		{
			//specific to Null pointer exception
			System.out.println(e);
		}
		catch (Exception e)
		{
			//catch other common exception
			System.out.println(e);
		}
		finally{
			//will not be executed if program exits by calling system.exit() or by causing fatal error
			System.out.println("Always executed at end");
		}
		//for each try ... only one finally is possible
		//finally
		//{
			
		//}
		try
		{
			return 100;
		}
		finally
		{
			System.out.println("finally for second try");
			// return the finally block value as it has greater priority
			//return 200;
		}

	}
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//////////Throw Keyword Example//////////////////////////////////////////////////////////////////////////////////////////////////////////
	//throw keyword is used to explicitly throw an exception , can throw checked or unchecked exception, mainly used to throw custom exception.
	//can be used to interrupt the program.
	void validateNumber(int no){
		if(no==0)
			throw new ArithmeticException("sorry its zero");
		else
			System.out.println("welcome");
	}
	//Exception propagation//////////////////
	//By Default Unchecked Exception are forwarded in calling chain
	//Checked Exception are not propagated
	//so following example will check handler in a , b ,c.
	void c()
	{
		//checked exception(using throw keyword we are throwing checked exception)
		//should be handled here
		//throw new IOException("device error");
		//above line will give compile time error while handled one will execute
		try
		{
		throw new IOException("device error");
		}
		catch (Exception e)
		{
			
		}
		
		//Unchecked exception(using throw keyword)
		//so this will propagate and will try to find the handler in b , a.
		throw new ArithmeticException("arithmetic exception");
	}
	void b()
	{
		c();
	}
	
	void a()
	{
		b();
	}

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//////////Throws Keyword Example//////////////////////////////////////////////////////////////////////////////////////////////////////////
	//throws is used to declare an exception
	//it gives an information to programmer that exception may occur so try to handle it
	//Use of Throws
	// 1- Unchecked Exception = under programmer's control
	// 2- Error = Beyond control
	// 3- Checked = so throws is used to declare checked exception so they might be occur or not
	//Advantage 
	//using throws checked exception can be propagated
	
	//Rule
	//if you are calling i.e. declared with throws...you must either declare or handle the exception
	//Declared in z
	void z() throws IOException{
		throw new IOException("device error");
	}
	
	//Declared in y
	void y() throws IOException{
		z();
	}
	//Handled in x
	void x()
	{
		try{
			y();
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	//not handled so give compile time errot
	void xy()
	{
		//calling y which is calling z and z is throwing an exception so must be handled or declare
		//y();
	}
	//if we declare the exception and not handling the exception .... it means error can occur
}
