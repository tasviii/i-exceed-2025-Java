import java.io.FileInputStream;  // reads the files in bytes and not as characters
import java.io.FileOutputStream;

public class fileInputStreamProg {
    public static void main(String[] args) throws Exception {
        FileOutputStream fOutput = new FileOutputStream("sample1.txt");
        String str = "Hello, welcome to the text file.";
        byte byteStr [] = str.getBytes();
        fOutput.write(byteStr);
        fOutput.close();

        FileInputStream fIn = new FileInputStream("sample1.txt");
        int i=0;
        fIn.skip(10);
        while((i=fIn.read())!=-1)
            System.out.print((char)i);
        fIn.close();
    }
}
