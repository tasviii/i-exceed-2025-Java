class CompanyApp {
    String name_of_company;
    String city;
    static int total_emp = 1000;

    CompanyApp(String name,String city){
        this.name_of_company=name;
        this.city = city;
    
    }
    public void displayDetails(){
        System.out.println("Name of the company "+name_of_company+ " in "+city);
        System.err.println("Total number of employees is "+total_emp);
    }
    
}

class Hr extends CompanyApp{
   
    int employees;
    String dept;

    Hr (String name,String city,String dept,int employees)
    {
        super(name,city);
        this.dept=dept;
        this.employees=employees;
    }
    @Override 
    public void displayDetails()
    {
        super.displayDetails();
        System.out.println("This is the HR department");
    }
    public void displayHR(){
        displayDetails();
        System.out.println("The departmet is "+dept+ " and the team has "+employees);
    }
}

class Finance extends CompanyApp{
  
    String dept;
    int employees;
  
    Finance(String name,String city,String dept,int employees) {
        super(name,city);
        this.dept=dept;
        this.employees=employees;
        System.out.println("Company: " + name_of_company + " in " + city +
                       " and department is " + dept +
                       " and the team has " + employees);
    }
    
}


public class company {
    public static void main(String[] args) {
        // CompanyApp obj = new CompanyApp("i-exceed", "Bangalore");
        // obj.displayDetails();
        Hr objhr = new Hr("i-exceed", "Bangalore", "HR", 20);
        objhr.displayHR();
        Finance objFinance = new Finance("i-exceed", "Bangalore", "Finance", 100);
    }
}
