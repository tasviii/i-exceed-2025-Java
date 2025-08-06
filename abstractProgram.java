abstract class Toy{
    void baseStruct () {
        System.out.println("basic toy structure.");
    }
    abstract void addArms();
    abstract void addLegs();

}

class RobotToy extends Toy {
    @Override 
    void addArms() {
        System.out.println("Added arms to the robot.");
    }
    @Override 
    void addLegs() {
        System.out.println("Added legs to the robot.");
    }
}

public class abstractProgram {
    public static void main(String[] args) {
        RobotToy myToy =new RobotToy();
        myToy.baseStruct();
        myToy.addArms();
        myToy.addLegs();
        System.out.println("Robot has been assembled!");
    }
    
}
