import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.Random;
import java.awt.*;


public class Main {

    public static void main(String[] args) throws SQLException {

        System.out.println("Do you Want to Create Bank account ?");


        Scanner sc = new Scanner(System.in);
        String ans = sc.nextLine();
        if (ans.equalsIgnoreCase("yes")) {
            //user First_name
            System.out.println("Enter Your First Name : ");
            String firstname = sc.nextLine();

            //User Last_name
            System.out.println("Enter Your Last Name : ");
            String lastname = sc.nextLine();

            //User account no provided by the bank

            //User Mobile_no
            System.out.println("Enter Your Mobile_no : ");
            String mob = sc.nextLine();

            // User email id
            System.out.println("Enter Your email_id : ");
            String email = sc.nextLine();

            //User initial Amount
            System.out.println("Enter Your Initial Amount : ");
            int amount = sc.nextInt();

            if (firstname.length() == 0) {
                new UserExceptionHandling("User First Name Can not Be Empty");
            }
            if (lastname.length() == 0) {
                new UserExceptionHandling("User Last Name Can not Be Empty");
            }
            if (mob.length() == 0) {
                new UserExceptionHandling("User Mobile No Can not Be Empty");
            }
            if (email.length() == 0) {
                new UserExceptionHandling("User email Can not Be Empty");
            } else if (!email.contains("@")) {
                new UserExceptionHandling("User provided Invalid email ");
            }
            if (amount < 0) {
                new UserExceptionHandling("Invalid amount ,it Must be in Positive Number");
            }
            Random rnd = new Random();
            int accountNumber = 100000 + rnd.nextInt(900000);
            try {
                Connection conn = JdbcConnManager.getConnection();

                Statement st = conn.createStatement();
                //  String query = "CREATE TABLE USER(First_name VARCHAR(53) NOT NULL,Last_name VARCHAR(52) NOT NULL,Mobile_no VARCHAR(52) NOT NULL,Account_no int NOT NULL,Email_id VARCHAR(52),Balance int)";
                //   st.executeUpdate(query);
                String str = "insert into user(First_name,Last_name,Mobile_no,Account_no,Email_id,Balance) values('" + firstname + "','" + lastname + "','" + mob + "'," + accountNumber + ",'" + email + "'," + amount + ")";
                st.executeUpdate(str);
                System.out.println("Account is created : " + "User Name: " + firstname + " " + lastname + " , " + " Account Number : " + accountNumber);
                conn.close();
            } catch (Exception exc) {
                System.out.println(exc.getMessage());
            }
        } else {
            System.out.println("Enter Your account Number");
            int account = sc.nextInt();
            System.out.println("Enter 1 to Check Balance");
            System.out.println("Enter 2 to Check account details");
            int num = sc.nextInt();
            Connection conn = JdbcConnManager.getConnection();
            if (num == 1) {
                String str = "select balance from user where Account_no=" + account;
                try {
                    Statement st = conn.createStatement();
                    ResultSet rs = st.executeQuery(str);
                    while (rs.next()) {
                        System.out.println("User Available Account balance : " + rs.getInt(1));
                    }
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
            if (num == 2) {
                String str = "select * from user where Account_no=" + account;
                try {
                    Statement st = conn.createStatement();
                    ResultSet rs = st.executeQuery(str);
                    while (rs.next()) {
                        System.out.println("User Name: " + rs.getString(1) + " " + rs.getString(2));
                        System.out.println("User Mobile Number: " + rs.getString(3));
                        System.out.println("User Email: " + rs.getString(5));
                    }

                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
    }
}

