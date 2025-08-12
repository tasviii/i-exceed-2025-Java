// class extends the thread class
class sample3 extends Thread{
    @Override
    public void run(){ // overrides the run method
        for(var i=1;i<11;i++) // starts the iteration from 1 to 10
        {
            // prints the name of the thread along with the iteration
            System.out.println(currentThread().getName()+"Iteration "+i); 
            if(i==5) {  // checks if the iterator equals 5
                Thread.yield(); // if it is 5 then the thread can be paused and another thread can run
                // it is decided by the job scheduler
            }
        }
    }
}

class yieldThread{
public static void main(String[] args) throws InterruptedException { 

    sample3 obj = new sample3();  // creating the first thread
    obj.start();  // starting the thread

    sample3 obj2 = new sample3(); // create the second thread
    obj2.start(); // starting the second thread

    for (int i = 0; i<10;i++) {
        System.out.println("Main thread running"); // running the main thread
        Thread.sleep(1000);  // sleeps for a second

    }    
}
}