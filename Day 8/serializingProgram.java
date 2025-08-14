import java.io.*;

class Youtube implements Serializable{

    String channelName,vidName;
    int duration,subscribers;

    Youtube(String channelName,String vidName, int duration,int subscribers) {

        this.channelName = channelName;
        this.vidName = vidName;
        this.duration = duration;
        this.subscribers = subscribers;
    }
}

public class serializingProgram {
    public static void main(String[] args) throws Exception{
        Youtube yt = new Youtube("Experiment", "Learning about physics", 2, 3);
        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(new File("myFile.txt")));
        os.writeObject(yt);
        os.close();

        ObjectInputStream oInput = new ObjectInputStream(new FileInputStream(new File("myFile.txt")));
        Youtube ytIn = (Youtube)oInput.readObject();
        System.out.println("Name of the channel: "+ytIn.channelName);
        System.out.println("Name of the video: "+ytIn.vidName);
        System.out.println("Subscribers(in millions): "+ytIn.subscribers);
        System.out.println("Duration of the video in hours : "+ytIn.duration);
        oInput.close();

    }
}
