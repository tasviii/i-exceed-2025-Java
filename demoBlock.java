public class demoBlock {
    {
        System.out.println("Instance block is called");
        numbers();
    }
    static{
        System.out.println("inside static block"); //static block
    }
    public void numbers(){
        for(var i =0;i<10;i++){
            System.out.print(i);
        }
    }
 
    demoBlock() // constructor
    {
        System.out.println("Inside constructor");
    }
 
     public static void main(String[] args) {
       new demoBlock();
        System.out.println("Inside main method");
     }
}
