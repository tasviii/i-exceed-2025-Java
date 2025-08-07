interface mainBranch {  // base interface 
    public void name(); 
    public void mainAddr();
}

interface franchise extends mainBranch {  // interface extending the main interface
    public void address();
}

class sample implements franchise {  // class that is implementing the interface
    sample() {
                        // constructor
    }
    @Override
    public void name() {
        System.out.println("Name: Cafe Z");
    }
    @Override 
    public void mainAddr() {
        System.out.println("Main address is xyz street near koramangala.");
    }
    @Override
    public void address() {
        System.out.println("Franchise address: abc street at mg road.");
    }
}

public class interfaceProgram {
    public static void main(String[] args) {
        sample objSample = new sample();
        objSample.name();
        objSample.mainAddr();
        objSample.address();  
    }
}
