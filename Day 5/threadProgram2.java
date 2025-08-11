public class threadProgram2 {

    public static void main(String[] args) { 
        new Thread() { // creating an anonymous class
            
            // Override the run() method to define the thread's behavior
            public void run() {
                
                for (int i = 1; i <= 10; i++) {
                    System.out.println(i);
                    
                    try {
                        // pause the thread for 1 second 
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        // catch block to handle interruption during sleep
                    }
                }
            }
        }.start(); // start the thread execution
    }
}
