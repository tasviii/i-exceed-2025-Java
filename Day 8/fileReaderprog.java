// importing the packages
import java.io.File;
import java.io.FileReader;

public class fileReaderprog {
    public static void main(String[] args) throws Exception{

        int i = 0; 
        File f = new File(args[0]); // passing the file name as a command line argument
        FileReader fr = new FileReader(f); // creating the filereader object
        while((i=fr.read())!=-1) // the filereader object returns the ASCII value of the character which is an integer
		{
	   	   System.out.print((char)i);  // typecasting the integer to character
		}
        fr.close(); // closing the file
    }
}
