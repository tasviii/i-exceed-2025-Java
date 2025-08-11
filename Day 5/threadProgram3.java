class threadJoin extends Thread{
    Thread t=new Thread(this); // Creating a new instance of a thread
     public void run()
	{
	   for(var i=0;i<10;i++)
		{
		    try{
			System.out.println(i);
			t.sleep(1000);  // Pauses the thread for 1 second
			}catch(InterruptedException d){} // To catch the exception 
		} 
	}

}

public class threadProgram3 {
    public static void main(String[] args) throws InterruptedException
     {
	     threadJoin obj1=new threadJoin();  // Creating the objects
	     threadJoin obj2=new threadJoin();
	     threadJoin obj3=new threadJoin();
 
	     obj1.start(); // The thread starts after this
         obj1.join();  // Wait for obj1 to finish before starting obj2
         
	     obj2.start(); 
	     obj2.join();
 
	     obj3.start();
    
    }
}


