import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;

public class CheckUserDetails {
    private static String query ="select * from user where Account_no=";
    private static  Connection conn =JdbcConnManager.getConnection();
    public void CheckUserDetails(int Account_no) throws SQLException
    {

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query+Account_no);
            while (rs.next()) {
                System.out.println("User Name: " + rs.getString(1) + " " + rs.getString(2));
                System.out.println("User Mobile Number: " + rs.getString(3));
                System.out.println("User Email: " + rs.getString(5));
            }
            conn.close();
        }
    }

