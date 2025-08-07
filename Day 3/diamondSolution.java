interface Speaker {
    default void connect() {
        System.out.println("Speaker connects.");
    }
}

interface Microphone {
    default void connect() {
        System.out.println("Microphone connects.");
    }
}

class SmartDevice implements Speaker, Microphone {
    @Override
    public void connect() {
        System.out.println("SmartDevice connecting...");
        Speaker.super.connect();
        Microphone.super.connect();
    }
}

public class diamondSolution {
    public static void main(String[] args) {
        SmartDevice device = new SmartDevice();
        device.connect();
    }
    
}