class call { // creating a class called call
    synchronized public void callme(String msg) { // creating a synchronized method
        System.out.print("["); 
        System.out.print(msg);  // printing the message 
        System.out.print("]"); 
    }
}

class caller extends Thread{  // extending the thread class 
    call obj;  // reference to the shared 'call' object
    String inputStr;
    caller(call obj,String inputStr)
    {
        this.obj = obj;
        this.inputStr = inputStr;
        start(); // starting the thread 
    }
    public void run() {
        obj.callme(inputStr); // sendind the string argument to the callme method
       
    }
}

public class synchronizeThread {
    public static void main(String[] args) {
        call c = new call(); // creating an object
        // create and start three threads, all sharing the same 'call' object
        new caller(c, "Hello");  // thread 1
        new caller(c, "Welcome");  // thread 2
        new caller(c, "How are you?");  // thread 3
    }
}
