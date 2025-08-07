class GravyMix {

    String name ="Basic gravy mix";
    String ingredientOne = "Tomato paste";
    String ingredientTwo = "Spices";
    String ingredientThree = "Onion";

    class FirstCurry 
    {

        String nameOfDish;

        FirstCurry(String nameOfDish) {
            this.nameOfDish = nameOfDish;
        }

        public void cook() {
            System.out.println("Name of the dish "+nameOfDish+" using:");
            System.out.println("-"+ingredientOne);
            System.out.println("-"+ingredientTwo);
            System.out.println("-"+ingredientThree);
        }

        class FinalTopping
         {
            String toppingName;

            FinalTopping(String toppingName) {
                this.toppingName = toppingName;
            }

            public void addTopping() {
                System.out.println("Adding topping: " + toppingName + " to " + nameOfDish);
            }
        }   
    }
}

public class nestedInner {
    public static void main(String[] args) {
        GravyMix objMix = new GravyMix();
        GravyMix.FirstCurry objCurry = objMix.new FirstCurry("Paneer butter masala");
        objCurry.cook();
        //objCurry.ingredientOne;
        GravyMix.FirstCurry.FinalTopping objTopping = objCurry.new FinalTopping("coriander leaves and cream");
        objTopping.addTopping();

    }
}
