class Address {

    String stName,city;
    int pincode,plotnum;

    Address(String stName,String city,int plotnum,int pincode) {
        this.stName=stName;
        this.city=city;
        this.plotnum=plotnum;
        this.pincode=pincode;
    }

public void displayAddr() 
{
    System.out.println("Street name "+stName);
    System.out.println("city "+city);
    System.out.println("plotnum "+plotnum);
    System.out.println("pincode "+pincode);
}

}


// public class address { 
//     public static void main(String[] args) {
        
//     }
// }
