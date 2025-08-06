public class staticBlock {
    {
        System.out.println("Instance block is called");
    }
    static{
        System.out.println("inside static block");
    }
 
    staticBlock() 
    {
        System.out.println("Inside constructor");
    }
}
class demoBlock
 {

     public static void main(String[] args) {
        
        System.out.println("Inside main method");
     }
 }