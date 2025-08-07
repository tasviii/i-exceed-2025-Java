abstract class Shape {
    abstract public void Rectangle();
    public void display() {
        System.out.println("This is a shape from abstract class");
    }
}

interface Hello {
    public void sayHello();
}

class Name {
    public void myName()
     {
        System.out.println("Hello my name is Mia.");
     }
}

public class anonymousCode {
    public static void main(String[] args) { 
        Shape objShape = new Shape() {
            public void Rectangle() {
                System.out.println("Rectangle from anonymous class.");
            }
        };
        objShape.Rectangle();
        objShape.display();

        Hello objHello = new Hello() {
            public void sayHello() {
                System.out.println("Hello from anonymous class.");
            }
        };
        objHello.sayHello();

        Name objName = new Name(){
            public void myName() {
                System.out.println("My name being printed from anonymous class.");
            }
        };
        objName.myName();
    }
}
