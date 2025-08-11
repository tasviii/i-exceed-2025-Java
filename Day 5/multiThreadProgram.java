class sample3 extends Thread

{
    public void run() // Creating the run function
	{
	  for(var i=0;i<10;i++)
	   {
	     try{  // try and catch block to catch the interruption exception
	      System.out.println(i);
	      new Thread(this).sleep(1000);
	     }catch(Exception d){}

	   }
	}
}
 
// the main method
public class multiThreadProgram {

    public static void main(String ads[]) throws InterruptedException  // to catch the exception
	{
	   sample3 obj=new sample3(); // creating the object
	   obj.start(); // Starting the thread execution
	   for(var i=0;i<10;i++)
		{	
		   System.out.println("main\t"+i);
		   Thread.currentThread().sleep(1000);  // pausing the thread for 1 second
		}
	} 
}