class UserSetUp {
    private String username, pswd; // private variables
    

    UserSetUp(String username,String pswd) { // constructor

        this.username = username;
        this.pswd = pswd;
        // System.out.println(username);
    }

    public void setUsername(String username) { // to set the username
        this.username = username;
    }

    public void setPassword(String pswd) {  // to set the password
        this.pswd = pswd;
    }

    public String getUsername() { // to access the private variable you need to write a public method
        return username;
    }

    // public String getPassword() {  // password can't be accessed by everyone
    //     return pswd;
    // }

}

public class privateAccessSpecifier1 {
    public static void main(String[] args) {

        UserSetUp objSetUp = new UserSetUp("Kaira", "123");
        String userName = objSetUp.getUsername();
        System.out.println(userName);
        objSetUp.setUsername("Shaney");
        System.out.println(objSetUp.getUsername());
        
    }
}
