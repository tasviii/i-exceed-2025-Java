class sample {
    static int counter = 0;
    sample () {
        counter++;
        System.out.println(counter);
    }
}
public class staticVariable {
    public static void main(String[] args) {

        sample obj1 = new sample();
        sample obj2 = new sample();
        sample obj3 = new sample();
        
    }
    
    
}
