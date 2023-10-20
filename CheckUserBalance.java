import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;

public class CheckUserBalance {
    public void CheckUserBalance(Connection conn,int Account_no){
        String str = "select balance from user where Account_no=" + Account_no;
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(str);
            while (rs.next()) {
                System.out.println("User Available Account balance : " + rs.getInt(1));
            }
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
