import java.io.File; // importing the file package
public class newFile {
    public static void main(String[] args) throws Exception {
        File f = new File("C:\\Users\\tasvi.shetty\\Desktop\\JAVA\\Day 6\sample.txt");
        f.createNewFile(); // creating a new file
       System.out.println( f.getAbsolutePath()); // getting the absolute path of the file
       Boolean fExist = f.exists(); // checking if the file exists or not
       System.out.println(fExist);
       if (fExist) { // if the file exists then you can check if the file is readable or writeable
            System.out.println("Can the file be written? "+f.canWrite());
            System.out.println("Can the file be written? "+f.canRead()); // returns a boolean value
       }
 
       f.delete(); // deleting the file
       System.out.println("Does file still exist? "+f.exists());

    }
}
