package NASA;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Conexio {

        private static String url = "jdbc:mysql://localhost:3306/nasa";
        private static String user = "root";
        private static String pass = "admin";
        private static Connection conn;

        public static Connection getConnection() {
            try {
                conn = DriverManager.getConnection(url, user, pass);
                if (conn != null) {
                    System.out.println("Connected");
                }
            } catch (SQLException e) {
                System.out.println("Not Connected" + e);
            }
            return conn;
        }
}
