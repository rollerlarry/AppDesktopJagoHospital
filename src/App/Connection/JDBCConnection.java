package App.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {
    public static Connection connection = null;
    public static Connection getJDBCConnection(){
        final String url = "jdbc:oracle:thin:@localhost:1521:";
        final String dbName = "orcl";
        final String user = "system";
        final String password = "orcl";
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            connection = DriverManager.getConnection(url+dbName, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
