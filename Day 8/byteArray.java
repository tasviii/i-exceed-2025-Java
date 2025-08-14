import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.File;
 
public class byteArray {
    public static void main(String[] args) throws Exception {
        ByteArrayOutputStream bos=new ByteArrayOutputStream();
	    bos.writeBytes("this is the sample string to be embed into multiple source".getBytes());
        for (var i=1;i<=2;i++) {
            String fileName = String.format("bArray%d.txt", i);
            bos.writeTo(new FileOutputStream(new File(fileName)));
            bos.close();
        }
    }
}
