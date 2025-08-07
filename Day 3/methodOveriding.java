class Parent {   // super class

    public void displayDetails() {
        System.out.println("Hi! You are inside the base or super class.");
    }

    public void addition (int x,int y) {
        System.out.println("Result from parent class: "+(x+y));
    }
}

class Child  extends Parent{  // derived class
    @Override
    public void displayDetails() {
        System.out.println("Hi! You are inside the derived class.");
    }
    @Override
    public void addition (int x,int y) {
        System.out.println("Result from derived class: "+(x+y));
    }
}

public class methodOveriding {
    public static void main(String[] args) {

        Parent ref;  // creating a reference variable of type parent 
        Parent objParent = new Parent();
        Child objChild = new Child();
        ref = objParent;  // ref refers to the parent object
        ref.displayDetails();
        ref.addition(78, 92);
        ref = objChild;  // ref refers to the child object
        ref.displayDetails();
        ref.addition(56, 9);

    }
}
