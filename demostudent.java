class Student 
 {

    String name,dept;
    int rollNum;
    Address adr;

    Student(int rollNum,String name,String dept,Address adr) {
        this.rollNum=rollNum;
        this.name=name;
        this.dept=dept;
        this.adr=adr;
        System.out.println(this);
    }

    public void displayStudent()
        {
            System.out.println("Name of the student"+name);
            System.out.println("Roll"+rollNum);
            System.out.println("Department"+dept);
            adr.displayAddr();
            //adr.stName;
        }
}

public class demostudent {
    public static void main(String[] args) {
        Address a1 = new Address("Koramangala A block","Bangalore",2,4324324);
        Student s1 = new Student(21, "Neha", "CSE", a1);
        s1.displayStudent();
        System.out.println(s1);
    }
}
