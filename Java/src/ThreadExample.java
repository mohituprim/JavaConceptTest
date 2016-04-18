
public class ThreadExample {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		//Who makes your class object as thread object?
			//Thread class constructor allocates a new thread object.When you create object of Multi class,
			//your class constructor is invoked(provided by Compiler) from where Thread class constructor is invoked(by super() as 
			//first statement).So your Multi class object is thread object now.
		Multi t1=new Multi();  
		//start() method of Thread class is used to start a newly created thread. It performs following tasks:
			//A new thread starts(with new callstack).
			//The thread moves from New state to the Runnable state.
			//When the thread gets a chance to execute, its target run() method will run.
		t1.start();  //so no need to invoke run() explicitly
		//After starting a thread, it can never be started again. If you does so, an IllegalThreadStateException is thrown
		//t1.start();
		
		//If you are not extending the Thread class,your class object would not be treated as a thread object.
		//So you need to explicitely create Thread class object.
		//We are passing the object of your class that implements Runnable so that your class run() method may execute.
		Multi2 m1=new Multi2();  
		Thread t2 =new Thread(m1);  
		t2.start();  
		
		//What if we call run() method directly instead start() method?
		//Invoking the run() method from main thread, the run() method goes onto 
		//the current call stack rather than at the beginning of a new call stack.
		Multi t3=new Multi();  
		t3.run();//fine, but does not start a separate call stack  
		
		//join throws InterruptedException so handle or declare
		t2.join();
		//The join() method waits for a thread to die. In other words, 
		//it causes the currently running threads to stop executing until the thread it joins with completes its task.
		
		//Note: If you want to make a user thread as Daemon, it must not be started otherwise it will throw IllegalThreadStateException.
		//t1.setDaemon(true);//will throw exception here  
	}
	//There are two ways to create a thread:
		// 1- By extending Thread class
			//Thread class provide constructors and methods to create and perform operations on a thread.
			//Thread class extends Object class and implements Runnable interface.
		// 2- By implementing Runnable interface.
			//The Runnable interface should be implemented by any class whose instances are intended to be executed by a thread.
			//Runnable interface have only one method named run().


}

//By extending Thread class:
class Multi extends Thread{  
	public void run(){  
	System.out.println("thread implented by thread class is running...");  
	} 
}

//By implementing the Runnable interface:
class Multi2 implements Runnable{  
	public void run(){  
	System.out.println("thread implemented by runnable is running...");  
	} 
}