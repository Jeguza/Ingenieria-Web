package connection;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
 
public class DBConnection {
    public static Connection connect() {
		String url = "jdbc:postgresql://localhost/CRUDWeb";
		String user = "postgres";
		String password = "eagle1997";
		Connection conn = null;
		try {
            conn = DriverManager.getConnection(url, user, password);
			System.out.println("Connected!");
		} catch (SQLException e) {
			System.out.println("Cannot connect to database");
			System.out.println(e.getMessage());
		}
		return conn;
	}
}