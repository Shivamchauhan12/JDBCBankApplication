import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.Scanner;

public class DebitAmount {

    public void DebitAmount(Connection conn, int account_no) {
        Scanner sc=InputTaker.getScanner();
        System.out.println("Enter The Amount You Want to Debit : ");
        int Debit_amount = sc.nextInt();

        try {
            String get = "SELECT balance FROM user WHERE Account_no = '" + account_no + "'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(get);
            int curr_bal=0;
            while (rs.next()) {
                curr_bal = rs.getInt(1);
            }
            if(Debit_amount<curr_bal) {
                int Updated_Balance=curr_bal-Debit_amount;
                String set = "UPDATE user SET Balance = " + Updated_Balance+ " WHERE Account_no = " + account_no;
                st.executeUpdate(set);
                System.out.println("User Account Balance: " + curr_bal);
                System.out.println(("Your Account has been Debited " + Debit_amount  + "In date " + LocalDateTime.now()));
                System.out.println("Your Updated Balance " + Updated_Balance);
            }
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
