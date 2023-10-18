import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class JdbcConnManager {
    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
        }
        String url = "jdbc:mysql://localhost:3306/jdbc";
        try {
            Connection conn = DriverManager.getConnection(url, "root", "Shivam@88");
            return conn;
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        return null;
    }
}
