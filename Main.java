import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws SQLException {

        System.out.println("Do you Want to Create Bank account ?");
        Scanner sc = new Scanner(System.in);
        String ans = sc.nextLine();
        if (ans.equalsIgnoreCase("yes")) {
            new CreateAccount().CreateAccount();
        }
        else {
            System.out.println("Enter Your account Number");
            int account = sc.nextInt();
            System.out.println("Enter 1 to Check Balance");
            System.out.println("Enter 2 to Check account details");
            System.out.println("Enter 3 to Update User Details");
            System.out.println("Enter 4 to Credit Amount");
            System.out.println("Enter 5 to Debit Amount");

            int num = sc.nextInt();

            Connection conn = JdbcConnManager.getConnection();

            switch (num) {
                case 1: {
                    new CheckUserBalance().CheckUserBalance(conn, account);
                    break;
                }
                case 2: {
                    new CheckUserDetails().CheckUserDetails(conn, account);
                    break;
                }
                case 3: {
                    new UpdateUserDetails().UpdateUserDetails(conn, account);
                    break;
                }
                case 4: {
                    new CreditAmount().addAmount(conn, account);
                    break;
                }
                case 5: {
                    new DebitAmount().DebitAmount(conn, account);
                    break;
                }
            }
        }
    }
}


