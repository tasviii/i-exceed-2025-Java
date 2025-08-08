// program defines the part of relationship

class School {  // creating a class
    String name;
    int numOfClass;
    private final classroom clsroom; // Composition: School "has-a" classroom

    School(String name,int numOfClass){  // creating a constructor
        clsroom = new classroom("Prekg A");   // Creating a classroom object as part of the school
        this.name = name;
        this.numOfClass=numOfClass; 
    }

    public void displaySchool() {  // displaying the school details
        System.out.println("Name of the school: "+name);
        System.out.println("Total number of classes: "+numOfClass);
        clsroom.displayClassromm();  // Display classroom details by calling its method
    }
}

class classroom {   // this class has become a part of the above class 
    String classroomName;

    classroom(String classroomName) {
        this.classroomName=classroomName;
    }

    public void displayClassromm() {
        System.out.println("The classroom is "+classroomName);
    }
}

public class composition {
    public static void main(String[] args) {
        School objSchool = new School("Euro kids", 10);  // Creating a School object with name and number of classes
        objSchool.displaySchool();   // Displaying the school and classroom details
    }
}
