import java.util.Scanner;
import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.File;

public class assignment {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the name of the file: ");
        File f = new File(sc.nextLine());
        FileOutputStream fOut = new FileOutputStream(f);

        System.out.println("Enter the content you wish to write on the text file:");
        String userText = sc.nextLine();
        byte byteString [] = userText.getBytes();
        fOut.write(byteString);
        fOut.close();
        sc.close();
        BufferedInputStream bin=new BufferedInputStream(new FileInputStream(f.getName()));
        int i=0;
	    while((i=bin.read())!=-1)
		    System.out.print((char)i);
        bin.close();
    }
}
