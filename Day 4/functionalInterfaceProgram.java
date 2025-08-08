// This annotation ensures the interface has only one abstract method

@FunctionalInterface  // creating a functional interface
interface trial {  // Abstract method to convert a string to uppercase
    public void upperCase(String str);
}

public class functionalInterfaceProgram {
    // Implementing the functional interface using an anonymous inner class
    public static void main(String[] args) { 
        trial t = new trial() {  // explicitly overriding a function
            @Override
            public void upperCase(String input) {
                String outputString = input.toUpperCase();
                System.out.println(outputString);
            }
        };

        // Uncomment the below lines to use a lambda expression instead:
        // trial t1 = (input) -> System.out.println(input.toUpperCase());  // using lambda function 
        // t1.upperCase("hello world");
    }
}
