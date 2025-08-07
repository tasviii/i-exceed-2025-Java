class Remote {
    public void powerOn() {
        System.out.println("The device is on.");
    }
}

class TV extends Remote {
    @Override
    public void powerOn() {
        System.out.println("The TV has been turned on.");
    }
}

class AC extends Remote {
    @Override 
    public void powerOn() {
        System.out.println("The AC has been turned on.");
    }
}

public class dynamicdispatch {
    public static void main(String[] args) {
        
    }
}
