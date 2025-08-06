class Student{
    String name,dept;
    int age;
    Student(String name,int age,String dept) {
        this.name = name;
        this.age=age;
        this.dept=dept;
    }
    public void displayStudent()
	{
	   System.out.println("Name="+name);
	   System.out.println("Age="+age);
	   System.out.println("Department="+dept);
	}
}

class teacher extends Student 
{
   
    teacher(String name,int age,String dept) {
        super(name,age,dept);  // to call the constructor from parent class use super keyword
	   System.out.println("Name of the Teacher "+name);
    }

}

public class inheritance {
    public static void main(String[] args) {
        teacher obj = new teacher("sia", 30, "cse");
        ///obj.displayStudent();
    }
    
}
