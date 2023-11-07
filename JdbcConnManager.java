import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class JdbcConnManager {
    public static Connection getConnection() {
        Connection conn=null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception exc) {
            System.out.println(exc.getMessage());
        }
        try {
            String url = "jdbc:mysql://localhost:3306/jdbc";
             conn = DriverManager.getConnection(url, "root", "Shivam@88");
            return conn;
        }
        catch (Exception exc) {
            System.out.println(exc.getMessage());
        }
        return conn;
    }
}
