class sample extends Thread {
    // sample () {
    //     new Thread(this).start();
    // }
    public void run() {  // cannot have a different name apart from run
        System.out.println("Inside the run method");
        myFunc();
    }
    void myFunc() { // creating another function
        System.out.println("Inside my function");
    }
}

// main method
class threadProgram {
    public static void main(String[] args) {
        sample obj = new sample();  // starting the run method
        obj.start();
        sample obj2 = new sample();
        obj2.myFunc();
    }
}