class CarName {
    String nameOfCompany;  //camelCase
    boolean isAvailable;

    CarName(String nameOfCar,boolean isAvailable) {
        this.nameOfCompany=nameOfCar;
        this.isAvailable=isAvailable;
    }
    public void getCarDetails() {
        System.out.println("Name of the car is: "+nameOfCompany+"\nIs it available? "+isAvailable);
    }
}

class Scorpio extends CarName {
    String carName,modelName,color;
    Scorpio(String carName,String modelName,String color) {
        super("Mahindra",true);  // can be decalred like this
        this.carName=carName;
        this.modelName=modelName;
        this.color=color;
    }

    public void displayCarModel(){
        System.out.println("Name of the car: "+carName+"\nCar model: "+modelName+"\nColor: "+color);
    }

}

public class car {
    public static void main(String[] myWish) {

        Scorpio objScorpio = new Scorpio("Scorpio", "vlx", "black");
        objScorpio.displayCarModel();
        objScorpio.getCarDetails();
    }
}
