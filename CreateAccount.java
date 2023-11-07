import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.Scanner;

public class CreateAccount {

    private String  firstname;
    private String  lastname;
    private String  mob;
    private String  email;
    private int   amount;
    private int accountNumber;
    private Connection conn=JdbcConnManager.getConnection();

    public  void CreateAccount(){

        Scanner sc=InputTaker.getScanner();

            //user First_name
            System.out.println("Enter Your First Name : ");
             firstname = sc.nextLine();

            //User Last_name
            System.out.println("Enter Your Last Name : ");
            lastname = sc.nextLine();

            //User account no provided by the bank

            //User Mobile_no
            System.out.println("Enter Your Mobile_no : ");
             mob = sc.nextLine();

            // User email id
            System.out.println("Enter Your email_id : ");
             email = sc.nextLine();

            //User initial Amount
            System.out.println("Enter Your Initial Amount : ");
             amount = sc.nextInt();

            //Bank automatically generate account number to user
            Random rnd = new Random();
            accountNumber = 100000 + rnd.nextInt(900000);
//to check the fields are valid or not
            validate();

            try{
                addAccountToDataBase();
            }catch (Exception exc){
                System.out.println(exc.getMessage());
            }
    }

    //Method used to check validation on user input
    public void validate(){

        if (this.firstname.length()==0){
            throw new UserExceptionHandling("User First Name Can not Be Empty");
        }
        if (this.lastname.length() == 0) {
            throw new UserExceptionHandling("User Last Name Can not Be Empty");
        }
        if (this.mob.length() == 0) {
            throw new UserExceptionHandling("User Mobile No Can not Be Empty");
        }
        if (this.email.length() == 0) {
            throw new UserExceptionHandling("User email Can not Be Empty");
        } else if (!this.email.contains("@")) {
            throw new UserExceptionHandling("User provided Invalid email ");
        }
        if (this.amount < 0) {
            throw new UserExceptionHandling("Invalid amount ,it Must be in Positive Number");
        }
        if(this.accountNumber==0){
            throw new UserExceptionHandling("Account Number not Created.");
        }
    }

    public void addAccountToDataBase() throws SQLException{
        Statement st=conn.createStatement();
        String query = "insert into user(First_name,Last_name,Mobile_no,Account_no,Email_id,Balance) values('" + firstname + "','" + lastname + "','" + mob + "'," + accountNumber + ",'" + email + "'," + amount + ")";
        int x=st.executeUpdate(query);
        System.out.println("Account is created : "+"User Name: "+firstname+" "+lastname+" , "+" Account Number : "+accountNumber);
        conn.close();
    }

    //    Table creation Query...
    //    String str="CREATE TABLE USER(First_name VARCHAR(53) NOT NULL,Last_name VARCHAR(52) NOT NULL,Mobile_no VARCHAR(52) NOT NULL,Account_no int NOT NULL,Email_id VARCHAR(52),Balance int)";
}










