import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;

public class CheckUserDetails {
    public void CheckUserDetails(Connection conn,int Account_no){
        String str = "select * from user where Account_no=" + Account_no;
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(str);
            while (rs.next()) {
                System.out.println("User Name: " + rs.getString(1) + " " + rs.getString(2));
                System.out.println("User Mobile Number: " + rs.getString(3));
                System.out.println("User Email: " + rs.getString(5));
            }
            conn.close();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
