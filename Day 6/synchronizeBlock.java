// creating a synchronized block

class call1 {
    public void callme(String msg) { 
        System.out.print("[");
        System.out.print(msg); // prints the message 
        System.out.print("]");
        display();
    }
    // method to print numbers from 0 to 5
    public void display() {
        for(var i = 0; i<6;i++){
            System.out.print(i);
        }
    }
}

class caller extends Thread{ // class extends the thread class
    call1 obj; // shared object reference 
    String inputStr;
    caller(call1 obj,String inputStr)
    {
        this.obj = obj;
        this.inputStr = inputStr;
        start();
    }
    public void run() {
        // creating the synchronized block 
        synchronized(obj){
        obj.callme(inputStr); 
    }   
    }
}

public class synchronizeBlock {
    public static void main(String[] args) throws InterruptedException{
        call1 c = new call1();

        // creating the threads
        caller c1 =new caller(c, "Hello");
        c1.join(); // wait for c1 to finish before starting next
        caller c2 = new caller(c, "Welcome"); 
        c2.join(); // wait for c2 to finish before starting next
        caller c3 = new caller(c, "How are you?");
    }
}
