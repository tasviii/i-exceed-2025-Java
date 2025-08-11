class sample1 extends Thread // Inheriting the thread class
{ 
    Thread t=new Thread(this); // creating an instance of the thread
    public void run()
	{
	  t.setName("myown thread"); // setting the name of the thread
	  System.out.println("Inside run method\t"+t.getName());
	}
}

public class threadProgram1 {
    public static void main(String asd[])
	{
	 // Thread t=Thread.currentThread();
	  System.out.println("Name in Main mathod\t"+Thread.currentThread().getName()); // Getting the name of the thread
	  sample1 obj=new sample1(); // creating the object
	  obj.start(); // starting the thread execution
	} 
}
 
 
